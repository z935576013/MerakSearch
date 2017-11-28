package com.sdx.merak.service.intf.fractionAlgorithm.dto.req.sub;

import java.io.Serializable;

public class LocationReq implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	/** 位置得分点百分比 默认10% - eg : 设置25%  参数值25.0f **/
	private Float locationTermsPercent; 
	
	/** 距离POI-客户设置距离 **/
	private Float distanceSetting;
	
	/** 距离POI-实际距离 **/
	private Float distance;
	
	/** 地段价值-地段评分 **/
	private Float lotValue;
	
	private boolean isDistancePOINecessary;
	
	private boolean isLotValueNecessary;

	public Float getLocationTermsPercent() {
		return locationTermsPercent;
	}

	public void setLocationTermsPercent(Float locationTermsPercent) {
		this.locationTermsPercent = locationTermsPercent;
	}

	public Float getDistanceSetting() {
		return distanceSetting;
	}

	public void setDistanceSetting(Float distanceSetting) {
		this.distanceSetting = distanceSetting;
	}

	public Float getDistance() {
		return distance;
	}

	public void setDistance(Float distance) {
		this.distance = distance;
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
