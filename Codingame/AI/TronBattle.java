import java.util.*;
import java.io.*;
import java.math.*;
import java.util.Map.*;

class Player {
    private static boolean[][] map = new boolean[20][30]; // global map "isOccupied"
    
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        GameAI ai = new GameAI();
        // game loop
        while (true) {
            int N = sc.nextInt(); // total number of players (2 to 4).
            int P = sc.nextInt(); // your player number (0 to 3).
			//int[][] input = new int[N][4];
			String ans = "RIGHT";
            for (int i = 0; i < N; i++) {
                int X0 = sc.nextInt(); // starting X coordinate of lightcycle (or -1)
                int Y0 = sc.nextInt(); // starting Y coordinate of lightcycle (or -1)
                int X1 = sc.nextInt(); // starting X coordinate of lightcycle (can be the same as X0 if you play before this player)
                int Y1 = sc.nextInt(); // starting Y coordinate of lightcycle (can be the same as Y0 if you play before this player)
				updateMap(X1, Y1);
				System.err.println(ai.countSurroundingVoidCell(X1, Y1, map) + " X1:" + X1 + " Y1:" + Y1);
				int[] temp  = {X0, Y0, X1, Y1};
				if (i == P){
				    ai.setXY(X1, Y1);
				    ai.updateMyValueArray(X1, Y1, map);
				    ans = ai.think(X1, Y1, map);
				    //input[i] = temp;
				}
			}
			System.err.println(ai.valueArray);
			//System.err.println(Arrays.deepToString(map));
			System.out.println(ans); // A single line with UP, DOWN, LEFT or RIGHT
        }
    }
    public static void updateMap(int X1, int Y1){
        if (0 <= X1 && X1 < 30 && 0 <= Y1 && Y1 < 20){
            map[Y1][X1] = true;
        }
    }
}
class GameAI{
    HashMap<String, Integer> valueArray = new HashMap<String, Integer>(); // "L", "LR", "RDD" などの各手の評価結果を格納するValueArrayを作成する。初期値-1
    private boolean[][] myMap = new boolean[20][35]; // 自分の位置のみを記したmap
    private int x;
    private int y;
    private static String[] order = {"U", "D", "L", "R"};
    
    GameAI(){
        this.myMap = myMap;
        initValueArray();
    }
    
