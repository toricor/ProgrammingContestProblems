import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

//Naive version
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] ln = br.readLine().split(" ");
        int[] A = new int[100000];
        int n = Integer.parseInt(ln[0]);
        int q = Integer.parseInt(ln[1]);
        for (int j = 0; j<q; j++){
            String[] line = br.readLine().split(" ");
            int com = Integer.parseInt(line[0]);
            int x = Integer.parseInt(line[1]);
            int y = Integer.parseInt(line[2]);
            if (com == 1){
                int tot = 0;
                for (int i = x; i < y + 1; i++){
                    tot += A[i];
                }
                System.out.println(tot);
            }else{
                A[x] += y;
            }
        }
    }
}
