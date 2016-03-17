import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
// TLE
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String text = br.readLine();
        String pattern = br.readLine();
        bmSearch(text, pattern);
    }
    public static void bmSearch(String text, String pattern){
        int textLen = text.length();
        int patnLen = pattern.length();
        int[] skip = new int[128]; //store ascii code chars
        for (int i = 0; i < 128; i++){
            skip[i] = patnLen;
        }
        for (int i = 0; i < patnLen - 1; i++){
            skip[pattern.charAt(i)] = patnLen - i - 1;
        }
        int i = patnLen - 1;
        while (i < textLen){
            int j = patnLen - 1;
            while (text.charAt(i) == pattern.charAt(j)){
                if (j == 0){
                    System.out.println(i);
                    break;
                }
                i--;
                j--;
            }
            i += Math.max(patnLen - j, skip[text.charAt(i)]);
        }
    }
}
