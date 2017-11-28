package com.sdx.merak.service.fractionAlgorithm.factor;

import com.sdx.merak.service.intf.fractionAlgorithm.dto.AlgorithmRes;
import com.sdx.merak.service.intf.fractionAlgorithm.dto.condition.RateCondition;
import com.sdx.merak.service.intf.fractionAlgorithm.dto.factor.RateFactor;

/**
 * Rate(价格）算法
 * @author yeegor
 *
 */
public abstract class RateFactorAlgorithm extends BaseFactorAlgorithm {

	public RateFactorAlgorithm(BaseFactorAlgorithm baseFactorAlgorithm) {
		super(baseFactorAlgorithm);
		super.defaultPercent = 40.0f;
	}
	
	public RateFactorAlgorithm(AlgorithmRes res) {
		super(res);
		super.defaultPercent = 40.0f;
	}
	
	@Override
	public Float factorAlgorithm() {
		
		if (factorCondition!=null && factorCondition instanceof RateCondition) {
			
			//System.out.println("价格算法计算");
			
			RateCondition rateCondition = (RateCondition)factorCondition;
			Float roomTotalPrice = rateCondition.getRoomTotalPrice();
			Float meetingPackageTotalPrice = rateCondition.getMeetingPackageTotalPrice();
			Float groundTotalRent = rateCondition.getGroundTotalRent();
			Float restaurantTotalRate = rateCondition.getRestaurantTotalRate();
			Float totalRate = rateCondition.getTotalRate();
			
			if (factorCondition.getPercentSetting()!=null) {
				super.defaultPercent = factorCondition.getPercentSetting();
			}
			
			Integer roomTotalPriceFactor = null, meetingPackageTotalPriceFactor = null, groundTotalRentFactor = null,
					restaurantTotalRateFactor = null, totalRateFactor = null;
			RateFactor rateFactor = new RateFactor();
			
			if (rateCondition.isRoomTotalPriceNecessary()) {
				roomTotalPriceFactor = rateFactor.roomTotalRateNecessary;
			} else {
				roomTotalPriceFactor = rateFactor.roomTotalRatePreferred;
			}
			if (rateCondition.isMeetingPackageTotalPriceNecessary()) {
				meetingPackageTotalPriceFactor = rateFactor.meetingPackageTotalRateNecessary;
			} else {
				meetingPackageTotalPriceFactor = rateFactor.meetingPackageTotalRatePreferred;
			}
			if (rateCondition.isGroundTotalRentNecessary()) {
				groundTotalRentFactor = rateFactor.groundTotalRentNecessary;
			} else {
				groundTotalRentFactor = rateFactor.groundTotalRentPreferred;
			}
			if (rateCondition.isRestaurantTotalRateNecessary()) {
				restaurantTotalRateFactor = rateFactor.restaurantTotalRateNecessary;
			} else {
				restaurantTotalRateFactor = rateFactor.restaurantTotalRatePreferred;
			}
			if (rateCondition.isTotalRateNecessary()) {
				totalRateFactor = rateFactor.totalRateNecessary;
			} else {
				totalRateFactor = rateFactor.totalRatePreferred;
			}
			
			if (roomTotalPrice==null || roomTotalPrice.compareTo(0f)==0) {
				roomTotalPriceFactor = 0;
			}
			if (meetingPackageTotalPrice==null || meetingPackageTotalPrice.compareTo(0f)==0) {
				meetingPackageTotalPriceFactor = 0;
			}
			if (groundTotalRent==null || groundTotalRent.compareTo(0f)==0) {
				groundTotalRentFactor = 0;
			}
			if (restaurantTotalRate==null || restaurantTotalRate.compareTo(0f)==0) {
				restaurantTotalRateFactor = 0;
			}
			if (totalRate==null || totalRate.compareTo(0f)==0) {
				totalRateFactor = 0;
			}
			
			Integer totalFraction = roomTotalPriceFactor+meetingPackageTotalPriceFactor+groundTotalRentFactor+restaurantTotalRateFactor+totalRateFactor;
			
			if (totalFraction.compareTo(0) == 0) {
				return defaultPercent;
			}
			
			roomTotalPrice = super.filterNegative(roomTotalPrice);
			meetingPackageTotalPrice = super.filterNegative(meetingPackageTotalPrice);
			groundTotalRent = super.filterNegative(groundTotalRent);
			restaurantTotalRate = super.filterNegative(restaurantTotalRate);
			totalRate = super.filterNegative(totalRate);
			
			Float result = (roomTotalPrice*roomTotalPriceFactor +
					        meetingPackageTotalPrice*meetingPackageTotalPriceFactor +
					        groundTotalRent*groundTotalRentFactor +
					        restaurantTotalRate*restaurantTotalRateFactor +
					        totalRate*totalRateFactor)
					        *(defaultPercent/totalFraction);
			
			if (res != null) {
				res.setRateRes(result);
			} else {
				res.setRateRes(0f);
			}
			if (super.baseFactorAlgorithm != null) {
				result += baseFactorAlgorithm.factorAlgorithm();
			}
			
			return result;
		}
		res.setRateRes(0f);
		return 0f;
	}

}
