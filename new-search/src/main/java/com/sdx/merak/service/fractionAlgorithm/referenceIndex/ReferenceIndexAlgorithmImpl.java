package com.sdx.merak.service.fractionAlgorithm.referenceIndex;

import java.util.ArrayList;
import java.util.List;

import com.sdx.merak.service.intf.fractionAlgorithm.ReferenceIndexAlgorithm;
import com.sdx.merak.service.intf.fractionAlgorithm.dto.SubResp;
import com.sdx.merak.service.intf.fractionAlgorithm.dto.req.sub.field.AvReq;
import com.sdx.merak.service.intf.fractionAlgorithm.dto.req.sub.field.DiningActivityAreaReq;
import com.sdx.merak.service.intf.fractionAlgorithm.dto.req.sub.field.DiningActivitySiteReq;
import com.sdx.merak.service.intf.fractionAlgorithm.dto.req.sub.field.Max3rdMeetingRoomSizeReq;
import com.sdx.merak.service.intf.fractionAlgorithm.dto.req.sub.field.Max3rdMeetingSetUpReq;

/**
 * ReferenceIndexAlgorithm 实现
 * 参考指标索引算法实现
 * @author yeegor
 */
public class ReferenceIndexAlgorithmImpl implements ReferenceIndexAlgorithm {
	
	/** 零分半分比浮点数 **/
	private final Float zero = 0f;     
	/** 满分百分比浮点数 **/
	private final Float perfect = 1.0f;

	@Override
	public Float distancePOI(Float distanceSetting, Float distance) {
		
		if (null==distanceSetting || distanceSetting.compareTo(0f)==0
				|| null==distance || distance.compareTo(0f)==0) {
			return zero;
		}
		
		Float perfectDistance = distanceSetting; //满分距离

		if (distance.compareTo(perfectDistance) <= 0) { //低于客户设置距离得满分
			return perfect;
		}
		
		//按照百分比降低
		
		Float result = perfect - ((distance-distanceSetting)/distanceSetting);
		
		return result;  
	}

	@Override
	public Float lotValue(Float lotValue) {
		
		if (null == lotValue) {
			lotValue = 0f;
		}
		
		Float perfectLotValue = 5.0f; //地段的满分评分
		
		if (lotValue.compareTo(perfectLotValue) == 0) {
			return perfect;
		}
		
		Float result = perfect - (perfectLotValue-lotValue)*0.2f;
//		if (result.compareTo(0f) < 0) {
//			return zero;
//		}
		
		return result;
	}
	
	/**
	 * 酒店价格-预算
	 * 通用逻辑处理
	 * @param hotelRate 酒店价格
	 * @param customerBudget 预算
	 * @return
	 */
	private Float budget4Rate(Integer hotelRate, Integer customerBudget) {
		
		if (null == hotelRate) {
			hotelRate = 0;
		}
		if (null == customerBudget) {
			customerBudget = 0;
		}
		
		Float hotelRate0 = hotelRate.floatValue();
		Float customerBudget0 = customerBudget.floatValue();
		
		if (customerBudget0.compareTo(0f) == 0) {
			return zero;
		}
		
		if (hotelRate0.compareTo(customerBudget0) <= 0 || hotelRate0.compareTo(0f) <= 0) { //满足预算
			return perfect;
		}
		//System.out.println("hotelRate=" + hotelRate + " customerBudget=" + customerBudget);
		Float result = perfect * (1 - (hotelRate0-customerBudget0)/customerBudget0);
		
//		if (result.compareTo(0f) < 0) {
//			return zero;
//		}
		
		return result;
	}

	@Override
	public Float roomTotalRate(Integer hotelRate, Integer customerBudget) {
		return budget4Rate(hotelRate, customerBudget);
	}

	@Override
	public Float meetingPackageTotalRate(Integer hotelRate,
			Integer customerBudget) {
		return budget4Rate(hotelRate, customerBudget);
	}

	@Override
	public Float groundTotalRent(Integer hotelRate, Integer customerBudget) {
		return budget4Rate(hotelRate, customerBudget);
	}

