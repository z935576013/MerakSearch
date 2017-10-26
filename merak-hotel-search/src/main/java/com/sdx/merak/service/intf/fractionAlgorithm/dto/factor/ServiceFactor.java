package com.sdx.merak.service.intf.fractionAlgorithm.dto.factor;

import java.io.Serializable;

/**
 * service（服务）
 * @author yeegor
 *
 */
public class ServiceFactor implements Serializable {

	private static final long serialVersionUID = 1L;
	
	//参考指标
	/** Response Date (报价时间）-必要得分点 **/
	public final Integer responseDateNecessary = 2; 
	/** Response Date (报价时间）-优选得分点 **/
	public final Integer responseDatePreferred = 1;
	/** F&B 餐饮安排-必要得分点 **/
	public final Integer diningArrangementNecessary = 2; 
	/** F&B 餐饮安排-优选得分点 **/
	public final Integer diningArrangementPreferred = 1;
	/** Merak Star (觅星服务评分）-必要得分点 **/
	public final Integer merakStarNecessary = 5; 
	/** Merak Star (觅星服务评分）-优选得分点 **/
	public final Integer merakStarPreferred = 5;

}
