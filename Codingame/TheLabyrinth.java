import java.util.*;
import java.io.*;
import java.math.*;
// 87 % Accepted
class Player {
    public static String[] map;
    public static int R, C, A;
    public static int remainMove; // remainMoveCount, initial:1200
    
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        R = in.nextInt(); // number of rows.
        C = in.nextInt(); // number of columns.
        A = in.nextInt(); // number of rounds between the time the alarm countdown is activated and the time the alarm goes off.
        map = new String[R];
        remainMove = 1200;
        // game loop
        int sKR = 0;
        int sKC = 0;
        int gKR = -1;
        int gKC = -1;
		boolean gotCFlag = false;
		boolean foundCFlag = false;
        while (true) {
            int KR = in.nextInt(); // row where Kirk is located.
            int KC = in.nextInt(); // column where Kirk is located.
			//System.err.println("R: " + R + " C: " + C);
            if (remainMove == 1200){   // set start row and column.
                sKR = KR;
                sKC = KC;
            }
            if (KR == gKR && KC == gKC){ // reached at C 
                gotCFlag = true;
            }
			// read the new map
            for (int i = 0; i < R; i++) {
                String ROW = in.next(); // C of the characters in '#.TC?' (i.e. one line of the ASCII maze).
                map[i] = ROW;
                if (ROW.indexOf("C") != -1){
                    gKR = i;
                    gKC = ROW.indexOf("C");
					foundCFlag = true;
                }
            }
			//int bunkiCount = countBunki(KR, KC);
			System.err.println(Arrays.toString(map));
			//System.err.println("KR: " + KR + " KC: " + KC + " foundCFlag:" + foundCFlag + " gotCFlag:" + gotCFlag);
            String ans = "UP";
            if (gotCFlag){
                ans = bfs(KR, KC, sKR, sKC);
            }else if (foundCFlag){
                //?の数が全体の1/xになるまでは?を探す 
                int questionCount = countQuestion();
                int x = 6;
                if (questionCount > R * C / x ){
                    ans = getNearestQuestion(KR, KC);
                    if (ans.equals("ERROR")){
                        ans = bfs(KR, KC, gKR, gKC);
                    }
                }else{
                    ans = bfs(KR, KC, gKR, gKC);
                }
            }else{
                ans = getNearestQuestion(KR, KC);
            }
            System.out.println(ans); // Kirk's next move (UP DOWN LEFT or RIGHT).
            remainMove--;
        }
    }
    public static int countQuestion(){
        int count = 0;
        for (int r = 0; r < R; r++){
            for (int c = 0; c < C; c++){
                if (map[r].charAt(c) == '?'){
                    count++;
                }
            }
        }
        return count;
    }
    public static String bfs(int KR, int KC, int gKR, int gKC){
        // (KR, KC)の位置から(gKR, gKC)の位置まで最短経路を求める
		// goalに到達できない場合: 最も近いQuestionに移動する
        // bfs
        List<int[]> que = new ArrayList<int[]>();
        int initLabel = getInitLabel(KR, KC);
        int[] initialArr = {KR, KC, initLabel};
        boolean[][] visited = new boolean[R][C];
        que.add(initialArr);
        visited[KR][KC] = true;
        int cnt = 0;
        while (que.size() > 0){
            //System.err.println("bfsque: " + que);
            int[] head = que.remove(0);
            int r = head[0];
            int c = head[1];
            int label = head[2];
            int[][] nextCells;
            if (cnt == 0){
                int [][] tnextCells = {{r+1, c, 0}, {r-1, c, 1}, {r, c+1, 2}, {r, c-1, 3}}; //D, U, R, L
                nextCells = tnextCells;
            }else{
                int [][] tnextCells = {{r+1, c, label}, {r-1, c, label}, {r, c+1, label}, {r, c-1, label}};
                nextCells = tnextCells;
            }
            for (int i = 0; i < 4; i++){
                int nextR = nextCells[i][0];
                int nextC = nextCells[i][1];
                int nextLabel = nextCells[i][2];
                if (!(0 <= nextR && nextR < R && 0 <= nextC && nextC < C)){
                    continue;
                }
                if (nextR == gKR && nextC == gKC && map[nextR].charAt(nextC) != '#'){
                    return mkDirection(nextLabel);
                }
                if ((map[nextR].charAt(nextC) == '.' || map[nextR].charAt(nextC) == 'T') && !visited[nextR][nextC]){
                    que.add(nextCells[i]);
                    visited[nextR][nextC] = true;
                }
            }
            cnt++;
        }
        // goalに到達できない場合: 最も近いQuestionに移動する
        return getNearestQuestion(KR, KC);
    }
	private static String mkDirection(int label){
        String ret = "";
        switch(label){
            case 0:
                ret = "DOWN";
                break;
            case 1:
                ret =  "UP";
                break;
            case 2:
                ret =  "RIGHT";
                break;
            case 3:
                ret =  "LEFT";
                break;
        }
        return ret;
    }
    private static int getInitLabel(int KR, int KC){
        int r = KR;
        int c = KC;
        int [][] nextCells = {{r+1, c, 0}, {r-1, c, 1}, {r, c+1, 2}, {r, c-1, 3}}; //D, U, R, L
        for (int i = 0; i < 4; i++){
            int nextR = nextCells[i][0];
            int nextC = nextCells[i][1];
            int nextLabel = nextCells[i][2];
            if (!(0 <= nextR && nextR < R && 0 <= nextC && nextC < C)){
                continue;
            }
            if (map[nextR].charAt(nextC) == '.'){
                return nextLabel;
            }
        }
        return -1;
    }
    public static String getNearestQuestion(int KR, int KC){
        //最寄りの最初に見つけたハテナに向かう
		//?が必ずある(必ずある場合にしか呼ばれない）。
        //bfs
        List<int[]> que = new ArrayList<int[]>();
        //List<int[]> nearQuestionList = new ArrayList<int[]>();
        int initLabel = getInitLabel(KR, KC);
        //System.err.println(initLabel + " " + mkDirection(initLabel));
        int[] initialArr = {KR, KC, initLabel};
        boolean[][] visited = new boolean[R][C];
        que.add(initialArr);
        visited[KR][KC] = true;
        int cnt = 0;
        while (que.size() > 0){
            //System.err.println("questionQue: " + Arrays.toString(que.get(0)));
            int[] head = que.remove(0);
            int r = head[0];
            int c = head[1];
            int label = head[2];
            int[][] nextCells;
            if (cnt == 0){
                int [][] tnextCells = {{r+1, c, 0}, {r-1, c, 1}, {r, c+1, 2}, {r, c-1, 3}}; //D, U, R, L
                nextCells = tnextCells;
            }else{
                int [][] tnextCells = {{r+1, c, label}, {r-1, c, label}, {r, c+1, label}, {r, c-1, label}};
                nextCells = tnextCells;
            }
            for (int i = 0; i < 4; i++){
                int nextR = nextCells[i][0];
                int nextC = nextCells[i][1];
                int nextLabel = nextCells[i][2];
                //System.err.println("nextLabel:" + Arrays.deepToString(nextCells) + " " + head[2] + " " + label);
                if (!(0 <= nextR && nextR < R && 0 <= nextC && nextC < C)){
                    continue;
                }
                if (map[nextR].charAt(nextC) == '?'){
                    return mkDirection(nextLabel);
                }
                if ((map[nextR].charAt(nextC) == '.' || map[nextR].charAt(nextC) == 'T') && !visited[nextR][nextC]){
                    que.add(nextCells[i]);
                    visited[nextR][nextC] = true;
                }
            }
            cnt++;
        }
        return "ERROR";
    }
}