	@Override
	public Float restaurantTotalRate(Integer hotelRate, Integer customerBudget) {
		return budget4Rate(hotelRate, customerBudget);
	}

	@Override
	public Float totalRate(Integer hotelRate, Integer customerBudget) {
		return budget4Rate(hotelRate, customerBudget);
	}

	@Override
	public boolean eventDate(boolean isSatisfy) {
//		if (isSatisfy) {
//			return perfect;
//		} 
//		return zero;
		return isSatisfy;
	}

	@Override
	public Float contract(Integer negotiabilityTermsCount,
			Integer totalTermsCount) {
		
		if (null==negotiabilityTermsCount || negotiabilityTermsCount.compareTo(0)==0) {
			return zero;
		}
		if (null==totalTermsCount || totalTermsCount.compareTo(0)==0) {
			return perfect;
		}
		
		Float negotiabilityTermsCount0 = negotiabilityTermsCount.floatValue();
		Float totalTermsCount0 = totalTermsCount.floatValue();
		
		if (totalTermsCount0.compareTo(0f) == 0) { //总条款数为零时 满分
			return perfect;
		}
		
		Float perfectPercent = 0.5f; //满足条款50%得满分
		//比例每减少10%时得分点减少20%
		Float p1 = 0.01f, p2 = 0.02f; 
		
		Float proportion = (negotiabilityTermsCount0/totalTermsCount0);  //条款满足比例
		if (perfectPercent.compareTo(proportion) < 0) {
			return perfect;
		}
		
		Float result = perfect * (1 - ((perfectPercent-proportion)/p1)*p2);
//		if (result.compareTo(0f) < 0) {
//			return zero;
//		}
		
		return result;
	}

	@Override
	public Float concession(Integer discountTerms) {
		final Float perfectDiscountTerms = 5.0f; //满分优惠条款数量
		
		if (null==discountTerms || discountTerms.compareTo(0)==0) {
			return zero;
		}

		Float discountTerms0 = discountTerms.floatValue();
		if (perfectDiscountTerms.compareTo(discountTerms0) <=0) {
			return perfect;
		}
		
		Float result = perfect - (perfectDiscountTerms - discountTerms0)*0.2f; //每少一项20%递减
//		if (result.compareTo(0f) < 0) {
//			return zero;
//		}
		return result;
	}

	@Override
	public boolean responseDate(boolean isSatisfy) {
		return isSatisfy;
	}

	@Override
	public Float diningArrangement(Integer satisfyTagCount,
			Integer tagTotalCount) {
		
		if (null==satisfyTagCount || satisfyTagCount.compareTo(0)==0) { //不占比例
			return zero;
		}
		if (null==tagTotalCount || tagTotalCount.compareTo(0)==0) {
			return perfect;
		}
		
		Float satisfyTagCount0 = satisfyTagCount.floatValue();
		Float tagTotalCount0 = tagTotalCount.floatValue();
		
		Float result = satisfyTagCount0/tagTotalCount0;
		
		return result;
	}

	@Override
	public Float merakStar(Float star) {
		
		if (null == star) {
			star = 0f;
		}
		
		Float perfectStar = 7.0f; //满分得分点条件
		Float zeroStar = 3.0f; //零分得分点条件
		if (perfectStar.compareTo(star) <= 0) {
			return perfect;
		}
		if (zeroStar.compareTo(star) > 0) {
			return zero;
		}
		Float result = null;
		Integer c = (int) Math.floor(star);
		switch(c) {
			case 3 :
				result = 0.2f;
				break;
			case 4 :
				result = 0.4f;
				break;
			case 5 :
				result = 0.6f;
				break;
			case 6 :
				result = 0.8f;
				break;
			default :
				break;
		}
		if (null == result) {
			result = zero;
		}
		
		return result;
	}

