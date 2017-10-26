package com.sdx.merak.service.intf.fractionAlgorithm.dto.condition;

/**
 * location（位置）
 * @author yeegor
 *
 */
public class LocationCondition extends FactorCondition {

	private static final long serialVersionUID = 1L;

	/**
	 * 距离POI
	 * 符合距离要求内得满分，超出距离按照比例扣分，例：客户设置距离POI 5KM 以内的酒店，在优选情况下，距离OPI6公里的酒店得80%的分，
	 * 距离 7公里的得到 60%的分，距离10公里以上的没有得分
	 */
	private Float distancePOI;
	
	/**
	 * 地段价值
	 * 参考地段评分,5.0得满分，4.0得80% 以此类推
	 */
	private Float lotValue;
	
	//条件是否必要
	private boolean isDistancePOINecessary;
	private boolean isLotValueNecessary;

	public Float getDistancePOI() {
		return distancePOI;
	}

	public void setDistancePOI(Float distancePOI) {
		this.distancePOI = distancePOI;
	}

	public Float getLotValue() {
		return lotValue;
	}

	public void setLotValue(Float lotValue) {
		this.lotValue = lotValue;
	}

	public boolean isDistancePOINecessary() {
		return isDistancePOINecessary;
	}

	public void setDistancePOINecessary(boolean isDistancePOINecessary) {
		this.isDistancePOINecessary = isDistancePOINecessary;
	}

	public boolean isLotValueNecessary() {
		return isLotValueNecessary;
	}

	public void setLotValueNecessary(boolean isLotValueNecessary) {
		this.isLotValueNecessary = isLotValueNecessary;
	}
	
}
