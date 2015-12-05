object Main {
  def main(args:Array[String]) = {
    val sc = new java.util.Scanner(System.in)
    val a, b, c = sc.nextInt
    println((a to b).filter(c % _ == 0).length)
  }
}
