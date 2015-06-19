import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] A = new int[101][101];
        for (int i = 0; i < 101; i++){
            for (int j = 0; j < 101; j++){
                A[i][j] = 0;
            }
        }
        int total = 0;
        for (int i = 0; i < n; i++){
            String[] line = br.readLine().split(" ");
            int x1 = Integer.parseInt(line[0]);
            int y1 = Integer.parseInt(line[1]);
            int x2 = Integer.parseInt(line[2]);
            int y2 = Integer.parseInt(line[3]);
            for (int j = x1; j < x2 + 1; j++){
                for (int k = y1; k < y2 + 1; k++){
                    A[j][k]++;
                    total++;
                }
            }
        }
        System.out.println(total);
    }
}
