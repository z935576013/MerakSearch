package com.sdx.merak.service.intf.fractionAlgorithm.dto;

import java.io.Serializable;

/**
 * 算法结果对象
 * @author yeegor
 *
 */
public class AlgorithmRes implements Serializable {

	private static final long serialVersionUID = 1L;

	private Float bookingTermsRes; //预定条款
	private Float facilityRes;     //设施
	private Float locationRes;     //位置
	private Float rateRes;         //价格
	private Float serviceRes; //服务
	
	private Float res; //最终结果
	
	public Float getBookingTermsRes() {
		return bookingTermsRes;
	}
	public void setBookingTermsRes(Float bookingTermsRes) {
		this.bookingTermsRes = bookingTermsRes;
	}
	public Float getFacilityRes() {
		return facilityRes;
	}
	public void setFacilityRes(Float facilityRes) {
		this.facilityRes = facilityRes;
	}
	public Float getLocationRes() {
		return locationRes;
	}
	public void setLocationRes(Float locationRes) {
		this.locationRes = locationRes;
	}
	public Float getRateRes() {
		return rateRes;
	}
	public void setRateRes(Float rateRes) {
		this.rateRes = rateRes;
	}
	public Float getServiceRes() {
		return serviceRes;
	}
	public void setServiceRes(Float serviceRes) {
		this.serviceRes = serviceRes;
	}
	public Float getRes() {
		return res;
	}
	public void setRes(Float res) {
		this.res = res;
	}
	
	
}
