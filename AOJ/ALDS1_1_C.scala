object Main {
  def main(args:Array[String]) = {
    val sc = new java.util.Scanner(System.in)
    val n = sc.nextInt
    val ls = List.fill(n)(sc.nextInt)
    println(ls.filter(i => is_prime(i)).size)
  }
  def is_prime2(n: Int): Boolean = {
    if (n == 2) return true
    //val count = (2 to n).filter(i => i * i <= n).filter(j => n % j == 0).size //memory limit exceeded
    val count_seq = for (i <- 2 to n if i * i <= n; if n % i == 0) yield i //memory limit exceeded
    val count = count_seq.size
    if (count == 0) true else false
  }
  def is_prime(n: Int): Boolean = {
    if (n == 2)
      return true
    var i = 2
    while (i * i <= n){
      if (n%i == 0){
        return false
      }
      i += 1
    }
    return true
  }
}
