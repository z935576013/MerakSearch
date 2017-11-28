/*
 * Copyright (C), 2002-2013
 * FileName: MerakHotel.java
 * Author:   zhuliang
 * Date:     2012-12-22 上午00:00:00
 */
package merak.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 实体类酒店基本信息
 * 
 * @author zhuliang
 */
public class MerakHotel implements Serializable {
	/**
	 * Serial UID
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 酒店id 酒店id
	 */
	private Long hotelId;
	/**
	 * 邮编 邮编
	 */
	private String zip;
	/**
	 * 总楼层数 总楼层数
	 */
	private Integer totalFloor;
	/**
	 * 挂牌星级 挂牌星级， 0-无星级；1,2,3,4,5,代表一至五星级
	 */
	private Integer star;
	/**
	 * 评定星级 评定星级
	 */
	private Float merakRate;

	// 酒店类型 vacation 度假,business 商务, airport 机场, boutique 精品 ,feature 特色
	private String hotelCategory;

	/**
	 * 经度 经度 经纬度为Google经纬度
	 */
	private Float lat;
	/**
	 * 地段价值
	 */
	private Float lotValue;
	/**
	 * 纬度 纬度 经纬度为Google经纬度
	 */
	private Float lot;
	/**
	 * 国家 国家，关联城市表国家id
	 */
	private String country;
	/**
	 * 省份id 省份id，关联城市表省份id
	 */
	private String provinceId;
	/**
	 * 城市id 城市id，关联城市表省城市d
	 */
	private String cityId;
	/**
	 * 商业区id 商业区id
	 */
	private String businessZoneId;
	/**
	 * 行政区id 行政区id
	 */
	private String districtId;
	/**
	 * 总客房数 总客房数
	 */
	private Integer totalRoom;
	/**
	 * 总会议间数 总会议间数
	 */
	private Integer totalMeetingRoom;
	/**
	 * 最大会议间面积 最大会议间面积
	 */
	private Float largestMeetingRoom;
	/**
	 * 最大会议间定价 最大会议间定价
	 */
	private Float largestMeetingRoomRate;
	/**
	 * 会议间均价 会议间均价
	 */
	private Double meetingRoomAvgRate;
	/**
	 * 客房半年最高价
	 */
	private Float roomMaxRate;
	/**
	 * 客房半年最低价
	 */
	private Float roomMinRate;

	/**
	 * 最大团体人数
	 */
	private Integer maxGroupNum;

	/**
	 * 客房均价 客房均价
	 */
	private Double roomAvgRate;
	/**
	 * 电话 电话
	 */
	private String phone;
	/**
	 * 传真 传真
	 */
	private String fax;
	/**
	 * 支持的币种 支持的币种，多个用半角逗号拼接，关联数据字典表
	 */
	private String currencySupport;
	/**
	 * 创建用户id 创建用户id
	 */
	private Long createUser;
	/**
	 * 创建时间 创建时间
	 */
	private java.util.Date createTime;
	/**
	 * 更新用户id 更新用户id
	 */
	private Long updateUser;
	/**
	 * 更新时间 更新时间
	 */
	private java.util.Date updateTime;
	/**
	 * 删除标记 删除标记，0-正常，1-删除
	 */
	private String delFlag;
	/**
	 * 所属集团
	 */
	private Long chianId;

	/**
	 * 所属品牌
	 */
	private Long brandId;
	/**
	 * 官方邮箱 官方邮箱
	 */
	private String email;
	/**
	 * 官方网站 官方网站
	 */
	private String webSite;
	/**
	 * 大堂是否可以放接待桌 0:可以(免费) 1:可以(收钱) 2:不可以 3:可商榷
	 */
	private Integer lobbyTable;
	/**
	 * 大堂是否可以展示企业logo 0:可以(免费) 1:可以(收钱) 2:不可以 3:可商榷
	 */
	private Integer lobbyLogo;

