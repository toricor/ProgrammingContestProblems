object Main{
  def main(args:Array[String]) = {
    io.Source.stdin.mkString.toCharArray.foreach(x => print(swap_case_as_int(x.toInt).toChar))
  }
  def swap_case_as_int(int: Int) : Int ={
    if (65 <= int && int <= 90) int + 32
    else if (97 <= int && int <= 122) int - 32
    else  int
  }
}
