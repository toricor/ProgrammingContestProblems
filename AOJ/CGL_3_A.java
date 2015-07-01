import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ArrayList<String[]> array = new ArrayList<String[]>();
        for (int i = 0; i < n; i++){
            String[] s = br.readLine().split(" ");
            array.add(s);
        }
        double ans = 0;
        for (int i = 0; i < n - 1; i++){
            double xi = Double.parseDouble(array.get(i)[0]);
            double yi = Double.parseDouble(array.get(i)[1]);
            double xi1 = Double.parseDouble(array.get(i+1)[0]);
            double yi1 = Double.parseDouble(array.get(i+1)[1]);            
            ans += (xi * yi1 - xi1 * yi) / 2;
        }
        // i == n -1
        double xn = Double.parseDouble(array.get(n-1)[0]);
        double yn = Double.parseDouble(array.get(n-1)[1]);
        double xn1 = Double.parseDouble(array.get(0)[0]);
        double yn1 = Double.parseDouble(array.get(0)[1]);
        ans += (xn * yn1 - xn1 * yn) / 2;
        System.out.printf("%.1f\n", ans);
    }
}
