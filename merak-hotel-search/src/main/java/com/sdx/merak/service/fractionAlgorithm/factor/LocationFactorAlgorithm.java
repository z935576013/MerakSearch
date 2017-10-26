package com.sdx.merak.service.fractionAlgorithm.factor;

import com.sdx.merak.service.intf.fractionAlgorithm.dto.AlgorithmRes;
import com.sdx.merak.service.intf.fractionAlgorithm.dto.condition.LocationCondition;
import com.sdx.merak.service.intf.fractionAlgorithm.dto.factor.LocationFactor;

/**
 * location（位置）算法
 * @author yeegor
 *
 */
public abstract class LocationFactorAlgorithm extends BaseFactorAlgorithm {

	public LocationFactorAlgorithm(BaseFactorAlgorithm baseFactorAlgorithm) {
		super(baseFactorAlgorithm);
		super.defaultPercent = 10.0f;
	}
	
	public LocationFactorAlgorithm(AlgorithmRes res) {
		super(res);
		super.defaultPercent = 10.0f;
	}
	
	@Override
	public Float factorAlgorithm() {
		
		if (factorCondition!=null && factorCondition instanceof LocationCondition) {
			
			//System.out.println("位置算法计算");
			
			LocationCondition locationCondition = (LocationCondition)factorCondition;
			Float distancePOI = locationCondition.getDistancePOI();
			Float lotValue = locationCondition.getLotValue();
			
			if (factorCondition.getPercentSetting()!=null) {
				super.defaultPercent = factorCondition.getPercentSetting();
			}
			
			Integer distancePOIFactor = null, lotValueFactor = null;
			LocationFactor locationFactor = new LocationFactor();
			if (locationCondition.isDistancePOINecessary()) {
				distancePOIFactor = locationFactor.distancePOINecessary;
			} else {
				distancePOIFactor = locationFactor.distancePOIPreferred;
			}
			if (locationCondition.isLotValueNecessary()) {
				lotValueFactor = locationFactor.lotValueNecessary;
			} else {
				lotValueFactor = locationFactor.distancePOIPreferred;
			}
			
			if (null==distancePOI || distancePOI.compareTo(0f)==0) {
				distancePOIFactor = 0;
			}
			if (null==lotValue || lotValue.compareTo(0f)==0) {
				lotValueFactor = 0;
			}
			
			Integer totalFraction = distancePOIFactor+lotValueFactor;
			
			if (totalFraction.compareTo(0) == 0) {
				return defaultPercent;
			}
			
			distancePOI = super.filterNegative(distancePOI);
			lotValue = super.filterNegative(lotValue);
			
			Float result = (distancePOI*distancePOIFactor+lotValue*lotValueFactor)*(defaultPercent/totalFraction);
			if (res != null) {
				res.setLocationRes(result);
			} else {
				res.setLocationRes(0f);
			}
			
			if (super.baseFactorAlgorithm != null) {
				result += baseFactorAlgorithm.factorAlgorithm();
			}
			
			return result;
		}
		res.setLocationRes(0f);
		return 0f;
	}

}
