import math._
import scala.util._

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
object Player extends App {
    // w: width of the building.
    // h: height of the building.
    val sc = new java.util.Scanner(System.in)
    val w, h, n = sc.nextInt
    var x, y = sc.nextInt
    var w_min = 0
    var w_max = w - 1
    var h_min = 0
    var h_max = h - 1    
    // game loop
    while(true) {
        val bomb_dir = sc.next // the direction of the bombs from batman's current location (U, UR, R, DR, D, DL, L or UL)
        if (bomb_dir.contains("U")){
            h_max = y - 1
        }
        if (bomb_dir.contains("D")){
            h_min = y + 1
        }
        if (bomb_dir.contains("R")){
            w_min = x + 1
        }
        if (bomb_dir.contains("L")){
            w_max = x - 1
        }
        // Write an action using println
        // To debug: Console.err.println("Debug messages...")
        x = (w_min + w_max)/2
        y = (h_min + h_max)/2

        println(x + " " + y) // the location of the next window Batman should jump to.
    }
}
