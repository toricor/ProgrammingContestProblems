import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Solution {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt(); // Number of elements which make up the association table.
        int Q = in.nextInt(); // Number Q of file names to be analyzed.
        Map<String, String> mp = new HashMap<String, String>();
        for (int i = 0; i < N; i++) {
            String EXT = in.next().toLowerCase(); // file extension
            String MT = in.next(); // MIME type.
            in.nextLine();
            mp.put(EXT, MT);
        }
        for (int i = 0; i < Q; i++) {
            String FNAME = in.nextLine(); // One file name per line.
            
            if (!FNAME.contains(".")){
                System.out.println("UNKNOWN");
                continue;
            }
            if (FNAME.charAt(FNAME.length() - 1) == '.'){
                System.out.println("UNKNOWN");
                continue;
            }
            String[] FNameSplited = FNAME.split("\\.");
            String FNAME_EXT = FNameSplited[FNameSplited.length - 1].toLowerCase();
            if (mp.containsKey(FNAME_EXT)){
                System.out.println(mp.get(FNAME_EXT));
            }else{
                System.out.println("UNKNOWN");
            }
        }

        // Write an action using System.out.println()
        // To debug: System.err.println("Debug messages...");

        //System.out.println("UNKNOWN"); // For each of the Q filenames, display on a line the corresponding MIME type. If there is no corresponding type, then display UNKNOWN.
    }
}
