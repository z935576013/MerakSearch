package com.sdx.merak.service.fractionAlgorithm.factor;

import com.sdx.merak.service.intf.fractionAlgorithm.dto.AlgorithmRes;
import com.sdx.merak.service.intf.fractionAlgorithm.dto.condition.BookingTermsCondition;
import com.sdx.merak.service.intf.fractionAlgorithm.dto.factor.BookingTermsFactor;

/**
 * Booking Terms(预定条款）算法
 * @author yeegor
 *
 */
public abstract class BookingTermsFactorAlgorithm extends BaseFactorAlgorithm {

	public BookingTermsFactorAlgorithm(BaseFactorAlgorithm baseFactorAlgorithm) {
		super(baseFactorAlgorithm);
		super.defaultPercent = 10.0f;
	}
	
	public BookingTermsFactorAlgorithm(AlgorithmRes res) {
		super(res);
		super.defaultPercent = 10.0f;
	}

	@Override
	public Float factorAlgorithm() {
		
		if (factorCondition!=null && factorCondition instanceof BookingTermsCondition) {
			
			//System.out.println("预定条款算法计算");
			
			BookingTermsCondition bookingTermsCondition = (BookingTermsCondition)factorCondition;
			boolean isEventDate = bookingTermsCondition.isEventDate();
			Float contract = bookingTermsCondition.getContract();
			Float concession = bookingTermsCondition.getConcession();
			
			if (factorCondition.getPercentSetting()!=null) {
				super.defaultPercent = factorCondition.getPercentSetting();
			}
			
			Integer isEventDateFactor = null, contractFactor = null, concessionFactor = null;
			BookingTermsFactor bookingTermsFactor = new BookingTermsFactor();
			if (isEventDate) { //得满分
				if (bookingTermsCondition.isEventDateNecessary()) {
					isEventDateFactor = bookingTermsFactor.eventDateNecessary;
				} else {
					isEventDateFactor = bookingTermsFactor.eventDatePreferred;
				}
			} else {
				isEventDateFactor = 0;
			}
			
			if (bookingTermsCondition.isContractNecessary()) {
				contractFactor = bookingTermsFactor.contractNecessary;
			} else {
				contractFactor = bookingTermsFactor.contractPreferred;
			}
			
			if (bookingTermsCondition.isConcessionNecessary()) {
				concessionFactor = bookingTermsFactor.concessionNecessary;
			} else {
				concessionFactor = bookingTermsFactor.concessionPreferred;
			}
			
			if (null==contract || contract.compareTo(0f)==0) {
				contractFactor = 0;
			}
			
			if (null==concession || concession.compareTo(0f)==0) {
				concessionFactor = 0;
			}
			
			Integer totalFraction = isEventDateFactor+contractFactor+concessionFactor;
			if (totalFraction.compareTo(0)==0) {
				return defaultPercent;
			}
			
			contract = super.filterNegative(contract);
			concession = super.filterNegative(concession);
			
			Float result = (contract*contractFactor +
					       concession*concessionFactor +
					       isEventDateFactor)
					       *(defaultPercent/totalFraction);
			
			if (res != null) {
				res.setBookingTermsRes(result);
			} else {
				res.setBookingTermsRes(0f);
			}
			if (super.baseFactorAlgorithm != null) {
				result += baseFactorAlgorithm.factorAlgorithm();
			}
			
			return result;
		}
		res.setBookingTermsRes(0f);
		return 0f;
	}

}
