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
        int N = in.nextInt();
        List<Integer> ls = new ArrayList<Integer>();
        for (int i = 0; i < N; i++) {
            int pi = in.nextInt();
            ls.add(pi);
        }
        Collections.sort(ls);
        int tmin = Integer.MAX_VALUE;
        for (int i = 0; i < N - 1; i++){
            int tmp = ls.get(i + 1) - ls.get(i);
            if (tmp < tmin){
                tmin = tmp;
            }
        }
        System.out.println(tmin);
    }
}
