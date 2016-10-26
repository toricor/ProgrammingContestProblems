import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static int count;
    private static int n;
    private static int t;
    private static List<String> ls;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        n = Integer.parseInt(line[0]);
        t = Integer.parseInt(line[1]);
        ls = new ArrayList<String>();
        hanoi(n, "LEFT", "CENTER", "RIGHT");
        System.out.println(decode(ls));
    }  
    private static void hanoi(int n, String from, String work, String dest) {
        if (n > 0) {
            hanoi(n - 1, from, dest, work);
            ls.add(++count + ":" + from + ":" + dest);
            if (count >= t){return;}
            hanoi(n - 1, work, from, dest);
        }
    }
    private static String decode(List<String> ls){
        Map<String, List<Integer>> hanoi = new HashMap<String, List<Integer>>();
        List<Integer> initial = new ArrayList<Integer>(); 
        for (int j = 1; j <= n; j++){
            initial.add(j);
        }
        hanoi.put("L", initial);
        hanoi.put("C", new ArrayList<Integer>());
        hanoi.put("R", new ArrayList<Integer>());
        
        for (int i = 0; i < t; i++){
            String[] line = ls.get(i).split(":");
            String from = line[1];
            String dest = line[2];
            //System.out.println(hanoi + " " + from + " " + dest);
            if (from.charAt(0) == 'L'){
                if (dest.charAt(0) == 'C'){
                    hanoi.get("C").add(0, hanoi.get("L").remove(0));
                }else if (dest.charAt(0) == 'R'){
                    hanoi.get("R").add(0, hanoi.get("L").remove(0));
                }
            }
            if (from.charAt(0) == 'C'){
                if (dest.charAt(0) == 'L'){
                    hanoi.get("L").add(0, hanoi.get("C").remove(0));
                }else if (dest.charAt(0) == 'R'){
                    hanoi.get("R").add(0, hanoi.get("C").remove(0));
                }
            }
            if (from.charAt(0) == 'R'){
                if (dest.charAt(0) == 'L'){
                    hanoi.get("L").add(0, hanoi.get("R").remove(0));
                }else if (dest.charAt(0) == 'C'){
                    hanoi.get("C").add(0, hanoi.get("R").remove(0));
                }
            }
        }
        //System.out.println(hanoi + " " + ls);
        return formatResult(hanoi);
    }
    private static String formatResult(Map<String, List<Integer>> hanoi){
        StringBuilder sb = new StringBuilder();
        List<Integer> L = hanoi.get("L");
        if (L.size() == 0){
            sb.append("-\n");
        }else{
            Collections.sort(L);
            Collections.reverse(L);
            sb.append(join(L));
        }
        List<Integer> C = hanoi.get("C");
        if (C.size() == 0){
            sb.append("-\n");
        }else{
            Collections.sort(C);
            Collections.reverse(C);
            sb.append(join(C));
        }
        List<Integer> R = hanoi.get("R");
        if (R.size() == 0){
            sb.append("-");
        }else{
            Collections.sort(R);
            Collections.reverse(R);
            sb.append(join(R));
        }
        return sb.toString();
    }
    private static String join(List<Integer> ls){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < ls.size() - 1; i++){
            sb.append(ls.get(i) + " ");
        }
        sb.append(ls.get(ls.size()-1) + "\n");
        return sb.toString();
    }
    
}
