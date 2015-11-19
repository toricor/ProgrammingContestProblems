import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] arr = br.readLine().split(" ");
        int[] A = new int[n];
        for (int i = 0; i < n; i++){
          A[i] = Integer.parseInt(arr[i]);
        }
        insertionSort(A, n);
    }
    static void insertionSort(int[] A, int n){
      printArray(A);
      for (int i = 1; i < n; i++){
        int v = A[i];
        int j = i - 1;
        while (j >= 0 && A[j] > v){
          swap(A, j+1, j);
          j--;
        }
        A[j+1] = v;
        printArray(A);
      }
    }
    static void swap(int[] A, int i, int j){
      int tmp = A[i];
      A[i] = A[j];
      A[j] = tmp;
    }
    static void printArray(int[] A){
      StringBuilder sb = new StringBuilder();
      for (int i = 0; i < A.length; i++){
        sb.append(String.valueOf(A[i]));
        if (i != A.length - 1){
          sb.append(" ");
        }
      }
      System.out.println(sb.toString());
    }
}