	@Override
	public Float facilityNum(Integer customerTagCount, Integer hotelSatisfyTagCount) {
		
		if (null == customerTagCount) {
			customerTagCount = 0;
		}
		if (null == hotelSatisfyTagCount) {
			hotelSatisfyTagCount = 0;
		}
		
		if (hotelSatisfyTagCount.compareTo(0) == 0) {
			return zero;
		}
		if (customerTagCount.compareTo(0) == 0) {
			return perfect;
		}
		
		Float customerTagCount0 = customerTagCount.floatValue();
		Float hotelSatisfyTagCount0 = hotelSatisfyTagCount.floatValue();
		
		Float result = hotelSatisfyTagCount0/customerTagCount0;
		if (result.compareTo(1f) > 0) {  //兼容大于1的情况
			result = 1f;
		}
		
		return result;
	}

	@Override
	public Float roomNumAndRoomType(Integer reqNotSatisfyRoomCount,
			Integer reqNotSatisfyRoomTypeCount) {
		
		if (null == reqNotSatisfyRoomCount || null == reqNotSatisfyRoomTypeCount) {
			return zero;
		}
		Float reqNotSatisfyRoomCount0 = reqNotSatisfyRoomCount.floatValue();
		Float reqNotSatisfyRoomTypeCount0 = reqNotSatisfyRoomTypeCount.floatValue();
		
		Float result = 1 - (reqNotSatisfyRoomCount0 + reqNotSatisfyRoomTypeCount0)*0.1f;
//		if (result==null || result.compareTo(0f)<0) {
//			result = zero;
//		}
		return result;
	}

	@Override
	public Float maxMeetingRoomSize(Float reqMeetingRoomArea,
			Float hotelMeetingRoomArea) {
		
		if (null==reqMeetingRoomArea || reqMeetingRoomArea.compareTo(0f)==0
				|| null==hotelMeetingRoomArea || hotelMeetingRoomArea.compareTo(0f)==0) {
			return zero;
		}
		
		if (hotelMeetingRoomArea.compareTo(reqMeetingRoomArea)>=0) {
			Float p0 = ((hotelMeetingRoomArea-reqMeetingRoomArea)/reqMeetingRoomArea); //酒店提供面积超过客户要求面积的百分比
			if (p0 <= 0.5) {
				return perfect;
			} else {
				Float result = (float) (1 - p0 * 0.5);
//				if (result.compareTo(0f)<0) {
//					return zero;
//				}
				return result;
			}
		} else {
			Float p0 = ((reqMeetingRoomArea-hotelMeetingRoomArea)/hotelMeetingRoomArea); //客户要求面积大于酒店提供面积的百分比
			Float result = (float) (1 - p0 * 2);
//			if (result.compareTo(0f)<0) {
//				return zero;
//			}
			return result;
		}
	}

	@Override
	public Float maxMeetingSetUp(Integer customerTagCount,
			Integer hotelSatisfyTagCount) {
		
		if (null==customerTagCount || customerTagCount.compareTo(0)==0
				|| null==hotelSatisfyTagCount || hotelSatisfyTagCount.compareTo(0)==0) {
			return zero;
		}
		
		Float hotelSatisfyTagCount0 = hotelSatisfyTagCount.floatValue();
		Float customerTagCount0 = customerTagCount.floatValue();
		
		Float p = (float) (hotelSatisfyTagCount0/customerTagCount0);
		if (p.compareTo(1f) > 0) {
			p = perfect;
		}
		return p;
	}

	@Override
	public Float max2ndMeetingRoomSize(Float reqMeetingRoomArea,
			Float hotelMeetingRoomArea) {
		
		if (null==reqMeetingRoomArea || reqMeetingRoomArea.compareTo(0f)==0
				|| null==hotelMeetingRoomArea || hotelMeetingRoomArea.compareTo(0f)==0) {
			return zero;
		}
		
		if (hotelMeetingRoomArea.compareTo(reqMeetingRoomArea)>=0) {
			Float p0 = ((hotelMeetingRoomArea-reqMeetingRoomArea)/reqMeetingRoomArea); //酒店提供面积超过客户要求面积的百分比
			if (p0 <= 0.5) {
				return perfect;
			} else {
				Float result = (float) (1 - p0 * 0.5);
//				if (result.compareTo(0f)<0) {
//					return zero;
//				}
				return result;
			}
		} else {
			Float p0 = ((reqMeetingRoomArea-hotelMeetingRoomArea)/hotelMeetingRoomArea); //客户要求面积大于酒店提供面积的百分比
			Float result = (float) (1 - p0 * 2);
//			if (result.compareTo(0f)<0) {
//				return zero;
//			}
			return result;
		}
	}

