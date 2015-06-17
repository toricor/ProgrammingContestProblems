import java.io.IOException;
import java.util.Scanner;

public class Main {
    static double cross(double x1, double x2, double y1, double y2, double xp, double yp){
        return (x2-x1) * (yp-y2) - (y2-y1) * (xp-x2);
    }
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            final double x1 = sc.nextDouble();
            final double y1 = sc.nextDouble();
            final double x2 = sc.nextDouble();
            final double y2 = sc.nextDouble();
            final double x3 = sc.nextDouble();
            final double y3 = sc.nextDouble();
            final double xp = sc.nextDouble();
            final double yp = sc.nextDouble();
            
            double c1 = cross(x1, x2, y1, y2, xp, yp);
            double c2 = cross(x2, x3, y2, y3, xp, yp);
            double c3 = cross(x3, x1, y3, y1, xp, yp);

            if ((c1 > 0 && c2 > 0 && c3 > 0)||(c1 < 0 && c2 < 0 && c3 < 0)){
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }
        }
    }
}
