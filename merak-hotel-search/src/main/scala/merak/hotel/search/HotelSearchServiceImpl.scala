package merak.hotel.search

import java.util.ArrayList

import scala.collection.JavaConverters.asScalaBufferConverter
import scala.collection.JavaConverters.seqAsJavaListConverter
import scala.collection.mutable.ArrayBuffer
import scala.util.control.Breaks.break
import scala.util.control.Breaks.breakable

import com.alibaba.fastjson.JSON
import com.sdx.merak.service.fractionAlgorithm.FractionAlgorithmImpl
import com.sdx.merak.service.inft.hotel.dto.HotelSearchService
import com.sdx.merak.service.inft.hotel.dto.MerakHotelAllDto
import com.sdx.merak.service.inft.hotel.dto.MerakHotelDto
import com.sdx.merak.service.inft.hotel.dto.MerakMeetingRoomDto
import com.sdx.merak.service.inft.hotel.dto.SaveResultParm
import com.sdx.merak.service.inft.hotel.dto.SearchParm
import com.sdx.merak.service.inft.hotel.dto.SearchScoreRes
import com.sdx.merak.service.intf.fractionAlgorithm.dto.AlgorithmRes
import com.sdx.merak.service.intf.fractionAlgorithm.dto.req.AlgorithmReq
import com.sdx.merak.service.intf.fractionAlgorithm.dto.req.sub.FacilityReq
import com.sdx.merak.service.intf.fractionAlgorithm.dto.req.sub.LocationReq
import com.sdx.merak.service.intf.fractionAlgorithm.dto.req.sub.field.AvReq
import com.sdx.merak.service.intf.fractionAlgorithm.dto.req.sub.field.DiningActivityAreaReq
import com.sdx.merak.service.intf.fractionAlgorithm.dto.req.sub.field.DiningActivitySiteReq
import com.sdx.merak.service.intf.fractionAlgorithm.dto.req.sub.field.Max3rdMeetingRoomSizeReq
import com.sdx.merak.service.intf.fractionAlgorithm.dto.req.sub.field.Max3rdMeetingSetUpReq

import redis.clients.jedis.Jedis
import com.sdx.merak.service.fractionAlgorithm.DistanceUtil

class HotelSearchServiceImpl extends java.io.Serializable with HotelSearchService {

  def setHotelCache(hotelId: String, hotel: MerakHotelAllDto) = {
    HotelCache.setHotelCache(hotelId, hotel)
  }

  //  def search1(searchParm: SearchParm): String = {
  //    val jedis = new Jedis("192.168.100.5", 6379)
  //    val str2 = jedis.get(sparkHotelKey + 518)
  //    val h = new MerakHotelAllDto()
  //    val hotel = JSON.parseObject(str2, h.getClass)
  //    println("checkHotel=" + checkHotel(hotel, searchParm))
  //    println("checkGuest=" + checkGuest(hotel, searchParm))
  //    println("checkMeeting=" + checkMeeting(hotel, searchParm))
  //    println("checkFacilities=" + checkFacilities(hotel, searchParm))
  //    ""
  //  }
  //
  //  def saveSearchResult1(parm: SaveResultParm): SearchScoreRes = {
  //    val jedis = new Jedis("192.168.100.5", 6379)
  //    val str2 = jedis.get(sparkHotelKey + 518)
  //    val h = new MerakHotelAllDto()
  //    val hotel = JSON.parseObject(str2, h.getClass)
  //    val res = mapResult(hotel, parm);
  //    res
  //  }

  def search(searchParm: SearchParm): String = {
    var result = ""
    val startTime = System.currentTimeMillis()
    println("start search--------------------------")
    //    val searchParm = parseParm(parm)
    val cacheHotel = getCacheHotel(searchParm)
    if (cacheHotel.length > 0) {
      val cacheRDD = SearcherStarter.sc.parallelize(cacheHotel, 2)
      cacheRDD.filter(filterCacheHotel(_, searchParm)).collect().foreach((hotel: MerakHotelDto) => result = result + " " + hotel.getHotelId)
    }
    val noCacheKeys = getNoCacheList(searchParm)
    if (cacheHotel.length > 0 && noCacheKeys.length > 0) {
      noCacheKeys.foreach(print(_))
      println()
    }
    if (noCacheKeys.length > 0) {
      val noCacheRDD = SearcherStarter.redisContext.fromRedisKV(noCacheKeys, 10)
      println("noCacheKeys:" + noCacheKeys.length)
      noCacheRDD.collect().foreach(setCache(_))
      noCacheRDD.map(mapHotel(_)).filter(filterHotel(_, searchParm)).collect().foreach((key: (String, MerakHotelDto)) => result = result + " " + key._2.getHotelId)
    }
    val endTime = System.currentTimeMillis()
    println("end search--------------------------cost:" + (endTime - startTime))
    result
  }

