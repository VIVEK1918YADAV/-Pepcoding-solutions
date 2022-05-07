import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        
   Scanner scn = new Scanner(System.in);
   int n = scn.nextInt();
   printStairPaths(n , "");

    }

    public static void printStairPaths(int n, String path) {
        // Positive base case
        if(n == 0 ) {
            System.out.println(path);
            return;
        }
        // Negative base case
        if(n<0)
        return;
        
        //Recursive call
        printStairPaths(n-1, path + "1");
                printStairPaths(n-2, path + "2");
                        printStairPaths(n-3, path + "3");
    }

}
