import java.io.*;
import java.util.*;

public class Main {
  public static class Node {
    int data;
    Node left;
    Node right;

    Node(int data, Node left, Node right) {
      this.data = data;
      this.left = left;
      this.right = right;
    }
  }

  public static class Pair {
    Node node;
    int state;

    Pair(Node node, int state) {
      this.node = node;
      this.state = state;
    }
  }

  public static Node construct(Integer[] arr) {
    Node root = new Node(arr[0], null, null);
    Pair rtp = new Pair(root, 1);

    Stack<Pair> st = new Stack<>();
    st.push(rtp);

    int idx = 0;
    while (st.size() > 0) {
      Pair top = st.peek();
      if (top.state == 1) {
        idx++;
        if (arr[idx] != null) {
          top.node.left = new Node(arr[idx], null, null);
          Pair lp = new Pair(top.node.left, 1);
          st.push(lp);
        } else {
          top.node.left = null;
        }

        top.state++;
      } else if (top.state == 2) {
        idx++;
        if (arr[idx] != null) {
          top.node.right = new Node(arr[idx], null, null);
          Pair rp = new Pair(top.node.right, 1);
          st.push(rp);
        } else {
          top.node.right = null;
        }

        top.state++;
      } else {
        st.pop();
      }
    }

    return root;
  }

  public static void display(Node node) {
    if (node == null) {
      return;
    }

    String str = "";
    str += node.left == null ? "." : node.left.data + "";
    str += " <- " + node.data + " -> ";
    str += node.right == null ? "." : node.right.data + "";
    System.out.println(str);

    display(node.left);
    display(node.right);
  }

  public static int height(Node node) {
    if (node == null) {
      return -1;
    }

    int lh = height(node.left);
    int rh = height(node.right);

    int th = Math.max(lh, rh) + 1;
    return th;
  }

  
    //Brute force
   // we are returning diameter
  // o(n^2) solution
  public static int diameter1(Node node) {
      if(node == null) return 0;
      
      int lDia = diameter1(node.left);
      int rDia = diameter1(node.right);
      
      // meeting expectation
      int lh = height(node.left);
      int rh = height(node.right);
      int dia = lh + rh + 2;
      
      return Math.max(dia, Math.max(lDia, rDia));
  }
  
  static int maxDiameter = 0;
  // we are returning height, but calculating diameter
  // global variable (travel & change) strategy
  public static int diameter2(Node node){
    if (node == null) {
      return -1;
    }

    int lh = diameter2(node.left);
    int rh = diameter2(node.right);

    int dia = lh + rh + 2;
    maxDiameter = Math.max(maxDiameter, dia);

    return Math.max(lh, rh) + 1;
  }
  
  
  public static class diaPair{
    int height;
    int diameter;
    
    public diaPair(){
        height = -1;
        diameter = 0;
    }
  }
  
  // Return both diameter & height
  public static diaPair diameter3(Node node){
      if(node == null)
          return new diaPair();
          
      diaPair l = diameter3(node.left);
      diaPair r = diameter3(node.right);
      
      diaPair curr = new diaPair();
      curr.height = Math.max(l.height, r.height) + 1;
      
      int dia = l.height + r.height + 2;
      curr.diameter = Math.max(dia, Math.max(l.diameter, r.diameter));
      
      return curr;
  }

  

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    Integer[] arr = new Integer[n];
    String[] values = br.readLine().split(" ");
    for (int i = 0; i < n; i++) {
      if (values[i].equals("n") == false) {
        arr[i] = Integer.parseInt(values[i]);
      } else {
        arr[i] = null;
      }
    }

    Node root = construct(arr);

    int diameter = 0;
    
    
    
    // System.out.println(diameter1(root));
    
    // diameter2(root);
    // System.out.println(maxDiameter);
    
    diaPair ans = diameter3(root);
    System.out.println(ans.diameter);
  }

}
