package com.sdx.merak.service.intf.fractionAlgorithm.dto.factor;

import java.io.Serializable;

/**
 * location（位置）
 * @author yeegor
 *
 */
public class LocationFactor implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	//参考指标
	/** 距离POI-必要得分点 **/
	public final Integer distancePOINecessary = 5;
	/** 距离POI-优选得分点 **/
	public final Integer distancePOIPreferred = 2;
	/** 地段价值-必要得分点 **/
	public final Integer lotValueNecessary = 3;
	/** 地段价值-优选得分点 **/
	public final Integer lotValuePreferred = 3;

}