  def saveSearchResult(parm: SaveResultParm): java.util.List[SearchScoreRes] = {
    val startTime = System.currentTimeMillis()
    println("start saveSearchResult--------------------------")
    val resList = new java.util.ArrayList[SearchScoreRes]
    val cacheHotel = getCacheHotel(parm)
    if (cacheHotel.length > 0) {
      val cacheRDD = SearcherStarter.sc.parallelize(cacheHotel, 2)
      cacheRDD.map(mapResult(_, parm)).collect().foreach((res: SearchScoreRes) => resList.add(res))
    }
    val endTime = System.currentTimeMillis()
    println("end saveSearchResult--------------------------cost:" + (endTime - startTime))
    resList
  }

  def setCache(kv: (String, String)) {
    val hotel = new MerakHotelAllDto()
    try {
      val hotel2 = JSON.parseObject(kv._2, hotel.getClass)
      HotelCache.setHotelKeyCache(kv._1, hotel2)
    } catch {
      case ex: Exception => println("setCache ex:" + kv._1)
    }
  }

  def getCacheHotel(searchParm: SearchParm): Array[MerakHotelAllDto] = {
    val ids = searchParm.getNearList.asScala.toArray
    var cacheHotel = new ArrayBuffer[MerakHotelAllDto]()
    for (id <- ids) {
      val hotel = HotelCache.getHotelCache(id.toString())
      if (hotel != null) {
        cacheHotel.+=:(hotel)
      }
    }
    cacheHotel.toArray
  }

  def getNoCacheList(searchParm: SearchParm): Array[String] = {
    val ids = searchParm.getNearList.asScala.toArray
    var noCacheHotel = new ArrayBuffer[String]()
    for (id <- ids) {
      val hotel = HotelCache.getHotelCache(id.toString())
      if (hotel == null) {
        noCacheHotel.+=:(HotelCache.sparkHotelKey + id)
      }
    }
    noCacheHotel.toArray
  }

  def filterCacheHotel(hotel: MerakHotelAllDto, searchParm: SearchParm): Boolean = {
    if (!checkHotel(hotel, searchParm)) return false
    if (!checkGuest(hotel, searchParm)) return false
    if (!checkMeeting(hotel, searchParm)) return false
    if (!checkFacilities(hotel, searchParm)) return false
    return true
  }

  def filterHotel(kv: (String, MerakHotelAllDto), searchParm: SearchParm): Boolean = {
    if (kv._2 != null) {
      val hotel = kv._2
      if (!checkHotel(hotel, searchParm)) return false
      if (!checkGuest(hotel, searchParm)) return false
      if (!checkMeeting(hotel, searchParm)) return false
      if (!checkFacilities(hotel, searchParm)) return false
      return true
    } else {
      return false
    }
  }

  def mapHotel(kv: (String, String)): (String, MerakHotelAllDto) = {
    val hotel = new MerakHotelAllDto()
    val hotel2 = JSON.parseObject(kv._2, hotel.getClass)
    (kv._1, hotel2)
  }

  def checkHotel(hotel: MerakHotelAllDto, searchParm: SearchParm): Boolean = {
    if (hotel.getDelFlag == 1 && hotel.getMatchingStatus == 0) return false
    if (searchParm.getCountry != null && searchParm.getCountry != hotel.getCountry) return false
    if (searchParm.getStarLow != null) {
      if (searchParm.getNoStar == null) {
        if (hotel.getStar > searchParm.getStarHigh || hotel.getStar < searchParm.getStarLow) return false
      } else {
        if ((hotel.getStar > searchParm.getStarHigh || hotel.getStar < searchParm.getStarLow) && hotel.getStar != 0) return false
      }
    }
    if (searchParm.getTotalGuestRoomNum != null && (hotel.getTotalRoom == null || hotel.getTotalRoom < searchParm.getTotalGuestRoomNum)) return false
    if (searchParm.getOverlapMeetingCount != null && (hotel.getTotalMeetingRoom == null || hotel.getTotalMeetingRoom < searchParm.getOverlapMeetingCount)) return false
    true
  }

