import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;

public class Main {
    static Map<Integer, int[]> map = new HashMap<Integer, int[]>();
    static Map<Integer, Boolean> visited = new HashMap<Integer, Boolean>();
    static List<Integer> que = new ArrayList<Integer>();
    static List<Integer> tmpQue = new ArrayList<Integer>();
	static int[] d; 

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
		
		//set map
        for (int i = 0; i < n; i++){
            String[] s = br.readLine().split(" ");
            int u = Integer.parseInt(s[0]);
            int k = Integer.parseInt(s[1]);
            int[] a = new int[k];
            for (int j = 0; j < k; j++){
                a[j] = Integer.parseInt(s[j+2]);
            }
            map.put(u, a);
            visited.put(u, false);
        }
        
        //array of steps
        d = new int[n + 1];
        for (int i = 0; i < n + 1; i++){
            d[i] = -1;
        }
        int v = 1;
        que.add(v);
        visited.put(1, true);
        int step = 0;
        d[v] = step;
        step++;
        
        while (que.size() > 0){
            v = que.remove(0);
			
            //add the next Vertices to the que
            try{
				if (map.get(v) == null){
					;
                }else{
                    int[] nextArr = map.get(v);
                    for (int j = 0; j < nextArr.length; j++){
                        if (visited.get(nextArr[j])){
                            ;
                        }else{
                            tmpQue.add(nextArr[j]);
                            visited.put(nextArr[j], true);
                            d[nextArr[j]] = step;
                        }
                    }
                }
				// 
				if (que.size() == 0){
					step++;
					for (int i = 0; i < tmpQue.size(); i++){
						que.add(tmpQue.get(i));
					}
					tmpQue.clear();
				}
            }catch (NullPointerException e){
                e.printStackTrace();
            }
        }
        //show the result
        for (int i = 1; i < n + 1; i++){
            System.out.println(i + " " + d[i]);
        }
    }    
}
