import java.util.*;
import java.io.*;
import java.math.*;
//AC

class Solution {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        String MESSAGE = in.nextLine();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < MESSAGE.length(); i++){
            String tmp = Integer.toBinaryString(MESSAGE.charAt(i));
            String bin = String.format("%7s", tmp).replace(' ', '0');
            sb.append(bin);
        }
        String binMESSAGE = sb.toString();
        System.err.println(binMESSAGE);
        System.out.println(convert(binMESSAGE));
        
    }

    public static String convert(String st){
        int inx = 0;
        char bin = st.charAt(inx);
        int cnt = 1;
        StringBuilder sb = new StringBuilder();
        while (true){// inx < st.length()
            if (inx == 0){
                inx++;
                continue;
            }
            if (st.charAt(inx - 1) == st.charAt(inx)){
                cnt++;
                inx++;
            }else{
                if (bin =='0'){
                    sb.append("00" + " " + repeat('0', cnt) + " ");
                }else{
                    sb.append("0" + " " + repeat('0', cnt) + " ");
                }
                bin = st.charAt(inx);
                cnt = 1;
                inx++;
            }
            if (inx == st.length()){
                if (bin =='0'){
                    sb.append("00" + " " + repeat('0', cnt));
                }else{
                    sb.append("0" + " " + repeat('0', cnt));
                }
                break;
            }
        }
        return sb.toString();
    }    
    
    public static String repeat(char st, int n){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++){
            sb.append(st);
        }
        return sb.toString();
    }

}
