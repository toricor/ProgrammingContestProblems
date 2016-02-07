import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
 
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] S = br.readLine().split("\\+");
        int cnt = 0;
        for (int i = 0; i < S.length; i++){
            if (S[i].length() == 1){
                if (Integer.parseInt(S[i]) == 0){
                    continue;
                }else{
                    cnt++;
                }
            }else if (S[i].contains("0")){
                continue;
            }else{
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}
