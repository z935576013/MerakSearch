package test

import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
import org.apache.spark.rdd.RDD.rddToPairRDDFunctions

object Test5 {
  def oncePerSecond(a: Int, b: Int, cb: (Int, Int) => Int): Int = {
    cb(a, b)
  }

  def main(args: Array[String]) {
    //    var sl = Array(1, 2, 3)
    //    sl.filter((a: Int) => a > 1)
    //      .foreach((a: Int) => Console.println("Found " + a))
    //    var c = oncePerSecond(2, 4, (a: Int, b: Int) => a * b)
    //    println(c)
    //
    //    sl.filter((a: Int) => a > 1).foreach(word => (word, 1))
    println(bb(2))
  }

  def bb(a: Int): Boolean = {
    if (a > 1) return true
    false
  }

}