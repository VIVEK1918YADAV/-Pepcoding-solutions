import java.io.*;
import java.util.*;

public class Main {
  private static class Node {
    int data;
    ArrayList<Node> children;

    Node(int data){
      this.data = data;
      this.children = new ArrayList<>();
    }

    Node(){
      this.data = 0;
      this.children = new ArrayList<>();
    }
  }

  public static void print(Node root){
    System.out.print(root.data + " -> ");

    for(Node child : root.children){
      System.out.print(child.data + ", ");
    }
    System.out.println(".");
  }

  public static void display(Node root) {
    if(root == null) return ;
    //Meeting Expectation 
    print(root);
    
    //Faith
    for(Node child : root.children){
      display(child);
    }
  }

  public static Node construct(int[] arr) {
    Node root = null;

    Stack<Node> st = new Stack<>();
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] != -1) {
       Node child = new Node(arr[i]);

       if(st.isEmpty()){
         root = child;
       }
       else {
         Node parent = st.peek();
         parent.children.add(child);
       }
       st.push(child);
      }
      else{
        st.pop();
      }
    }

    return root;
  }

  public static int size(Node root){
    if(root == null)
    return 0;
    int count  = 1;
    for(Node child : root.children){
      count += size(child);
    }
    return count;
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[] arr = new int[n];
    String[] values = br.readLine().split(" ");
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(values[i]);
    }

    Node root = construct(arr);
    int sz = size(root);
    System.out.println(sz);
    // display(root);
  }

}
