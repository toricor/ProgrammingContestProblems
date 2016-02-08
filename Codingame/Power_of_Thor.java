import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 * ---
 * Hint: You can use the debug stream to print initialTX and initialTY, if Thor seems not follow your orders.
 **/
class Player {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int lightX = in.nextInt(); // the X position of the light of power
        int lightY = in.nextInt(); // the Y position of the light of power
        int initialTX = in.nextInt(); // Thor's starting X position
        int initialTY = in.nextInt(); // Thor's starting Y position
        int TX = initialTX;
        int TY = initialTY;
        // game loop
        while (true) {
            int remainingTurns = in.nextInt(); // The remaining amount of turns Thor can move. Do not remove this line.
            // Write an action using System.out.println()
            // To debug: System.err.println("Debug messages...");

            int difX = TX - lightX;
            int difY = TY - lightY;
            if (difX == 0 && difY == 0){
                ;
            }else if (difX == 0 && difY > 0){
                System.out.println("N");
                TY--;
            }else if (difX == 0 && difY < 0){
                System.out.println("S");
                TY++;
            }else if (difX > 0 && difY == 0){
                System.out.println("W");
                TX--;
            }else if (difX < 0 && difY == 0){
                System.out.println("E");
                TX++;
            }else if (difX > 0 && difY > 0){
                System.out.println("NW");
                TX--;
                TY--;
            }else if (difX > 0 && difY < 0){
                System.out.println("SW");
                TX--;
                TY++;
            }else if (difX < 0 && difY > 0){
                System.out.println("NE");
                TX++;
                TY--;
            }else{
                System.out.println("SE");
                TX++;
                TY++;
            }
            //System.out.println("SE"); // A single line providing the move to be made: N NE E SE S SW W or NW
        }
    }
}
