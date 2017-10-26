package com.sdx.merak.service.fractionAlgorithm.factor;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;

import com.sdx.merak.service.intf.fractionAlgorithm.dto.AlgorithmRes;
import com.sdx.merak.service.intf.fractionAlgorithm.dto.SubResp;
import com.sdx.merak.service.intf.fractionAlgorithm.dto.condition.FacilityCondition;
import com.sdx.merak.service.intf.fractionAlgorithm.dto.factor.FacilityFactor;

/**
 * Facility (设施）算法
 * @author yeegor
 *
 */
public abstract class FacilityFactorAlgorithm extends BaseFactorAlgorithm {

	public FacilityFactorAlgorithm(BaseFactorAlgorithm baseFactorAlgorithm) {
		super(baseFactorAlgorithm);
		super.defaultPercent = 30.0f;
	}
	
	public FacilityFactorAlgorithm(AlgorithmRes res) {
		super(res);
		super.defaultPercent = 30.0f;
	}

	@Override
	public Float factorAlgorithm() {
		
		if (factorCondition!=null && factorCondition instanceof FacilityCondition) {
			
			//System.out.println("设施算法计算");
			
			FacilityCondition facilityCondition = (FacilityCondition)factorCondition;
			
			Float facilityNum = facilityCondition.getFacilityNum();
			Float roomNumAndRoomType = facilityCondition.getRoomNumAndRoomType();
			Float maxMeetingRoomSize = facilityCondition.getMaxMeetingRoomSize();
			Float maxMeetingSetUp = facilityCondition.getMaxMeetingSetUp();
			Float max2ndMeetingRoomSize = facilityCondition.getMax2ndMeetingRoomSize();
			Float max2ndMeetingSetUp = facilityCondition.getMax2ndMeetingSetUp();
			
			List<SubResp> max3rdMeetingRoomSizeResps = facilityCondition.getMax3rdMeetingRoomSizeResp();
			List<SubResp> max3rdMeetingSetUpResps = facilityCondition.getMax3rdMeetingSetUpResp();
			List<SubResp> diningActivityAreaResps = facilityCondition.getDiningActivityAreaResp();
			List<SubResp> diningActivitySiteResps = facilityCondition.getDiningActivitySiteReqResp();
			List<SubResp> avReqResps = facilityCondition.getAvReqResp();
			
			if (facilityNum==null || roomNumAndRoomType==null || maxMeetingRoomSize==null || maxMeetingSetUp==null
					|| max2ndMeetingRoomSize==null || max2ndMeetingSetUp==null) {
				return 0f;
			}
			
			if (factorCondition.getPercentSetting()!=null) {
				super.defaultPercent = factorCondition.getPercentSetting();
			}
			
			//叠加Factor值的list需要赋初始值累加
			Integer facilityNumFactor=null, roomNumAndRoomTypeFactor=null, maxMeetingRoomSizeFactor=null, maxMeetingSetUpFactor=null,
					max2ndMeetingRoomSizeFactor=null, max2ndMeetingSetUpFactor=null, max3rdMeetingRoomSizeFactor=0,
					max3rdMeetingSetUpFactor=0, diningActivityAreaFactor=0, diningActivitySiteReqFactor=0, avReqFactor=0;
			
			FacilityFactor facilityFactor = new FacilityFactor();
			
			if (facilityCondition.isFacilityNumNecessary()) {
				facilityNumFactor = facilityFactor.facilityNecessary;
			} else {
				facilityNumFactor = facilityFactor.facilityPreferred;
			}
			if (facilityCondition.isRoomNumAndRoomTypeNecessary()) {
				roomNumAndRoomTypeFactor = facilityFactor.roomCountAndRoomTypeNecessary;
			} else {
				roomNumAndRoomTypeFactor = facilityFactor.roomCountAndRoomTypePreferred;
			}
			if (facilityCondition.isMaxMeetingRoomSizeNecessary()) {
				maxMeetingRoomSizeFactor = facilityFactor.maxMeetingRoomSizeNecessary;
			} else {
				maxMeetingRoomSizeFactor = facilityFactor.maxMeetingRoomSizePreferred;
			}
			if (facilityCondition.isMaxMeetingSetUpNecessary()) {
				maxMeetingSetUpFactor = facilityFactor.maxMeetingSetUpNecessary;
			} else {
				maxMeetingSetUpFactor = facilityFactor.maxMeetingSetUpPreferred;
			}
			if (facilityCondition.isMax2ndMeetingRoomSizeNecessary()) {
				max2ndMeetingRoomSizeFactor = facilityFactor.max2ndMeetingRoomSizeNecessary;
			} else {
				max2ndMeetingRoomSizeFactor = facilityFactor.max2ndMeetingRoomSizePreferred;
			}
			if (facilityCondition.isMax2ndMeetingSetUpNecessary()) {
				max2ndMeetingSetUpFactor = facilityFactor.max2ndMeetingSetUpNecessary;
			} else {
				max2ndMeetingSetUpFactor = facilityFactor.max2ndMeetingSetUpPreferred;
			}
			
			//处理算法list参数
			Float max3rdMeetingRoomSizeResps0 = new Float(0);
			if (CollectionUtils.isNotEmpty(max3rdMeetingRoomSizeResps)) {
				for (SubResp resp : max3rdMeetingRoomSizeResps) {
					Integer max3rdMeetingRoomSizeFactor0 = resp.isNecessary()?facilityFactor.max3rdMeetingRoomSizeNecessary:facilityFactor.max3rdMeetingRoomSizePreferred;
					
					Float result = resp.getResult();
					if (null!=result && result.compareTo(0f)!=0) {
						result = super.filterNegative(result);
						max3rdMeetingRoomSizeResps0 += result*max3rdMeetingRoomSizeFactor0;
						max3rdMeetingRoomSizeFactor += max3rdMeetingRoomSizeFactor0;
					}
//					max3rdMeetingRoomSizeResps0 += result*max3rdMeetingRoomSizeFactor0;
//					if (null!=max3rdMeetingRoomSizeResps0 && max3rdMeetingRoomSizeResps0.compareTo(0f)>0) {
//						max3rdMeetingRoomSizeFactor += max3rdMeetingRoomSizeFactor0;
//					}
				}
			} else {
				max3rdMeetingRoomSizeFactor = facilityFactor.empty;
			}

			Float max3rdMeetingSetUpResps0 = new Float(0);
			if (CollectionUtils.isNotEmpty(max3rdMeetingSetUpResps)) {
				for (SubResp resp : max3rdMeetingSetUpResps) {
					Integer max3rdMeetingSetUpFactor0 = resp.isNecessary()?facilityFactor.max3rdMeetingSetUpNecessary:facilityFactor.max3rdMeetingSetUpPreferred;
					
					Float result = resp.getResult();
					if (null!=result && result.compareTo(0f)!=0) {
						result = super.filterNegative(result);
						max3rdMeetingSetUpResps0 += result*max3rdMeetingSetUpFactor0;
						max3rdMeetingSetUpFactor += max3rdMeetingSetUpFactor0;
					}
					
//					max3rdMeetingSetUpResps0 += resp.getResult()*max3rdMeetingSetUpFactor0;
//					if (null!=max3rdMeetingSetUpResps0 && max3rdMeetingSetUpResps0.compareTo(0f)>0) {
//						max3rdMeetingSetUpFactor += max3rdMeetingSetUpFactor0;
//					}
				}
			} else {
				max3rdMeetingSetUpFactor = facilityFactor.empty;
			}
			
			Float diningActivityAreaResps0 = new Float(0);
			if (CollectionUtils.isNotEmpty(diningActivityAreaResps)) {
				for (SubResp resp : diningActivityAreaResps) {
					Integer diningActivityAreaFactor0 = resp.isNecessary()?facilityFactor.diningActivityAreaNecessary:facilityFactor.diningActivityAreaPreferred;
					
					Float result = resp.getResult();
					if (null!=result && result.compareTo(0f)!=0) {
						result = super.filterNegative(result);
						diningActivityAreaResps0 += result*diningActivityAreaFactor0;
						diningActivityAreaFactor += diningActivityAreaFactor0;
					}
					
//					diningActivityAreaResps0 += resp.getResult()*diningActivityAreaFactor0;
//					if (null!=diningActivityAreaResps0 && diningActivityAreaResps0.compareTo(0f)>0) {
//						diningActivityAreaFactor += diningActivityAreaFactor0;
//					}
				}
			} else {
				diningActivityAreaFactor = facilityFactor.empty;
			}
			
			Float diningActivitySiteResps0 = new Float(0);
			if (CollectionUtils.isNotEmpty(diningActivitySiteResps)) {
				for (SubResp resp : diningActivitySiteResps) {
					Integer diningActivitySiteFactor0 = resp.isNecessary()?facilityFactor.diningActivitySiteReqNecessary:facilityFactor.diningActivitySiteReqPreferred;
					
					Float result = resp.getResult();
					if (null!=result && result.compareTo(0f)!=0) {
						result = super.filterNegative(result);
						diningActivitySiteResps0 += result*diningActivitySiteFactor0;
						diningActivitySiteReqFactor += diningActivitySiteFactor0;
					}
					
//					diningActivitySiteResps0 += resp.getResult()*diningActivitySiteFactor0;
//					if (null!=diningActivitySiteResps0 && diningActivitySiteResps0.compareTo(0f)>0) {
//						diningActivitySiteReqFactor += diningActivitySiteFactor0;
//					}
				}
			} else {
				diningActivitySiteReqFactor = facilityFactor.empty;
			}
			
			Float avReqResps0 = new Float(0);
			if (CollectionUtils.isNotEmpty(avReqResps)) {
				for (SubResp resp : avReqResps) {
					Integer avReqFactor0 = resp.isNecessary()?facilityFactor.avReqNecessary:facilityFactor.avReqPreferred;
					
					Float result = resp.getResult();
					if (null!=result && result.compareTo(0f)!=0) {
						result = super.filterNegative(result);
						avReqResps0 += result*avReqFactor0;
						avReqFactor += avReqFactor0;
					}
					
//					avReqResps0 += resp.getResult()*avReqFactor0;
//					if (null!=avReqResps0 && avReqResps0.compareTo(0f)>0) {
//						avReqFactor += avReqFactor0;
//					}
				}
			} else {
				avReqFactor = facilityFactor.empty;
			}
			
			Integer totalFraction = facilityNumFactor+roomNumAndRoomTypeFactor+maxMeetingRoomSizeFactor+maxMeetingSetUpFactor+max2ndMeetingRoomSizeFactor+max2ndMeetingSetUpFactor+max3rdMeetingRoomSizeFactor
					+max3rdMeetingSetUpFactor+diningActivityAreaFactor+diningActivitySiteReqFactor+avReqFactor;
			
			if (totalFraction.compareTo(0)==0) {
				return defaultPercent;
			}
			
		    facilityNum = super.filterNegative(facilityNum);
			roomNumAndRoomType = super.filterNegative(roomNumAndRoomType);
			maxMeetingRoomSize = super.filterNegative(maxMeetingRoomSize);
			maxMeetingSetUp = super.filterNegative(maxMeetingSetUp);
			max2ndMeetingRoomSize = super.filterNegative(max2ndMeetingRoomSize);
			max2ndMeetingSetUp = super.filterNegative(max2ndMeetingSetUp);
			
			Float result = (facilityNum*facilityNumFactor +
							roomNumAndRoomType*roomNumAndRoomTypeFactor +
							maxMeetingRoomSize*maxMeetingRoomSizeFactor +
							maxMeetingSetUp*maxMeetingSetUpFactor +
							max2ndMeetingRoomSize*max2ndMeetingRoomSizeFactor +
							max2ndMeetingSetUp*max2ndMeetingSetUpFactor +
							max3rdMeetingRoomSizeResps0 +
							max3rdMeetingSetUpResps0 +
							diningActivityAreaResps0 +
							diningActivitySiteResps0 +
							avReqResps0)
							*(defaultPercent/totalFraction);
			
			if (res != null) {
				res.setFacilityRes(result);
			} else {
				res.setFacilityRes(0f);
			}
			if (super.baseFactorAlgorithm != null) {
				result += baseFactorAlgorithm.factorAlgorithm();
			}
			
			return result;
		}
		res.setFacilityRes(0f);
		return 0f;
	}

}
