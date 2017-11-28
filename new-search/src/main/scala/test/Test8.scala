

package test

import scala.math.BigInt.int2bigInt
import redis.clients.jedis.Jedis
import org.apache.spark.SparkConf
import org.apache.spark.SparkContext

object Test8 {
  def main(args: Array[String]) {
    val conf = new SparkConf().setMaster("spark://192.168.100.21:7077").setAppName("wc1");
    val sc = new SparkContext(conf)
    val line = sc.textFile("hdfs://192.168.100.23:9000/user/ubuntu/README.md")

    line.flatMap(flatMaptest(_)).map(maptest(_)).reduceByKey(reduceByKeytest(_, _)).collect().foreach(println)
    sc.stop()
  }

  def maptest(a: String): (String, Int) = {
    (a, 1)
  }

  def flatMaptest(a: String): Array[String] = {
    a.split(" ")
  }

  def reduceByKeytest(a: Int, b: Int): Int = {
    a + b
  }

}