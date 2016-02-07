object Main{
  def main(args:Array[String]) : Unit = {
    val sc = new java.util.Scanner(System.in)
    val st = sc.next
    if (st(0) == st(1) && st(1) == st(2) && st(2) == st(3)) println("SAME") else println("DIFFERENT")
  }
}
