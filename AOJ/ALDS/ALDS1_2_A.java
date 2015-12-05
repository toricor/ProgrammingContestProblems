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
        
        int count = bubbleSort(array);
        printArray2(array);
        System.out.println(count);
        
    }
    static void printArray(int[] arr){
        for (int i = 0; i < arr.length - 1; i++){
            System.out.print(arr[i]);
            System.out.print(" ");
        }
        System.out.println(arr[arr.length-1]);
    }
    static void printArray2(int[] arr){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length - 1; i++){
            sb.append(arr[i]);
            sb.append(" ");
        }
        sb.append(arr[arr.length - 1]);
        System.out.println(sb.toString());
    }
    static int bubbleSort(int[] arr){
        //bubble sort and count swaps
        int swapcnt = 0;
        for (int i = 0; i < arr.length; i++){
            for (int j = arr.length - 1; j > i; j--){
                if ( arr[j] < arr[j-1]){
                    swap(arr, j, j - 1);
                    swapcnt += 1;
                }
            }
        }
        return swapcnt;
    }
    static void swap(int[] arr, int i, int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
