object Main{
  def main(args:Array[String]) : Unit = {
    val sc = new java.util.Scanner(System.in)
    val list = List.fill(3)(sc.nextInt).sorted
    println(list.mkString(" "))
  }
}
