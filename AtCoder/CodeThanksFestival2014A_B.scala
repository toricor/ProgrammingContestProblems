object Main {
  def main(args:Array[String]) = {
    val sc = new java.util.Scanner(System.in)
    val N = sc.nextInt
    val ls = List.fill(3)(sc.nextInt).sorted.reverse
    val result = make(ls, N)
    println(result)
  }
  def make(ls: List[Int], N: Int): Int = {
    import scala.util.control.Breaks
    var ans = 0
    var badge = 0
    val b = new Breaks
    while (badge < N){
      b.breakable {
        for (i <- ls){
          badge += i
          ans += 1
          if (badge >= N) b.break
        }
      }
    }
    ans
  }
}