  def checkGuest(hotel: MerakHotelAllDto, searchParm: SearchParm): Boolean = {
    val guest = hotel.getGuestRoom
    if (searchParm.getKingRoom != null && (guest == null || guest.getKingRoom == null || guest.getKingRoom < searchParm.getKingRoom)) return false
    if (searchParm.getTwinRoom != null && (guest == null || guest.getTwinRoom == null || guest.getTwinRoom < searchParm.getTwinRoom)) return false
    if (searchParm.getRunOfHorse != null && (guest == null || guest.getRunOfHorse == null || guest.getRunOfHorse < searchParm.getRunOfHorse)) return false
    if (searchParm.getSuite != null && (guest == null || guest.getSuite == null || guest.getSuite < searchParm.getSuite)) return false
    true
  }

  def checkMeeting(hotel: MerakHotelAllDto, searchParm: SearchParm): Boolean = {
    val meetingRoom = hotel.getMeetingRoomList
    var largestRoomIds = new ArrayBuffer[Long]
    if (searchParm.getLargestFunctionRoomReqCount != null || searchParm.getLargestMeetingSize != null) {
      if (meetingRoom == null) false
      val meetingRoomList = meetingRoom.asScala.toArray
      var fit = false
      for (room <- meetingRoomList) {
        breakable {
          if (searchParm.getLargestMeetingSize != null && room.getArea.toDouble < searchParm.getLargestMeetingSize) break
          if (searchParm.getLargestFunctionRoomReqCount != null || searchParm.getLargestFunctionRoomReq != null) {
            var fitReqCount = getHotelMeetingRoomFitCount(room, meetingRoomList, searchParm.getLargestFunctionRoomReq)
            if (fitReqCount < searchParm.getLargestFunctionRoomReqCount) break
          }
          largestRoomIds.+=(room.getRoomId)
          fit = true
        }
      }
      if (!fit) return false
    }

    if (searchParm.getSecondFunctionRoomReqCount != null || searchParm.getSecondMeetingSize != null) {
      if (meetingRoom == null) false
      val meetingRoomList = meetingRoom.asScala.toArray
      var fit = false
      for (room <- meetingRoomList) {
        breakable {
          if (largestRoomIds.length == 1 && largestRoomIds(0) == room.getRoomId) break
          if (searchParm.getSecondMeetingSize != null && room.getArea.toDouble < searchParm.getSecondMeetingSize) break
          if (searchParm.getSecondFunctionRoomReqCount != null || searchParm.getSecondFunctionRoomReq != null) {
            var fitReqCount = getHotelMeetingRoomFitCount(room, meetingRoomList, searchParm.getSecondFunctionRoomReq)
            if (fitReqCount < searchParm.getSecondFunctionRoomReqCount) break
          }
          fit = true
          break
        }
      }
      if (!fit) return false
    }
    true
  }

  def getHotelMeetingRoomFitCount(room: MerakMeetingRoomDto, meetingRoomList: Array[MerakMeetingRoomDto], functionRoomReqOld: java.util.List[String]): Int = {
    var functionRoomReq = new ArrayList[String];
    functionRoomReq.addAll(functionRoomReqOld)
    if (functionRoomReq.contains("caraccess")) functionRoomReq.add("b_directcar")
    if (functionRoomReq.contains("nopillar")) functionRoomReq.add("b_upright")
    if (functionRoomReq.contains("naturaldaylight")) functionRoomReq.add("x_sunshine")
    if (functionRoomReq.contains("nodividableroom")) functionRoomReq.add("b_nodividable")
    var fitReqCount = 0
    if (functionRoomReq.contains("b_directcar") && room.getDirectcar != null && room.getDirectcar == 1) fitReqCount = fitReqCount + 1
    if (functionRoomReq.contains("b_upright") && room.getNoUpright != null && room.getNoUpright == 1) fitReqCount = fitReqCount + 1
    if (functionRoomReq.contains("x_sunshine")
      && room.getSunshineType != null && room.getSunshineType != "" && room.getSunshineType != "no") fitReqCount = fitReqCount + 1
    if (functionRoomReq.contains("b_nodividable")) {
      if (room.getParentId == null) {
        var isParent = false
        for (childRoom <- meetingRoomList) {
          if (childRoom.getParentId != null && childRoom.getParentId == room.getRoomId) isParent = true
        }
        if (!isParent) fitReqCount = fitReqCount + 1
      }
    }
    fitReqCount
  }