	/**
	 * 积分ID
	 * 关联积分表
	 */
	private Long pointId;
	
	/**
	 * 余额ID
	 * 关联余额表
	 */
	private Long balanceId;
	
	/** 提交修改的积分值 **/
	private Integer pointValue;
	
	/** 判断积分值是否为正数 **/
	private Integer isPositive;
	
	/**
	 * 信息编辑完成度
	 */
	private String completionDegree;
	
	private String cityName;
	
	/**
	 * 备注(只有后台可以添加和查看)
	 */
	private String note;
	/**
     * 酒店简称 酒店简称
     */
    private String hotelShortName;
    /**
     * 酒店简称英文 酒店简称英文
     */
    private String hotelShortNameEn;
    /**
     * 所属楼层 所属楼层  逗号隔开
     */
    private String floorList;
    /**
     * 开业日期 开业日期
     */
    private java.util.Date openDate;
    /**
     * 最近整修日期 最近整修日期
     */
    private java.util.Date lastRenovationDate;
    /**
     * 独立品牌名称 独立品牌名称
     */
    private String indBrandName;
    /**
     * 独立品牌名称英文 独立品牌名称英文
     */
    private String indBrandNameEn;
    /**
     * 业主国家 业主国家
     */
    private Long ownerCountryId;
    /**
     * 业主大洲 业主大洲
     */
    private Long ownerContinentsId;
    /**
     * 业主名称 业主名称
     */
    private String ownerName;
    /**
     * 最大团队房间数量 最大团队房间数量
     */
    private Long largestGroupGuestNum;
    /**
     * 匹配状态  0:不能匹配  1:能匹配
     */
    private Integer matchingStatus;
    
    /**
     * 觅星认证  0:否  1:是
     */
    private Integer merakCert;
    
    /**
     * 觅星推荐  0:否  1:是
     */
    private Integer merakRecommend;
    
    private List<MerakMeetingRoom> roomList;
	/**
	 * Get hotelId
	 * 
	 * @return hotelId
	 */
	public Long getHotelId() {
		return this.hotelId;
	}

	/**
	 * Set hotelId
	 * 
	 * @param hotelId
	 *            酒店id
	 */

	public void setHotelId(Long hotelId) {
		this.hotelId = hotelId;
	}

	/**
	 * Get zip
	 * 
	 * @return zip
	 */
	public String getZip() {
		return this.zip;
	}

	/**
	 * Set zip
	 * 
	 * @param zip
	 *            邮编
	 */

	public void setZip(String zip) {
		this.zip = zip;
	}

	/**
	 * Get totalFloor
	 * 
	 * @return totalFloor
	 */
	public Integer getTotalFloor() {
		return this.totalFloor;
	}

	/**
	 * Set totalFloor
	 * 
	 * @param totalFloor
	 *            总楼层数
	 */

	public void setTotalFloor(Integer totalFloor) {
		this.totalFloor = totalFloor;
	}

	/**
	 * Get star
	 * 
	 * @return star
	 */
	public Integer getStar() {
		return this.star;
	}

	/**
	 * Set star
	 * 
	 * @param star
	 *            挂牌星级
	 */

	public void setStar(Integer star) {
		this.star = star;
	}

	/**
	 * Get merakRate
	 * 
	 * @return merakRate
	 */
	public Float getMerakRate() {
		return this.merakRate;
	}

	/**
	 * Set merakRate
	 * 
	 * @param merakRate
	 *            评定星级
	 */

	public void setMerakRate(Float merakRate) {
		this.merakRate = merakRate;
	}

	/**
	 * Get lat
	 * 
	 * @return lat
	 */
	public Float getLat() {
		return this.lat;
	}

	/**
	 * Set lat
	 * 
	 * @param lat
	 *            经度
	 */

	public void setLat(Float lat) {
		this.lat = lat;
	}

