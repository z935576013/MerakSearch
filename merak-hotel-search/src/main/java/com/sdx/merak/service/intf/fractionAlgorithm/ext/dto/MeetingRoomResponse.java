package com.sdx.merak.service.intf.fractionAlgorithm.ext.dto;

import java.io.Serializable;
import java.util.List;

/**
 * 会议室相关算法返回对象
 * @author Aaron
 *
 */
public class MeetingRoomResponse implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private List<BestChoiceMeetingRoom> bestChoiceMeetingRooms;
	
	private List<NotBestChoiceMeetingRoom> notBestChoiceMeetingRooms;
	
	public List<BestChoiceMeetingRoom> getBestChoiceMeetingRooms() {
		return bestChoiceMeetingRooms;
	}

	public void setBestChoiceMeetingRooms(
			List<BestChoiceMeetingRoom> bestChoiceMeetingRooms) {
		this.bestChoiceMeetingRooms = bestChoiceMeetingRooms;
	}

	public List<NotBestChoiceMeetingRoom> getNotBestChoiceMeetingRooms() {
		return notBestChoiceMeetingRooms;
	}

	public void setNotBestChoiceMeetingRooms(
			List<NotBestChoiceMeetingRoom> notBestChoiceMeetingRooms) {
		this.notBestChoiceMeetingRooms = notBestChoiceMeetingRooms;
	}
	
	/**
	 * 最优选会议室
	 * @author Aaron
	 */
	public class BestChoiceMeetingRoom {
		private Long meetingRoomId;
		
		private Float score;

		public Long getMeetingRoomId() {
			return meetingRoomId;
		}
		public void setMeetingRoomId(Long meetingRoomId) {
			this.meetingRoomId = meetingRoomId;
		}

		public Float getScore() {
			return score;
		}

		public void setScore(Float score) {
			this.score = score;
		}
	}
	
	/**
	 * 非最优选会议室
	 * @author Aaron
	 */
	public class NotBestChoiceMeetingRoom {
		private Long meetingRoomId;
		
		/** 未选理由，目前为空字符串 **/
		private String reason;
		
		private Float score;
		
		public Long getMeetingRoomId() {
			return meetingRoomId;
		}
		public void setMeetingRoomId(Long meetingRoomId) {
			this.meetingRoomId = meetingRoomId;
		}
		public String getReason() {
			return reason;
		}
		public void setReason(String reason) {
			this.reason = reason;
		}
		public Float getScore() {
			return score;
		}

		public void setScore(Float score) {
			this.score = score;
		}
	}
}
