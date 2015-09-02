object Main {
  def main(args:Array[String]) = {
    val sc = new java.util.Scanner(System.in)
    val n = sc.nextInt
    val head = n.toString.head.toInt - 48
    val last = n.toString.last.toInt - 48 
    println(n + head + last)
  }
}
