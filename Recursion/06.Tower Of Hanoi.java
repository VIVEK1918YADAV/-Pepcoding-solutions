import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        
        int n = scn.nextInt();
        int srcTower = scn.nextInt();
        int destTower = scn.nextInt(); 
        int auxTower = scn.nextInt();

        toh(n, srcTower, destTower, auxTower);  
    }

    public static void toh(int n, int srcTower, int destTower, int auxTower){
        if(n == 0 ) {
           return;
        }

        toh(n-1, srcTower, auxTower, destTower);  // n-1 disk from src to aux using dest

        System.out.println(n + "[" + srcTower + " -> " + destTower + "]");   //move nth disk form src to dest using aux

        toh(n-1, auxTower, destTower, srcTower);  // n-1 disk from aux to dest using src
        
    }

}
