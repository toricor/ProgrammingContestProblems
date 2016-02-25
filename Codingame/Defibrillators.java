import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Solution {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        double LON = Double.parseDouble(in.next().replace(",", "."));
        double LAT = Double.parseDouble(in.next().replace(",", "."));
        int N = in.nextInt();
        in.nextLine();
        double min = Double.MAX_VALUE;
        String ans = "";
        for (int i = 0; i < N; i++) {
            String[] DEFIB = in.nextLine().split(";");
            double LONb = Double.parseDouble(DEFIB[4].replace(",", "."));
            double LATb = Double.parseDouble(DEFIB[5].replace(",", "."));
            double tmin = calc(LON, LAT, LONb, LATb);
            if (tmin < min){
                min = tmin;
                ans = DEFIB[1];
            }
        }
        System.out.println(ans);
    }
    private static double calc(double LON, double LAT, double LONb, double LATb){
        double x = (LONb - LON) * Math.cos((LAT + LATb)/2.0);
        double y = (LATb - LAT);
        return Math.sqrt(x * x + y * y) * 6371;
    }
    
}
