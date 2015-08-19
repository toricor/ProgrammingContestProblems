object Main {
  def main(args:Array[String]) = {
    val sc = new java.util.Scanner(System.in)
    println(List.fill(2)(sc.nextInt).max)
  }
}