	/**
	 * Get lot
	 * 
	 * @return lot
	 */
	public Float getLot() {
		return this.lot;
	}

	/**
	 * Set lot
	 * 
	 * @param lot
	 *            纬度
	 */

	public void setLot(Float lot) {
		this.lot = lot;
	}

	/**
	 * Get country
	 * 
	 * @return country
	 */
	public String getCountry() {
		return this.country;
	}

	/**
	 * Set country
	 * 
	 * @param country
	 *            国家
	 */

	public void setCountry(String country) {
		this.country = country;
	}

	/**
	 * Get provinceId
	 * 
	 * @return provinceId
	 */
	public String getProvinceId() {
		return this.provinceId;
	}

	/**
	 * Set provinceId
	 * 
	 * @param provinceId
	 *            省份id
	 */

	public void setProvinceId(String provinceId) {
		this.provinceId = provinceId;
	}

	/**
	 * Get cityId
	 * 
	 * @return cityId
	 */
	public String getCityId() {
		return this.cityId;
	}

	/**
	 * Set cityId
	 * 
	 * @param cityId
	 *            城市id
	 */

	public void setCityId(String cityId) {
		this.cityId = cityId;
	}

	/**
	 * Get businessZoneId
	 * 
	 * @return businessZoneId
	 */
	public String getBusinessZoneId() {
		return this.businessZoneId;
	}

	/**
	 * Set businessZoneId
	 * 
	 * @param businessZoneId
	 *            商业区id
	 */

	public void setBusinessZoneId(String businessZoneId) {
		this.businessZoneId = businessZoneId;
	}

	/**
	 * Get districtId
	 * 
	 * @return districtId
	 */
	public String getDistrictId() {
		return this.districtId;
	}

	/**
	 * Set districtId
	 * 
	 * @param districtId
	 *            行政区id
	 */

	public void setDistrictId(String districtId) {
		this.districtId = districtId;
	}

	/**
	 * Get totalRoom
	 * 
	 * @return totalRoom
	 */
	public Integer getTotalRoom() {
		return this.totalRoom;
	}

	/**
	 * Set totalRoom
	 * 
	 * @param totalRoom
	 *            总客房数
	 */

	public void setTotalRoom(Integer totalRoom) {
		this.totalRoom = totalRoom;
	}

	/**
	 * Get totalMeetingRoom
	 * 
	 * @return totalMeetingRoom
	 */
	public Integer getTotalMeetingRoom() {
		return this.totalMeetingRoom;
	}

	/**
	 * Set totalMeetingRoom
	 * 
	 * @param totalMeetingRoom
	 *            总会议间数
	 */

	public void setTotalMeetingRoom(Integer totalMeetingRoom) {
		this.totalMeetingRoom = totalMeetingRoom;
	}

	/**
	 * Get largestMeetingRoom
	 * 
	 * @return largestMeetingRoom
	 */
	public Float getLargestMeetingRoom() {
		return this.largestMeetingRoom;
	}

	/**
	 * Set largestMeetingRoom
	 * 
	 * @param largestMeetingRoom
	 *            最大会议间面积
	 */

	public void setLargestMeetingRoom(Float largestMeetingRoom) {
		this.largestMeetingRoom = largestMeetingRoom;
	}

	/**
	 * Get largestMeetingRoomRate
	 * 
	 * @return largestMeetingRoomRate
	 */
	public Float getLargestMeetingRoomRate() {
		return this.largestMeetingRoomRate;
	}

	/**
	 * Set largestMeetingRoomRate
	 * 
	 * @param largestMeetingRoomRate
	 *            最大会议间定价
	 */

	public void setLargestMeetingRoomRate(Float largestMeetingRoomRate) {
		this.largestMeetingRoomRate = largestMeetingRoomRate;
	}

	/**
	 * Get meetingRoomAvgRate
	 * 
	 * @return meetingRoomAvgRate
	 */
	public Double getMeetingRoomAvgRate() {
		return this.meetingRoomAvgRate;
	}

