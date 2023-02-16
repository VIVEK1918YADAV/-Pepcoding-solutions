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

  public static boolean find(Node node, int data){
    if(node == null) return false;
    
    // return (node.data == data) ? true : (find(node.left, data) || (find(node.right, data))
    
    if(node.data == data) return true;
    
    boolean lres = find(node.left, data);
    if(lres == true) return true;
    
    boolean rres = find(node.right, data);
    if(rres == true) return true;
    
    return false;
    
  }

  public static ArrayList<Integer> nodeToRootPath(Node node, int data){
    
    //-ve base case
    if(node == null) return new ArrayList<>();
    //+ve base case 
    if(node.data == data){
        ArrayList<Integer> list = new ArrayList<>();
        list.add(node.data);
        return list;
    }
    ArrayList<Integer> lres = nodeToRootPath(node.left, data);
    if(lres.size() > 0){
        lres.add(node.data);
        return lres;
    }
    
    ArrayList<Integer> rres = nodeToRootPath(node.right, data);
    if(rres.size() > 0){
        rres.add(node.data);
        return rres;
    }
    
    return new ArrayList<>();
  }
  
  //   // Approach -> 2  =>  root to leaf
//   public static boolean nodeToRootPath(Node node, int data, ArrayList<Integer> curr){
//       //-ve base case
//       if(node == null) return false;
      
//       //+ve base case
//       if(node.data == data){
//           curr.add(node.data);
//           return true;
//       }
      
//       curr.add(node.data);
//       boolean left = nodeToRootPath(node.left,data, curr);
//       if(left == true) return true;
      
//       boolean right = nodeToRootPath(node.right,data, curr);
//       if(right == true) return true;
      
//       curr.remove(curr.size()-1);
//       return false;
//   }


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

    int data = Integer.parseInt(br.readLine());

    Node root = construct(arr);
    boolean found = find(root, data);
    System.out.println(found);

    ArrayList<Integer> path = nodeToRootPath(root, data);
    System.out.println(path);
    
//     ArrayList<Integer> path2 = new ArrayList<>();
//     nodeToRootPath(root, data, path2);
//     System.out.println(path2);
  }

}
