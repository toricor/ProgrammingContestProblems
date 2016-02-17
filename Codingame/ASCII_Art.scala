import math._
import scala.util._
/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
object Solution{
    def main(args: Array[String]) = {
        val l, h = readInt
        val t = readLine.toUpperCase
        val ascii = List.fill(h)(readLine)
        val result = List.fill(h)(new StringBuilder)
        for (i <- 0 until t.length){
            val ch = t.charAt(i)
            if ('A' <= ch && ch <= 'Z'){
                val inx = ch - 65
                for (j <- 0 until h){
                    result(j) ++= ascii(j).slice(inx * l, (inx + 1) * l)
                }
            }else{
                val inx = 26
                for (j <- 0 until h){
                    result(j) ++= ascii(j).slice(inx * l, (inx + 1) * l)
                }
            }
        }
        result.foreach(println)
    }
}
