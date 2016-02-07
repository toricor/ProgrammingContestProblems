import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
//TLE
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] points = new int[n][2];
        for (int i = 0; i < n; i++){
            String[] line = br.readLine().split(" ");
            points[i][0] = Integer.parseInt(line[0]);
            points[i][1] = Integer.parseInt(line[1]);
        }
        int eikaku = 0;
        int chokaku = 0;
        int donkaku = 0;
        for (int i = 0; i < n - 2; i++){
            for (int j = i + 1; j < n - 1; j++){
                for (int k = j + 1; k < n; k++){
                    switch (getTriangleType(points[i], points[j], points[k])){
                        case 1:
                            eikaku++;
                            break;
                        case 0:
                            chokaku++;
                            break;
                        case -1:
                            donkaku++;
                            break;
                    }
                }
            }
        }
        System.out.println(String.format("%s %s %s", eikaku, chokaku, donkaku));
    }
    private static int getTriangleType(int[] p1, int[] p2, int[] p3){
        int p1p2 = (p2[0] - p1[0]) * (p2[0] - p1[0]) + (p2[1] - p1[1]) * (p2[1] - p1[1]);
        int p2p3 = (p3[0] - p2[0]) * (p3[0] - p2[0]) + (p3[1] - p2[1]) * (p3[1] - p2[1]);
        int p3p1 = (p1[0] - p3[0]) * (p1[0] - p3[0]) + (p1[1] - p3[1]) * (p1[1] - p3[1]);
        int maxVert = Math.max(p1p2, Math.max(p2p3, p3p1));
        
        int largestAnglePoint = 0;
        if (maxVert == p1p2){
            largestAnglePoint = 3;
        }else if (maxVert == p2p3){
            largestAnglePoint = 1;
        }else{
            largestAnglePoint = 2;
        }
        
        int checkVal = 0;
        switch (largestAnglePoint){
            case 1:
                checkVal = p1p2 + p3p1 - p2p3;
                break;
            case 2:
                checkVal = p1p2 + p2p3 - p3p1;
                break;
            case 3:
                checkVal = p3p1 + p2p3 - p1p2;
                break;
        }
        return checkCos(checkVal);
    }
    private static int checkCos(int checkVal){    
        if (checkVal > 0){
            return 1;
        }else if (checkVal == 0){
            return 0;
        }else{
            return -1;
        }
    }
}
