import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int cnt = 0;
        for (int i = 0; i < n; i++){
            int m = Integer.parseInt(br.readLine());
            if (millerRabinTest(m)){
                cnt++;
            }
        }
        System.out.println(cnt);
    }
    public static long modPow(long a, long b, long d){
        String bit = Long.toBinaryString(b);
        long ret = 1;
        for (int i=0; i<bit.length(); i++){
            ret *= ret;
            if (Integer.parseInt(""+bit.charAt(i))==1){
                ret *= a;
            }
            //System.out.println(ret);
            ret %= d;
            }
        return ret;
    }
    public static boolean millerRabinTest(int q){
        if (q == 2) return true;
        if (q < 2 || ((q & 1) == 0)) return false;

        int d = (q - 1) >> 1;
        while ((d & 1) == 0){
            d >>= 1;
        }
        
        int k = 50;
        Random r = new Random();
        for (int i = 0; i < k; i++){
            long a = 1 + r.nextInt(q-1);
            long t = d;
            long y = modPow(a, t, q);
            while (t != q - 1 && y != 1 && y != q - 1){
                y = modPow(y, 2, q);
                t <<= 1;
            }
            if (y != q - 1 &&(t&1) == 0){
                return false;
            }
        }
        return true;
    }
}
