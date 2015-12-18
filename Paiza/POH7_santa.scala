import scala.collection.mutable._
object Main{
  def main(args: Array[String]) = {
    val sc = new java.util.Scanner(System.in)
    val x, y, z, n = sc.nextInt
    val xListBuf, yListBuf = ListBuffer.empty[Int]
    xListBuf += 0
    xListBuf += x
    yListBuf += 0
    yListBuf += y
    for (i <- 1 to n){
      val d_i, a_i = sc.nextInt
      d_i match {
        case 0 => xListBuf += a_i
        case 1 => yListBuf += a_i
      }
    }
    val min_x = calcMin(xListBuf)
    val min_y = calcMin(yListBuf)
    println(min_x * min_y * z)
  }
  def calcMin(xListBuf: ListBuffer[Int]) : Int = {
    val xList = xListBuf.toList.sorted
    val xRanges = ListBuffer.empty[Int]
    for (i <- 1 to xList.size - 1){
      xRanges += xList(i) - xList(i-1)
    }
    val min_x = xRanges.toList.sorted.head
    min_x
  }
}
