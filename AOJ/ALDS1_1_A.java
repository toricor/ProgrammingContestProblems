import java.io.IOException;
import java.util.Scanner;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        LinkedList<Integer> list = new LinkedList<Integer>();
        for (int i = 0; i < n; i++){
            list.add(sc.nextInt());
        }
        sc.close();
        InsertionSort(list);
    }
    
    static void InsertionSort(LinkedList<Integer> list){
        int key = 0;
        PrintList(list);
        for (int i = 1; i < list.size(); i++){
            key = list.get(i);
            int j = i - 1;
            while (j >= 0 && list.get(j) > key){
                swap(list, j+1, j);
                j--;
            }
            list.set(j+1 , key);
            PrintList(list);
        }
        
    }
    static void swap(LinkedList<Integer> list, int from, int to){
        int temp = list.get(from);
        list.set(from,list.get(to));
        list.set(to, temp);
    }
    static void PrintList(LinkedList<Integer> list){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++){
            sb.append(list.get(i)+" ");
        }
        System.out.println(sb.deleteCharAt(sb.length()-1));
        
    }
}
