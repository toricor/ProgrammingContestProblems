import java.util.*;
import java.io.*;
/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Player {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int road = in.nextInt(); // the length of the road before the gap.
        int gap = in.nextInt(); // the length of the gap.
        int platform = in.nextInt(); // the length of the landing platform.

        // game loop
        boolean jumped = false;
        while (true) {
            int speed = in.nextInt(); // the motorbike's speed.
            int coordX = in.nextInt(); // the position on the road of the motorbike.
            // Write an action using System.out.println()
            // To debug: System.err.println("Debug messages...");
            
            if (coordX + speed < road){
                if (speed == gap + 1){
                    System.out.println("WAIT");
                }else if (speed > gap + 1){
                    System.out.println("SLOW");
                }else{
                    System.out.println("SPEED");
                }
            }else{
                if (coordX + speed >road && !jumped){
                    System.out.println("JUMP"); // A single line containing one of 4 keywords: SPEED, SLOW, JUMP, WAIT.
                    jumped = true;
                }else{    
                    System.out.println("SLOW");
                }
            }
        }
    }
}
