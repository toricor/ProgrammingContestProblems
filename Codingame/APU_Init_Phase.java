import java.util.*;
import java.io.*;
//AC
/**
 * Don't let the machines win. You are humanity's last hope...
 **/
class Player {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int width = in.nextInt(); // the number of cells on the X axis
        int height = in.nextInt(); // the number of cells on the Y axis
        in.nextLine();
        List<String> strings = new ArrayList<String>();
        for (int i = 0; i < height; i++) {
            String line = in.nextLine(); // width characters, each either 0 or .
            strings.add(line);
        }
        for (int h = 0; h < height; h++){
            for (int w = 0; w < width; w++){
                StringBuilder result = new StringBuilder();
                String tline = strings.get(h);
                char node = tline.charAt(w);
                if (node == '0'){
                    result.append(w + " " + h + " ");
                    // calculate the next Right Node 
                    int nextRightNodePos = getNextRightNodePos(tline, w);
                    if (nextRightNodePos >= 0){
                        result.append(nextRightNodePos + " " + h + " ");
                    }else{
                        result.append(-1 + " " + -1 + " ");
                    }
                    // culculate the next Bottom Node
                    int nextBottomNodePos = getNextBottomNodePos(strings, h, w);
                    if (nextBottomNodePos >= 0){
                        result.append(w + " " + nextBottomNodePos);
                    }else{
                        result.append(-1 + " " + -1);
                    }
                    System.out.println(result.toString());
                }
            }
        }
    }
    static int getNextBottomNodePos(List<String> strings, int currentRow, int index){
        int pointer = currentRow + 1;
        if (pointer >= strings.size()){
            return -1;
        }
        while (pointer < strings.size() && strings.get(pointer).charAt(index) != '0'){
            if (strings.get(pointer).charAt(index) == '0'){
                break;
            }
            pointer++;
        }
        return pointer;
    }
    
    static int getNextRightNodePos(String line, int currentPos){
        int pointer = currentPos + 1;
        if (pointer >= line.length()){
            return -1;
        }
        while (pointer < line.length() && line.charAt(pointer) != '0'){
            if (line.charAt(pointer) == '0'){
                break;
            }
            pointer++;
        }
        return pointer;
    }
}
