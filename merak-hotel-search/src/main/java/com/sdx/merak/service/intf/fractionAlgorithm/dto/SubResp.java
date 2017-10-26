package com.sdx.merak.service.intf.fractionAlgorithm.dto;

import java.io.Serializable;

/**
 * 列表参数属性计算结果返回
 * @author yeegor
 *
 */
public class SubResp implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Float result;
	
	private boolean isNecessary;

	public Float getResult() {
		return result;
	}

	public void setResult(Float result) {
		this.result = result;
	}

	public boolean isNecessary() {
		return isNecessary;
	}

	public void setNecessary(boolean isNecessary) {
		this.isNecessary = isNecessary;
	}

	
}
