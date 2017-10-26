package com.sdx.merak.service.intf.fractionAlgorithm.dto.condition;

/**
 * Rate(价格）
 * @author yeegor
 *
 */
public class RateCondition extends FactorCondition {

	private static final long serialVersionUID = 1L;
	
	/**
	 * 总房价 酒店价格：所有房间数量和房型的包含服务费的价格，如果客户选择了早餐和网络为必选，则比较所有杂费全含的总价。客户预算：房间单价*总房间数（
	 * 不计房型）。 满足预算得分100%，超出预算比例等比例减扣
	 */
	private Float roomTotalPrice;
	
	/**
	 * 总会议包价 酒店价格：会议包价含服务费的总价（酒店会场的最低会议包价人数要求可能多余客户参会人数，核算是取较大值）。 客户预算：单价*人数。
	 * 满足预算得分100%，超出预算比例等比例减扣
	 */
	private Float meetingPackageTotalPrice;
	
	/**
	 * 总场地租金
	 * 酒店价格：所有会议室场租费用和提前入场布置场租费的总和。 客户预算：按客户填写值为准。 满足预算得分100%，超出预算比例等比例减扣
	 */
	private Float groundTotalRent;
	
	/**
	 * 总餐饮费用 
	 * 所有单独收费的餐饮项目和服务费总和（如果已经包含在房费中的早餐和包含在会议包价中的餐饮项目不重复计算
	 * （无客户数据对比的情况下，按照所有酒店报价中价格最低的三家平均价为客户预算进行排序，此条款适用与整个价格排序参考指标）
	 */
	private Float restaurantTotalRate; 
	
	/**
	 * 总价 
	 * 所有费用总和（包括AV，其他特殊需求的花费等等）满足预算得分100%，超出预算比例等比例减扣。
	 * 总价得分和分项得分存在排序中重复计算，因为有些杂费是其他分项无法反应出来的，分项各自单独的得分也要综合考虑
	 */
	private Float totalRate;
	
	//条件是否必要
	private boolean isRoomTotalPriceNecessary;
	private boolean isMeetingPackageTotalPriceNecessary;
	private boolean isGroundTotalRentNecessary;
	private boolean isRestaurantTotalRateNecessary;
	private boolean isTotalRateNecessary;

	public Float getRoomTotalPrice() {
		return roomTotalPrice;
	}

	public void setRoomTotalPrice(Float roomTotalPrice) {
		this.roomTotalPrice = roomTotalPrice;
	}

	public Float getMeetingPackageTotalPrice() {
		return meetingPackageTotalPrice;
	}

	public void setMeetingPackageTotalPrice(Float meetingPackageTotalPrice) {
		this.meetingPackageTotalPrice = meetingPackageTotalPrice;
	}

	public Float getGroundTotalRent() {
		return groundTotalRent;
	}

	public void setGroundTotalRent(Float groundTotalRent) {
		this.groundTotalRent = groundTotalRent;
	}

	public Float getRestaurantTotalRate() {
		return restaurantTotalRate;
	}

	public void setRestaurantTotalRate(Float restaurantTotalRate) {
		this.restaurantTotalRate = restaurantTotalRate;
	}

	public Float getTotalRate() {
		return totalRate;
	}

	public void setTotalRate(Float totalRate) {
		this.totalRate = totalRate;
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
