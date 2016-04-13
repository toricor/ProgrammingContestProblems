import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[][] map = new String[n][n];
        for (int i = 0; i < n; i++){
            String st = br.readLine();
            map[i] = mkStringArray(st);
        }
        String[][] newMap = rotateStringArray(map);
        for (int i = 0; i < n; i++){
            System.out.println(concatStringArray(newMap[i]));
        }
        
    }
    public static String concatStringArray(String[] arr){
        StringBuilder sb = new StringBuilder();
        for (String st: arr){
            sb.append(st);
        }
        return sb.toString();
    }
    public static String[][] rotateStringArray(String[][] map){
        int n = map.length;
        String[][] newMap = new String[n][n];
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                 newMap[i][j] = map[n - j - 1][i];
            }
        }
        return newMap;
    }
    
    public static String[] mkStringArray(String st){
        String[] ret = new String[st.length()];
        for (int i = 0; i < st.length(); i++){
            ret[i] = st.substring(i, i + 1);
        }
        return ret;
    }
}
