object Main{
  def main(args:Array[String]) : Unit = {
    val sc = new java.util.Scanner(System.in)
    val a,b,c = sc.nextInt
    if (isSorted(a, b, c)) println("Yes") else println("No")
  }
  def isSorted(a: Int, b: Int, c: Int) : Boolean = {
    if (a < b && b < c) true else false
  }
}
