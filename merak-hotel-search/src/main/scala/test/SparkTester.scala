package test

import scala.math.BigInt.int2bigInt
import redis.clients.jedis.Jedis
import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
import com.redislabs.provider.redis.RedisContext

class SparkTester extends java.io.Serializable {

  var result: Array[String] = Array();

  def runTest() = {
    val conf = new SparkConf().setMaster("spark://10.0.0.23:7077").setAppName("wc1")
      .set("redis.host", "119.254.97.130")
    val sc = new SparkContext(conf)
    sc.addJar("/Users/lz/scala/test/target/test-0.0.1-SNAPSHOT-jar-with-dependencies.jar")
    //    val rs = sc.parallelize(1 to 100, 3)
    //    rs.map((_, 1)).reduceByKey(_ + _).collect().foreach(println)
    //    sc.stop()
    val redisContext = new RedisContext(sc)
    println("start--------------------------")
    val stringRDD = redisContext.fromRedisKV(Array("name", "name2", "name22"))
    stringRDD.filter(filterH(_)).collect().foreach(exec(_))
    for (x <- result) {
      println("------------" + x)
    }
    println("end--------------------------")
    sc.stop()
  }

  def filterH(kv: (String, String)): Boolean = {
    if (kv._2.contains("2")) {
      true;
    } else {
      false
    }
  }

  def exec(kv: (String, String)) = {
    result = result.+:(kv._1)
  }

}