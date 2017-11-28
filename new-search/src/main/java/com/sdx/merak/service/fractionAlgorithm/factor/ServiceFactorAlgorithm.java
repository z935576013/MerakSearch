package com.sdx.merak.service.fractionAlgorithm.factor;

import com.sdx.merak.service.intf.fractionAlgorithm.dto.AlgorithmRes;
import com.sdx.merak.service.intf.fractionAlgorithm.dto.condition.ServiceCondition;
import com.sdx.merak.service.intf.fractionAlgorithm.dto.factor.ServiceFactor;

/**
 * service（服务）算法
 * @author yeegor
 *
 */
public abstract class ServiceFactorAlgorithm extends BaseFactorAlgorithm {

	public ServiceFactorAlgorithm(BaseFactorAlgorithm baseFactorAlgorithm) {
		super(baseFactorAlgorithm);
		super.defaultPercent = 10.0f;
	}
	
	public ServiceFactorAlgorithm(AlgorithmRes res) {
		super(res);
		super.defaultPercent = 10.0f;
	}

	@Override
	public Float factorAlgorithm() {
		
		if (factorCondition!=null && factorCondition instanceof ServiceCondition) {
			
			//System.out.println("服务算法计算");
			
			ServiceCondition serviceCondition = (ServiceCondition)factorCondition;
			boolean isResponseDate = serviceCondition.isResponseDate();
			Float diningArrangement = serviceCondition.getDiningArrangement();
			Float merakStar = serviceCondition.getMerakStar();
			
			if (diningArrangement==null) {
				diningArrangement = 0f;
			}
			if (merakStar == null) {
				merakStar = 0f; 
			}
			
			if (factorCondition.getPercentSetting()!=null) {
				super.defaultPercent = factorCondition.getPercentSetting();
			}
			
			Integer isResponseDateFactor = null, diningArrangementFactor = null, merakStarFactor = null;
			ServiceFactor serviceFactor = new ServiceFactor();
			if (isResponseDate) { //满分
				if (serviceCondition.isResponseDateNecessary()) {
					isResponseDateFactor = serviceFactor.responseDateNecessary;
				} else {
					isResponseDateFactor = serviceFactor.responseDatePreferred;
				}
			} else {
				isResponseDateFactor = 0;
			}
			if (serviceCondition.isDiningArrangementNecessary()) {
				diningArrangementFactor = serviceFactor.diningArrangementNecessary;
			} else {
				diningArrangementFactor = serviceFactor.diningArrangementPreferred;
			}
			if (serviceCondition.isMerakStarNecessary()) {
				merakStarFactor = serviceFactor.merakStarNecessary;
			} else {
				merakStarFactor = serviceFactor.merakStarPreferred;
			}
			
			//diningArrangement酒店端不care的情况
			if (diningArrangement.compareTo(0f) == 0) {
				diningArrangementFactor = 0;
			}
			
			Float result = (isResponseDateFactor +
					        diningArrangement*diningArrangementFactor +
					        merakStar*merakStarFactor)*(defaultPercent/(isResponseDateFactor+diningArrangementFactor+merakStarFactor));
			
			if (res != null) {
				res.setServiceRes(result);
			} else {
				res.setServiceRes(0f);
			}
			if (super.baseFactorAlgorithm != null) {
				result += baseFactorAlgorithm.factorAlgorithm();
			}
			
			return result;
		}
		res.setServiceRes(0f);
		return 0f;
	}

}
