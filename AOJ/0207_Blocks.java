import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static int[][] board;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true){
            String[] line0 = br.readLine().split(" ");
            int w = Integer.parseInt(line0[0]);
            int h = Integer.parseInt(line0[1]);
            if (w == 0 && h == 0){
                break;
            }
            String[] line1 = br.readLine().split(" ");
            String[] line2 = br.readLine().split(" ");
            int xs = Integer.parseInt(line1[0]);
            int ys = Integer.parseInt(line1[1]);
            int xg = Integer.parseInt(line2[0]);
            int yg = Integer.parseInt(line2[1]);
            int n = Integer.parseInt(br.readLine());
            board = new int[h][w];
            for (int i = 0; i < n; i++){
                String[] linei = br.readLine().split(" ");
                int c = Integer.parseInt(linei[0]);
                int d = Integer.parseInt(linei[1]);
                int x = Integer.parseInt(linei[2]);
                int y = Integer.parseInt(linei[3]);
                setBlock(c, d, x, y, w, h);
            }
            //System.out.println(Arrays.deepToString(board));
            if (dfs(xs, ys, xg, yg, w, h)){
                System.out.println("OK");
            }else{
                System.out.println("NG");
            }
        }
    }
    static void setBlock(int c, int d, int x, int y, int w, int h){
        // add an block to the static board
        if (d == 0){
            for (int i = y - 1; i < y + 1; i++){
                for (int j = x - 1; j < x + 3; j++){
                    board[i][j] = c;
                }
            }
        }else{ // d == 1
            for (int i = y - 1; i < y + 3; i++){
                for (int j = x - 1; j < x + 1; j++){
                    board[i][j] = c;
                }
            }
        }
        //System.out.println(Arrays.deepToString(board));
    }
    static boolean dfs(int xs, int ys, int xg, int yg, int w, int h){
        // dfs (xs, ys) to (xg, yg)
        boolean[][] visited = new boolean[h][w];
        List<Integer> ls = new ArrayList<Integer>(2);
        ls.add(xs);
        ls.add(ys);
        visited[ys-1][xs-1] = true;
        int color = board[ys-1][xs-1];
        List<List<Integer>> stack = new ArrayList<List<Integer>>();
        stack.add(ls);
        
        while (stack.size() > 0){
            
            List<Integer> tls = stack.remove(stack.size()-1);
            
            int txs = tls.get(0);
            int tys = tls.get(1);
            int tcolor = board[tys - 1][txs - 1];
            int[][] nextcells = {{txs + 1, tys}, {txs - 1, tys}, {txs, tys + 1}, {txs, tys - 1}};
            for (int i = 0; i < 4; i++){
                int nextx = nextcells[i][0];
                int nexty = nextcells[i][1];
                //System.out.println(nextx + " " + nexty);
                
                if (1 <= nextx && nextx <= w && 1 <= nexty && nexty <= h && !visited[nexty-1][nextx-1]){
                    int nextcolor = board[nexty-1][nextx-1];
                    visited[nexty -1 ][nextx -1] = true;
                    if (tcolor == nextcolor){
                        if (nextx == xg && nexty == yg){
                            return true;
                        }
                        List<Integer> nextls = new ArrayList<Integer>();
                        nextls.add(nextx);
                        nextls.add(nexty);
                        stack.add(nextls);
                        
                    }
                }
            }
        }
		return false;
    }
}
