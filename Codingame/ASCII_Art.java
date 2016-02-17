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
        int L = in.nextInt();
        int H = in.nextInt();
        in.nextLine();
        String T = in.nextLine().toUpperCase();
        String[] ascii = new String[H];
        for (int i = 0; i < H; i++) {
            String ROW = in.nextLine();
            ascii[i] = ROW;
        }
        StringBuilder[] ans = new StringBuilder[H];
        for (int i = 0; i < H; i++){
            ans[i] = new StringBuilder();
        }
        for (int i = 0; i < T.length(); i++){
            char ch = T.charAt(i);
            if ('A' <= ch && ch <= 'Z'){
                // ansにasciiの該当するアスキーアートをつける。
                int inx = ch - 65; 
                for (int j = 0; j < H; j++){
                    String sub = ascii[j].substring(inx * L, (inx + 1) * L);
                    ans[j].append(sub);
                }
            }else{
                // ans に?つける
                int inx = 26;
                for (int j = 0; j < H; j++){
                    String sub = ascii[j].substring(inx * L);
                    ans[j].append(sub);
                }
            }
        }
        //show ans
        for (int i = 0; i < H; i++){
            System.out.println(ans[i].toString());
        }
    }
}
