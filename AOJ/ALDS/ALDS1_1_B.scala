object Main{
  def main(args: Array[String]) = {
    val sc = new java.util.Scanner(System.in)
    val a, b = sc.nextInt
    val x = math.max(a, b)
    val y = math.min(a, b)
    println(gcd(x,y))
  }
  def gcd(x: Int, y: Int) : Int = {
    if (y == 0) x else gcd(y, x%y)
  }
}
