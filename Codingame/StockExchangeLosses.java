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
        int n = in.nextInt();
        int maxv = in.nextInt();
        int minv = 0;
        for (int i = 1; i < n; i++) {
            int nextv = in.nextInt();
            minv = Math.min(minv, nextv - maxv);
            maxv = Math.max(maxv, nextv);
        }
        System.out.println(minv);
    }
}
