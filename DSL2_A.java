import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

//Naive version
public class Main {
    static int[] A = new int[100000];
    static void update(int i, int x){
        A[i] = x;
    }
    
    static void find(int s, int t){
        int min = Integer.MAX_VALUE;
        for (int i = s; i < t + 1; i++){
            if (A[i] < min){
                min = A[i];
            }
        }
        System.out.println(min);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        int n = Integer.parseInt(line[0]);
        int q = Integer.parseInt(line[1]);
        for (int j = 0; j < 100000; j++){
            A[j] = Integer.MAX_VALUE;
        }
        for (int i = 0; i < q; i++){
            String[] ln = br.readLine().split(" ");
            int com = Integer.parseInt(ln[0]);
            int x = Integer.parseInt(ln[1]);
            int y = Integer.parseInt(ln[2]);
            if (com == 0){
                update(x,y);
            }else{
                find(x,y);
            }
        }
    }
}    
