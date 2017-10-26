package com.sdx.merak.service.intf.fractionAlgorithm.dto.req.sub;

import java.io.Serializable;

public class BookingTermsReq implements Serializable {

	private static final long serialVersionUID = 1L;
	
	/** 预定条款得分点百分比 默认10% - eg : 设置25%  参数值25.0f **/
	private Float bookingTermsPercent;  
	
	/** Event Date-是否满足 **/
	private boolean isSatisfy4eventDate;
	
	/** Contract-可谈判条款数量 **/
	private Integer negotiabilityTermsCount;
	
	/** Contract-总条款数量 **/
	private Integer totalTermsCount;
	
	/** Concession（优惠条款）-优惠条款数量 **/
	private Integer discountTerms;
	
	private boolean isEventDateNecessary;
	private boolean isContractNecessary;
	private boolean isConcessionNecessary;
	public Float getBookingTermsPercent() {
		return bookingTermsPercent;
	}
	public void setBookingTermsPercent(Float bookingTermsPercent) {
		this.bookingTermsPercent = bookingTermsPercent;
	}
	public boolean isSatisfy4eventDate() {
		return isSatisfy4eventDate;
	}
	public void setSatisfy4eventDate(boolean isSatisfy4eventDate) {
		this.isSatisfy4eventDate = isSatisfy4eventDate;
	}
	public Integer getNegotiabilityTermsCount() {
		return negotiabilityTermsCount;
	}
	public void setNegotiabilityTermsCount(Integer negotiabilityTermsCount) {
		this.negotiabilityTermsCount = negotiabilityTermsCount;
	}
	public Integer getTotalTermsCount() {
		return totalTermsCount;
	}
	public void setTotalTermsCount(Integer totalTermsCount) {
		this.totalTermsCount = totalTermsCount;
	}
	public Integer getDiscountTerms() {
		return discountTerms;
	}
	public void setDiscountTerms(Integer discountTerms) {
		this.discountTerms = discountTerms;
	}
	public boolean isEventDateNecessary() {
		return isEventDateNecessary;
	}
	public void setEventDateNecessary(boolean isEventDateNecessary) {
		this.isEventDateNecessary = isEventDateNecessary;
	}
	public boolean isContractNecessary() {
		return isContractNecessary;
	}
	public void setContractNecessary(boolean isContractNecessary) {
		this.isContractNecessary = isContractNecessary;
	}
	public boolean isConcessionNecessary() {
		return isConcessionNecessary;
	}
	public void setConcessionNecessary(boolean isConcessionNecessary) {
		this.isConcessionNecessary = isConcessionNecessary;
	}

}
