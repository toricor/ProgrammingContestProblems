object Main {
  def main(args:Array[String]) = {
    val sc = new java.util.Scanner(System.in)
    val N = sc.nextInt
    val V = List.fill(N)(sc.nextInt)
    val F = List.fill(N)(sc.nextInt)
    
    var count = 0
    val zipList = V zip F
    for (i <- 0 until N)
      if (zipList(i)._2/zipList(i)._1.toDouble > 0.5) count += 1
    println(count)
  }
}
