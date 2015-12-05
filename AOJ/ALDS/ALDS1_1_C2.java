import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int cnt = 0;
        for (int i = 0; i < n; i++){
            int m = Integer.parseInt(br.readLine());
            if (isPrime(m)){
                cnt++;
            }
        }
        System.out.println(cnt);
    }
    static boolean isPrime(int q){
        if (q == 2) return true;
        if (q < 2 || ((q & 1) == 0)) return false;
        
        int i = 3;
        while (i * i <= q){
            if (q % i == 0){
                return false;
            }
            i += 2;
            //i++;
            //if ((i & 1) == 0) i++;
        }
        return true;
        
    }
}
