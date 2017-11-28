package com.sdx.merak.service.fractionAlgorithm.factor;

import com.sdx.merak.service.intf.fractionAlgorithm.dto.AlgorithmRes;
import com.sdx.merak.service.intf.fractionAlgorithm.dto.condition.FactorCondition;

/**
 * Base Factor Algorithm
 * @author yeegor
 *
 */
public abstract class BaseFactorAlgorithm {
	
	protected Float defaultPercent = 20.0f; //20%
	
	protected BaseFactorAlgorithm baseFactorAlgorithm;
	
	protected FactorCondition factorCondition;
	
	protected AlgorithmRes res;
	
	public abstract Float factorAlgorithm();
	
	protected abstract FactorCondition initFactorCondition();
	
	public BaseFactorAlgorithm(BaseFactorAlgorithm baseFactorAlgorithm) {
		this.baseFactorAlgorithm = baseFactorAlgorithm;
		this.factorCondition = initFactorCondition();
	}
	
	/**
	 * 增强构造函数,用于使用AlgorithmRes返回
	 * @param baseFactorAlgorithm
	 * @param res  算法责任链中同一指针对象
	 */
	public BaseFactorAlgorithm(AlgorithmRes res) {
		this.factorCondition = initFactorCondition();
		this.res = res;
	}
	
    public void setNextHandler(BaseFactorAlgorithm baseFactorAlgorithm) {
    	this.baseFactorAlgorithm = baseFactorAlgorithm;
    }
    
    protected Float filterNegative(Float value) {
		if (value==null || value.compareTo(0f)<0) {
			return 0f;
		}
		return value;
	}
	
}
