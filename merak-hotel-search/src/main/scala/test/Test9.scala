

package test

import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
import scala.collection.mutable.ArrayBuffer

object Test9 {
  def main(args: Array[String]) {
    var hotelCache: Map[String, String] = Map()
    hotelCache.+=("111" -> "1111")
    hotelCache.+=("222" -> "1111")
    print(hotelCache)
    //    val sparkHotelKey = "sparkhotel_";
    //    val id = "1 3 2 4"
    //    val ids = id.split(" ")
    //    val cacheKeys = for (elem <- ids) yield sparkHotelKey + elem
    //    println(cacheKeys)
    //     val cacheKeys2 = Array("sparkhotel_1", "sparkhotel_2");
    //       println(cacheKeys2)
    //    val sparkHotelKey = "sparkhotel_";
    //    val id = "1 2 3 4 5 6"
    //    val ids = id.split(" ")
    //    var cacheKeys = new ArrayBuffer[String](ids.length);
    //    ids.foreach((key: String) => cacheKeys += (sparkHotelKey + key))
    //    println(cacheKeys)
    //    val host = "spark://10.0.0.23:7077";
    //    val conf = new SparkConf().setMaster(host).setAppName("wc1")
    //    val sc = new SparkContext(conf)
    //    sc.addJar("/Users/lz/scala/test/target/test-0.0.1-SNAPSHOT.jar")
    //
    //    val data = new Array[Int](1000000)
    //    for (i <- 0 until data.length) data(i) = i + 1
    //    val distData = sc.parallelize(data)
    //    val c = distData.reduce(_ + _)
    //    println("-斑斑驳驳吧-----------------" + c)
    //    sc.stop()
  }

}