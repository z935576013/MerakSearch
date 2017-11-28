package com.sdx.merak.service.intf.fractionAlgorithm.dto.condition;

import java.io.Serializable;

/**
 * 定义所有Factor计算条件(入参)
 * 用作业务逻辑结果和算法参数映射,解耦算法与业务逻辑处理
 * 入参值为已经过业务逻辑处理的最终值
 * @author yeegor
 */
public class FactorCondition implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Float percentSetting;

	public Float getPercentSetting() {
		return percentSetting;
	}

	public void setPercentSetting(Float percentSetting) {
		this.percentSetting = percentSetting;
	}

}
