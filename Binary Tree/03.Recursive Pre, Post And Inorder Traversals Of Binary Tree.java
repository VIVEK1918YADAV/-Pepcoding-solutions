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
  
  public static void preorder(Node root){
      if(root == null) return;
      
      System.out.print(root.data + " ");
      preorder(root.left);
      preorder(root.right);
  }
  
  public static void inorder(Node root){
      if(root == null) return;
      
      inorder(root.left);
      System.out.print(root.data + " ");
      inorder(root.right);
  }
  
  public static void postorder(Node root){
      if(root == null) return;
      
      postorder(root.left);
      postorder(root.right);
      System.out.print(root.data + " ");
  }

  public static void iterativePrePostInTraversal(Node node) {
    
    Stack<Pair> st = new Stack<>();
    st.push(new Pair(node, -1));
    
    ArrayList<Integer> preorder = new ArrayList<>();
    ArrayList<Integer> inorder = new ArrayList<>();
    ArrayList<Integer> postorder = new ArrayList<>();
    
    while(!st.isEmpty()){
        Pair par = st.peek();
        
        if(par.state == -1){
            //preorder
            preorder.add(par.node.data);
            
            if(par.node.left != null){
                st.push(new Pair(par.node.left, -1));
            }
            par.state++;
        }
        else if(par.state == 0){
            //inorder
            inorder.add(par.node.data);
            
            if(par.node.right != null){
                st.push(new Pair(par.node.right, -1));
            }
            par.state++;
        }
        
        else if(par.state == 1){
            //postorder
            postorder.add(par.node.data);
            st.pop();
        }
    }
    
    for(Integer i : preorder) System.out.print(i + " ");
    System.out.println();
    for(Integer i : inorder) System.out.print(i + " ");
    System.out.println();
    for(Integer i : postorder) System.out.print(i + " ");
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
    //iterativePrePostInTraversal(root);
    
    //recursive
    preorder(root);
    System.out.println();
    
    inorder(root);
    System.out.println();
    
    postorder(root);
    System.out.println();
  }

}
