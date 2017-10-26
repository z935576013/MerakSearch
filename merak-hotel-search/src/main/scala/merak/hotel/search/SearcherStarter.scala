package merak.hotel.search

import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
import exec.DubboStarter
import com.sdx.merak.service.inft.hotel.dto.SearchParm
import java.util.ArrayList
import com.redislabs.provider.redis.RedisContext
import org.apache.log4j.Level
import org.apache.log4j.Logger

object SearcherStarter {

  //SIT 
  val sparkHost = "spark://192.168.100.19:7077"
  val redisHost = "192.168.100.5"
  val zkHost = "192.168.100.6:2181"
  
   //PRD
//  val sparkHost = "spark://192.168.100.38:7077"
//  val redisHost = "192.168.100.2"
//  val zkHost = "192.168.100.16:2181,192.168.100.17:2181,192.168.100.3:2181"

  var redisContext: RedisContext = null

  var sc: SparkContext = null

  def main(args: Array[String]) {
    Logger.getRootLogger.setLevel(Level.WARN)
    val conf = new SparkConf().setMaster(sparkHost).setAppName("wc1")
      .set("redis.host", redisHost)
      .set("spark.driver.allowMultipleContexts", "true");
    sc = new SparkContext(conf)
    //    sc.addJar("/Users/lz/scala/test/target/test-0.0.1-SNAPSHOT-jar-with-dependencies.jar")
    redisContext = new RedisContext(sc)
    new DubboStarter().start();
  }
}