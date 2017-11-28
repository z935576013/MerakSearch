/**
 * Copyright &copy; 2012-2015 All rights reserved.
 */
package merak.dto;

import java.io.Serializable;

/**
 * 酒店会议间信息Entity
 * @author liucongwen
 * @version 2015-08-16
 */
public class MerakMeetingRoom implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private Long roomId;		// 会议间id
	private Long hotelId;		// 酒店id
	private String roomType;	//会议厅大类
	private Long parentId;      //父会议室ID
	private Integer minPersonCount; //最小人数
	private String area;		// 面积
	private String floor;		// 楼层
	private String plan; // 平面图
	private String dimensions;		// 尺寸，长X宽
	private String ceiling;		// 大厅高度，格式： min-max
	private Integer isReserve;		// 是否可用 0：不可用，1：可用
	private String suggestRate; //全天租金
	private String halfSuggestRate; //半天租金
	private String hasSunshine; //是否有日光
	private String viewIds; //风景code
	private String renovationTime; //装修时间
	private String noObstacleCeiling;//无障碍物高度
	
//	private String britishArea ;
//	private String britishCeiling ;
//	private String 	britishLength ;
//	private String britishWidth ;
//	private String britishNoObstacleCeiling ;
	
	 /**
     * 宴会式人数 宴会式人数
     */
    private Long round10Count;
    /**
     * 课桌式人数 课桌式人数
     */
    private Long classroomCount;
    /**
     * 剧院式人数 剧院式人数
     */
    private Long theatreCount;
    /**
     * 酒会式人数 酒会式人数
     */
    private Long receptionCount;
    /**
     * U型式人数 U型式人数
     */
    private Long ushapeCount;
    /**
     * 董事会式人数 董事会人数
     */
    private Long directorateCount;
    /**
     * 回形式人数 回形式人数
     */
    private Long hollowsquareCount;
    /**
     * 鱼骨式人数 鱼骨式人数
     */
    private Long fishboneCount;
    /**
     * 前厅面积 前厅面积
     */
    private Double anteroomSize;
    /**
     * 固定舞台面积 固定舞台面积
     */
    private Double fixstageSize;
    /**
     * 自然采光类型 自然采光类型  no:无  waterscape:水景 civicLandscape:城景 interior :内景 grassland:绿地
     */
    private String sunshineType;
    /**
     * 门头高度 门头高度
     */
    private Double doorHight;
    /**
     * 汽车直达 汽车直达 0:无 1:有
     */
    private Integer directcar=0;
    /**
     * 免费会议文具 免费会议文具 0:无 1:有
     */
    private Integer freeMeetingTool=0;
    /**
     * 演讲台 演讲台  0:无 1:有
     */
    private Integer speech=0;
    /**
     * 无立柱 无立柱  0:否 1:是
     */
    private Integer noUpright=0;
    /**
     * 重型机械 重型机械  0:无 1:有
     */
    private Integer machinery=0;
    /**
     * LED屏幕 LED屏幕 0:无 1:有
     */
    private Integer led=0;
    /**
     * 投影仪 投影仪 0:无 1:有
     */
    private Integer projector=0;
    /**
     * 屏幕 屏幕  0:无 1:有
     */
    private Integer screen=0;
    /**
     * 音响系统 音响系统 0:无 1:有
     */
    private Integer soundSystem=0;
    /**
     * 扬声器 扬声器  0:无 1:有
     */
    private Integer speakers=0;
    /**
     * 灯光特效 灯光特效 0:无 1:有
     */
    private Integer speciallighting=0;
	
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
	private Integer delFlag;
	

	public Long getRoomId() {
		return roomId;
	}

	public void setRoomId(Long roomId) {
		this.roomId = roomId;
	}
	public Long getHotelId() {
		return hotelId;
	}

	public void setHotelId(Long hotelId) {
		this.hotelId = hotelId;
	}
	
	/**
	 * @return the roomType
	 */
	public String getRoomType() {
		return roomType;
	}

	/**
	 * @param roomType the roomType to set
	 */
	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}
	
	public String getFloor() {
		return floor;
	}

	public void setFloor(String floor) {
		this.floor = floor;
	}
	
	public String getDimensions() {
		return dimensions;
	}

	public void setDimensions(String dimensions) {
		this.dimensions = dimensions;
	}
	
	public String getCeiling() {
		return ceiling;
	}

	public void setCeiling(String ceiling) {
		this.ceiling = ceiling;
	}
	
	public Integer getIsReserve() {
		return isReserve;
	}

	public void setIsReserve(Integer isReserve) {
		this.isReserve = isReserve;
	}

	public Long getCreateUser() {
		return createUser;
	}

	public void setCreateUser(Long createUser) {
		this.createUser = createUser;
	}
	
	public java.util.Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(java.util.Date createTime) {
		this.createTime = createTime;
	}

	public Long getUpdateUser() {
		return updateUser;
	}

	public void setUpdateUser(Long updateUser) {
		this.updateUser = updateUser;
	}

	public java.util.Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(java.util.Date updateTime) {
		this.updateTime = updateTime;
	}

	public Integer getDelFlag() {
		return delFlag;
	}

	public void setDelFlag(Integer delFlag) {
		this.delFlag = delFlag;
	}

	public String getPlan() {
		return plan;
	}

	public void setPlan(String plan) {
		this.plan = plan;
	}
	public String getSuggestRate() {
		return suggestRate;
	}

	public void setSuggestRate(String suggestRate) {
		this.suggestRate = suggestRate;
	}
	public String getHasSunshine() {
		return hasSunshine;
	}

	public void setHasSunshine(String hasSunshine) {
		this.hasSunshine = hasSunshine;
	}
	public String getViewIds() {
		return viewIds;
	}

	public void setViewIds(String viewIds) {
		this.viewIds = viewIds;
	}
	public String getRenovationTime() {
		return renovationTime;
	}

	public void setRenovationTime(String renovationTime) {
		this.renovationTime = renovationTime;
	}
	public String getNoObstacleCeiling() {
		return noObstacleCeiling;
	}

	public void setNoObstacleCeiling(String noObstacleCeiling) {
		this.noObstacleCeiling = noObstacleCeiling;
	}

	public String getHalfSuggestRate() {
		return halfSuggestRate;
	}

	public void setHalfSuggestRate(String halfSuggestRate) {
		this.halfSuggestRate = halfSuggestRate;
	}

	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}
	public Integer getMinPersonCount() {
		return minPersonCount;
	}

	public void setMinPersonCount(Integer minPersonCount) {
		this.minPersonCount = minPersonCount;
	}

