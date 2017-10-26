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

object HotelCache {

  val sparkHotelKey = "hotelAllCache_"

  var hotelCache: Map[String, MerakHotelAllDto] = Map()

  def setHotelCache(hotelId: String, hotel: MerakHotelAllDto) = {
    hotelCache.+=(sparkHotelKey + hotelId -> hotel)
  }

  def setHotelKeyCache(key: String, hotel: MerakHotelAllDto) = {
    hotelCache.+=(key -> hotel)
  }

  def getHotelCache(hotelId: String): MerakHotelAllDto = {
    val hotel = hotelCache.get(sparkHotelKey + hotelId)
    if (hotel == None) {
      null
    } else {
      hotel.get
    }
  }

}