import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Cup cup = new Cup(0, 0);
        for (int i = 0; i < n; i++){
            String[] st = br.readLine().split(" ");
            int order = Integer.parseInt(st[0]);
            int weight = Integer.parseInt(st[1]);
            switch (order) {
                case 1: //add water
                    cup.water += weight;
                    break;
                case 2: //add coffee
                    cup.coffee += weight;
                    break;
                case 3: //sampling coffee
                    cup.sample(weight);
                    break;
            }
        }
        System.out.println((int)Math.floor(cup.conc()));
    }
}
class Cup implements MyCupInterface {
    double water;
    double coffee;
    
    Cup(int water, int coffee){
        this.water = water;
        this.coffee = coffee;
    }
    @Override
    public void sample(int weight){
        double w = (double)weight;
        this.water = this.water - w * (this.water / (this.water + this.coffee));
        this.coffee = this.coffee - w * (this.coffee / (this.water + this.coffee));
    }
    @Override
    public void sample(double weight){
        double w = weight;
        this.water = this.water - w * (this.water / (this.water + this.coffee));
        this.coffee = this.coffee - w * (this.coffee / (this.water + this.coffee));
    }
    @Override
    public double conc(){
        return 100 * (this.coffee / (this.water + this.coffee));
    } 
}
interface MyCupInterface{
    void sample(int weight);
    void sample(double weight);
    double conc();
}


