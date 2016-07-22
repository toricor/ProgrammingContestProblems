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
        for (int i = 0; i < N; i++) {
            String xY = in.next();
            String ans = calc(xY);
            System.out.println(ans);
        }
    }
    
    public static String calc(String xY){
        boolean negativeFlagBunshi = false;
        boolean negativeFlagBunbo  = false;
        String[] splited = xY.split("/");
        int givenBunshi;
        int givenBunbo;
        if (splited[0].charAt(0) == '-'){
            givenBunshi = Integer.parseInt(splited[0].substring(1));
            negativeFlagBunshi = true;
        }else{
            givenBunshi = Integer.parseInt(splited[0]);
        }
        if (splited[1].charAt(0) == '-'){
            givenBunbo = Integer.parseInt(splited[1].substring(1));
            negativeFlagBunbo = true;
        }else{
            givenBunbo = Integer.parseInt(splited[1]);
        }
        
        String ans = calcBunsu(givenBunshi, givenBunbo);
        if (negativeFlagBunshi && negativeFlagBunbo){
            return ans;
        }else if (!negativeFlagBunshi && negativeFlagBunbo && !ans.equals("0") && ans.charAt(0) != 'D'){
            return "-" + ans;
        }else if (negativeFlagBunshi && !negativeFlagBunbo && !ans.equals("0") && ans.charAt(0) != 'D'){
            return "-" + ans;
        }else{
            return ans;
        }
    }
    
    private static String calcBunsu(int bunshi, int bunbo){
        // bunshi > 0, bunbo > 0;
        int retSeisu;
        int retBunshi;
        int retBunbo;
        
        if (bunbo == 0){
            return "DIVISION BY ZERO";
        }
        if (bunshi == 0){
            return "0";
        }
        if (bunshi%bunbo == 0){
            return "" + bunshi/bunbo;
        }
        
        if (bunshi/bunbo == 0){
            retSeisu = 0;
        }else{
            // bunshi/bunbo > 0;
            retSeisu = bunshi/bunbo;
        }
        int gcd = gcd(bunshi, bunbo);
        retBunshi = (bunshi - retSeisu * bunbo)/gcd;
        retBunbo  = bunbo/gcd;
        //System.out.println(retBunshi + " "+ retBunbo);
        if (retSeisu == 0){
            return retBunshi + "/" + retBunbo;
        }else{
            return retSeisu + " " + retBunshi + "/" + retBunbo;
        }
    }
    public static int gcd(int a, int b){
        if (a > b){
            int t = a;
            a = b;
            b = t;
        }
        int t = 0;
        while (b%a > 0){
            t = b;
            b = a;
            a = t%a;
        }
        return a;
    } 
}
