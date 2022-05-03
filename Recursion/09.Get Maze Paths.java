import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int rows = scn.nextInt();
         int cols = scn.nextInt();
         
         ArrayList<String> res = getMazePaths(0, 0, rows-1, cols-1);
         System.out.println(res);

    }

    // sr - source row
    // sc - source column
    // dr - destination row
    // dc - destination column
    public static ArrayList<String> getMazePaths(int sr, int sc, int dr, int dc) {
        if(sr > dr || sc>dc) {
                    //negative base case
           ArrayList<String> base = new ArrayList<>();
 
           return base;  
        }
        
        if(sr == dr && sc == dc) {
           //positive base case
           ArrayList<String> base = new ArrayList<>();
           base.add("");
           return base;
        }
        
        ArrayList<String> res = new ArrayList<>();
        
        ArrayList<String> rightPaths = getMazePaths(sr, sc+1, dr, dc);
        for(String str: rightPaths) {
            res.add('h' + str);
        }
        
                ArrayList<String> downPaths = getMazePaths(sr+1, sc, dr, dc);
        for(String str: downPaths) {
            res.add('v' + str);
        }
        
        return res;
    }

}