  def getHotelMeetingAvFitCount(room: MerakMeetingRoomDto, avReq: Array[String]): Int = {
    var fitReqCount = 0
    if (avReq.contains("led") && room.getLed() != null && room.getLed().intValue() == 1) fitReqCount = fitReqCount + 1
    if (avReq.contains("microphone") && room.getSpeakers() != null && room.getSpeakers().intValue() == 1) fitReqCount = fitReqCount + 1
    if (avReq.contains("projector") && room.getProjector() != null && room.getProjector().intValue() == 1) fitReqCount = fitReqCount + 1
    if (avReq.contains("screen") && room.getScreen() != null && room.getScreen().intValue() == 1) fitReqCount = fitReqCount + 1
    if (avReq.contains("soundsystem") && room.getSoundSystem() != null && room.getSoundSystem().intValue() == 1) fitReqCount = fitReqCount + 1
    if (avReq.contains("speakers") && room.getSpeakers() != null && room.getSpeakers().intValue() == 1) fitReqCount = fitReqCount + 1
    if (avReq.contains("speciallighting") && room.getSpeciallighting() != null && room.getSpeciallighting().intValue() == 1) fitReqCount = fitReqCount + 1
    fitReqCount
  }

  def getHotelFacilitiesFitCount(hotel: MerakHotelAllDto, facilitiesList: java.util.List[String]): Int = {
    val actFacilitiesList = hotel.getActFacilitiesList
    val otherFacilitie = hotel.getOtherFacilitie
    var fitReqCount = 0
    if (facilitiesList.contains("functional-gym")) {
      if (actFacilitiesList != null && actFacilitiesList.size > 0) {
        breakable {
          for (act <- actFacilitiesList.asScala.toArray) {
            if (act.getActType == 0) {
              fitReqCount = fitReqCount + 1
              break
            }
          }
        }
      }
    }
    if (facilitiesList.contains("functional-swimmingpool")) {
      if (actFacilitiesList != null && actFacilitiesList.size > 0) {
        breakable {
          for (act <- actFacilitiesList.asScala.toArray) {
            if (act.getActType == 1) {
              fitReqCount = fitReqCount + 1
              break
            }
          }
        }
      }
    }
    if (facilitiesList.contains("functional-spa")) {
      if (actFacilitiesList != null && actFacilitiesList.size > 0) {
        breakable {
          for (act <- actFacilitiesList.asScala.toArray) {
            if (act.getActType == 2) {
              fitReqCount = fitReqCount + 1
              break
            }
          }
        }
      }
    }
    if (facilitiesList.contains("functional-golf")) {
      if (actFacilitiesList != null && actFacilitiesList.size > 0) {
        breakable {
          for (act <- actFacilitiesList.asScala.toArray) {
            if (act.getActType == 3) {
              fitReqCount = fitReqCount + 1
              break
            }
          }
        }
      }
    }
    if (facilitiesList.contains("functional-freeparkinglot")) {
      if (otherFacilitie != null && otherFacilitie.getEquipment != null && otherFacilitie.getEquipment.contains("freeparkinglot")) fitReqCount = fitReqCount + 1
    }
    if (facilitiesList.contains("functional-m_business")) {
      if (otherFacilitie != null && otherFacilitie.getFuntionalDep != null && otherFacilitie.getFuntionalDep.contains("m_business")) fitReqCount = fitReqCount + 1
    }
    if (facilitiesList.contains("functional-baggage")) {
      if (otherFacilitie != null && otherFacilitie.getFuntionalDep != null && otherFacilitie.getFuntionalDep.contains("baggage")) fitReqCount = fitReqCount + 1
    }
    if (facilitiesList.contains("functional-s_wifi")) {
      if (otherFacilitie != null && otherFacilitie.getEquipment != null && otherFacilitie.getEquipment.contains("s_wifi")) fitReqCount = fitReqCount + 1
    }
    if (facilitiesList.contains("functional-presidentsuit")) {
      if (otherFacilitie != null && otherFacilitie.getEquipment != null && otherFacilitie.getEquipment.contains("presidentsuit")) fitReqCount = fitReqCount + 1
    }
    return fitReqCount
  }

