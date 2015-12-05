import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        final int n = Integer.parseInt(line[0]);
        final int m = Integer.parseInt(line[1]);
        final int l = Integer.parseInt(line[2]);
        int[][] A = new int[n][m];
        int[][] B = new int[m][l];
        long[][] C = new long[n][l];
        
        for (int i=0; i<n; i++){
            String[] tmp= br.readLine().split(" ");
            for (int j=0; j<m; j++){
                int num = Integer.parseInt(tmp[j]);
                A[i][j] = num;
            }
        }
        for (int i=0; i<m; i++){
            String[] tmp= br.readLine().split(" ");
            for (int j=0; j<l; j++){
                int num = Integer.parseInt(tmp[j]);
                B[i][j] = num;
            }
        }
        for (int i=0; i<n; i++){
            for (int j=0; j<m; j++){
                for (int k=0; k<l; k++){
                    C[i][k] += A[i][j]*B[j][k]; 
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<n; i++){
            for (int j=0; j<l-1; j++){
                sb.append(C[i][j]);
                sb.append(" ");
            }
            sb.append(C[i][l-1]);
            sb.append("\n");
        }
        System.out.print(sb.toString());
    }
}

