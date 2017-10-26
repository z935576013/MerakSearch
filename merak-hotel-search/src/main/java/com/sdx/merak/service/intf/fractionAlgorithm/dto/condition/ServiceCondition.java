package com.sdx.merak.service.intf.fractionAlgorithm.dto.condition;

/**
 * service（服务）
 * @author yeegor
 *
 */
public class ServiceCondition extends FactorCondition {

	private static final long serialVersionUID = 1L;
	
	/**
	 * Response Date (报价时间）
	 * 满足要求得满分，不满足不得分
	 */
	private boolean isResponseDate;
	
	/**
	 * F&B 餐饮安排
	 * 酒店满足客户选择的食物酒水安排，几分之几的tag不满足，等比例扣分 （如提供具体餐厅安排，提供菜单，则算法等于增加了两个系统tag
	 */
	private Float diningArrangement;
	
	/**
	 * Merak Star (觅星服务评分）
	 * 7分为满分100% 得分， 3分及以下得分为0. 3-7中间4分得维度同比例对应得分点。（本项不需要客户定义preference，默认必要地评分指标）
	 */
	private Float merakStar;
	
	//条件是否必要
	private boolean isResponseDateNecessary;
	private boolean isDiningArrangementNecessary;
	private boolean isMerakStarNecessary;

	public boolean isResponseDate() {
		return isResponseDate;
	}

	public void setResponseDate(boolean isResponseDate) {
		this.isResponseDate = isResponseDate;
	}

	public Float getDiningArrangement() {
		return diningArrangement;
	}

	public void setDiningArrangement(Float diningArrangement) {
		this.diningArrangement = diningArrangement;
	}

	public Float getMerakStar() {
		return merakStar;
	}

	public void setMerakStar(Float merakStar) {
		this.merakStar = merakStar;
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
