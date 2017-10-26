package com.sdx.merak.service.fractionAlgorithm.ext;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import com.sdx.merak.service.intf.fractionAlgorithm.ReferenceIndexAlgorithm;
import com.sdx.merak.service.intf.fractionAlgorithm.dto.factor.FacilityFactor;
import com.sdx.merak.service.intf.fractionAlgorithm.ext.FacilityReqService;
import com.sdx.merak.service.intf.fractionAlgorithm.ext.dto.MeetingRoomReq;
import com.sdx.merak.service.intf.fractionAlgorithm.ext.dto.MeetingRoomResponse;

public class FacilityReqServiceImpl implements FacilityReqService {
	
	
	private final FacilityFactor facilityFactor = new FacilityFactor();
	
	ReferenceIndexAlgorithm referenceIndexAlgorithm;

	@Override
	public MeetingRoomResponse match(List<MeetingRoomReq> meetingRoomReqs) {
		
		MeetingRoomResponse response = new MeetingRoomResponse();
		
		List<MeetingRoomResponse.BestChoiceMeetingRoom> bestChoiceMeetingRooms = new ArrayList<>();
		List<MeetingRoomResponse.NotBestChoiceMeetingRoom> notBestChoiceMeetingRooms = new ArrayList<>();
		
		for (MeetingRoomReq meetingRoomReq : meetingRoomReqs) {
			
			Integer maxMeetingRoomSizeFactor = null;
			Integer maxMeetingSetUpFactor = null;
			if (meetingRoomReq.isMaxMeetingRoomSizeNecessary()) {
				maxMeetingRoomSizeFactor = facilityFactor.maxMeetingRoomSizeNecessary;
			} else {
				maxMeetingRoomSizeFactor = facilityFactor.maxMeetingRoomSizePreferred;
			}
			if (meetingRoomReq.isMaxMeetingSetUpNecessary()) {
				maxMeetingSetUpFactor = facilityFactor.maxMeetingSetUpNecessary;
			} else {
				maxMeetingSetUpFactor = facilityFactor.maxMeetingSetUpPreferred;
			}
			Float c0 = referenceIndexAlgorithm.maxMeetingRoomSize(meetingRoomReq.getReqMeetingRoomArea4MeetingRoomSize(), meetingRoomReq.getHotelMeetingRoomArea4MeetingRoomSize());
			Float c1 = referenceIndexAlgorithm.maxMeetingSetUp(meetingRoomReq.getCustomerTagCount4MeetingSetUp(), meetingRoomReq.getHotelSatisfyTagCount4MeetingSetUp());
			
			//按照原算法条件因子计算方式
			Float score = (c0*maxMeetingRoomSizeFactor + c1*maxMeetingSetUpFactor)/(maxMeetingRoomSizeFactor + maxMeetingSetUpFactor);
			
			//先全部放入非优选会议室
			MeetingRoomResponse.NotBestChoiceMeetingRoom meetingRoom = response.new NotBestChoiceMeetingRoom();
			meetingRoom.setMeetingRoomId(meetingRoomReq.getMeetingRoomId());
			meetingRoom.setScore(score);
			
			notBestChoiceMeetingRooms.add(meetingRoom);
		}
		
		//按照分数进行倒序排序
		Collections.sort(notBestChoiceMeetingRooms, new Comparator<MeetingRoomResponse.NotBestChoiceMeetingRoom>() {
			@Override
			public int compare(MeetingRoomResponse.NotBestChoiceMeetingRoom o1, MeetingRoomResponse.NotBestChoiceMeetingRoom o2) {
				return o2.getScore().compareTo(o1.getScore());
			}
		});
		
		List<MeetingRoomResponse.NotBestChoiceMeetingRoom> notBestChoiceMeetingRooms0 = new CopyOnWriteArrayList<MeetingRoomResponse.NotBestChoiceMeetingRoom>();
		notBestChoiceMeetingRooms0.addAll(notBestChoiceMeetingRooms);
		
		for (MeetingRoomResponse.NotBestChoiceMeetingRoom meetingRoom : notBestChoiceMeetingRooms0) {
			boolean isBestChoice = false;
			if (bestChoiceMeetingRooms.size() > 0) {
				Float socre = meetingRoom.getScore();
				if (socre.compareTo(bestChoiceMeetingRooms.get(0).getScore()) == 0) { //如果存在相同分数的加入最优会议室列表
					isBestChoice = true;
					continue;
				} else {
					break;
				}
			} else {
				isBestChoice = true;
			}
			
			if (isBestChoice) {
				MeetingRoomResponse.BestChoiceMeetingRoom bestChoiceMeetingRoom = response.new BestChoiceMeetingRoom();
				bestChoiceMeetingRoom.setMeetingRoomId(meetingRoom.getMeetingRoomId());
				bestChoiceMeetingRoom.setScore(meetingRoom.getScore());
				
				bestChoiceMeetingRooms.add(bestChoiceMeetingRoom);
				notBestChoiceMeetingRooms0.remove(meetingRoom);
			}
		}
		response.setBestChoiceMeetingRooms(bestChoiceMeetingRooms);
		response.setNotBestChoiceMeetingRooms(notBestChoiceMeetingRooms0);
		
		return response;
	}
	
}
