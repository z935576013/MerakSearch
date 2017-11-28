package com.sdx.merak.service.intf.fractionAlgorithm.dto.req.sub;

import java.io.Serializable;

public class ServiceReq implements Serializable {

	private static final long serialVersionUID = 1L;
	
	/** 服务得分点百分比 默认10% - eg : 设置25%  参数值25.0f **/
	private Float servicePercent;   
	
	/** Response Date (报价时间）-是否满足 **/
	private boolean isSatisfy4responseDate;
	
	/** F&B 餐饮安排-满足条件的tag数量 **/
	private Integer satisfyTagCount4diningArrangement;
	
	/** F&B 餐饮安排-tag总数量 **/
	private Integer tagTotalCount4diningArrangement;
	
	/**  Merak Star (觅星服务评分）- 服务评分 **/
	private Float star;
	
	private boolean isResponseDateNecessary;
	private boolean isDiningArrangementNecessary;
	private boolean isMerakStarNecessary;
	public Float getServicePercent() {
		return servicePercent;
	}
	public void setServicePercent(Float servicePercent) {
		this.servicePercent = servicePercent;
	}
	public boolean isSatisfy4responseDate() {
		return isSatisfy4responseDate;
	}
	public void setSatisfy4responseDate(boolean isSatisfy4responseDate) {
		this.isSatisfy4responseDate = isSatisfy4responseDate;
	}
	public Integer getSatisfyTagCount4diningArrangement() {
		return satisfyTagCount4diningArrangement;
	}
	public void setSatisfyTagCount4diningArrangement(
			Integer satisfyTagCount4diningArrangement) {
		this.satisfyTagCount4diningArrangement = satisfyTagCount4diningArrangement;
	}
	public Integer getTagTotalCount4diningArrangement() {
		return tagTotalCount4diningArrangement;
	}
	public void setTagTotalCount4diningArrangement(
			Integer tagTotalCount4diningArrangement) {
		this.tagTotalCount4diningArrangement = tagTotalCount4diningArrangement;
	}
	public Float getStar() {
		return star;
	}
	public void setStar(Float star) {
		this.star = star;
	}
	public boolean isResponseDateNecessary() {
		return isResponseDateNecessary;
	}
	public void setResponseDateNecessary(boolean isResponseDateNecessary) {
		this.isResponseDateNecessary = isResponseDateNecessary;
	}
	public boolean isDiningArrangementNecessary() {
		return isDiningArrangementNecessary;
	}
	public void setDiningArrangementNecessary(boolean isDiningArrangementNecessary) {
		this.isDiningArrangementNecessary = isDiningArrangementNecessary;
	}
	public boolean isMerakStarNecessary() {
		return isMerakStarNecessary;
	}
	public void setMerakStarNecessary(boolean isMerakStarNecessary) {
		this.isMerakStarNecessary = isMerakStarNecessary;
	}

}
