import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] array= new int[n];
        for (int i = 0; i < n; i++){
            array[i] =  Integer.parseInt(br.readLine());
        }
        int minv = array[0];
        int maxv = Integer.MIN_VALUE;
        for (int j = 1; j < n; j++){
            maxv = max(maxv, array[j] - minv);
            minv = min(minv, array[j]);
        }
        System.out.println(maxv);
    }
	//use Math.max or Math.min 
    static int max(int a, int b){
        if (a > b){
            return a;
        }else{
            return b;
        }
    }
    static int min(int a, int b){
        if (a > b){
            return b;
        }else{
            return a;
        }
    }
}
