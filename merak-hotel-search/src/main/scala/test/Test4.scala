package test

import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
import org.apache.spark.rdd.RDD.rddToPairRDDFunctions

object Test4 {
  def main(args: Array[String]) {
    val conf = new SparkConf().setMaster("spark://192.168.100.21:7077").setAppName("wc1");
    val sc = new SparkContext(conf)
    val line = sc.textFile("hdfs://192.168.100.23:9000/user/ubuntu/README.md")

    line.flatMap(flatMaptest(_)).map(maptest(_)).reduceByKey(reduceByKeytest(_, _)).collect().foreach(println)
    //    line.flatMap(_.split(" ")).map((_, 1)).reduceByKey(_ + _).collect().foreach(println)
    //    val wordCounts = line.flatMap(line => line.split(" ")).map(word => (word, 1)).reduceByKey((a, b) => a + b)
    //    val rs = Array(new Rational(0, 1), new Rational(2, 1), new Rational(1), new Rational())
    //    sc.parallelize(rs, 1)
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
