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
  
   public static class isBSTPair{
      int max = Integer.MIN_VALUE;
      int min = Integer.MAX_VALUE;
      boolean isBST = true;
      int count = 0;
  }
  
  static int maxCount = 0;
  static Node largestBST = null;
  
  public static isBSTPair largestBST(Node root){
      if(root == null) return new isBSTPair();
      
      isBSTPair left = largestBST(root.left);
      isBSTPair right = largestBST(root.right);
      
      isBSTPair curr = new isBSTPair();
      curr.count = left.count + right.count + 1;
      
      if(left.max < root.data && root.data < right.min
          && left.isBST && right.isBST){
          curr.isBST = true;
          
          if(curr.count > maxCount){
            maxCount = curr.count;
            largestBST = root;
          }
          
      } else {
          curr.isBST = false;
      }
      
      curr.min = Math.min(root.data, Math.min(left.min, right.min));
      curr.max = Math.max(root.data, Math.max(left.max, right.max));
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
    
    // write your code here
    largestBST(root);
    System.out.println(largestBST.data+ "@" + maxCount);
  }

}
