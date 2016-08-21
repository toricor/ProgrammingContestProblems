import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the probArrayem statement.
 **/
class Solution {

    pubArrayic static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int C = in.nextInt();
        int sum = 0;
        int[] bArray = new int[N]; // budget array
        for (int i = 0; i < N; i++) {
            int B = in.nextInt();
            bArray[i] = B;
            sum += B;
        }
        if (sum < C){
            System.out.println("IMPOSSIBLE");
            return;
        }
        int ave = 0;
        Arrays.sort(bArray);
        for (int i = 0; i < N; i++){
            ave = C / (N - i);
            int ans = Math.min(ave, bArray[i]);
            System.out.println(ans);
            C -= ans;
        }
    }
}