//	@Column(name = "BRITISH_AREA")
//	public String getBritishArea() {
//		return britishArea;
//	}
//
//	public void setBritishArea(String britishArea) {
//		this.britishArea = britishArea;
//	}
//
//	@Column(name = "BRITISH_CEILING")
//	public String getBritishCeiling() {
//		return britishCeiling;
//	}
//
//	public void setBritishCeiling(String britishCeiling) {
//		this.britishCeiling = britishCeiling;
//	}
//
//	@Column(name = "BRITISH_LENGTH")
//	public String getBritishLength() {
//		return britishLength;
//	}
//
//	public void setBritishLength(String britishLength) {
//		this.britishLength = britishLength;
//	}
//
//	@Column(name = "BRITISH_WIDTH")
//	public String getBritishWidth() {
//		return britishWidth;
//	}
//
//	public void setBritishWidth(String britishWidth) {
//		this.britishWidth = britishWidth;
//	}
//
//	@Column(name = "BRITISH_NO_OBSTACLE_CEILING")
//	public String getBritishNoObstacleCeiling() {
//		return britishNoObstacleCeiling;
//	}
//
//	public void setBritishNoObstacleCeiling(String britishNoObstacleCeiling) {
//		this.britishNoObstacleCeiling = britishNoObstacleCeiling;
//	}

    /**
     * Get round10Count
     * 
     * @return round10Count
     */
    public Long getRound10Count() {
        return this.round10Count;
    }

    /**
     * Set round10Count
     * 
     * @param round10Count 宴会式人数
     */

    public void setRound10Count(Long round10Count) {
        this.round10Count = round10Count;
    }

    /**
     * Get classroomCount
     * 
     * @return classroomCount
     */
    public Long getClassroomCount() {
        return this.classroomCount;
    }

    /**
     * Set classroomCount
     * 
     * @param classroomCount 课桌式人数
     */

    public void setClassroomCount(Long classroomCount) {
        this.classroomCount = classroomCount;
    }

    /**
     * Get theatreCount
     * 
     * @return theatreCount
     */
    public Long getTheatreCount() {
        return this.theatreCount;
    }

    /**
     * Set theatreCount
     * 
     * @param theatreCount 剧院式人数
     */

    public void setTheatreCount(Long theatreCount) {
        this.theatreCount = theatreCount;
    }

    /**
     * Get receptionCount
     * 
     * @return receptionCount
     */
    public Long getReceptionCount() {
        return this.receptionCount;
    }

    /**
     * Set receptionCount
     * 
     * @param receptionCount 酒会式人数
     */

    public void setReceptionCount(Long receptionCount) {
        this.receptionCount = receptionCount;
    }

    /**
     * Get ushapeCount
     * 
     * @return ushapeCount
     */
    public Long getUshapeCount() {
        return this.ushapeCount;
    }

    /**
     * Set ushapeCount
     * 
     * @param ushapeCount U型式人数
     */

    public void setUshapeCount(Long ushapeCount) {
        this.ushapeCount = ushapeCount;
    }

    /**
     * Get directorateCount
     * 
     * @return directorateCount
     */
    public Long getDirectorateCount() {
        return this.directorateCount;
    }

    /**
     * Set directorateCount
     * 
     * @param directorateCount 董事会式人数
     */

    public void setDirectorateCount(Long directorateCount) {
        this.directorateCount = directorateCount;
    }

    /**
     * Get hollowsquareCount
     * 
     * @return hollowsquareCount
     */
    public Long getHollowsquareCount() {
        return this.hollowsquareCount;
    }

    /**
     * Set hollowsquareCount
     * 
     * @param hollowsquareCount 回形式人数
     */

    public void setHollowsquareCount(Long hollowsquareCount) {
        this.hollowsquareCount = hollowsquareCount;
    }

    /**
     * Get fishboneCount
     * 
     * @return fishboneCount
     */
    public Long getFishboneCount() {
        return this.fishboneCount;
    }

    /**
     * Set fishboneCount
     * 
     * @param fishboneCount 鱼骨式人数
     */

    public void setFishboneCount(Long fishboneCount) {
        this.fishboneCount = fishboneCount;
    }

    /**
     * Get anteroomSize
     * 
     * @return anteroomSize
     */
    public Double getAnteroomSize() {
        return this.anteroomSize;
    }

    /**
     * Set anteroomSize
     * 
     * @param anteroomSize 前厅面积
     */

    public void setAnteroomSize(Double anteroomSize) {
        this.anteroomSize = anteroomSize;
    }

    /**
     * Get fixstageSize
     * 
     * @return fixstageSize
     */
    public Double getFixstageSize() {
        return this.fixstageSize;
    }

    /**
     * Set fixstageSize
     * 
     * @param fixstageSize 固定舞台面积
     */

    public void setFixstageSize(Double fixstageSize) {
        this.fixstageSize = fixstageSize;
    }

    /**
     * Get sunshineType
     * 
     * @return sunshineType
     */
    public String getSunshineType() {
        return this.sunshineType;
    }

    /**
     * Set sunshineType
     * 
     * @param sunshineType 自然采光类型
     */

    public void setSunshineType(String sunshineType) {
        this.sunshineType = sunshineType;
    }

    /**
     * Get doorHight
     * 
     * @return doorHight
     */
    public Double getDoorHight() {
        return this.doorHight;
    }

    /**
     * Set doorHight
     * 
     * @param doorHight 门头高度
     */

    public void setDoorHight(Double doorHight) {
        this.doorHight = doorHight;
    }

    /**
     * Get directcar
     * 
     * @return directcar
     */
    public Integer getDirectcar() {
        return this.directcar;
    }

    /**
     * Set directcar
     * 
     * @param directcar 汽车直达
     */

    public void setDirectcar(Integer directcar) {
        this.directcar = directcar;
    }

    /**
     * Get freeMeetingTool
     * 
     * @return freeMeetingTool
     */
    public Integer getFreeMeetingTool() {
        return this.freeMeetingTool;
    }

    /**
     * Set freeMeetingTool
     * 
     * @param freeMeetingTool 免费会议文具
     */

    public void setFreeMeetingTool(Integer freeMeetingTool) {
        this.freeMeetingTool = freeMeetingTool;
    }

    /**
     * Get speech
     * 
     * @return speech
     */
    public Integer getSpeech() {
        return this.speech;
    }

    /**
     * Set speech
     * 
     * @param speech 演讲台
     */

    public void setSpeech(Integer speech) {
        this.speech = speech;
    }

    /**
     * Get noUpright
     * 
     * @return noUpright
     */
    public Integer getNoUpright() {
        return this.noUpright;
    }

    /**
     * Set noUpright
     * 
     * @param noUpright 无立柱
     */

    public void setNoUpright(Integer noUpright) {
        this.noUpright = noUpright;
    }

    /**
     * Get machinery
     * 
     * @return machinery
     */
    public Integer getMachinery() {
        return this.machinery;
    }

    /**
     * Set machinery
     * 
     * @param machinery 重型机械
     */

    public void setMachinery(Integer machinery) {
        this.machinery = machinery;
    }

    /**
     * Get led
     * 
     * @return led
     */
    public Integer getLed() {
        return this.led;
    }

    /**
     * Set led
     * 
     * @param led LED屏幕
     */

    public void setLed(Integer led) {
        this.led = led;
    }

    /**
     * Get projector
     * 
     * @return projector
     */
    public Integer getProjector() {
        return this.projector;
    }

    /**
     * Set projector
     * 
     * @param projector 投影仪
     */

    public void setProjector(Integer projector) {
        this.projector = projector;
    }

    /**
     * Get screen
     * 
     * @return screen
     */
    public Integer getScreen() {
        return this.screen;
    }

    /**
     * Set screen
     * 
     * @param screen 屏幕
     */

    public void setScreen(Integer screen) {
        this.screen = screen;
    }

    /**
     * Get soundSystem
     * 
     * @return soundSystem
     */
    public Integer getSoundSystem() {
        return this.soundSystem;
    }

    /**
     * Set soundSystem
     * 
     * @param soundSystem 音响系统
     */

    public void setSoundSystem(Integer soundSystem) {
        this.soundSystem = soundSystem;
    }

    /**
     * Get speakers
     * 
     * @return speakers
     */
    public Integer getSpeakers() {
        return this.speakers;
    }

    /**
     * Set speakers
     * 
     * @param speakers 扬声器
     */

    public void setSpeakers(Integer speakers) {
        this.speakers = speakers;
    }

    /**
     * Get speciallighting
     * 
     * @return speciallighting
     */
    public Integer getSpeciallighting() {
        return this.speciallighting;
    }

    /**
     * Set speciallighting
     * 
     * @param speciallighting 灯光特效
     */

    public void setSpeciallighting(Integer speciallighting) {
        this.speciallighting = speciallighting;
    }

	
}