    void setXY(int X, int Y){
        setX(X);
        setY(Y);
        updateMyMap(X, Y);
    }
    private void setX(int X){
        this.x = X;
    }
    private void setY(int Y){
        this.y = Y;
    }
    private void updateMyMap(int X, int Y){
        this.myMap[Y][X] = true;
    }
    private void initValueArray(){
        //3階層までのすべての指し手に初期値-1を割り当てる
        for (int i = 0; i < 4; i++){
            this.valueArray.put(order[i], -1);
        }
        for (int i = 0; i < 4; i++){
            StringBuilder sb = new StringBuilder();
            sb.append(order[i]);
            for (int j = 0; j < 4; j++){
                sb.append(order[j]);
                this.valueArray.put(sb.toString(), -1);
                sb.deleteCharAt(sb.length() - 1);
            }
        }        
        for (int i = 0; i < 4; i++){
            StringBuilder sb = new StringBuilder();
            sb.append(order[i]);
            for (int j = 0; j < 4; j++){
                sb.append(order[j]);
                for (int k = 0; k < 4; k++){
                    sb.append(order[k]);
                    this.valueArray.put(sb.toString(), -1);
                    sb.deleteCharAt(sb.length() - 1);
                }
                sb.deleteCharAt(sb.length() - 1);
            }
        }
        this.valueArray.put("LRLU", -1);
        this.valueArray.put("LRLD", -1);
        this.valueArray.put("LRLL", -1);
        this.valueArray.put("LRLR", -1);
        this.valueArray.put("LULDLL", -1);
        this.valueArray.put("LULRLR", -1);
        this.valueArray.put("LULULL", -1);
        this.valueArray.put("LULLLR", -1);
    }
    private static boolean isAcceptableTrack(int X1, int Y1, String st, boolean[][] map){
        // stは"LLR"や"DU"などの文字
        // 到達するまでにすでに埋まっているマスは通らないようにする。
        // 到達するまでにmapからはみ出ないようにする。
        boolean[][] tMap = new boolean[20][35];
        for (int i = 0; i < st.length(); i++){
            switch (st.charAt(i)){
                case 'U':
                    Y1--;
                    break;
                case 'D':
                    Y1++;
                    break;
                case 'L':
                    X1--;
                    break;
                case 'R':
                    X1++;
                    break;
            }
            
            
            if (isValidXY(X1, Y1, map) && !tMap[Y1][X1]){
                tMap[Y1][X1] = true; // 同じマスに戻ってくる場合ははじく;
            }else{
                return false;
            }
        }
        return true;
    }
    private static int[] calcAfterMovementPosition(int X1, int Y1, String st, boolean[][] map){
        // stは"LLR"や"DU"などの文字
        // 到達するまでにすでに埋まっているマスは通らないようにする。
        // 到達するまでにmapからはみ出ないようにする。
		int[] ret = new int[2];
		ret[0] = -1;
		ret[1] = -1;
        boolean[][] tMap = new boolean[20][35];
        for (int i = 0; i < st.length(); i++){
            switch (st.charAt(i)){
                case 'U':
                    Y1--;
                    break;
                case 'D':
                    Y1++;
                    break;
                case 'L':
                    X1--;
                    break;
                case 'R':
                    X1++;
                    break;
            }
            
            
            if (isValidXY(X1, Y1, map) && !tMap[Y1][X1]){
                tMap[Y1][X1] = true; // 同じマスに戻ってくる場合ははじく;
            }else{
                return ret;
            }
        }
		ret[0] = X1;
		ret[1] = Y1;
        return ret;
    }
    public static int countSurroundingVoidCell(int x, int y, boolean[][] map){
        int count = 0;
        int[] ref = {-1, 0 , 1};
        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++){
                int tx = x;
                int ty = y;
                tx += ref[i];
                ty += ref[j];
                if (isValidXY(tx, ty, map)){
                    count++;
                }
            }
        }
        return count; // 自分のいるセルをかならず含むので
    }
    
    private static boolean isValidXY(int X1, int Y1, boolean[][] map){
        // X1, Y1がmap上の範囲にあるか&& occupied cellを通らないか
        if (0 <= X1 && X1 < 30 && 0 <= Y1 && Y1 < 20){
            if (map[Y1][X1]){
                return false;
            }else{
                return true;
            }
        }else{
            return false;
        }
    }
    
    private static String mkAnswerFormat(char ch){
        switch (ch){
                case 'U':
                    return "UP";
                case 'D':
                    return "DOWN";
                case 'L':
                    return "LEFT";
                case 'R':
                    return "RIGHT";
        }
        return "";
    }
    public void updateMyValueArray(int X1, int Y1, boolean[][] map){
        List<Map.Entry<String, Integer>> entries = new ArrayList<Map.Entry<String, Integer>>(valueArray.entrySet());
        for (Map.Entry<String, Integer> e: entries){
            int[] temp = calcAfterMovementPosition(X1,Y1, e.getKey(), map);
            int x = temp[0];
            int y = temp[1];
            valueArray.put(e.getKey(), countSurroundingVoidCell(x, y, map));
        }
    }
	public String think(int X1, int Y1, boolean[][] map){
		//マンハッタン距離3まで読むようにする。 自分(P)の手のみ読む。
		String ret = "LEFT";
		char headChar = 'L';
		//valueArrayをfor文でまわす
        //Map.Entry のリストを作る
        List<Map.Entry<String, Integer>> entries = 
        new ArrayList<Map.Entry<String, Integer>>(valueArray.entrySet());

        //Comparator で Map.Entry の値を比較
        Collections.sort(entries, new Comparator<Map.Entry<String, Integer>>() {
            //比較関数
            @Override
            public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
            //return o1.getValue().compareTo(o2.getValue());    //昇順
            return o2.getValue().compareTo(o1.getValue());    //降順
            }
        });
    	for (Entry<String, Integer> e : entries){
		    if (isAcceptableTrack(X1, Y1, e.getKey(), map)){
		        headChar = e.getKey().charAt(0);
		        break;
		    }
		}
		ret = mkAnswerFormat(headChar);
		return ret;
	}
}
