object Main{
  object readInput{
    val sc = new java.util.Scanner(System.in)
    val N = sc.nextInt
    val array = Array.fill(N)(sc.nextInt)
  }
  def main(args:Array[String]) {
    val arr = readInput.array
    val (ans, count) = selectionSort(arr)
    println(ans.mkString(" ") + "\n" + count)
  }
  def selectionSort(array: Array[Int]) : (Array[Int], Int)= {
    val arr = array
    var count = 0
    for (i <- 0 until arr.length){
      var minj = i
      for (j <- i until arr.length){
        if (arr(j) < arr(minj)){
          minj = j
        }
      }
      swap(arr, i, minj)
      if (i != minj) count += 1
    }
    (arr, count)
  }
  def swap(arr: Array[Int], i: Int, j: Int) = {
    val t = arr(i)
    arr(i) = arr(j)
    arr(j) = t
  }
}
