import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static int gcd(int x, int y){
        if (y == 0){
            return x;
        }else{
            return gcd(y, x%y);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        int a = Integer.parseInt(line[0]);
        int b = Integer.parseInt(line[1]);
        int x = Math.max(a, b);
        int y = Math.min(a, b);
        int ans = gcd(x, y);
        System.out.println(ans);
    }
}
