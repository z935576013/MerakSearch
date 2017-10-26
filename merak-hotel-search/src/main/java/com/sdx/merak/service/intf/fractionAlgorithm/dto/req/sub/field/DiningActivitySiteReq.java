package com.sdx.merak.service.intf.fractionAlgorithm.dto.req.sub.field;

import java.io.Serializable;

/**
 * FacilityReq的属性对象
 * @author yeegor
 *
 */
public class DiningActivitySiteReq implements Serializable {

	private static final long serialVersionUID = 1L;
	
	/** 每项餐饮活动的场地要求-客户选项数量 **/
	private Integer customerTagCount4diningActivitySiteReq;
	
	/** 每项餐饮活动的场地要求-酒店满足的选项数量 **/
	private Integer hotelSatisfyTagCount4diningActivitySiteReq;
	
	private boolean isDiningActivitySiteReqNecessary;

	public Integer getCustomerTagCount4diningActivitySiteReq() {
		return customerTagCount4diningActivitySiteReq;
	}

	public void setCustomerTagCount4diningActivitySiteReq(
			Integer customerTagCount4diningActivitySiteReq) {
		this.customerTagCount4diningActivitySiteReq = customerTagCount4diningActivitySiteReq;
	}

	public Integer getHotelSatisfyTagCount4diningActivitySiteReq() {
		return hotelSatisfyTagCount4diningActivitySiteReq;
	}

	public void setHotelSatisfyTagCount4diningActivitySiteReq(
			Integer hotelSatisfyTagCount4diningActivitySiteReq) {
		this.hotelSatisfyTagCount4diningActivitySiteReq = hotelSatisfyTagCount4diningActivitySiteReq;
	}

	public boolean isDiningActivitySiteReqNecessary() {
		return isDiningActivitySiteReqNecessary;
	}

	public void setDiningActivitySiteReqNecessary(
			boolean isDiningActivitySiteReqNecessary) {
		this.isDiningActivitySiteReqNecessary = isDiningActivitySiteReqNecessary;
	}
	
}
