import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        printIncreasing(n);
      
    }

    public static void printIncreasing(int n){

//base case
          if(n==0) {
            return;
        }

        //Faith 1,2,3...(n-1)
        printIncreasing(n-1);
        // Meet Expectation with Faith
        System.out.println(n);
        
    }

}