	/**
	 * Set meetingRoomAvgRate
	 * 
	 * @param meetingRoomAvgRate
	 *            会议间均价
	 */

	public void setMeetingRoomAvgRate(Double meetingRoomAvgRate) {
		this.meetingRoomAvgRate = meetingRoomAvgRate;
	}

	/**
	 * Get roomAvgRate
	 * 
	 * @return roomAvgRate
	 */
	public Double getRoomAvgRate() {
		return this.roomAvgRate;
	}

	/**
	 * Set roomAvgRate
	 * 
	 * @param roomAvgRate
	 *            客房均价
	 */

	public void setRoomAvgRate(Double roomAvgRate) {
		this.roomAvgRate = roomAvgRate;
	}

	/**
	 * Get phone
	 * 
	 * @return phone
	 */
	public String getPhone() {
		return this.phone;
	}

	/**
	 * Set phone
	 * 
	 * @param phone
	 *            电话
	 */

	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 * Get fax
	 * 
	 * @return fax
	 */
	public String getFax() {
		return this.fax;
	}

	/**
	 * Set fax
	 * 
	 * @param fax
	 *            传真
	 */

	public void setFax(String fax) {
		this.fax = fax;
	}

	/**
	 * Get currencySupport
	 * 
	 * @return currencySupport
	 */
	public String getCurrencySupport() {
		return this.currencySupport;
	}

	/**
	 * Set currencySupport
	 * 
	 * @param currencySupport
	 *            支持的币种
	 */

	public void setCurrencySupport(String currencySupport) {
		this.currencySupport = currencySupport;
	}

	/**
	 * Get createUser
	 * 
	 * @return createUser
	 */
	public Long getCreateUser() {
		return this.createUser;
	}

	/**
	 * Set createUser
	 * 
	 * @param createUser
	 *            创建用户id
	 */

	public void setCreateUser(Long createUser) {
		this.createUser = createUser;
	}

	/**
	 * Get createTime
	 * 
	 * @return createTime
	 */
	public java.util.Date getCreateTime() {
		return this.createTime;
	}

	/**
	 * Set createTime
	 * 
	 * @param createTime
	 *            创建时间
	 */

	public void setCreateTime(java.util.Date createTime) {
		this.createTime = createTime;
	}

	/**
	 * Get updateUser
	 * 
	 * @return updateUser
	 */
	public Long getUpdateUser() {
		return this.updateUser;
	}

	/**
	 * Set updateUser
	 * 
	 * @param updateUser
	 *            更新用户id
	 */

	public void setUpdateUser(Long updateUser) {
		this.updateUser = updateUser;
	}

	/**
	 * Get updateTime
	 * 
	 * @return updateTime
	 */
	public java.util.Date getUpdateTime() {
		return this.updateTime;
	}

	/**
	 * Set updateTime
	 * 
	 * @param updateTime
	 *            更新时间
	 */

	public void setUpdateTime(java.util.Date updateTime) {
		this.updateTime = updateTime;
	}

	/**
	 * Get delFlag
	 * 
	 * @return delFlag
	 */
	public String getDelFlag() {
		return this.delFlag;
	}

	/**
	 * Set delFlag
	 * 
	 * @param delFlag
	 *            删除标记
	 */

	public void setDelFlag(String delFlag) {
		this.delFlag = delFlag;
	}

	public void initInsert(Long userId) {
		this.createTime = new Date();
		this.createUser = userId;
	}

	public void initUpdate(Long userId) {
		this.updateTime = new Date();
		this.updateUser = userId;
	}

	public Float getRoomMaxRate() {
		return roomMaxRate;
	}

	public void setRoomMaxRate(Float roomMaxRate) {
		this.roomMaxRate = roomMaxRate;
	}

	public Float getRoomMinRate() {
		return roomMinRate;
	}

