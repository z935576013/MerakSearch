package com.sdx.merak.service.intf.fractionAlgorithm.dto.req.sub;

import java.io.Serializable;
import java.util.List;

import com.sdx.merak.service.intf.fractionAlgorithm.dto.req.sub.field.AvReq;
import com.sdx.merak.service.intf.fractionAlgorithm.dto.req.sub.field.DiningActivityAreaReq;
import com.sdx.merak.service.intf.fractionAlgorithm.dto.req.sub.field.DiningActivitySiteReq;
import com.sdx.merak.service.intf.fractionAlgorithm.dto.req.sub.field.Max3rdMeetingRoomSizeReq;
import com.sdx.merak.service.intf.fractionAlgorithm.dto.req.sub.field.Max3rdMeetingSetUpReq;

public class FacilityReq implements Serializable {

	private static final long serialVersionUID = 1L;
	
	/** 设施得分点百分比 默认30% - eg : 设置25%  参数值25.0f **/
	private Float facilityPercent; 
	
	/** 设施-客户选项数量 **/
	private Integer customerTagCount4facilityNum;
	
	/** 设施-酒店满足的选项数量 **/
	private Integer hotelSatisfyTagCount4facilityNum;
	
	/** 房间数量和房型要求-不匹配的房间数量 **/
	private Integer reqNotSatisfyRoomCount;
	
	/** 房间数量和房型要求-不匹配的房型数量 **/
	private Integer reqNotSatisfyRoomTypeCount;
	
	/** Largest Meeting Room Size (最大会议室面积）-客户要求面积 **/
	private Float reqMeetingRoomArea4maxMeetingRoomSize;
	
	/** Largest Meeting Room Size (最大会议室面积）-酒店会场面积 **/
	private Float hotelMeetingRoomArea4maxMeetingRoomSize;
	
	/** Largest Meeting set up (最大会议室要求）-客户选项数量 **/
	private Integer customerTagCount4maxMeetingSetUp;
	
	/** Largest Meeting set up (最大会议室要求）- 酒店满足的选项数量 **/
	private Integer hotelSatisfyTagCount4maxMeetingSetUp;
	
	/** 2nd larget Meeting room size (第二会议室面积）-客户要求面积 **/
	private Float reqMeetingRoomArea4max2ndMeetingRoomSize;
	
	/** 2nd larget Meeting room size (第二会议室面积）-酒店会场面积 **/
	private Float hotelMeetingRoomArea4max2ndMeetingRoomSize;
	
	/** 2nd Largest Meeting set up (最大会议室要求）-客户选项数量 **/
	private Integer customerTagCount4max2ndMeetingSetUp;
	
	/** 2nd Largest Meeting set up (最大会议室要求）-酒店满足的选项数量 **/
	private Integer hotelSatisfyTagCount4max2ndMeetingSetUp;
	
	/** 第三大会议室面积 - 入参信息 **/
	private List<Max3rdMeetingRoomSizeReq> max3rdMeetingRoomSizeReqs;
	
	/** 第三大会议室要求 - 入参信息 **/
	private List<Max3rdMeetingSetUpReq> max3rdMeetingSetUpReqs;
	
	/** 每项餐饮活动的场地面积 **/
	private List<DiningActivityAreaReq> diningActivityAreaReqs;
	
	/** 每项餐饮活动的场地要求 **/
	private List<DiningActivitySiteReq> diningActivitySiteReqs;
	
	/** AV要求集合 **/
	private List<AvReq> avReqs;
	
