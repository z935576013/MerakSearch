package test

import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
import org.apache.spark.rdd.RDD.rddToPairRDDFunctions
import com.redislabs.provider.redis.RedisContext

object Test6 {
  def main(args: Array[String]) {
    val conf = new SparkConf().setMaster("spark://192.168.100.21:7077").setAppName("wc1")
      .set("redis.host", "192.168.100.5")
    val sc = new SparkContext(conf)
    val redisContext = new RedisContext(sc)
    val keysRDD = redisContext.fromRedisKeys(Array("hotelCache_140", "hotelCache_147", "hotelCache_146"));
    println("start--------------------------")
    println(keysRDD)
    keysRDD.foreach(println)
    println("end--------------------------")
    sc.stop()
  }

}