	@Override
	public Float max2ndMeetingSetUp(Integer customerTagCount,
			Integer hotelSatisfyTagCount) {
		
		if (null==customerTagCount || customerTagCount.compareTo(0)==0
				|| null==hotelSatisfyTagCount || hotelSatisfyTagCount.compareTo(0)==0) {
			return zero;
		}
		
		Float hotelSatisfyTagCount0 = hotelSatisfyTagCount.floatValue();
		Float customerTagCount0 = customerTagCount.floatValue();
		
		Float p = hotelSatisfyTagCount0/customerTagCount0;
		if (p.compareTo(1f) > 0) {
			p = 1f;
		}
		return p;
	}

	@Override
	public Float max3rdMeetingRoomSize(Float reqMeetingRoomArea,
			Float hotelMeetingRoomArea) {
		
		if (null==reqMeetingRoomArea || reqMeetingRoomArea.compareTo(0f)==0
				|| null==hotelMeetingRoomArea || hotelMeetingRoomArea.compareTo(0f)==0) {
			return zero;
		}
		
		if (hotelMeetingRoomArea.compareTo(reqMeetingRoomArea)>=0) {
			Float p0 = ((hotelMeetingRoomArea-reqMeetingRoomArea)/reqMeetingRoomArea); //酒店提供面积超过客户要求面积的百分比
			if (p0 <= 0.5) {
				return perfect;
			} else {
				Float result = (float) (1 - p0 * 0.5);
//				if (result.compareTo(0f)<0) {
//					return zero;
//				}
				return result;
			}
		} else {
			Float p0 = ((reqMeetingRoomArea-hotelMeetingRoomArea)/hotelMeetingRoomArea); //客户要求面积大于酒店提供面积的百分比
			Float result = (float) (1 - p0 * 2);
//			if (result.compareTo(0f)<0) {
//				return zero;
//			}
			return result;
		}
	}
	
	@Override
	public List<SubResp> max3rdMeetingRoomSize(List<Max3rdMeetingRoomSizeReq> max3rdMeetingRoomSizeReqs) {
		List<SubResp> result = new ArrayList<SubResp>();
		if (max3rdMeetingRoomSizeReqs == null || max3rdMeetingRoomSizeReqs.isEmpty()) {
			return result;
		}
		
		for (Max3rdMeetingRoomSizeReq req : max3rdMeetingRoomSizeReqs) {
			SubResp resp = new SubResp();
			resp.setResult(max3rdMeetingRoomSize(req.getReqMeetingRoomArea4max3rdMeetingRoomSize(), req.getHotelMeetingRoomArea4max3rdMeetingRoomSize()));
			resp.setNecessary(req.isMax3rdMeetingRoomSizeNecessary());
			
			result.add(resp);
		}
		return result;
	}

	@Override
	public Float max3rdMeetingSetUp(Integer customerTagCount, Integer hotelSatisfyTagCount) {
		
		if (null==customerTagCount || customerTagCount.compareTo(0)==0
				|| null==hotelSatisfyTagCount || hotelSatisfyTagCount.compareTo(0)==0) {
			return zero;
		}
		
		Float hotelSatisfyTagCount0 = hotelSatisfyTagCount.floatValue();
		Float customerTagCount0 = customerTagCount.floatValue();
		
		return hotelSatisfyTagCount0/customerTagCount0;
	}
	
	@Override
	public List<SubResp> max3rdMeetingSetUp(List<Max3rdMeetingSetUpReq> max3rdMeetingSetUpReqs) {
		List<SubResp> result = new ArrayList<SubResp>();
		if (max3rdMeetingSetUpReqs==null || max3rdMeetingSetUpReqs.isEmpty()) {
			return result;
		}
		for (Max3rdMeetingSetUpReq req : max3rdMeetingSetUpReqs) {
			SubResp resp = new SubResp();
			resp.setResult(max3rdMeetingSetUp(req.getCustomerTagCount4max3rdMeetingSetUp(), req.getHotelSatisfyTagCount4max3rdMeetingSetUp()));
			resp.setNecessary(req.isMax3rdMeetingSetUpNecessary());
			
			result.add(resp);
		}
		return result;
	}

