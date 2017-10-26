package com.sdx.merak.service.intf.fractionAlgorithm.ext.dto;

import java.io.Serializable;

/**
 * 会议室相关算法请求参数
 * @author Aaron
 *
 */
public class MeetingRoomReq implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long meetingRoomId;
	
	/** Meeting Room Size (会议室面积）-客户要求面积 **/
	private Float reqMeetingRoomArea4MeetingRoomSize;
	
	/** Meeting Room Size (会议室面积）-酒店会场面积 **/
	private Float hotelMeetingRoomArea4MeetingRoomSize;
	
	/** Meeting set up (会议室要求）-客户选项数量 **/
	private Integer customerTagCount4MeetingSetUp;
	
	/** Meeting set up (会议室要求）- 酒店满足的选项数量 **/
	private Integer hotelSatisfyTagCount4MeetingSetUp;
	
	private boolean isMaxMeetingRoomSizeNecessary;
	
	private boolean isMaxMeetingSetUpNecessary;

	public Long getMeetingRoomId() {
		return meetingRoomId;
	}

	public void setMeetingRoomId(Long meetingRoomId) {
		this.meetingRoomId = meetingRoomId;
	}

	public Float getReqMeetingRoomArea4MeetingRoomSize() {
		return reqMeetingRoomArea4MeetingRoomSize;
	}

	public void setReqMeetingRoomArea4MeetingRoomSize(
			Float reqMeetingRoomArea4MeetingRoomSize) {
		this.reqMeetingRoomArea4MeetingRoomSize = reqMeetingRoomArea4MeetingRoomSize;
	}

	public Float getHotelMeetingRoomArea4MeetingRoomSize() {
		return hotelMeetingRoomArea4MeetingRoomSize;
	}

	public void setHotelMeetingRoomArea4MeetingRoomSize(
			Float hotelMeetingRoomArea4MeetingRoomSize) {
		this.hotelMeetingRoomArea4MeetingRoomSize = hotelMeetingRoomArea4MeetingRoomSize;
	}

	public Integer getCustomerTagCount4MeetingSetUp() {
		return customerTagCount4MeetingSetUp;
	}

	public void setCustomerTagCount4MeetingSetUp(
			Integer customerTagCount4MeetingSetUp) {
		this.customerTagCount4MeetingSetUp = customerTagCount4MeetingSetUp;
	}

	public Integer getHotelSatisfyTagCount4MeetingSetUp() {
		return hotelSatisfyTagCount4MeetingSetUp;
	}

	public void setHotelSatisfyTagCount4MeetingSetUp(
			Integer hotelSatisfyTagCount4MeetingSetUp) {
		this.hotelSatisfyTagCount4MeetingSetUp = hotelSatisfyTagCount4MeetingSetUp;
	}

	public boolean isMaxMeetingRoomSizeNecessary() {
		return isMaxMeetingRoomSizeNecessary;
	}

	public void setMaxMeetingRoomSizeNecessary(boolean isMaxMeetingRoomSizeNecessary) {
		this.isMaxMeetingRoomSizeNecessary = isMaxMeetingRoomSizeNecessary;
	}

	public boolean isMaxMeetingSetUpNecessary() {
		return isMaxMeetingSetUpNecessary;
	}

	public void setMaxMeetingSetUpNecessary(boolean isMaxMeetingSetUpNecessary) {
		this.isMaxMeetingSetUpNecessary = isMaxMeetingSetUpNecessary;
	}

}
