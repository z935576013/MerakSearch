package com.sdx.merak.service.intf.fractionAlgorithm;

import java.util.List;

import com.sdx.merak.service.intf.fractionAlgorithm.dto.SubResp;
import com.sdx.merak.service.intf.fractionAlgorithm.dto.req.sub.field.AvReq;
import com.sdx.merak.service.intf.fractionAlgorithm.dto.req.sub.field.DiningActivityAreaReq;
import com.sdx.merak.service.intf.fractionAlgorithm.dto.req.sub.field.DiningActivitySiteReq;
import com.sdx.merak.service.intf.fractionAlgorithm.dto.req.sub.field.Max3rdMeetingRoomSizeReq;
import com.sdx.merak.service.intf.fractionAlgorithm.dto.req.sub.field.Max3rdMeetingSetUpReq;

/**
 * 参考指标的业务逻辑算法
 * @author yeegor
 *
 */
public interface ReferenceIndexAlgorithm {
	
	/**
	 * 距离POI
	 * 符合距离要求内得满分，超出距离按照比例扣分，例：客户设置距离POI 5KM 以内的酒店，在优选情况下，距离OPI6公里的酒店得80%的分，
	 * 距离 7公里的得到 60%的分，距离10公里以上的没有得分
	 * 
	 * @param distanceSetting 客户设置距离
	 * @param distance  实际距离
	 * @return 百分比浮点数
	 */
	Float distancePOI(Float distanceSetting, Float distance);
	
	/**
	 * 地段价值
	 * 参考地段评分,5.0得满分，4.0得80% 以此类推
	 * @param lotValue 地段评分
	 * @return 百分比浮点数
	 */
	Float lotValue(Float lotValue);
	
	/**
	 * 总房价
	 * 酒店价格：所有房间数量和房型的包含服务费的价格，如果客户选择了早餐和网络为必选，则比较所有杂费全含的总价。
	 * 客户预算：房间单价*总房间数（不计房型）。满足预算得分100%，超出预算比例等比例减扣
	 * @param Integer hotelRate 酒店价格
	 * @param Integer customerBudget 客户预算
	 * @return 百分比浮点数
	 */
	Float roomTotalRate(Integer hotelRate, Integer customerBudget);
	
	/**
	 * 总会议包价 
	 * 酒店价格：会议包价含服务费的总价（酒店会场的最低会议包价人数要求可能多余客户参会人数，核算是取较大值）。 客户预算：单价*人数。
	 * 满足预算得分100%，超出预算比例等比例减扣
	 * @param hotelRate
	 * @param customerBudget
	 * @return 百分比浮点数
	 */
	Float meetingPackageTotalRate(Integer hotelRate, Integer customerBudget);
	
	/**
	 * 总场地租金
	 * 酒店价格：所有会议室场租费用和提前入场布置场租费的总和。 客户预算：按客户填写值为准。 满足预算得分100%，超出预算比例等比例减扣
	 * @param hotelRate
	 * @param customerBudget
	 * @return 百分比浮点数
	 */
	Float groundTotalRent(Integer hotelRate, Integer customerBudget);
	
	/**
	 * 总餐饮费用 
	 * 所有单独收费的餐饮项目和服务费总和（如果已经包含在房费中的早餐和包含在会议包价中的餐饮项目不重复计算
	 * （无客户数据对比的情况下，按照所有酒店报价中价格最低的三家平均价为客户预算进行排序，此条款适用与整个价格排序参考指标）
	 * @param hotelRate  
	 * @param customerBudget 所有酒店报价中价格最低的三家平均价
	 * @return 百分比浮点数
	 */
	Float restaurantTotalRate(Integer hotelRate, Integer customerBudget);
	
	/**
	 * 总价 
	 * 所有费用总和（包括AV，其他特殊需求的花费等等）满足预算得分100%，超出预算比例等比例减扣。
	 * 总价得分和分项得分存在排序中重复计算，因为有些杂费是其他分项无法反应出来的，分项各自单独的得分也要综合考虑
	 * @param hotelRate
	 * @param customerBudget
	 * @return 百分比浮点数
	 */
	Float totalRate(Integer hotelRate, Integer customerBudget);
	
	/**
	 * Event Date
	 * 满足要求得满分，不满足不得分
	 * @param isSatisfy 是否满足
	 * @return 是否满足
	 */
	boolean eventDate(boolean isSatisfy);
	
	/**
	 * Contract 
	 * 酒店合约：得分比例依据 可谈判条款数量/总条款数量
	 * 。如果这个比例超过50%则得满分，小于50%的以此类推递减得分。例：酒店一个有10项合约条款
	 * ，有5个可以谈的则得分率为100%，有4个是可以谈判的则得分率为80% 有3个是可以谈判的则得分率为60%
	 * 以此递减类推（默认必选，依据酒店合约我们人工维护进来的数据
	 * @param negotiabilityTermsCount 可谈判条款数量
	 * @param totalTermsCount         总条款数量
	 * @return 百分比浮点数
	 */
	Float contract (Integer negotiabilityTermsCount, Integer totalTermsCount);
	
