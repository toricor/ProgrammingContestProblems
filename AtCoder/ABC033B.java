import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int tot = 0;
        int tMax = 0;
        int tMaxIndex = 0;
        String tMaxCity = "";
        for (int i = 0; i < n; i++){
            String[] ln = br.readLine().split(" ");
            String s_i = ln[0];
            int p_i = Integer.parseInt(ln[1]);
            tot += p_i;
            if (tMax < p_i){
                tMax = p_i;
                tMaxCity = s_i;
            }
        }
        if ((double)tMax/tot > 0.5){
            System.out.println(tMaxCity);
        }else{
            System.out.println("atcoder");
        }
    }
}
