package com.sdx.merak.service.intf.fractionAlgorithm.dto.condition;

import java.util.List;

import com.sdx.merak.service.intf.fractionAlgorithm.dto.SubResp;

/**
 * Facility (设施）
 * @author yeegor
 *
 */
public class FacilityCondition extends FactorCondition {

	private static final long serialVersionUID = 1L;
	
	/**
	 * 设施
	 * 酒店基本设施所有被选中的项目平均分配此项分值，例：客户选了5项设施要求，酒店满足4项，则获得80%的分数
	 */
	private Float facilityNum;
	
	/**
	 * 房间数量和房型要求
	 * 全部满足则满分，如果某天房间数量或者某个房型不匹配则扣除10%
	 */
	private Float roomNumAndRoomType;
	
	/**
	 * Largest Meeting Room Size (最大会议室面积） 
	 * 酒店提供的会场不小于面积要求满分，双倍递减 面积小了5%扣
	 * 10%的分数。酒店提供的会场面积大于客户要求面积50%以上的也不是好事儿，需要扣分，0.5倍递减扣分
	 * 酒店会场面积是客户要求面积的150%是口服起点，如果酒店面积是客户要求面积的160% 则扣（160%-150%） *0.5 =
	 * 5%的分数，得分率95%
	 */
	private Float maxMeetingRoomSize;
	
	/**
	 * Largest Meeting set up (最大会议室要求）
	 * 酒店提供的会场完全满足要求满分，不完全满足则看有几分之几的tag不满足，等比例扣分（例：客户选择5个tag 酒店只满足3个，则得分60%
	 */
	private Float maxMeetingSetUp;
	
	/**
	 * 2nd larget Meeting room size (第二会议室面积） 
	 * 酒店提供的会场不小于面积要求满分，双倍递减 面积小了5%扣
	 * 10%的分数。酒店提供的会场面积大于客户要求面积50%以上的也不是好事儿，需要扣分，0.5倍递减扣分
	 * 酒店会场面积是客户要求面积的150%是口服起点，如果酒店面积是客户要求面积的160% 则扣（160%-150%） *0.5 =
	 * 5%的分数，得分率95%
	 */
	private Float max2ndMeetingRoomSize;
	
	/**
	 * 2nd Largest Meeting set up (第二会议室要求）
	 * 酒店提供的会场完全满足要求满分，不完全满足则看有几分之几的tag不满足，等比例扣分（例：客户选择5个tag 酒店只满足3个，则得分60%
	 */
	private Float max2ndMeetingSetUp;
	
	/** 
	 *  第三大会议室面积 
	 *  酒店提供的会场不小于面积要求满分，双倍递减扣分小于5%扣 10%的分数（ 同理叠加计算第四 第五等其他会议室）
	 * **/
	private List<SubResp> max3rdMeetingRoomSizeResp;
	
	/**
	 * 第三大会议室要求 
	 * 酒店提供的会场完全满足要求满分，不完全满足则看有几分之几的tag不满足，等比例扣分（例：客户选择5个tag
	 * 酒店只满足3个，则得分60%（ 同理叠加计算第四 第五等其他会议室）
	 */
	private List<SubResp> max3rdMeetingSetUpResp;
	
	/**
	 * 每项餐饮活动的场地面积
	 * 酒店提供的会场不小于面积要求满分，双倍递减扣分小于5%扣 10%的分数
	 */
	private List<SubResp> diningActivityAreaResp;
	
	/**
	 * 每项餐饮活动的场地要求
	 * 酒店提供的会场完全满足要求满分，不完全满足则看有几分之几的tag不满足，等比例扣分（例：客户选择5个tag 酒店只满足3个，则得分60%（ 同理叠加计算）
	 */
	private List<SubResp> diningActivitySiteReqResp;
	
	/**
	 * AV要求集合
	 * 酒店提供的会场完全满足要求满分，不完全满足则看有几分之几的tag不满足，等比例扣分（例：客户选择5个tag 酒店只满足3个，则得分60%（ 同理叠加计算）
	 */
	private List<SubResp> avReqResp;
	
	//条件是否必要
	private boolean isFacilityNumNecessary;
	private boolean isRoomNumAndRoomTypeNecessary;
	private boolean isMaxMeetingRoomSizeNecessary;
	private boolean isMaxMeetingSetUpNecessary;
	private boolean isMax2ndMeetingRoomSizeNecessary;
	private boolean isMax2ndMeetingSetUpNecessary;

	public Float getFacilityNum() {
		return facilityNum;
	}

	public void setFacilityNum(Float facilityNum) {
		this.facilityNum = facilityNum;
	}

	public Float getRoomNumAndRoomType() {
		return roomNumAndRoomType;
	}

