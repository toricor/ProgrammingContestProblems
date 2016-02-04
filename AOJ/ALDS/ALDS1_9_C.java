import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
//AC
public class Main {
    private static int[] A = new int[2000001];
    private static int heapSize = 0;
    private static void maxHeapify(int k){
        int l = 2 * k;
        int r = 2 * k + 1;
        int largest;
    
        if ((l <= (heapSize)) && (A[l] > A[k])){
            largest = l;
        }else{
            largest = k;
        }
        if ((r <= (heapSize)) && (A[r] > A[largest])){
            largest = r;
        }
        if (largest != k){
            swap(k, largest);
            maxHeapify(largest);
        }
    }
    private static void swap(int i, int j) {
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true){
            String[] line = br.readLine().split(" ");
            String order = line[0];
            if (order.equals("insert")){
                heapSize++;
                int num = Integer.parseInt(line[1]);
                A[heapSize] = num;
                int i = heapSize;
                while (i > 1 && A[i/2] < A[i]) {
                    swap(i, i/2);
                    i = i/2;
                }
            }else if (order.equals("extract")){
                int max = A[1];
                A[1] = 0;
                swap(1, heapSize);
                heapSize--;
                maxHeapify(1);
                System.out.println(max);
            }else{ // end
                break;
            }
        }
    }
}
