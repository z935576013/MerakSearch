package com.sdx.merak.service.fractionAlgorithm;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

import com.sdx.merak.service.fractionAlgorithm.factor.BaseFactorAlgorithm;
import com.sdx.merak.service.fractionAlgorithm.factor.BookingTermsFactorAlgorithm;
import com.sdx.merak.service.fractionAlgorithm.factor.FacilityFactorAlgorithm;
import com.sdx.merak.service.fractionAlgorithm.factor.LocationFactorAlgorithm;
import com.sdx.merak.service.fractionAlgorithm.factor.RateFactorAlgorithm;
import com.sdx.merak.service.fractionAlgorithm.factor.ServiceFactorAlgorithm;
import com.sdx.merak.service.fractionAlgorithm.referenceIndex.ReferenceIndexAlgorithmImpl;
import com.sdx.merak.service.intf.fractionAlgorithm.FractionAlgorithm;
import com.sdx.merak.service.intf.fractionAlgorithm.ReferenceIndexAlgorithm;
import com.sdx.merak.service.intf.fractionAlgorithm.dto.AlgorithmRes;
import com.sdx.merak.service.intf.fractionAlgorithm.dto.condition.BookingTermsCondition;
import com.sdx.merak.service.intf.fractionAlgorithm.dto.condition.FacilityCondition;
import com.sdx.merak.service.intf.fractionAlgorithm.dto.condition.FactorCondition;
import com.sdx.merak.service.intf.fractionAlgorithm.dto.condition.LocationCondition;
import com.sdx.merak.service.intf.fractionAlgorithm.dto.condition.RateCondition;
import com.sdx.merak.service.intf.fractionAlgorithm.dto.condition.ServiceCondition;
import com.sdx.merak.service.intf.fractionAlgorithm.dto.req.AlgorithmReq;
import com.sdx.merak.service.intf.fractionAlgorithm.dto.req.sub.BookingTermsReq;
import com.sdx.merak.service.intf.fractionAlgorithm.dto.req.sub.FacilityReq;
import com.sdx.merak.service.intf.fractionAlgorithm.dto.req.sub.LocationReq;
import com.sdx.merak.service.intf.fractionAlgorithm.dto.req.sub.RateReq;
import com.sdx.merak.service.intf.fractionAlgorithm.dto.req.sub.ServiceReq;

/**
 * FractionAlgorithm实现
 * @author yeegor
 */
public class FractionAlgorithmImpl implements FractionAlgorithm {
	
	ReferenceIndexAlgorithm referenceIndexAlgorithm=new ReferenceIndexAlgorithmImpl();
	
	@Override
	public Float algorithm(AlgorithmReq algorithmReq) {
		
		BaseFactorAlgorithm algorithm = constructBaseFactorAlgorithm(algorithmReq, null);
		
		if(algorithm == null) {
			return 0f;
		}
		
		return wrapValue(algorithm.factorAlgorithm());
	}

	@Override
	public AlgorithmRes enhanceAlgorithm(final AlgorithmReq algorithmReq) {
		
		AlgorithmRes res = new AlgorithmRes();
		
		BaseFactorAlgorithm algorithm = constructBaseFactorAlgorithm(algorithmReq, res);
		if(algorithm == null) {
			return new AlgorithmRes();
		}
		
		Float result = wrapValue(algorithm.factorAlgorithm());
		
		if (result != null) {
			res.setRes(result);
		} else {
			res.setRes(0f);
		}
		return res;
	}
	
	private Float wrapValue(Float value) {
		
		if (value != null) {
			NumberFormat nf = new DecimalFormat("#.##");
			try {
				return Float.parseFloat(nf.format(value.doubleValue()));
			} catch (Exception e) {
				return value;
			}
		}
		
		return 0f;
	}
	
