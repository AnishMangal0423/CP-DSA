package DSA.Tree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 *
 *  TC - O(N)
 *  SC - O(N)
 *
 *
 * **/
public class Serialize_and_Deserialize_Binary_Tree{

    public static String Serialize(TreeNode root){

        StringBuilder sb = new StringBuilder();
        Queue<TreeNode>q=new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()){

            TreeNode front = q.poll();
            if(front == null)sb.append("#"+",");
            else sb.append(front.data+",");

            if(front!=null){

                q.add(front.left);
                q.add(front.right);
            }
        }

        return sb.toString();
    }


    public static TreeNode Deserialize(String serializedString){

        if(serializedString.charAt(0)=='#')return null;

        String []values = serializedString.split(",");
        Queue<TreeNode>q=new LinkedList<>();
      TreeNode root = new TreeNode(Integer.parseInt(values[0]));
      q.add(root);

        int i=0;

        while (!q.isEmpty()){

            TreeNode front = q.poll();

            if(!values[i+1].equals("#")){
                TreeNode left = new TreeNode(Integer.parseInt(values[i+1]));
                front.left=left;
                q.add(left);
            }

            if(!values[i+2].equals("#")){
                TreeNode right = new TreeNode(Integer.parseInt(values[i+2]));
                front.right=right;
                q.add(right);
            }

            i+=2;
        }
        return root;
    }

    public static void Display(TreeNode root){

        // Level Order Printing -
        if(root==null) return;

        Queue<TreeNode>q=new LinkedList<>();
        q.add(root);
        System.out.print("Root"+root.data+", ");

        while (!q.isEmpty()){

            TreeNode front = q.poll();
            int data = front.data;

            if(front.left!=null){
                q.add(front.left);
                System.out.print(data + "->L"+front.left.data+", ");
            }
            if(front.right!=null){
                q.add(front.right);
                System.out.print(data + "->R"+front.right.data+", ");
            }
        }

    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        TreeNode root = Tree.CreateTree();

        String serializedString = Serialize(root);
        TreeNode Deserialized_Root = Deserialize(serializedString);

        Display(Deserialized_Root);
    }
}
