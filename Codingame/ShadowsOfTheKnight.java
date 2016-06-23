import java.util.*;
import java.io.*;
import java.math.*;

class Player {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int W = in.nextInt(); // width of the building.
        int H = in.nextInt(); // height of the building.
        int N = in.nextInt(); // maximum number of turns before game over.
        int x = in.nextInt();
        int y = in.nextInt();
        
        int h_max = H;
        int h_min = 0;
        int w_max = W;
        int w_min = 0;
        // game loop
        while (true) {
            String BOMBDIR = in.next(); // the direction of the bombs from batman's current location (U, UR, R, DR, D, DL, L or UL)
            if (BOMBDIR.contains("U")){
                h_max = y - 1;
            }else if (BOMBDIR.contains("D")){
                h_min = y + 1;
            }
            if (BOMBDIR.contains("R")){
                w_min = x + 1;
            }else if (BOMBDIR.contains("L")){
                w_max = x - 1;
            }
            x = (w_min + w_max)/2;
            y = (h_min + h_max)/2;
            System.out.println(x + " " + y); // the location of the next window Batman should jump to.
        }
    }
}
