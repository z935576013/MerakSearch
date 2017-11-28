package com.sdx.merak.service.intf.fractionAlgorithm.ext;

import java.util.List;

import com.sdx.merak.service.intf.fractionAlgorithm.ext.dto.MeetingRoomReq;
import com.sdx.merak.service.intf.fractionAlgorithm.ext.dto.MeetingRoomResponse;

/**
 * 智能算法支持的单独的设施计算接口
 * @author Aaron
 *
 */
public interface FacilityReqService {
	
	/**
	 * 会议室算法相关业务逻辑
	 * @param meetingRoomReqs @see MeetingRoomReq
	 * @return <font color='red'>可能返回空</font>
	 */
	MeetingRoomResponse match(List<MeetingRoomReq> meetingRoomReqs);

}