  def checkFacilities(hotel: MerakHotelAllDto, searchParm: SearchParm): Boolean = {
    if (searchParm.getFacilitiesCount != null && searchParm.getFacilitiesList != null) {
      val fitReqCount = getHotelFacilitiesFitCount(hotel, searchParm.getFacilitiesList)
      if (searchParm.getFacilitiesCount > fitReqCount) return false
    }
    true
  }

  def getCacheHotel(parm: SaveResultParm): Array[MerakHotelAllDto] = {
    val ids = parm.getHotelIds.asScala.toArray
    var cacheHotel = new ArrayBuffer[MerakHotelAllDto]()
    for (id <- ids) {
      val hotel = HotelCache.getHotelCache(id)
      if (hotel != null) {
        cacheHotel.+=:(hotel)
      }
    }
    cacheHotel.toArray
  }

  def mapResult(hotel: MerakHotelAllDto, parm: SaveResultParm): SearchScoreRes = {
    val fractionAlgorithm = new FractionAlgorithmImpl()
    val algorithmReq = new AlgorithmReq()
    algorithmReq.setBookingTermsReq(null)
    algorithmReq.setRateReq(null)
    algorithmReq.setServiceReq(null)

    var locationReq = new LocationReq()
    locationReq.setLocationTermsPercent(parm.getLocationTermsPercent)
    if (parm.getDistanceSetting != null) {
      locationReq.setDistanceSetting(parm.getDistanceSetting)
    } else {
      locationReq.setDistanceSetting(0)
    }
    locationReq.setLotValue(hotel.getLotValue)
    if (parm.getPreferencesLocation != null && parm.getPreferencesLocation == 1) {
      locationReq.setDistancePOINecessary(true)
    } else {
      locationReq.setDistancePOINecessary(false)
    }
    locationReq.setLotValue(hotel.getLotValue)
    locationReq.setLotValueNecessary(false)
    if (parm.getLocationLat != null) {
      val distance = DistanceUtil.getDistance(parm.getLocationLat, parm.getLocationLot,
        hotel.getLot.doubleValue(), hotel.getLat.doubleValue());
      locationReq.setDistance(distance / 1000)
    } else {
      locationReq.setDistance(0)
    }
    algorithmReq.setLocationReq(locationReq)

    var facilityReq = new FacilityReq()
    facilityReq.setFacilityPercent(parm.getFacilityPercent)
    facilityReq.setCustomerTagCount4facilityNum(parm.getCustomerTagCount4facilityNum)
    val fitFacilityCount = getHotelFacilitiesFitCount(hotel, parm.getFacilitiesList)
    facilityReq.setHotelSatisfyTagCount4facilityNum(fitFacilityCount)
    val reqNotSatisfyRoomCount = getHotelNotSatisfyRoomCount(hotel, parm)
    facilityReq.setReqNotSatisfyRoomCount(reqNotSatisfyRoomCount._1)
    facilityReq.setReqNotSatisfyRoomTypeCount(reqNotSatisfyRoomCount._2)
    if (parm.getReqMeetingRoomArea4maxMeetingRoomSize != null) {
      facilityReq.setReqMeetingRoomArea4maxMeetingRoomSize(parm.getReqMeetingRoomArea4maxMeetingRoomSize)
    } else {
      facilityReq.setReqMeetingRoomArea4maxMeetingRoomSize(0)
    }
    if (hotel.getMeetingRoomList != null && hotel.getMeetingRoomList.size() > 0) {
      facilityReq.setHotelMeetingRoomArea4maxMeetingRoomSize(hotel.getMeetingRoomList.get(0).getArea.toFloat)
    } else {
      facilityReq.setHotelMeetingRoomArea4maxMeetingRoomSize(0)
    }

    if (parm.getReqMeetingRoomArea4max2ndMeetingRoomSize != null) {
      facilityReq.setReqMeetingRoomArea4max2ndMeetingRoomSize(parm.getReqMeetingRoomArea4max2ndMeetingRoomSize)
    } else {
      facilityReq.setReqMeetingRoomArea4max2ndMeetingRoomSize(0)
    }
    if (hotel.getMeetingRoomList != null && hotel.getMeetingRoomList.size() > 1) {
      facilityReq.setHotelMeetingRoomArea4max2ndMeetingRoomSize(hotel.getMeetingRoomList.get(1).getArea.toFloat)
    } else {
      facilityReq.setHotelMeetingRoomArea4max2ndMeetingRoomSize(0)
    }
    if (parm.getLargestFunctionRoomReq != null) {
      var functionRoomReq = parm.getLargestFunctionRoomReq.split(",").toList
      if (parm.getLargestFunctionRoomReq.equals("")) {
        functionRoomReq = List();
      }
      facilityReq.setCustomerTagCount4maxMeetingSetUp(functionRoomReq.length)
      if (hotel.getMeetingRoomList != null && hotel.getMeetingRoomList.size() > 0) {
        facilityReq.setHotelSatisfyTagCount4maxMeetingSetUp(getHotelMeetingRoomFitCount(hotel.getMeetingRoomList.get(0), hotel.getMeetingRoomList.asScala.toArray, functionRoomReq.asJava))
      } else {
        facilityReq.setHotelSatisfyTagCount4maxMeetingSetUp(0)
      }
    } else {
      facilityReq.setCustomerTagCount4maxMeetingSetUp(0)
      facilityReq.setHotelSatisfyTagCount4maxMeetingSetUp(0)
    }
    if (parm.getSecondFunctionRoomReq != null) {
      var functionRoomReq = parm.getSecondFunctionRoomReq.split(",").toList
      if (parm.getSecondFunctionRoomReq.equals("")) {
        functionRoomReq = List();
      }
      facilityReq.setCustomerTagCount4max2ndMeetingSetUp(functionRoomReq.length)
      if (hotel.getMeetingRoomList != null && hotel.getMeetingRoomList.size() > 1) {
        facilityReq.setHotelSatisfyTagCount4max2ndMeetingSetUp(getHotelMeetingRoomFitCount(hotel.getMeetingRoomList.get(1), hotel.getMeetingRoomList.asScala.toArray, functionRoomReq.asJava))
      } else {
        facilityReq.setHotelSatisfyTagCount4max2ndMeetingSetUp(0)
      }
    } else {
      facilityReq.setCustomerTagCount4max2ndMeetingSetUp(0)
      facilityReq.setHotelSatisfyTagCount4max2ndMeetingSetUp(0)
    }
    val max3rdMeetingRoomSizeReqs = new ArrayList[Max3rdMeetingRoomSizeReq]()
    val max3rdMeetingSetUpReqs = new ArrayList[Max3rdMeetingSetUpReq]()
    if (parm.getMax3rdMeetingSize != null) {
      for (i <- 0 to parm.getMax3rdMeetingSize.size() - 1) {
        var max3rdMeettingSize = parm.getMax3rdMeetingSize.get(i)
        val max3rdMeetingRoomSizeReq = new Max3rdMeetingRoomSizeReq()
        max3rdMeetingRoomSizeReq.setReqMeetingRoomArea4max3rdMeetingRoomSize(max3rdMeettingSize.toFloat)
        if (hotel.getMeetingRoomList != null && hotel.getMeetingRoomList.size() > i + 2) {
          max3rdMeetingRoomSizeReq.setHotelMeetingRoomArea4max3rdMeetingRoomSize(hotel.getMeetingRoomList.get(i + 2).getArea.toFloat)
        } else {
          max3rdMeetingRoomSizeReq.setHotelMeetingRoomArea4max3rdMeetingRoomSize(0)
        }
        max3rdMeetingRoomSizeReq.setMax3rdMeetingRoomSizeNecessary(true)
        max3rdMeetingRoomSizeReqs.add(max3rdMeetingRoomSizeReq)

        if (parm.getMax3rdMeetingFunctionRoomReq.get(i) != null) {
          var functionRoomReq = parm.getMax3rdMeetingFunctionRoomReq.get(i).split(",").toList
          if (parm.getMax3rdMeetingFunctionRoomReq.equals("")) {
            functionRoomReq = List();
          }
          val max3rdMeetingSetUpReq = new Max3rdMeetingSetUpReq()
          max3rdMeetingSetUpReq.setCustomerTagCount4max3rdMeetingSetUp(functionRoomReq.length)
          if (hotel.getMeetingRoomList != null && hotel.getMeetingRoomList.size() > i + 2) {
            max3rdMeetingSetUpReq.setHotelSatisfyTagCount4max3rdMeetingSetUp(getHotelMeetingRoomFitCount(hotel.getMeetingRoomList.get(i + 2), hotel.getMeetingRoomList.asScala.toArray, functionRoomReq.asJava))
          } else {
            max3rdMeetingSetUpReq.setHotelSatisfyTagCount4max3rdMeetingSetUp(0)
          }
          max3rdMeetingSetUpReq.setMax3rdMeetingSetUpNecessary(true)
          max3rdMeetingSetUpReqs.add(max3rdMeetingSetUpReq)
        }
      }
    }
    facilityReq.setMax3rdMeetingSetUpReqs(max3rdMeetingSetUpReqs)
    facilityReq.setMax3rdMeetingRoomSizeReqs(max3rdMeetingRoomSizeReqs)

    val diningActivityAreaReqs = new ArrayList[DiningActivityAreaReq]()
    val diningActivitySiteReqs = new ArrayList[DiningActivitySiteReq]()
    if (parm.getLargestFbMeetingSize != null) {
      for (i <- 0 to parm.getLargestFbMeetingSize.size() - 1) {
        var largestFbMeetingSize = parm.getLargestFbMeetingSize.get(i)
        val diningActivityAreaReq = new DiningActivityAreaReq()
        diningActivityAreaReq.setReqDiningArea(largestFbMeetingSize.toFloat)
        if (hotel.getMeetingRoomList != null && hotel.getMeetingRoomList.size() > i + 1) {
          diningActivityAreaReq.setHotelDiningArea(hotel.getMeetingRoomList.get(i).getArea.toFloat)
        } else {
          diningActivityAreaReq.setHotelDiningArea(0)
        }
        if (parm.getPreferencesLargestMeetingFbLocation().equals(1)) {
          diningActivityAreaReq.setDiningActivityAreaNecessary(true)
        } else {
          diningActivityAreaReq.setDiningActivityAreaNecessary(false)
        }
        diningActivityAreaReqs.add(diningActivityAreaReq)

        if (parm.getLargestFbFunctionRoomReq.get(i) != null) {
          var functionRoomReq = parm.getLargestFbFunctionRoomReq.get(i).split(",").toList
          if (parm.getLargestFbFunctionRoomReq.equals("")) {
            functionRoomReq = List();
          }
          val diningActivitySiteReq = new DiningActivitySiteReq()
          diningActivitySiteReq.setCustomerTagCount4diningActivitySiteReq(functionRoomReq.length)
          if (hotel.getMeetingRoomList != null && hotel.getMeetingRoomList.size() > i + 1) {
            diningActivitySiteReq.setHotelSatisfyTagCount4diningActivitySiteReq(getHotelMeetingRoomFitCount(hotel.getMeetingRoomList.get(i), hotel.getMeetingRoomList.asScala.toArray, functionRoomReq.asJava))
          } else {
            diningActivitySiteReq.setHotelSatisfyTagCount4diningActivitySiteReq(0)
          }
          if (parm.getPreferencesLargestMeetingFbLocation().equals(1)) {
            diningActivitySiteReq.setDiningActivitySiteReqNecessary(true)
          } else {
            diningActivitySiteReq.setDiningActivitySiteReqNecessary(false)
          }
          diningActivitySiteReqs.add(diningActivitySiteReq)
        }
      }
    }
    facilityReq.setDiningActivitySiteReqs(diningActivitySiteReqs)
    facilityReq.setDiningActivityAreaReqs(diningActivityAreaReqs)

    val avReqs = new ArrayList[AvReq]()
    val avReq = new AvReq()
    if (parm.getPreferencesLargestMeetingAv().equals(1)) {
      avReq.setAvReqNecessary(true)
    } else {
      avReq.setAvReqNecessary(false)
    }
    if (parm.getLargestAvReq != null) {
      var largestAvReq = parm.getLargestAvReq.split(",")
      if (parm.getLargestAvReq.equals("")) {
        largestAvReq = Array();
      }
      avReq.setCustomerTagCount4avReq(largestAvReq.length)
      if (hotel.getMeetingRoomList != null && hotel.getMeetingRoomList.size() > 0) {
        avReq.setHotelSatisfyTagCount4avReq(getHotelMeetingAvFitCount(hotel.getMeetingRoomList.get(0), largestAvReq))
      } else {
        avReq.setHotelSatisfyTagCount4avReq(0)
      }
    } else {
      avReq.setCustomerTagCount4avReq(0)
      avReq.setHotelSatisfyTagCount4avReq(0)
    }
    avReqs.add(avReq)
    facilityReq.setAvReqs(avReqs)
    if (parm.getPreferencesFacility().equals(1)) {
      facilityReq.setFacilityNumNecessary(true)
    } else {
      facilityReq.setFacilityNumNecessary(false)
    }
    if (parm.getPreferencesGuestNumber().equals(1)) {
      facilityReq.setRoomNumAndRoomTypeNecessary(true)
    } else {
      facilityReq.setRoomNumAndRoomTypeNecessary(false)
    }
    if (parm.getPreferencesLargestMeetingSize().equals(1)) {
      facilityReq.setMaxMeetingRoomSizeNecessary(true)
    } else {
      facilityReq.setMaxMeetingRoomSizeNecessary(false)
    }
    if (parm.getPreferencesLargestMeetingSetUp().equals(1)) {
      facilityReq.setMaxMeetingSetUpNecessary(true)
    } else {
      facilityReq.setMaxMeetingSetUpNecessary(false)
    }
    if (parm.getPreferencesSecondMeetingSize().equals(1)) {
      facilityReq.setMax2ndMeetingRoomSizeNecessary(true)
    } else {
      facilityReq.setMax2ndMeetingRoomSizeNecessary(false)
    }
    if (parm.getPreferencesSecondMeetingSetUp().equals(1)) {
      facilityReq.setMax2ndMeetingSetUpNecessary(true)
    } else {
      facilityReq.setMax2ndMeetingSetUpNecessary(false)
    }
    algorithmReq.setFacilityReq(facilityReq)
    val res = fractionAlgorithm.enhanceAlgorithm(algorithmReq)
    val result = new SearchScoreRes()
    result.setBookingTermsRes(res.getBookingTermsRes)
    result.setFacilityRes(res.getFacilityRes)
    result.setHotelId(hotel.getHotelId)
    result.setLocationRes(res.getLocationRes)
    result.setRateRes(res.getRateRes)
    result.setRes(res.getRes)
    result.setServiceRes(res.getServiceRes)
    result
  }

