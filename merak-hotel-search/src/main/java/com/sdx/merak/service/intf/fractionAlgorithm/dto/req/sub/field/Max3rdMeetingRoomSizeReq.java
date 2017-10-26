package com.sdx.merak.service.intf.fractionAlgorithm.dto.req.sub.field;

import java.io.Serializable;

/**
 * FacilityReq的属性对象
 * @author yeegor
 *
 */
public class Max3rdMeetingRoomSizeReq implements Serializable {

	private static final long serialVersionUID = 1L;
	
	/** 第三大会议室面积-客户要求面积 **/
	private Float reqMeetingRoomArea4max3rdMeetingRoomSize;
	
	/** 第三大会议室面积-酒店会场面积 **/
	private Float hotelMeetingRoomArea4max3rdMeetingRoomSize;
	
	private boolean isMax3rdMeetingRoomSizeNecessary;

	public Float getReqMeetingRoomArea4max3rdMeetingRoomSize() {
		return reqMeetingRoomArea4max3rdMeetingRoomSize;
	}

	public void setReqMeetingRoomArea4max3rdMeetingRoomSize(
			Float reqMeetingRoomArea4max3rdMeetingRoomSize) {
		this.reqMeetingRoomArea4max3rdMeetingRoomSize = reqMeetingRoomArea4max3rdMeetingRoomSize;
	}

	public Float getHotelMeetingRoomArea4max3rdMeetingRoomSize() {
		return hotelMeetingRoomArea4max3rdMeetingRoomSize;
	}

	public void setHotelMeetingRoomArea4max3rdMeetingRoomSize(
			Float hotelMeetingRoomArea4max3rdMeetingRoomSize) {
		this.hotelMeetingRoomArea4max3rdMeetingRoomSize = hotelMeetingRoomArea4max3rdMeetingRoomSize;
	}

	public boolean isMax3rdMeetingRoomSizeNecessary() {
		return isMax3rdMeetingRoomSizeNecessary;
	}

	public void setMax3rdMeetingRoomSizeNecessary(
			boolean isMax3rdMeetingRoomSizeNecessary) {
		this.isMax3rdMeetingRoomSizeNecessary = isMax3rdMeetingRoomSizeNecessary;
	}
	
}
