import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Player {
    static boolean[][] elevatorMap;
    static boolean[][] blockedClonePos;
    
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        final int nbFloors = in.nextInt(); // number of floors
        final int width = in.nextInt(); // width of the area
        final int nbRounds = in.nextInt(); // maximum number of rounds
        final int exitFloor = in.nextInt(); // floor on which the exit is found
        final int exitPos = in.nextInt(); // position of the exit on its floor
        final int nbTotalClones = in.nextInt(); // number of generated clones
        final int nbAdditionalElevators = in.nextInt(); // ignore (always zero)
        final int nbElevators = in.nextInt(); // number of elevators
        
        elevatorMap = new boolean[nbFloors][width];
        for (int i = 0; i < nbElevators; i++) {
            final int elevatorFloor = in.nextInt(); // floor on which this elevator is found
            final int elevatorPos = in.nextInt(); // position of the elevator on its floor
            elevatorMap[elevatorFloor][elevatorPos] = true;
        }

        // game loop
        blockedClonePos = new boolean[nbFloors][width];
        while (true) {
            final int cloneFloor = in.nextInt(); // floor of the leading clone
            final int clonePos = in.nextInt(); // position of the leading clone on its floor
            final String direction = in.next(); // direction of the leading clone: LEFT or RIGHT

            // Write an action using System.out.println()
            // To debug: System.err.println("Debug messages...");
            System.err.println(cloneFloor + " " + clonePos);
            if (cloneFloor == -1){
                System.out.println("WAIT");
            }else{
                if (isRightDirection(elevatorMap, cloneFloor, clonePos, exitFloor, exitPos, direction)){
                    System.out.println("WAIT"); // action: WAIT or BLOCK
                }else if (clonePos == getElevatorIndex(elevatorMap[cloneFloor])){
                    System.out.println("WAIT");
                }else{
                    if (blockedClonePos[cloneFloor][clonePos]){
                        System.out.println("WAIT");
                    }else{
                        System.out.println("BLOCK");
                        blockedClonePos[cloneFloor][clonePos] = true;
                    }
                }
            }
        }
    }
    public static boolean isRightDirection(boolean[][] elevatorMap, int cloneFloor, int clonePos, int exitFloor, int exitPos, String direction){
        if (exitFloor == 0){
            return checkCloneDirection(exitPos, clonePos, direction);
        }
        if (cloneFloor == exitFloor){
            return checkCloneDirection(exitPos, clonePos, direction);
        }
        int elevatorPos = getElevatorIndex(elevatorMap[cloneFloor]);
        return checkCloneDirection(elevatorPos, clonePos, direction);
    }
    private static boolean checkCloneDirection(int elevatorPos, int clonePos, String direction){
        if (elevatorPos < clonePos){
            if (direction.equals("LEFT")){
                return true;
            }else{
                return false;
            }
        }else if (elevatorPos > clonePos){
            if (direction.equals("LEFT")){
                return false;
            }else{
                return true;
            }
        }
        return false; // elevatorPos == clonePos
    }
    private static int getElevatorIndex(boolean[] arr){
        for (int i = 0; i < arr.length; i++){
            if (arr[i]){
                return i;
            }
        }
        return -1;
    }
}
