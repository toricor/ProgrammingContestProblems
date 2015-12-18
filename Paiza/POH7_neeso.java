import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        int len = 0;
        while (len < m){
            if (len/n%2 == 0){
                sb.append('R');
            }else{
                sb.append('W');
            }
            len++;
        }
        System.out.println(sb.toString());
    }
}
