import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Cup cup = new Cup(new BigDecimal("0"), new BigDecimal("0"));
        for (int i = 0; i < n; i++){
            String[] st = br.readLine().split(" ");
            int order = Integer.parseInt(st[0]);
            BigDecimal weight = new BigDecimal(st[1]);
            //System.out.println(weight + " " + cup.water + " " + cup.coffee);
            switch (order) {
                case 1: //add water
                    cup.water = cup.water.add(weight);
                    break;
                case 2: //add coffee
                    cup.coffee = cup.coffee.add(weight);
                    break;
                case 3: //sampling coffee
                    cup.sample(weight);
                    break;
            }
        }
        System.out.println(cup.conc().setScale(0, BigDecimal.ROUND_DOWN).intValue());
    }
}
class Cup implements MyCupInterface {
    BigDecimal water;
    BigDecimal coffee;
    
    Cup(BigDecimal water, BigDecimal coffee){
        this.water = water;
        this.coffee = coffee;
    }
    @Override
    public void sample(BigDecimal weight){
        BigDecimal water = new BigDecimal(this.water.toString());
        BigDecimal coffee = new BigDecimal(this.coffee.toString());
        BigDecimal total = water.add(coffee);
        BigDecimal water_ratio = water.divide(total, 12, BigDecimal.ROUND_HALF_UP);
        BigDecimal coffee_ratio = coffee.divide(total, 12, BigDecimal.ROUND_HALF_UP);
        this.water = water.subtract(weight.multiply(water_ratio));
        this.coffee = coffee.subtract(weight.multiply(coffee_ratio));
    }
    
    @Override
    public BigDecimal conc(){
        BigDecimal water = new BigDecimal(this.water.toString());
        BigDecimal coffee = new BigDecimal(this.coffee.toString());
        BigDecimal total = water.add(coffee);
        return coffee.divide(total, 12, BigDecimal.ROUND_HALF_UP).multiply(new BigDecimal(100));
    } 
}
interface MyCupInterface{
    void sample(BigDecimal weight);
    BigDecimal conc();
}
