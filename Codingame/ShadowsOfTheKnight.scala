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
    var w_max = w 
    var h_min = 0
    var h_max = h     
    // game loop
    while(true) {
        val bomb_dir = sc.next // the direction of the bombs from batman's current location (U, UR, R, DR, D, DL, L or UL)
        bomb_dir match {
            case "U"|"UR"|"UL" => h_max = y - 1
            case "D"|"DR"|"DL" => h_min = y + 1
            case _ =>
        }
        bomb_dir match {
            case "R"|"UR"|"DR" => w_min = x + 1
            case "L"|"UL"|"DL" => w_max = x - 1
            case _ =>
        }
        // Write an action using println
        // To debug: Console.err.println("Debug messages...")
        x = (w_min + w_max)/2
        y = (h_min + h_max)/2

        println(x + " " + y) // the location of the next window Batman should jump to.
    }
}