  def getHotelNotSatisfyRoomCount(hotel: MerakHotelAllDto, parm: SaveResultParm): (Int, Int) = {
    var reqNotSatisfyRoomCount = 0L
    var reqNotSatisfyRoomTypeCount = 0L
    var lessCount = 0L
    if (hotel.getGuestRoom.getRunOfHorse != null) {
      val hotelRunOfHorse = hotel.getGuestRoom.getRunOfHorse
      lessCount = parm.getRunOfHorse - hotelRunOfHorse
    }
    if (lessCount > 0) {
      reqNotSatisfyRoomCount = reqNotSatisfyRoomCount + lessCount
      reqNotSatisfyRoomTypeCount = reqNotSatisfyRoomTypeCount + 1
    }

    lessCount = 0L
    if (hotel.getGuestRoom.getSuite != null) {
      val hotelSuite = hotel.getGuestRoom.getSuite
      lessCount = parm.getSuite - hotelSuite
    }
    if (lessCount > 0) {
      reqNotSatisfyRoomCount = reqNotSatisfyRoomCount + lessCount
      reqNotSatisfyRoomTypeCount = reqNotSatisfyRoomTypeCount + 1
    }

    lessCount = 0L
    if (hotel.getGuestRoom.getTwinRoom != null) {
      val hotelTwinRoom = hotel.getGuestRoom.getTwinRoom
      lessCount = parm.getTwinRoom - hotelTwinRoom
    }
    if (lessCount > 0) {
      reqNotSatisfyRoomCount = reqNotSatisfyRoomCount + lessCount
      reqNotSatisfyRoomTypeCount = reqNotSatisfyRoomTypeCount + 1
    }

    lessCount = 0L
    if (hotel.getGuestRoom.getKingRoom != null) {
      val hotelKingRoom = hotel.getGuestRoom.getKingRoom
      lessCount = parm.getKingRoom - hotelKingRoom
    }
    if (lessCount > 0) {
      reqNotSatisfyRoomCount = reqNotSatisfyRoomCount + lessCount
      reqNotSatisfyRoomTypeCount = reqNotSatisfyRoomTypeCount + 1
    }
    (reqNotSatisfyRoomCount.intValue(), reqNotSatisfyRoomTypeCount.intValue())
  }

}