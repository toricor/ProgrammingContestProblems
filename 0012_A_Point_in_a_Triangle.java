import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            double x1 = sc.nextDouble();
            double y1 = sc.nextDouble();
            double x2 = sc.nextDouble();
            double y2 = sc.nextDouble();
            double x3 = sc.nextDouble();
            double y3 = sc.nextDouble();
            double xp = sc.nextDouble();
            double yp = sc.nextDouble();
            
            double c1 = (x2-x1) * (yp-y2) - (y2-y1) * (xp-x2);
            double c2 = (x3-x2) * (yp-y3) - (y3-y2) * (xp-x3);
            double c3 = (x1-x3) * (yp-y1) - (y1-y3) * (xp-x1);
    
            if ((c1 > 0&& c2 > 0 && c3 > 0)||(c1 < 0 && c2 < 0 && c3 < 0)){
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }
        }
    }
}
