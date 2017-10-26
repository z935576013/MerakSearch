package com.sdx.merak.service.intf.fractionAlgorithm.dto.req.sub.field;

import java.io.Serializable;

/**
 * FacilityReq的属性对象
 * @author yeegor
 *
 */
public class Max3rdMeetingSetUpReq implements Serializable {

	private static final long serialVersionUID = 1L;
	
	/** 第三大会议室要求-客户选项数量 **/
	private Integer customerTagCount4max3rdMeetingSetUp;
	
	/** 第三大会议室要求-酒店满足的选项数量 **/
	private Integer hotelSatisfyTagCount4max3rdMeetingSetUp;
	
	private boolean isMax3rdMeetingSetUpNecessary;

	public Integer getCustomerTagCount4max3rdMeetingSetUp() {
		return customerTagCount4max3rdMeetingSetUp;
	}

	public void setCustomerTagCount4max3rdMeetingSetUp(
			Integer customerTagCount4max3rdMeetingSetUp) {
		this.customerTagCount4max3rdMeetingSetUp = customerTagCount4max3rdMeetingSetUp;
	}

	public Integer getHotelSatisfyTagCount4max3rdMeetingSetUp() {
		return hotelSatisfyTagCount4max3rdMeetingSetUp;
	}

	public void setHotelSatisfyTagCount4max3rdMeetingSetUp(
			Integer hotelSatisfyTagCount4max3rdMeetingSetUp) {
		this.hotelSatisfyTagCount4max3rdMeetingSetUp = hotelSatisfyTagCount4max3rdMeetingSetUp;
	}

	public boolean isMax3rdMeetingSetUpNecessary() {
		return isMax3rdMeetingSetUpNecessary;
	}

	public void setMax3rdMeetingSetUpNecessary(boolean isMax3rdMeetingSetUpNecessary) {
		this.isMax3rdMeetingSetUpNecessary = isMax3rdMeetingSetUpNecessary;
	}
	
}
