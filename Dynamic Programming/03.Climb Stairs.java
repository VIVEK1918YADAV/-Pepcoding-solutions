import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        //int cp = countPaths(n);
        //int cp = countPaths(n, new int[n+1]);
        int cp = countPathsTab(n);
        System.out.println(cp);
    }
    // public static int countPaths(int n){
    //     //Recursive
    //     if(n == 0) return 1;
    //     if(n < 0) return 0;
        
    //     int nm1 = countPaths(n-1);
    //     int nm2 = countPaths(n-2);
    //     int nm3 = countPaths(n-3);
    //     int cp = nm1 + nm2 + nm3;
        
    //     return cp;
    // }
    
    // public static int countPaths(int n, int[] qb){
    //     //Memoization
    //     if(n == 0) return 1;
    //     if(n < 0) return 0;
        
    //     if(qb[n] > 0) return qb[n];
        
    //     int nm1 = countPaths(n-1, qb);
    //     int nm2 = countPaths(n-2, qb);
    //     int nm3 = countPaths(n-3, qb);
    //     int cp = nm1 + nm2 + nm3;
    //     qb[n] = cp;
    //     return cp;
    // }
    
    public static int countPathsTab(int n){
        int[] dp = new int[n+1];
        dp[0] = 1;
        
        for(int i=1; i<=n; i++){
            
            if(i == 1){
                dp[i] = dp[i-1];
            }
            
            else if(i == 2){
                dp[i] = dp[i-1] + dp[i-1];
            }
            
            else {
                dp[i] = dp[i-1] + dp[i-2]+ dp[i-3];
            }
        }
        
        return dp[n]
    }

}
