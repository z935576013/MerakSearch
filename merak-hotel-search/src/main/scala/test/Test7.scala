

package test

import scala.math.BigInt.int2bigInt
import redis.clients.jedis.Jedis
import redis.clients.jedis.JedisPool
import redis.clients.jedis.JedisPoolConfig
import redis.clients.jedis.exceptions.JedisConnectionException
import merak.dto.MerakHotel
import com.alibaba.fastjson.JSON
import merak.dto.MerakHotel
import merak.dto.MerakHotel
import merak.dto.MerakHotel

object Test7 {
  def main(args: Array[String]) {
    val jedis = new Jedis("119.254.97.130", 6379)
    val str2 = jedis.get("name22")
    println(str2)
    val h = new MerakHotel()
    val h2 = JSON.parseObject(str2, h.getClass);
    println(h2.getHotelId)
  }

}