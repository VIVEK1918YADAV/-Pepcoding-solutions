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

    int[] nge = solve(a);
    display(nge);
 }


//APPROACH 1


//  public static int[] solve(int[] arr){
//   int[] nge = new int[arr.length];
//   Arrays.fill(nge, -1);
   
//   Stack<Integer> stk = new Stack<>();
   
//   for(int i=0; i<arr.length; i++){
//       while(stk.size() > 0 && arr[stk.peek()] <
//       arr[i]) {
//          nge[stk.pop()] = arr[i];
         
//       }
//       stk.push(i);
//   }
//   return nge;
//  }
 
 
 //APPROACH 2
 
  public static int[] solve(int[] arr){
   int[] nge = new int[arr.length];
   Arrays.fill(nge, -1);
   
   Stack<Integer> stk = new Stack<>();
   
   for(int i=arr.length-1; i>=0; i--){
       while(stk.size() > 0 && arr[i] >= arr[stk.peek()]) {
           stk.pop();
       }
        
        if(stk.size() >0)
       nge[i] = arr[stk.peek()];
         
      
       stk.push(i);
   }
   return nge;
 }

}
