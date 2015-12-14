import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        //set array
        String[] st = br.readLine().split(" ");
        int[] array = new int[n];
        for (int i = 0; i < n; i++){
            int a = Integer.parseInt(st[i]);
            array[i] = a;
        }
        
        int count = selectionSort(array);
        System.out.println(mkArrayString(array));
        System.out.println(count);
    }
    static String mkArrayString(int[] arr){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length - 1; i++){
            sb.append(arr[i]);
            sb.append(" ");
        }
        sb.append(arr[arr.length - 1]);
        return sb.toString();
    }
    static int selectionSort(int[] arr){
        //selectionSort and return swapCount
        int swapCnt = 0;
        for (int i = 0; i < arr.length; i++){
            int minj = i;
            for (int j = i; j < arr.length; j++){
                if ( arr[j] < arr[minj]){
                    minj = j;
                }
            }
            swap(arr, i, minj);
            if (i != minj) swapCnt += 1;
        }
        return swapCnt;
    }
    static void swap(int[] arr, int i, int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