	/**
	 * 构造链式调用头对象
	 * @param algorithmReq  算法请求参数
	 * @param res    算法结果输出对象
	 * @return
	 */
	private BaseFactorAlgorithm constructBaseFactorAlgorithm(final AlgorithmReq algorithmReq, AlgorithmRes res) {
		
	     final LocationReq locationReq = algorithmReq.getLocationReq();
	     final RateReq rateReq = algorithmReq.getRateReq();
	     final BookingTermsReq bookingTermsReq = algorithmReq.getBookingTermsReq();
	     final ServiceReq serviceReq = algorithmReq.getServiceReq();
	     final FacilityReq facilityReq = algorithmReq.getFacilityReq();
	    
	     FacilityFactorAlgorithm f = null;
	     RateFactorAlgorithm r = null;
	     ServiceFactorAlgorithm s = null;
	     BookingTermsFactorAlgorithm b = null;
	     LocationFactorAlgorithm l = null;
		
	     if (facilityReq != null) {
		     f = new FacilityFactorAlgorithm(res) {
					@Override
					public FactorCondition initFactorCondition() {
						FacilityCondition fc = new FacilityCondition();
						fc.setFacilityNum(referenceIndexAlgorithm.facilityNum(facilityReq.getCustomerTagCount4facilityNum(), facilityReq.getHotelSatisfyTagCount4facilityNum()));
						fc.setFacilityNumNecessary(facilityReq.isFacilityNumNecessary());
						fc.setRoomNumAndRoomType(referenceIndexAlgorithm.roomNumAndRoomType(facilityReq.getReqNotSatisfyRoomCount(), facilityReq.getReqNotSatisfyRoomTypeCount()));
						fc.setRoomNumAndRoomTypeNecessary(facilityReq.isRoomNumAndRoomTypeNecessary());
						fc.setMaxMeetingRoomSize(referenceIndexAlgorithm.maxMeetingRoomSize(facilityReq.getReqMeetingRoomArea4maxMeetingRoomSize(), facilityReq.getHotelMeetingRoomArea4maxMeetingRoomSize()));
						fc.setMaxMeetingRoomSizeNecessary(facilityReq.isMaxMeetingRoomSizeNecessary());
						fc.setMaxMeetingSetUp(referenceIndexAlgorithm.maxMeetingSetUp(facilityReq.getCustomerTagCount4maxMeetingSetUp(), facilityReq.getHotelSatisfyTagCount4maxMeetingSetUp()));
						fc.setMaxMeetingSetUpNecessary(facilityReq.isMaxMeetingSetUpNecessary());
						fc.setMax2ndMeetingRoomSize(referenceIndexAlgorithm.max2ndMeetingRoomSize(facilityReq.getReqMeetingRoomArea4max2ndMeetingRoomSize(), facilityReq.getHotelMeetingRoomArea4max2ndMeetingRoomSize()));
						fc.setMax2ndMeetingRoomSizeNecessary(facilityReq.isMax2ndMeetingRoomSizeNecessary());
						fc.setMax2ndMeetingSetUp(referenceIndexAlgorithm.max2ndMeetingSetUp(facilityReq.getCustomerTagCount4max2ndMeetingSetUp(), facilityReq.getHotelSatisfyTagCount4max2ndMeetingSetUp()));
						fc.setMax2ndMeetingSetUpNecessary(facilityReq.isMax2ndMeetingSetUpNecessary());
						
						//处理list入参
						fc.setMax3rdMeetingRoomSizeResp(referenceIndexAlgorithm.max3rdMeetingRoomSize(facilityReq.getMax3rdMeetingRoomSizeReqs()));//参数修改为list
						fc.setMax3rdMeetingSetUpResp(referenceIndexAlgorithm.max3rdMeetingSetUp(facilityReq.getMax3rdMeetingSetUpReqs()));//参数修改为list
						fc.setDiningActivityAreaResp(referenceIndexAlgorithm.diningActivityArea(facilityReq.getDiningActivityAreaReqs()));
						fc.setDiningActivitySiteReqResp(referenceIndexAlgorithm.diningActivitySiteReq(facilityReq.getDiningActivitySiteReqs()));
						fc.setAvReqResp(referenceIndexAlgorithm.avReq(facilityReq.getAvReqs()));
						
						//设置得分点百分比
						fc.setPercentSetting(facilityReq.getFacilityPercent());
						
						return fc;
					}
				};
	     }
	     
	     if (rateReq != null) {
		     r = new RateFactorAlgorithm(res) {
					@Override
					public FactorCondition initFactorCondition() {
						RateCondition rc = new RateCondition();
						rc.setRoomTotalPrice(referenceIndexAlgorithm.roomTotalRate(rateReq.getHotelRate4roomTotalRate(), rateReq.getCustomerBudget4roomTotalRate()));
						rc.setRoomTotalPriceNecessary(rateReq.isRoomTotalPriceNecessary());
						rc.setMeetingPackageTotalPrice(referenceIndexAlgorithm.meetingPackageTotalRate(rateReq.getHotelRate4meetingPackageTotalRate(), rateReq.getCustomerBudget4meetingPackageTotalRate()));
						rc.setMeetingPackageTotalPriceNecessary(rateReq.isMeetingPackageTotalPriceNecessary());
						rc.setGroundTotalRent(referenceIndexAlgorithm.groundTotalRent(rateReq.getHotelRate4groundTotalRent(), rateReq.getCustomerBudget4groundTotalRent()));
						rc.setGroundTotalRentNecessary(rateReq.isGroundTotalRentNecessary());
						rc.setRestaurantTotalRate(referenceIndexAlgorithm.restaurantTotalRate(rateReq.getHotelRate4restaurantTotalRate(), rateReq.getCustomerBudget4restaurantTotalRate()));
						rc.setRestaurantTotalRateNecessary(rateReq.isRestaurantTotalRateNecessary());
						rc.setTotalRate(referenceIndexAlgorithm.totalRate(rateReq.getHotelRate4totalRate(), rateReq.getCustomerBudget4totalRate()));
						rc.setTotalRateNecessary(rateReq.isTotalRateNecessary());
						
						//设置得分点百分比
						rc.setPercentSetting(rateReq.getRatePercent());
						
						return rc;
					}
				};
	     }

	     if (serviceReq != null) {
	    	 s = new ServiceFactorAlgorithm(res) {
	 			@Override
	 			public FactorCondition initFactorCondition() {
	 				ServiceCondition sc  = new ServiceCondition();
	 				sc.setDiningArrangement(referenceIndexAlgorithm.diningArrangement(serviceReq.getSatisfyTagCount4diningArrangement(), serviceReq.getTagTotalCount4diningArrangement()));
	 				sc.setDiningArrangementNecessary(serviceReq.isDiningArrangementNecessary());
	 				sc.setMerakStar(referenceIndexAlgorithm.merakStar(serviceReq.getStar()));
	 				sc.setMerakStarNecessary(serviceReq.isMerakStarNecessary());
	 				sc.setResponseDate(referenceIndexAlgorithm.responseDate(serviceReq.isSatisfy4responseDate()));
	 				sc.setResponseDateNecessary(serviceReq.isResponseDateNecessary());
	 				
	 				//设置得分点百分比
	 				sc.setPercentSetting(serviceReq.getServicePercent());
	 				
	 				return sc;
	 			}
	 		};
	     }

	     
	     if (bookingTermsReq != null) {
	    	 b = new BookingTermsFactorAlgorithm(res) {
	 			@Override
	 			public FactorCondition initFactorCondition() {
	 				BookingTermsCondition bc = new BookingTermsCondition();
	 				bc.setConcession(referenceIndexAlgorithm.concession(bookingTermsReq.getDiscountTerms()));
	 				bc.setConcessionNecessary(bookingTermsReq.isConcessionNecessary());
	 				bc.setContract(referenceIndexAlgorithm.contract(bookingTermsReq.getNegotiabilityTermsCount(), bookingTermsReq.getTotalTermsCount()));
	 				bc.setContractNecessary(bookingTermsReq.isContractNecessary());
	 				bc.setEventDate(referenceIndexAlgorithm.eventDate(bookingTermsReq.isSatisfy4eventDate()));
	 				bc.setEventDateNecessary(bookingTermsReq.isEventDateNecessary());
	 				
	 				//设置得分点百分比
	 				bc.setPercentSetting(bookingTermsReq.getBookingTermsPercent());
	 				
	 				return bc;
	 			}
	 		};
	     }
	     
	     if (locationReq != null) {
	    	 l = new LocationFactorAlgorithm(res) {
	 			@Override
	 			public FactorCondition initFactorCondition() {
	 				LocationCondition lc = new LocationCondition();
	 				lc.setDistancePOI(referenceIndexAlgorithm.distancePOI(locationReq.getDistanceSetting(), locationReq.getDistance()));
	 				lc.setDistancePOINecessary(locationReq.isDistancePOINecessary());
	 				lc.setLotValue(referenceIndexAlgorithm.lotValue(locationReq.getLotValue()));
	 				lc.setLotValueNecessary(locationReq.isLotValueNecessary());
	 				
	 				//设置得分点百分比
	 				lc.setPercentSetting(locationReq.getLocationTermsPercent());
	 				
	 				return lc;
	 			}
	 		};
	     }
	     BaseFactorAlgorithm[] handlers0 = new BaseFactorAlgorithm[]{f, r, s, b, l};
	     List<BaseFactorAlgorithm> handlers = new ArrayList<BaseFactorAlgorithm>();
	     for (BaseFactorAlgorithm h0 : handlers0) {
	    	 if (h0 != null) {
	    		 handlers.add(h0);
	    	 }
	     }
	     if (handlers!=null && !handlers.isEmpty()) {
	    	 for (int i=handlers.size()-1; i>0; i--) {
	    		 BaseFactorAlgorithm handler = handlers.get(i);
	    		 BaseFactorAlgorithm nextHandler = handlers.get(i-1);
	    		 handler.setNextHandler(nextHandler);
	    	 }
	    	 
	    	 return handlers.get(handlers.size()-1);
	     }

		
		return null;
	}

}