	public void setRoomMinRate(Float roomMinRate) {
		this.roomMinRate = roomMinRate;
	}

	public Float getLotValue() {
		return lotValue;
	}

	public void setLotValue(Float lotValue) {
		this.lotValue = lotValue;
	}

	public String getHotelCategory() {
		return hotelCategory;
	}

	public void setHotelCategory(String hotelCategory) {
		this.hotelCategory = hotelCategory;
	}


	/**
	 * @return the chianId
	 */
	public Long getChianId() {
		return chianId;
	}

	/**
	 * @param chianId
	 *            the chianId to set
	 */
	public void setChianId(Long chianId) {
		this.chianId = chianId;
	}

	/**
	 * @return the brandId
	 */
	public Long getBrandId() {
		return brandId;
	}

	/**
	 * @param brandId
	 *            the brandId to set
	 */
	public void setBrandId(Long brandId) {
		this.brandId = brandId;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email
	 *            the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the webSite
	 */
	public String getWebSite() {
		return webSite;
	}

	/**
	 * @param webSite
	 *            the webSite to set
	 */
	public void setWebSite(String webSite) {
		this.webSite = webSite;
	}

	/**
	 * @return the lobbyTable
	 */
	public Integer getLobbyTable() {
		return lobbyTable;
	}

	/**
	 * @param lobbyTable
	 *            the lobbyTable to set
	 */
	public void setLobbyTable(Integer lobbyTable) {
		this.lobbyTable = lobbyTable;
	}

	/**
	 * @return the lobbyLogo
	 */
	public Integer getLobbyLogo() {
		return lobbyLogo;
	}

	/**
	 * @param lobbyLogo
	 *            the lobbyLogo to set
	 */
	public void setLobbyLogo(Integer lobbyLogo) {
		this.lobbyLogo = lobbyLogo;
	}

	public Integer getMaxGroupNum() {
		return maxGroupNum;
	}

	public void setMaxGroupNum(Integer maxGroupNum) {
		this.maxGroupNum = maxGroupNum;
	}

	public String getCompletionDegree() {
		return completionDegree;
	}

    public void setCompletionDegree(String completionDegree) {
        this.completionDegree = completionDegree;
    }
    
	public Long getPointId() {
		return pointId;
	}

	public void setPointId(Long pointId) {
		this.pointId = pointId;
	}

	public Long getBalanceId() {
		return balanceId;
	}

	public void setBalanceId(Long balanceId) {
		this.balanceId = balanceId;
	}

	public Integer getPointValue() {
		return pointValue;
	}

	public void setPointValue(Integer pointValue) {
		this.pointValue = pointValue;
	}

	public Integer getIsPositive() {
		return isPositive;
	}

	public void setIsPositive(Integer isPositive) {
		this.isPositive = isPositive;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}
	

    /**
	 * @return the hotelShortName
	 */
	public String getHotelShortName() {
		return hotelShortName;
	}

	/**
	 * @param hotelShortName the hotelShortName to set
	 */
	public void setHotelShortName(String hotelShortName) {
		this.hotelShortName = hotelShortName;
	}

	/**
	 * @return the hotelShortNameEn
	 */
	public String getHotelShortNameEn() {
		return hotelShortNameEn;
	}

	/**
	 * @param hotelShortNameEn the hotelShortNameEn to set
	 */
	public void setHotelShortNameEn(String hotelShortNameEn) {
		this.hotelShortNameEn = hotelShortNameEn;
	}

	/**
     * Get floorList
     * 
     * @return floorList
     */
    public String getFloorList() {
        return this.floorList;
    }

    /**
     * Set floorList
     * 
     * @param floorList 所属楼层
     */

    public void setFloorList(String floorList) {
        this.floorList = floorList;
    }

    /**
     * Get openDate
     * 
     * @return openDate
     */
    public java.util.Date getOpenDate() {
        return this.openDate;
    }

    /**
     * Set openDate
     * 
     * @param openDate 开业日期
     */

    public void setOpenDate(java.util.Date openDate) {
        this.openDate = openDate;
    }

    /**
     * Get lastRenovationDate
     * 
     * @return lastRenovationDate
     */
    public java.util.Date getLastRenovationDate() {
        return this.lastRenovationDate;
    }

    /**
     * Set lastRenovationDate
     * 
     * @param lastRenovationDate 最近整修日期
     */

    public void setLastRenovationDate(java.util.Date lastRenovationDate) {
        this.lastRenovationDate = lastRenovationDate;
    }
    /**
     * Get indBrandName
     * 
     * @return indBrandName
     */
    public String getIndBrandName() {
        return this.indBrandName;
    }

    /**
     * Set indBrandName
     * 
     * @param indBrandName 独立品牌名称
     */

    public void setIndBrandName(String indBrandName) {
        this.indBrandName = indBrandName;
    }

    /**
     * Get indBrandNameEn
     * 
     * @return indBrandNameEn
     */
    public String getIndBrandNameEn() {
        return this.indBrandNameEn;
    }

    /**
     * Set indBrandNameEn
     * 
     * @param indBrandNameEn 独立品牌名称英文
     */

    public void setIndBrandNameEn(String indBrandNameEn) {
        this.indBrandNameEn = indBrandNameEn;
    }

	/**
	 * @return the ownerCountryId
	 */
	public Long getOwnerCountryId() {
		return ownerCountryId;
	}

	/**
	 * @param ownerCountryId the ownerCountryId to set
	 */
	public void setOwnerCountryId(Long ownerCountryId) {
		this.ownerCountryId = ownerCountryId;
	}

	/**
	 * @return the ownerContinentsId
	 */
	public Long getOwnerContinentsId() {
		return ownerContinentsId;
	}

	/**
	 * @param ownerContinentsId the ownerContinentsId to set
	 */
	public void setOwnerContinentsId(Long ownerContinentsId) {
		this.ownerContinentsId = ownerContinentsId;
	}

	/**
	 * @return the ownerName
	 */
	public String getOwnerName() {
		return ownerName;
	}

	/**
	 * @param ownerName the ownerName to set
	 */
	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}
	
