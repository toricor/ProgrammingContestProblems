import math._
import scala.util._

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
object Solution extends App {
    val lon  = readLine.replace(",", ".").toDouble
    val lat  = readLine.replace(",", ".").toDouble
    val n = readInt
    
    var ans = ""
    var tmin = Double.MaxValue
    for(i <- 0 until n) {
        val defib = readLine.split(";")
        val lonb  = defib(4).replace(",", ".").toDouble
        val latb  = defib(5).replace(",", ".").toDouble
        val d = calc(lon, lat, lonb, latb)
        if (d < tmin){
            tmin = d
            ans = defib(1)
        }
    }
    println(ans)
    
    def calc(lon: Double, lat: Double, lonb: Double, latb: Double): Double = {
        val x = (lonb - lon) * cos((lat + latb)/2.0)
        val y = latb - lat
        sqrt(x * x + y * y) * 6371
    }
}