	public void setRoomNumAndRoomType(Float roomNumAndRoomType) {
		this.roomNumAndRoomType = roomNumAndRoomType;
	}

	public Float getMaxMeetingRoomSize() {
		return maxMeetingRoomSize;
	}

	public void setMaxMeetingRoomSize(Float maxMeetingRoomSize) {
		this.maxMeetingRoomSize = maxMeetingRoomSize;
	}

	public Float getMaxMeetingSetUp() {
		return maxMeetingSetUp;
	}

	public void setMaxMeetingSetUp(Float maxMeetingSetUp) {
		this.maxMeetingSetUp = maxMeetingSetUp;
	}

	public Float getMax2ndMeetingRoomSize() {
		return max2ndMeetingRoomSize;
	}

	public void setMax2ndMeetingRoomSize(Float max2ndMeetingRoomSize) {
		this.max2ndMeetingRoomSize = max2ndMeetingRoomSize;
	}

	public Float getMax2ndMeetingSetUp() {
		return max2ndMeetingSetUp;
	}

	public void setMax2ndMeetingSetUp(Float max2ndMeetingSetUp) {
		this.max2ndMeetingSetUp = max2ndMeetingSetUp;
	}

	public List<SubResp> getMax3rdMeetingRoomSizeResp() {
		return max3rdMeetingRoomSizeResp;
	}

	public void setMax3rdMeetingRoomSizeResp(
			List<SubResp> max3rdMeetingRoomSizeResp) {
		this.max3rdMeetingRoomSizeResp = max3rdMeetingRoomSizeResp;
	}
	
	public List<SubResp> getMax3rdMeetingSetUpResp() {
		return max3rdMeetingSetUpResp;
	}

	public void setMax3rdMeetingSetUpResp(List<SubResp> max3rdMeetingSetUpResp) {
		this.max3rdMeetingSetUpResp = max3rdMeetingSetUpResp;
	}
	
	public List<SubResp> getDiningActivityAreaResp() {
		return diningActivityAreaResp;
	}

	public void setDiningActivityAreaResp(List<SubResp> diningActivityAreaResp) {
		this.diningActivityAreaResp = diningActivityAreaResp;
	}

	public List<SubResp> getDiningActivitySiteReqResp() {
		return diningActivitySiteReqResp;
	}

	public void setDiningActivitySiteReqResp(List<SubResp> diningActivitySiteReqResp) {
		this.diningActivitySiteReqResp = diningActivitySiteReqResp;
	}

	public boolean isFacilityNumNecessary() {
		return isFacilityNumNecessary;
	}

	public void setFacilityNumNecessary(boolean isFacilityNumNecessary) {
		this.isFacilityNumNecessary = isFacilityNumNecessary;
	}

	public boolean isRoomNumAndRoomTypeNecessary() {
		return isRoomNumAndRoomTypeNecessary;
	}

	public void setRoomNumAndRoomTypeNecessary(boolean isRoomNumAndRoomTypeNecessary) {
		this.isRoomNumAndRoomTypeNecessary = isRoomNumAndRoomTypeNecessary;
	}

	public boolean isMaxMeetingRoomSizeNecessary() {
		return isMaxMeetingRoomSizeNecessary;
	}

	public void setMaxMeetingRoomSizeNecessary(boolean isMaxMeetingRoomSizeNecessary) {
		this.isMaxMeetingRoomSizeNecessary = isMaxMeetingRoomSizeNecessary;
	}

	public boolean isMaxMeetingSetUpNecessary() {
		return isMaxMeetingSetUpNecessary;
	}

	public void setMaxMeetingSetUpNecessary(boolean isMaxMeetingSetUpNecessary) {
		this.isMaxMeetingSetUpNecessary = isMaxMeetingSetUpNecessary;
	}

	public boolean isMax2ndMeetingRoomSizeNecessary() {
		return isMax2ndMeetingRoomSizeNecessary;
	}

	public void setMax2ndMeetingRoomSizeNecessary(
			boolean isMax2ndMeetingRoomSizeNecessary) {
		this.isMax2ndMeetingRoomSizeNecessary = isMax2ndMeetingRoomSizeNecessary;
	}

	public boolean isMax2ndMeetingSetUpNecessary() {
		return isMax2ndMeetingSetUpNecessary;
	}

	public void setMax2ndMeetingSetUpNecessary(boolean isMax2ndMeetingSetUpNecessary) {
		this.isMax2ndMeetingSetUpNecessary = isMax2ndMeetingSetUpNecessary;
	}

	public List<SubResp> getAvReqResp() {
		return avReqResp;
	}

	public void setAvReqResp(List<SubResp> avReqResp) {
		this.avReqResp = avReqResp;
	}
	
}
