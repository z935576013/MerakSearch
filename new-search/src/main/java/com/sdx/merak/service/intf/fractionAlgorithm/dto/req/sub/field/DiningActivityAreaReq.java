package com.sdx.merak.service.intf.fractionAlgorithm.dto.req.sub.field;

import java.io.Serializable;

/**
 * FacilityReq的属性对象
 * @author yeegor
 *
 */
public class DiningActivityAreaReq implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	/** 每项餐饮活动的场地面积-客户要求面积 **/
	private Float reqDiningArea;
	
	/** 每项餐饮活动的场地面积-酒店餐厅面积 **/
	private Float hotelDiningArea;
	
	private boolean isDiningActivityAreaNecessary;

	public Float getReqDiningArea() {
		return reqDiningArea;
	}

	public void setReqDiningArea(Float reqDiningArea) {
		this.reqDiningArea = reqDiningArea;
	}

	public Float getHotelDiningArea() {
		return hotelDiningArea;
	}

	public void setHotelDiningArea(Float hotelDiningArea) {
		this.hotelDiningArea = hotelDiningArea;
	}

	public boolean isDiningActivityAreaNecessary() {
		return isDiningActivityAreaNecessary;
	}

	public void setDiningActivityAreaNecessary(boolean isDiningActivityAreaNecessary) {
		this.isDiningActivityAreaNecessary = isDiningActivityAreaNecessary;
	}
	
}
