package com.sdx.merak.service.intf.fractionAlgorithm.dto.req.sub.field;

import java.io.Serializable;

/**
 * FacilityReq的属性对象
 * @author yeegor
 *
 */
public class AvReq implements Serializable {

	private static final long serialVersionUID = 1L;
	
	/** AV要求集合-客户选项数量 **/
	private Integer customerTagCount4avReq;
	
	/** AV要求集合-酒店满足的选项数量 **/
	private Integer hotelSatisfyTagCount4avReq;
	
	private boolean isAvReqNecessary;

	public Integer getCustomerTagCount4avReq() {
		return customerTagCount4avReq;
	}

	public void setCustomerTagCount4avReq(Integer customerTagCount4avReq) {
		this.customerTagCount4avReq = customerTagCount4avReq;
	}

	public Integer getHotelSatisfyTagCount4avReq() {
		return hotelSatisfyTagCount4avReq;
	}

	public void setHotelSatisfyTagCount4avReq(Integer hotelSatisfyTagCount4avReq) {
		this.hotelSatisfyTagCount4avReq = hotelSatisfyTagCount4avReq;
	}

	public boolean isAvReqNecessary() {
		return isAvReqNecessary;
	}

	public void setAvReqNecessary(boolean isAvReqNecessary) {
		this.isAvReqNecessary = isAvReqNecessary;
	}
	
}