	@Override
	public Float diningActivityArea(Float reqDiningArea, Float hotelDiningArea) {
		
		if (null==reqDiningArea || reqDiningArea.compareTo(0f)==0
				|| null==hotelDiningArea || hotelDiningArea.compareTo(0f)==0) {
			return zero;
		}
		
		if (reqDiningArea.compareTo(hotelDiningArea) < 0 || hotelDiningArea.compareTo(0f)<=0) {
			return perfect;
		}
		Float result = 1 - ((reqDiningArea-hotelDiningArea)/hotelDiningArea)*2;
//		if (result.compareTo(0f) < 0) {
//			result = zero;
//		}
		return result;
	}
	
	@Override
	public List<SubResp> diningActivityArea(List<DiningActivityAreaReq> diningActivityAreaReqs) {
		List<SubResp> result = new ArrayList<SubResp>();
		if (diningActivityAreaReqs==null || diningActivityAreaReqs.isEmpty()) {
			return result;
		}
		for (DiningActivityAreaReq req : diningActivityAreaReqs) {
			SubResp resp = new SubResp();
			resp.setResult(diningActivityArea(req.getReqDiningArea(), req.getHotelDiningArea()));
			resp.setNecessary(req.isDiningActivityAreaNecessary());
			
			result.add(resp);
		}
		return result;
	}

	@Override
	public Float diningActivitySiteReq(Integer customerTagCount,
			Integer hotelSatisfyTagCount) {
		
		if (null==customerTagCount || customerTagCount.compareTo(0)==0
				|| null==hotelSatisfyTagCount || hotelSatisfyTagCount.compareTo(0)==0) {
			return zero;
		}
		
		Float hotelSatisfyTagCount0 = hotelSatisfyTagCount.floatValue();
		Float customerTagCount0 = customerTagCount.floatValue();
		
		Float p = hotelSatisfyTagCount0/customerTagCount0;
		if (p.compareTo(1f) > 0) {
			p = 1f;
		}
		return p;
	}
	
	@Override
	public List<SubResp> diningActivitySiteReq(List<DiningActivitySiteReq> diningActivitySiteReqs) {
		List<SubResp> result = new ArrayList<SubResp>();
		if (diningActivitySiteReqs==null || diningActivitySiteReqs.isEmpty()) {
			return result;
		}
		for (DiningActivitySiteReq req : diningActivitySiteReqs) {
			SubResp resp = new SubResp();
			resp.setResult(diningActivitySiteReq(req.getCustomerTagCount4diningActivitySiteReq(), req.getHotelSatisfyTagCount4diningActivitySiteReq()));
			resp.setNecessary(req.isDiningActivitySiteReqNecessary());
			
			result.add(resp);
		}
		return result;
	}

	@Override
	public Float avReq(Integer customerTagCount, Integer hotelSatisfyTagCount) {
		
		if (null==customerTagCount || customerTagCount.compareTo(0)==0
				|| null==hotelSatisfyTagCount || hotelSatisfyTagCount.compareTo(0)==0) {
			return zero;
		}
		
		Float hotelSatisfyTagCount0 = hotelSatisfyTagCount.floatValue();
		Float customerTagCount0 = customerTagCount.floatValue();
		
		Float p = hotelSatisfyTagCount0/customerTagCount0;
		if (p.compareTo(1f) > 0) {
			p = 1f;
		}
		return p;
	}

	@Override
	public List<SubResp> avReq(List<AvReq> avReqs) {
		List<SubResp> result = new ArrayList<SubResp>();
		if (avReqs == null || avReqs.isEmpty()) {
			return result;
		}
		for (AvReq req : avReqs) {
			SubResp resp = new SubResp();
			resp.setResult(avReq(req.getCustomerTagCount4avReq(), req.getHotelSatisfyTagCount4avReq()));
			resp.setNecessary(req.isAvReqNecessary());
			
			result.add(resp);
		}
		return result;
	}

}
