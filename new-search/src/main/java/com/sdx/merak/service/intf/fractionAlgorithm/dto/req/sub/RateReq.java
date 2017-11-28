package com.sdx.merak.service.intf.fractionAlgorithm.dto.req.sub;

import java.io.Serializable;

public class RateReq implements Serializable {

	private static final long serialVersionUID = 1L;
	
	/** 价格得分点百分比 默认40% - eg : 设置25%  参数值25.0f **/
	private Float ratePercent; 
	
	/** 总房价-酒店价格 **/
	private Integer hotelRate4roomTotalRate;
	
	/** 总房价-客户预算 **/
	private Integer customerBudget4roomTotalRate;
	
	/** 总会议包价-酒店价格 **/
	private Integer hotelRate4meetingPackageTotalRate;
	
	/** 总会议包价-客户预算 **/
	private Integer customerBudget4meetingPackageTotalRate;
	
	/** 总场地租金-酒店价格 **/
	private Integer hotelRate4groundTotalRent;
	
	/** 总场地租金-客户预算 **/
	private Integer customerBudget4groundTotalRent;
	
	/** 总餐饮费用-酒店价格 **/
	private Integer hotelRate4restaurantTotalRate;
	
	/** 总餐饮费用-客户预算[所有酒店报价中价格最低的三家平均价] **/
	private Integer customerBudget4restaurantTotalRate;
	
	/** 总价-酒店价格 **/
	private Integer hotelRate4totalRate;
	
	/** 总价-客户预算 **/
	private Integer customerBudget4totalRate;
	
	//是否必要
	private boolean isRoomTotalPriceNecessary; //总房价
	private boolean isMeetingPackageTotalPriceNecessary; //总会议包价
	private boolean isGroundTotalRentNecessary; //总场地租金
	private boolean isRestaurantTotalRateNecessary; //总餐饮费用
	private boolean isTotalRateNecessary; //总价
	public Float getRatePercent() {
		return ratePercent;
	}
	public void setRatePercent(Float ratePercent) {
		this.ratePercent = ratePercent;
	}
	public Integer getHotelRate4roomTotalRate() {
		return hotelRate4roomTotalRate;
	}
	public void setHotelRate4roomTotalRate(Integer hotelRate4roomTotalRate) {
		this.hotelRate4roomTotalRate = hotelRate4roomTotalRate;
	}
	public Integer getCustomerBudget4roomTotalRate() {
		return customerBudget4roomTotalRate;
	}
	public void setCustomerBudget4roomTotalRate(Integer customerBudget4roomTotalRate) {
		this.customerBudget4roomTotalRate = customerBudget4roomTotalRate;
	}
	public Integer getHotelRate4meetingPackageTotalRate() {
		return hotelRate4meetingPackageTotalRate;
	}
	public void setHotelRate4meetingPackageTotalRate(
			Integer hotelRate4meetingPackageTotalRate) {
		this.hotelRate4meetingPackageTotalRate = hotelRate4meetingPackageTotalRate;
	}
	public Integer getCustomerBudget4meetingPackageTotalRate() {
		return customerBudget4meetingPackageTotalRate;
	}
	public void setCustomerBudget4meetingPackageTotalRate(
			Integer customerBudget4meetingPackageTotalRate) {
		this.customerBudget4meetingPackageTotalRate = customerBudget4meetingPackageTotalRate;
	}
	public Integer getHotelRate4groundTotalRent() {
		return hotelRate4groundTotalRent;
	}
	public void setHotelRate4groundTotalRent(Integer hotelRate4groundTotalRent) {
		this.hotelRate4groundTotalRent = hotelRate4groundTotalRent;
	}
	public Integer getCustomerBudget4groundTotalRent() {
		return customerBudget4groundTotalRent;
	}
	public void setCustomerBudget4groundTotalRent(
			Integer customerBudget4groundTotalRent) {
		this.customerBudget4groundTotalRent = customerBudget4groundTotalRent;
	}
	public Integer getHotelRate4restaurantTotalRate() {
		return hotelRate4restaurantTotalRate;
	}
	public void setHotelRate4restaurantTotalRate(
			Integer hotelRate4restaurantTotalRate) {
		this.hotelRate4restaurantTotalRate = hotelRate4restaurantTotalRate;
	}
	public Integer getCustomerBudget4restaurantTotalRate() {
		return customerBudget4restaurantTotalRate;
	}
	public void setCustomerBudget4restaurantTotalRate(
			Integer customerBudget4restaurantTotalRate) {
		this.customerBudget4restaurantTotalRate = customerBudget4restaurantTotalRate;
	}
	public Integer getHotelRate4totalRate() {
		return hotelRate4totalRate;
	}
	public void setHotelRate4totalRate(Integer hotelRate4totalRate) {
		this.hotelRate4totalRate = hotelRate4totalRate;
	}
	public Integer getCustomerBudget4totalRate() {
		return customerBudget4totalRate;
	}
	public void setCustomerBudget4totalRate(Integer customerBudget4totalRate) {
		this.customerBudget4totalRate = customerBudget4totalRate;
	}
	public boolean isRoomTotalPriceNecessary() {
		return isRoomTotalPriceNecessary;
	}
	public void setRoomTotalPriceNecessary(boolean isRoomTotalPriceNecessary) {
		this.isRoomTotalPriceNecessary = isRoomTotalPriceNecessary;
	}
	public boolean isMeetingPackageTotalPriceNecessary() {
		return isMeetingPackageTotalPriceNecessary;
	}
	public void setMeetingPackageTotalPriceNecessary(
			boolean isMeetingPackageTotalPriceNecessary) {
		this.isMeetingPackageTotalPriceNecessary = isMeetingPackageTotalPriceNecessary;
	}
	public boolean isGroundTotalRentNecessary() {
		return isGroundTotalRentNecessary;
	}
	public void setGroundTotalRentNecessary(boolean isGroundTotalRentNecessary) {
		this.isGroundTotalRentNecessary = isGroundTotalRentNecessary;
	}
	public boolean isRestaurantTotalRateNecessary() {
		return isRestaurantTotalRateNecessary;
	}
	public void setRestaurantTotalRateNecessary(
			boolean isRestaurantTotalRateNecessary) {
		this.isRestaurantTotalRateNecessary = isRestaurantTotalRateNecessary;
	}
	public boolean isTotalRateNecessary() {
		return isTotalRateNecessary;
	}
	public void setTotalRateNecessary(boolean isTotalRateNecessary) {
		this.isTotalRateNecessary = isTotalRateNecessary;
	}

}
