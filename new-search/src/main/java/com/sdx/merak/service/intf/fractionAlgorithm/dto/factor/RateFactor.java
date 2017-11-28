package com.sdx.merak.service.intf.fractionAlgorithm.dto.factor;

import java.io.Serializable;

/**
 * Rate(价格）
 * @author yeegor
 *
 */
public class RateFactor implements Serializable {

	private static final long serialVersionUID = 1L;
	
	//参考指标
	/** 总房价-必要得分点 **/
	public final Integer roomTotalRateNecessary = 3; 
	/** 总房价-优选得分点 **/
	public final Integer roomTotalRatePreferred = 1;
	/** 总会议包价-必要得分点 **/
	public final Integer meetingPackageTotalRateNecessary = 3; 
	/** 总会议包价-优选得分点 **/
	public final Integer meetingPackageTotalRatePreferred = 1;
	/** 总场地租金-必要得分点 **/
	public final Integer groundTotalRentNecessary = 2; 
	/** 总场地租金-优选得分点 **/
	public final Integer groundTotalRentPreferred = 1;
	/** 总餐饮费用-必要得分点 **/
	public final Integer restaurantTotalRateNecessary = 1; 
	/** 总餐饮费用-优选得分点 **/
	public final Integer restaurantTotalRatePreferred = 1;
	/** 总价-必要得分点 **/
	public final Integer totalRateNecessary = 5; 
	/** 总价-优选得分点 **/
	public final Integer totalRatePreferred = 3;
}