	/**
	 * Concession（优惠条款）
	 * 酒店提供的该RFP适用的优惠条款数量。 5项优惠条款及以上的得满分，4项80%，3项60% 以此类推
	 * @param discountTerms 优惠条款数量
	 * @return 百分比浮点数
	 */
	Float concession(Integer discountTerms);
	
	/**
	 * Response Date (报价时间）
	 * 满足要求得满分，不满足不得分
	 * @param isSatisfy 是否满足
	 * @return 是否满足
	 */
	boolean responseDate(boolean isSatisfy);
	
	/**
	 * F&B 餐饮安排
	 * 酒店满足客户选择的食物酒水安排，几分之几的tag不满足，等比例扣分 （如提供具体餐厅安排，提供菜单，则算法等于增加了两个系统tag
	 * @param satisfyTagCount  满足条件的tag数量
	 * @param tagTotalCount    tag总数量
	 * @return 百分比浮点数
	 */
	Float diningArrangement(Integer satisfyTagCount, Integer tagTotalCount);

	/**
	 * Merak Star (觅星服务评分）
	 * 7分为满分100% 得分， 3分及以下得分为0. 3-7中间4分得维度同比例对应得分点。（本项不需要客户定义preference，默认必要地评分指标）
	 * @param star 服务评分
	 * @return 百分比浮点数
	 */
	Float merakStar(Float star);
	
	/**
	 * 设施
	 * 酒店基本设施所有被选中的项目平均分配此项分值，例：客户选了5项设施要求，酒店满足4项，则获得80%的分数
	 * @param customerTagCount       客户选项数量
	 * @param hotelSatisfyTagCount   酒店满足的选项数量
	 * @return 百分比浮点数
	 */
	Float facilityNum(Integer customerTagCount, Integer hotelSatisfyTagCount);
	
	/**
	 * 房间数量和房型要求
	 * 全部满足则满分，如果某天房间数量或者某个房型不匹配则扣除10%
	 * @param reqNotSatisfyRoomCount       不匹配的房间数量
	 * @param reqNotSatisfyRoomTypeCount   不匹配的房型数量
	 * @return 百分比浮点数
	 */
	Float roomNumAndRoomType(Integer reqNotSatisfyRoomCount, Integer reqNotSatisfyRoomTypeCount);
	
	/**
	 * Largest Meeting Room Size (最大会议室面积） 
	 * 酒店提供的会场不小于面积要求满分，双倍递减 面积小了5%扣
	 * 10%的分数。酒店提供的会场面积大于客户要求面积50%以上的也不是好事儿，需要扣分，0.5倍递减扣分
	 * 酒店会场面积是客户要求面积的150%是口服起点，如果酒店面积是客户要求面积的160% 则扣（160%-150%） *0.5 =
	 * 5%的分数，得分率95%
	 * @param reqMeetingRoomArea   客户要求面积
	 * @param hotelMeetingRoomArea 酒店会场面积
	 * @return 百分比浮点数
	 */
	Float maxMeetingRoomSize(Float reqMeetingRoomArea, Float hotelMeetingRoomArea);
	
	/**
	 * Largest Meeting set up (最大会议室要求）
	 * 酒店提供的会场完全满足要求满分，不完全满足则看有几分之几的tag不满足，等比例扣分（例：客户选择5个tag 酒店只满足3个，则得分60%
	 * @param customerTagCount       客户选项数量
	 * @param hotelSatisfyTagCount   酒店满足的选项数量
	 * @return 百分比浮点数
	 */
	Float maxMeetingSetUp(Integer customerTagCount, Integer hotelSatisfyTagCount);
	
	/**
	 * 2nd larget Meeting room size (第二会议室面积） 
	 * 酒店提供的会场不小于面积要求满分，双倍递减 面积小了5%扣
	 * 10%的分数。酒店提供的会场面积大于客户要求面积50%以上的也不是好事儿，需要扣分，0.5倍递减扣分
	 * 酒店会场面积是客户要求面积的150%是口服起点，如果酒店面积是客户要求面积的160% 则扣（160%-150%） *0.5 =
	 * 5%的分数，得分率95%
	 * @param reqMeetingRoomArea   客户要求面积
	 * @param hotelMeetingRoomArea 酒店会场面积
	 * @return 百分比浮点数
	 */
	Float max2ndMeetingRoomSize(Float reqMeetingRoomArea, Float hotelMeetingRoomArea);
	
	/**
	 * 2nd Largest Meeting set up (最大会议室要求）
	 * 酒店提供的会场完全满足要求满分，不完全满足则看有几分之几的tag不满足，等比例扣分（例：客户选择5个tag 酒店只满足3个，则得分60%
	 * @param customerTagCount       客户选项数量
	 * @param hotelSatisfyTagCount   酒店满足的选项数量
	 * @return 百分比浮点数
	 */
	Float max2ndMeetingSetUp(Integer customerTagCount, Integer hotelSatisfyTagCount);
	
