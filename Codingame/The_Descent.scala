import math._
import scala.util._

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
object Player extends App {

    // game loop
    while(true) {
        val Array(spacex, spacey) = for(i <- readLine split " ") yield i.toInt
        val ls = List.fill(8)(readInt)
        val max = ls.max
        val inx = ls.indexOf(max)
        // Write an action using println
        // To debug: Console.err.println("Debug messages...")
        if (inx == spacex) println("FIRE") else println("HOLD") // either:  FIRE (ship is firing its phase cannons) or HOLD (ship is not firing).
    }
}
