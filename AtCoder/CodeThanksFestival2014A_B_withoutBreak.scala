object Main {
  def main(args:Array[String]) = {
    val sc = new java.util.Scanner(System.in)
    val N = sc.nextInt
    val ls = List.fill(3)(sc.nextInt).sorted.reverse
    val result = produce(ls, N)
    println(result)
  }
  def produce(ls: List[Int], N: Int): Int = {
    var ans = 0
    var badge = 0
    var flag = true
    
    while (flag){
      for (i <- ls){
        if (flag){
          badge += i
          ans += 1
          if (badge >= N) flag = false
        }
      }
    }
    ans
  }
}
