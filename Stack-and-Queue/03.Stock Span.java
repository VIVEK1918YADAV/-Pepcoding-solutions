import java.io.*;
import java.util.*;

public class Main{
  public static void display(int[] a){
    StringBuilder sb = new StringBuilder();

    for(int val: a){
      sb.append(val + "\n");
    }
    System.out.println(sb);
  }

public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    int[] a = new int[n];
    for(int i = 0; i < n; i++){
       a[i] = Integer.parseInt(br.readLine());
    }

    int[] span = solve(a);
    display(span);
 }
 
 
   public static int[] solve(int[] arr){
   int[] stock = new int[arr.length];
   Arrays.fill(stock, -1);
   
   Stack<Integer> stk = new Stack<>();
   
   for(int i=0; i<arr.length; i++){
       while(stk.size() > 0 && arr[i] >= arr[stk.peek()]) {
           stk.pop();
       }
        
        if(stk.size() >0)
       stock[i] = (i - stk.peek());
         
      else stock[i] = (i+1);
       stk.push(i);
   }
   return stock;
 }

}
