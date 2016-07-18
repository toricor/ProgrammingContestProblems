import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int maxMinute = Integer.parseInt(br.readLine()) * 60;
        int n = Integer.parseInt(br.readLine());
        int ans = 0;
        for (int i = 0; i < n; i++){
            maxMinute -= Integer.parseInt(br.readLine());
            if (maxMinute < 0){
                break;
            }else{
                ans++;
            }
        }
        if (ans == n){
            System.out.println("OK");
        }else{
            System.out.println(ans);
        }
    }
}