	/**
	 * 第三大会议室面积
	 * 酒店提供的会场不小于面积要求满分，双倍递减扣分小于5%扣 10%的分数（ 同理叠加计算第四 第五等其他会议室）
	 * @param reqMeetingRoomArea 客户要求面积
	 * @param hotelMeetingRoomArea 酒店会场面积
	 * @return 百分比浮点数
	 */
	@Deprecated
	Float max3rdMeetingRoomSize(Float reqMeetingRoomArea, Float hotelMeetingRoomArea);
	
	/**
	 * 第三大会议室面积
	 * 酒店提供的会场不小于面积要求满分，双倍递减扣分小于5%扣 10%的分数（ 同理叠加计算第四 第五等其他会议室）
	 * @param reqMeetingRoomArea 客户要求面积
	 * @param hotelMeetingRoomArea 酒店会场面积
	 * @return 百分比浮点数
	 */
	List<SubResp> max3rdMeetingRoomSize(List<Max3rdMeetingRoomSizeReq> max3rdMeetingRoomSizeReqs);
	
	/**
	 * 第三大会议室要求
	 * 酒店提供的会场完全满足要求满分，不完全满足则看有几分之几的tag不满足，等比例扣分（例：客户选择5个tag 酒店只满足3个，则得分60%
	 * @param customerTagCount       客户选项数量
	 * @param hotelSatisfyTagCount   酒店满足的选项数量
	 * @return 百分比浮点数
	 */
	@Deprecated
	Float max3rdMeetingSetUp(Integer customerTagCount, Integer hotelSatisfyTagCount);
	
	/**
	 * 第三大会议室要求
	 * 酒店提供的会场完全满足要求满分，不完全满足则看有几分之几的tag不满足，等比例扣分（例：客户选择5个tag 酒店只满足3个，则得分60%
	 * @param customerTagCount       客户选项数量
	 * @param hotelSatisfyTagCount   酒店满足的选项数量
	 * @return 百分比浮点数
	 */
	List<SubResp> max3rdMeetingSetUp(List<Max3rdMeetingSetUpReq> max3rdMeetingSetUpReqs);
	
	/**
	 * 每项餐饮活动的场地面积
	 * 酒店提供的会场不小于面积要求满分，双倍递减扣分小于5%扣 10%的分数
	 * @param reqDiningArea    客户要求面积
	 * @param hotelDiningArea  酒店餐厅面积
	 * @return 百分比浮点数
	 */
	@Deprecated
	Float diningActivityArea(Float reqDiningArea, Float hotelDiningArea);
	
	/**
	 * 每项餐饮活动的场地面积
	 * 酒店提供的会场不小于面积要求满分，双倍递减扣分小于5%扣 10%的分数
	 * @param reqDiningArea    客户要求面积
	 * @param hotelDiningArea  酒店餐厅面积
	 * @return 百分比浮点数
	 */
	List<SubResp> diningActivityArea(List<DiningActivityAreaReq> diningActivityAreaReqs);
	
	/**
	 * 每项餐饮活动的场地要求
	 * 酒店提供的会场完全满足要求满分，不完全满足则看有几分之几的tag不满足，等比例扣分（例：客户选择5个tag 酒店只满足3个，则得分60%（ 同理叠加计算）
	 * @param customerTagCount      客户选项数量
	 * @param hotelSatisfyTagCount  酒店满足的选项数量
	 * @return 百分比浮点数
	 */
	@Deprecated
	Float diningActivitySiteReq(Integer customerTagCount, Integer hotelSatisfyTagCount);
	
	/**
	 * 每项餐饮活动的场地要求
	 * 酒店提供的会场完全满足要求满分，不完全满足则看有几分之几的tag不满足，等比例扣分（例：客户选择5个tag 酒店只满足3个，则得分60%（ 同理叠加计算）
	 * @param customerTagCount      客户选项数量
	 * @param hotelSatisfyTagCount  酒店满足的选项数量
	 * @return 百分比浮点数
	 */
	List<SubResp> diningActivitySiteReq(List<DiningActivitySiteReq> diningActivitySiteReqs);
	
	/**
	 * AV要求集合
	 * 酒店提供的会场完全满足要求满分，不完全满足则看有几分之几的tag不满足，等比例扣分（例：客户选择5个tag 酒店只满足3个，则得分60%（ 同理叠加计算）
	 * @param customerTagCount
	 * @param hotelSatisfyTagCount
	 * @return
	 */
	@Deprecated
	Float avReq(Integer customerTagCount, Integer hotelSatisfyTagCount);
	
	/**
	 * AV要求集合
	 * 酒店提供的会场完全满足要求满分，不完全满足则看有几分之几的tag不满足，等比例扣分（例：客户选择5个tag 酒店只满足3个，则得分60%（ 同理叠加计算）
	 * @param customerTagCount
	 * @param hotelSatisfyTagCount
	 * @return
	 */
	List<SubResp> avReq(List<AvReq> avReqs);
}
