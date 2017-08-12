import scala.collection.mutable.ListBuffer
object Main {
    def main(args: Array[String]) : Unit = {
        val sc  = new java.util.Scanner(System.in)
        val n = sc.nextInt
        val inp = sc.next
        println(genAnsList(inp).mkString(" "))
    }
    
    def genAnsList(st: String) : List[Int] = {
        val buf = new ListBuffer[Int]
        var cnt = 1
        for (ch <- st) {
            if (ch == 'R') {
                buf += cnt
            } else {
                cnt +=: buf
            }
            cnt += 1
        }
        buf.toList
    }
}
