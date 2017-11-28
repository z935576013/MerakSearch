package com.sdx.merak.service.intf.fractionAlgorithm.dto.factor;

import java.io.Serializable;

/**
 * Booking Terms(预定条款）
 * @author yeegor
 *
 */
public class BookingTermsFactor implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	//参考指标
	/** Event Date-必要得分点 **/
	public final Integer eventDateNecessary = 5;
	/** Event Date-优选得分点 **/
	public final Integer eventDatePreferred = 2;
	/** Contract-必要得分点 **/
	public final Integer contractNecessary = 5;
	/** Contract-优选得分点 **/
	public final Integer contractPreferred = 5;
	/** Concession（优惠条款）-必要得分点 **/
	public final Integer concessionNecessary = 5;
	/** Concession（优惠条款）-优选得分点 **/
	public final Integer concessionPreferred = 3;

}