	private boolean isFacilityNumNecessary;
	private boolean isRoomNumAndRoomTypeNecessary;
	private boolean isMaxMeetingRoomSizeNecessary;
	private boolean isMaxMeetingSetUpNecessary;
	private boolean isMax2ndMeetingRoomSizeNecessary;
	private boolean isMax2ndMeetingSetUpNecessary;
	public Float getFacilityPercent() {
		return facilityPercent;
	}
	public void setFacilityPercent(Float facilityPercent) {
		this.facilityPercent = facilityPercent;
	}
	public Integer getCustomerTagCount4facilityNum() {
		return customerTagCount4facilityNum;
	}
	public void setCustomerTagCount4facilityNum(Integer customerTagCount4facilityNum) {
		this.customerTagCount4facilityNum = customerTagCount4facilityNum;
	}
	public Integer getHotelSatisfyTagCount4facilityNum() {
		return hotelSatisfyTagCount4facilityNum;
	}
	public void setHotelSatisfyTagCount4facilityNum(
			Integer hotelSatisfyTagCount4facilityNum) {
		this.hotelSatisfyTagCount4facilityNum = hotelSatisfyTagCount4facilityNum;
	}
	public Integer getReqNotSatisfyRoomCount() {
		return reqNotSatisfyRoomCount;
	}
	public void setReqNotSatisfyRoomCount(Integer reqNotSatisfyRoomCount) {
		this.reqNotSatisfyRoomCount = reqNotSatisfyRoomCount;
	}
	public Integer getReqNotSatisfyRoomTypeCount() {
		return reqNotSatisfyRoomTypeCount;
	}
	public void setReqNotSatisfyRoomTypeCount(Integer reqNotSatisfyRoomTypeCount) {
		this.reqNotSatisfyRoomTypeCount = reqNotSatisfyRoomTypeCount;
	}
	public Float getReqMeetingRoomArea4maxMeetingRoomSize() {
		return reqMeetingRoomArea4maxMeetingRoomSize;
	}
	public void setReqMeetingRoomArea4maxMeetingRoomSize(
			Float reqMeetingRoomArea4maxMeetingRoomSize) {
		this.reqMeetingRoomArea4maxMeetingRoomSize = reqMeetingRoomArea4maxMeetingRoomSize;
	}
	public Float getHotelMeetingRoomArea4maxMeetingRoomSize() {
		return hotelMeetingRoomArea4maxMeetingRoomSize;
	}
	public void setHotelMeetingRoomArea4maxMeetingRoomSize(
			Float hotelMeetingRoomArea4maxMeetingRoomSize) {
		this.hotelMeetingRoomArea4maxMeetingRoomSize = hotelMeetingRoomArea4maxMeetingRoomSize;
	}
	public Integer getCustomerTagCount4maxMeetingSetUp() {
		return customerTagCount4maxMeetingSetUp;
	}
	public void setCustomerTagCount4maxMeetingSetUp(
			Integer customerTagCount4maxMeetingSetUp) {
		this.customerTagCount4maxMeetingSetUp = customerTagCount4maxMeetingSetUp;
	}
	public Integer getHotelSatisfyTagCount4maxMeetingSetUp() {
		return hotelSatisfyTagCount4maxMeetingSetUp;
	}
	public void setHotelSatisfyTagCount4maxMeetingSetUp(
			Integer hotelSatisfyTagCount4maxMeetingSetUp) {
		this.hotelSatisfyTagCount4maxMeetingSetUp = hotelSatisfyTagCount4maxMeetingSetUp;
	}
	public Float getReqMeetingRoomArea4max2ndMeetingRoomSize() {
		return reqMeetingRoomArea4max2ndMeetingRoomSize;
	}
	public void setReqMeetingRoomArea4max2ndMeetingRoomSize(
			Float reqMeetingRoomArea4max2ndMeetingRoomSize) {
		this.reqMeetingRoomArea4max2ndMeetingRoomSize = reqMeetingRoomArea4max2ndMeetingRoomSize;
	}
	public Float getHotelMeetingRoomArea4max2ndMeetingRoomSize() {
		return hotelMeetingRoomArea4max2ndMeetingRoomSize;
	}
	public void setHotelMeetingRoomArea4max2ndMeetingRoomSize(
			Float hotelMeetingRoomArea4max2ndMeetingRoomSize) {
		this.hotelMeetingRoomArea4max2ndMeetingRoomSize = hotelMeetingRoomArea4max2ndMeetingRoomSize;
	}
	public Integer getCustomerTagCount4max2ndMeetingSetUp() {
		return customerTagCount4max2ndMeetingSetUp;
	}
	public void setCustomerTagCount4max2ndMeetingSetUp(
			Integer customerTagCount4max2ndMeetingSetUp) {
		this.customerTagCount4max2ndMeetingSetUp = customerTagCount4max2ndMeetingSetUp;
	}
	public Integer getHotelSatisfyTagCount4max2ndMeetingSetUp() {
		return hotelSatisfyTagCount4max2ndMeetingSetUp;
	}
	public void setHotelSatisfyTagCount4max2ndMeetingSetUp(
			Integer hotelSatisfyTagCount4max2ndMeetingSetUp) {
		this.hotelSatisfyTagCount4max2ndMeetingSetUp = hotelSatisfyTagCount4max2ndMeetingSetUp;
	}
	public List<Max3rdMeetingRoomSizeReq> getMax3rdMeetingRoomSizeReqs() {
		return max3rdMeetingRoomSizeReqs;
	}
	public void setMax3rdMeetingRoomSizeReqs(
			List<Max3rdMeetingRoomSizeReq> max3rdMeetingRoomSizeReqs) {
		this.max3rdMeetingRoomSizeReqs = max3rdMeetingRoomSizeReqs;
	}
	public List<Max3rdMeetingSetUpReq> getMax3rdMeetingSetUpReqs() {
		return max3rdMeetingSetUpReqs;
	}
	public void setMax3rdMeetingSetUpReqs(
			List<Max3rdMeetingSetUpReq> max3rdMeetingSetUpReqs) {
		this.max3rdMeetingSetUpReqs = max3rdMeetingSetUpReqs;
	}
	public List<DiningActivityAreaReq> getDiningActivityAreaReqs() {
		return diningActivityAreaReqs;
	}
	public void setDiningActivityAreaReqs(
			List<DiningActivityAreaReq> diningActivityAreaReqs) {
		this.diningActivityAreaReqs = diningActivityAreaReqs;
	}
	public List<DiningActivitySiteReq> getDiningActivitySiteReqs() {
		return diningActivitySiteReqs;
	}
	public void setDiningActivitySiteReqs(
			List<DiningActivitySiteReq> diningActivitySiteReqs) {
		this.diningActivitySiteReqs = diningActivitySiteReqs;
	}
	public List<AvReq> getAvReqs() {
		return avReqs;
	}
	public void setAvReqs(List<AvReq> avReqs) {
		this.avReqs = avReqs;
	}
	public boolean isFacilityNumNecessary() {
		return isFacilityNumNecessary;
	}
	public void setFacilityNumNecessary(boolean isFacilityNumNecessary) {
		this.isFacilityNumNecessary = isFacilityNumNecessary;
	}
	public boolean isRoomNumAndRoomTypeNecessary() {
		return isRoomNumAndRoomTypeNecessary;
	}
	public void setRoomNumAndRoomTypeNecessary(boolean isRoomNumAndRoomTypeNecessary) {
		this.isRoomNumAndRoomTypeNecessary = isRoomNumAndRoomTypeNecessary;
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
	public boolean isMax2ndMeetingRoomSizeNecessary() {
		return isMax2ndMeetingRoomSizeNecessary;
	}
	public void setMax2ndMeetingRoomSizeNecessary(
			boolean isMax2ndMeetingRoomSizeNecessary) {
		this.isMax2ndMeetingRoomSizeNecessary = isMax2ndMeetingRoomSizeNecessary;
	}
	public boolean isMax2ndMeetingSetUpNecessary() {
		return isMax2ndMeetingSetUpNecessary;
	}
	public void setMax2ndMeetingSetUpNecessary(boolean isMax2ndMeetingSetUpNecessary) {
		this.isMax2ndMeetingSetUpNecessary = isMax2ndMeetingSetUpNecessary;
	}

}
