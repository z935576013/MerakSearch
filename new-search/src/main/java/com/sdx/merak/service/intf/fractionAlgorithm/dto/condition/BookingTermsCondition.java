package com.sdx.merak.service.intf.fractionAlgorithm.dto.condition;

/**
 * Booking Terms(预定条款）
 * @author yeegor
 *
 */
public class BookingTermsCondition extends FactorCondition {
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * Event Date - 满足要求得满分，不满足不得分
	 */
	private boolean isEventDate;
	
	/**
	 * 酒店合约：得分比例依据 可谈判条款数量/总条款数量
	 * 。如果这个比例超过50%则得满分，小于50%的以此类推递减得分。例：酒店一个有10项合约条款，有5个可以谈的则得分率为100
	 * %，有4个是可以谈判的则得分率为80% 有3个是可以谈判的则得分率为60% 以此递减类推（默认必选，依据酒店合约我们人工维护进来的数据
	 */
	private Float contract;
	
	/**
	 * Concession（优惠条款）
	 * 酒店提供的该RFP适用的优惠条款数量。 5项优惠条款及以上的得满分，4项80%，3项60% 以此类推
	 */
	private Float concession;
	
	//条件是否必要
	private boolean isEventDateNecessary;
	private boolean isContractNecessary;
	private boolean isConcessionNecessary;

	public boolean isEventDate() {
		return isEventDate;
	}

	public void setEventDate(boolean isEventDate) {
		this.isEventDate = isEventDate;
	}

	public Float getContract() {
		return contract;
	}

	public void setContract(Float contract) {
		this.contract = contract;
	}

	public Float getConcession() {
		return concession;
	}

	public void setConcession(Float concession) {
		this.concession = concession;
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
