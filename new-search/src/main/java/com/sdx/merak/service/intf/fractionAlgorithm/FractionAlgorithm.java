package com.sdx.merak.service.intf.fractionAlgorithm;

import com.sdx.merak.service.intf.fractionAlgorithm.dto.AlgorithmRes;
import com.sdx.merak.service.intf.fractionAlgorithm.dto.req.AlgorithmReq;

/**
 * 分数算法
 * 供外部调用
 * @author yeegor
 *
 */
public interface FractionAlgorithm {
	
	/**
	 * 返回计算总分数
	 * @param algorithmReq
	 * @return Float
	 */
	Float algorithm(AlgorithmReq algorithmReq);
	
	/**
	 * 增强算法接口
	 * 对象返回，可以获取中间值
	 * @param algorithmReq
	 * @return AlgorithmRes
	 */
	AlgorithmRes enhanceAlgorithm(AlgorithmReq algorithmReq);

}
