import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
 
public class Main {
    static void gcd(int a, int b){
            int x = Math.max(a,b);
            int y = Math.min(a,b);
            int t = 0;
            while (y>0){
                t = x;
                x = y;
                y = t%y;
            }
            System.out.println(x);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        int a = Integer.parseInt(line[0]);
        int b = Integer.parseInt(line[1]);
        gcd(a,b);
    }
}
