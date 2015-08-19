object Main {
  def main(arg:Array[String]) = {
    val sc = new java.util.Scanner(System.in)
    val a,b,c = sc.nextInt
    val ans = List(pp(a,b,c), pt(a,b,c), tp(a,b,c), tt(a,b,c)).max //need refactoring
    println(ans)
  }//p: plus, t: times
  def pp(a: Int, b: Int, c: Int) : Int = {
    val ret = a + b + c
    ret
  }
  def pt(a: Int, b: Int, c: Int) : Int = {
    val ret = (a + b) * c
    ret
  }
  def tp(a: Int, b: Int, c: Int) : Int = {
    val ret = a * b + c
    ret
  }
  def tt(a: Int, b: Int, c: Int) : Int = {
    val ret = a * b * c
    ret
  }
}