	  /**
     * Get largestGroupGuestNum
     * 
     * @return largestGroupGuestNum
     */
    public Long getLargestGroupGuestNum() {
        return this.largestGroupGuestNum;
    }

    /**
     * Set largestGroupGuestNum
     * 
     * @param largestGroupGuestNum 最大团队房间数量
     */

    public void setLargestGroupGuestNum(Long largestGroupGuestNum) {
        this.largestGroupGuestNum = largestGroupGuestNum;
    }

	/**
	 * @return the matchingStatus
	 */
	public Integer getMatchingStatus() {
		return matchingStatus;
	}

	/**
	 * @param matchingStatus the matchingStatus to set
	 */
	public void setMatchingStatus(Integer matchingStatus) {
		this.matchingStatus = matchingStatus;
	}

	/**
	 * @return the merakCert
	 */
	public Integer getMerakCert() {
		return merakCert;
	}

	/**
	 * @param merakCert the merakCert to set
	 */
	public void setMerakCert(Integer merakCert) {
		this.merakCert = merakCert;
	}

	/**
	 * @return the merakRecommend
	 */
	public Integer getMerakRecommend() {
		return merakRecommend;
	}

	/**
	 * @param merakRecommend the merakRecommend to set
	 */
	public void setMerakRecommend(Integer merakRecommend) {
		this.merakRecommend = merakRecommend;
	}

	/**
	 * @return the roomList
	 */
	public List<MerakMeetingRoom> getRoomList() {
		return roomList;
	}

	/**
	 * @param roomList the roomList to set
	 */
	public void setRoomList(List<MerakMeetingRoom> roomList) {
		this.roomList = roomList;
	}


	
}
