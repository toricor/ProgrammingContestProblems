object Main {
  def main(args:Array[String]) = {
    val sc = new java.util.Scanner(System.in)
    val N, M = sc.nextInt
    val points = List.fill(N)(sc.nextInt)
    val corrects = List.fill(M)(sc.nextInt)
    var total = 0
    for (num <- corrects)
      total += points(num - 1)
    println(total)
  }
}
