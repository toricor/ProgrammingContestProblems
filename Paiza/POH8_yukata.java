import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.HashMap;

public class Main {
    private static int tempDiff;
    private static int cost;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Map<Integer, String> input = new HashMap<Integer, String>();
        for (int i = 0; i < n; i++){
            String[] line = br.readLine().split(" ");
            int time = Integer.parseInt(line[0]);
            input.put(time, line[1]);
        }
        tempDiff = 0;
        cost = 0;
        int preTemp = 0;
        if (input.containsKey(0)){
                switch (input.get(0)){
                    case "in":
                        if (preTemp == 0){
                            tempDiff += 5;
                            cost++;
                        }else{
                            tempDiff += 4;
                            cost += 2;
                        }
                        break;
                    case "out":
                        if (preTemp == 0){
                            tempDiff += 3;
                            cost ++;
                        }else{
                            tempDiff += 2;
                            cost += 2;
                        }
                        break;
                        
                }
        }
        for (int i = 1; i <= 24; i++){
            if (input.containsKey(i)){
                switch (input.get(i)){
                    case "in":
                        if (preTemp == 0){
                            tempDiff += 5;
                            cost++;
                        }else{
                            tempDiff += 4;
                            cost += 2;
                        }
                        break;
                    case "out":
                        if (preTemp == 0){
                            tempDiff += 3;
                            cost ++;
                        }else{
                            tempDiff += 2;
                            cost += 2;
                        }
                        break;
                        
                }
            }else if (preTemp == 0){
                cost++;
            }else{
                cost+=2;
                tempDiff--;
            }
    
            //System.out.println("time: " + i + " cost: " + cost + " tempDiff: " + tempDiff + " preTemp: " + preTemp);
            preTemp = tempDiff;
        }
        System.out.println(cost);
    }
}
