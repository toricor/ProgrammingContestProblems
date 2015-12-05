object Main{
  def main(args:Array[String]) : Unit = {
      val sc = new java.util.Scanner(System.in)
      val n = sc.nextInt
      val list = List.fill(n)(sc.nextInt)
      val q = sc.nextInt
      val queries = List.fill(q)(sc.nextInt)
      println(queries.filter(binarySearch(list, _).size))
  }
  def binarySearch(list: List[Int], n: Int) : Boolean = {
    val l = list.size
    if (l==0) false
    else if (list(l/2) > n ) binarySearch(list.slice(0, l/2), n)
    else if (list(l/2) == n) true
    else binarySearch(list.slice((l/2) + 1, list.size), n)
  }
}
