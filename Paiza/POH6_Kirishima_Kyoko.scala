import scala.collection.mutable.ArrayBuffer
object Main {
  def main(args:Array[String]) = {
    val sc = new java.util.Scanner(System.in)
    val n = sc.nextInt
    val ls = List.fill(n)(sc.nextInt)
    val m = sc.nextInt
    for (i <- 1 to m){
      val q = sc.nextInt
      if (checkFirstInputRange(ls, q) && canBeSolved(ls, q)) println("Yes")
      else println("No")
    }
  }
  def checkFirstInputRange(ls: List[Int], query: Int) : Boolean = {
    if (query >= ls.size) false
    else true
  }
  def canBeSolved(ls: List[Int], query: Int) : Boolean = {
    if (query == ls.size - 1) return true
    val visited = ArrayBuffer.fill(ls.size)(false)
    var index = query
    while ((0 <= index && index < ls.size) && (visited(index) == false)){
      visited(index) = true
      val delta = ls(index)
      if (delta == 0){return false}
      else{
        val tmp_index = index + delta
        if (tmp_index == ls.size - 1){return true}
        else{index = tmp_index}
      }
    }
    false
  }
}
