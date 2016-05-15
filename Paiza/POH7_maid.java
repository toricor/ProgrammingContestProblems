import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++){
            int overtime = Integer.parseInt(br.readLine());
            System.out.println(getWhenSleep(overtime));
        }
    }
    public static String getWhenSleep(int overtime) {
        int requiredSleepTime = overtime / 3;
        StringBuilder sb = new StringBuilder();
        if (requiredSleepTime == 0){// 残業ﾅｼの場合
            return "01:00";
        }
        if (requiredSleepTime <= 60){// 就寝が0:00-1:00の間の場合
            int minute = 60 - requiredSleepTime;
            sb.append("00:");
            sb.append(zfill("" + minute));
        }else{ // 就寝が24:00より前になる場合
            int hour = 24 - requiredSleepTime/60;
            int minute = 60 - requiredSleepTime%60;
            if (minute == 60){
                hour += 1;
                minute = 0;
            }
            sb.append(hour);
            sb.append(":");
            sb.append(zfill("" + minute));
        }
        return sb.toString();
    }
    public static String zfill(String st){
        if (st.length() == 2){
            return st;
        }else{
            StringBuilder sb = new StringBuilder();
            sb.append("0");
            sb.append(st);
            return sb.toString();
        }
    }
}
