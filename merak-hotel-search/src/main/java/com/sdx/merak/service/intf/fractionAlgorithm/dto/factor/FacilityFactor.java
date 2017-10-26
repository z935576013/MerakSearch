package com.sdx.merak.service.intf.fractionAlgorithm.dto.factor;

import java.io.Serializable;

/**
 * Facility (设施）
 * @author yeegor
 *
 */
public class FacilityFactor implements Serializable {

	private static final long serialVersionUID = 1L;
	
	//参考指标
	/** 设施-必要得分点 **/
	public final Integer facilityNecessary = 3;
	/** 设施-优选得分点 **/
	public final Integer facilityPreferred = 1;
	/** 房间数量和房型要求-必要得分点 **/
	public final Integer roomCountAndRoomTypeNecessary = 5;
	/** 房间数量和房型要求-优选得分点 **/
	public final Integer roomCountAndRoomTypePreferred = 4;
	/** Largest Meeting Room Size (最大会议室面积）-必要得分点 **/
	public final Integer maxMeetingRoomSizeNecessary = 5;
	/** Largest Meeting Room Size (最大会议室面积）-优选得分点 **/
	public final Integer maxMeetingRoomSizePreferred = 4;
	/** Largest Meeting set up (最大会议室要求）-必要得分点 **/
	public final Integer maxMeetingSetUpNecessary = 5;
	/** Largest Meeting set up (最大会议室要求）-优选得分点 **/
	public final Integer maxMeetingSetUpPreferred = 2;
	/** 2nd larget Meeting room size (第二会议室面积）-必要得分点 **/
	public final Integer max2ndMeetingRoomSizeNecessary = 5;
	/** 2nd larget Meeting room size (第二会议室面积）-优选得分点 **/
	public final Integer max2ndMeetingRoomSizePreferred = 3;
	/** 2nd Largest Meeting set up (最大会议室要求）-必要得分点 **/
	public final Integer max2ndMeetingSetUpNecessary = 3;
	/** 2nd Largest Meeting set up (最大会议室要求）-优选得分点 **/
	public final Integer max2ndMeetingSetUpPreferred = 1;
	/** 第三大会议室面积-必要得分点 **/
	public final Integer max3rdMeetingRoomSizeNecessary = 2;
	/** 第三大会议室面积-优选得分点 **/
	public final Integer max3rdMeetingRoomSizePreferred = 1;
	/** 第三大会议室要求-必要得分点 **/
	public final Integer max3rdMeetingSetUpNecessary = 2;
	/** 第三大会议室要求-优选得分点 **/
	public final Integer max3rdMeetingSetUpPreferred = 1;
	/** 每项餐饮活动的场地面积-必要得分点 **/
	public final Integer diningActivityAreaNecessary = 2;
	/** 每项餐饮活动的场地面积-优选得分点 **/
	public final Integer diningActivityAreaPreferred = 1;
	/** 每项餐饮活动的场地要求-必要得分点 **/
	public final Integer diningActivitySiteReqNecessary = 5;
	/** 每项餐饮活动的场地要求-优选得分点 **/
	public final Integer diningActivitySiteReqPreferred = 2;
	/** AV要求集合-必要得分点 **/
	public final Integer avReqNecessary = 2;
	/** AV要求集合-优选得分点 **/
	public final Integer avReqPreferred = 1;
	
	/** list参数为空时默认值 **/
	public final Integer empty = 0;

}
