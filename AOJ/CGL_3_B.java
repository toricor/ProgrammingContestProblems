import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.ArrayList;

public class Main {
    public static double cross(double x1, double y1, double x2, double y2) {
        return x1 * y2 - x2 * y1;
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ArrayList<String[]> points = new ArrayList<String[]>();
        for (int i = 0; i < n; i++){
            String[] s = br.readLine().split(" ");
            points.add(s);
        }
        ArrayList<double[]> edges = new ArrayList<double[]>();
        for (int i = 0; i < n - 1; i++){
            double xi = Double.parseDouble(points.get(i)[0]);
            double yi = Double.parseDouble(points.get(i)[1]);
            double xi1 = Double.parseDouble(points.get(i+1)[0]);
            double yi1 = Double.parseDouble(points.get(i+1)[1]);
            double[] vector = new double[2];
            vector[0] = xi1 - xi;
            vector[1] = yi1 - yi;
            edges.add(vector);
        }
        // i == n -1
        double xn = Double.parseDouble(points.get(n-1)[0]);
        double yn = Double.parseDouble(points.get(n-1)[1]);
        double xn1 = Double.parseDouble(points.get(0)[0]);
        double yn1 = Double.parseDouble(points.get(0)[1]);
        double[] vector = new double[2];
        vector[0] = xn1 - xn;
        vector[1] = yn1 - yn;
        edges.add(vector);
        
        boolean flag = true;
        for (int i = 0; i < n - 1; i++){
            if (cross(edges.get(i)[0], edges.get(i)[1], edges.get(i+1)[0],edges.get(i+1)[1]) < 0){
                System.out.println(0);
                flag = false;
                break;
            }
        }
        if (flag){
            System.out.println(1);
        }
    }
}
