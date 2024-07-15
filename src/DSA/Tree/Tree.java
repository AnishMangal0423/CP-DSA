package DSA.Tree;

import java.util.*;

class TreeNode{

    public int data;
    public TreeNode left=null;
    public TreeNode right=null;

    TreeNode(int d){

        data = d;
    }

}

public class Tree{

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

    public static TreeNode CreateTree(){

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the RootData");
        int rootData = sc.nextInt();
        TreeNode root = new TreeNode(rootData);

        Queue<TreeNode>q=new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()){

            TreeNode front = q.poll();

            int data = front.data;


            System.out.println("Enter the left data of node "+ data);
            int leftData = sc.nextInt();
            if(leftData!=-1){

                TreeNode left = new TreeNode(leftData);
                front.left = left;
                q.add(left);
            }


            System.out.println("Enter the Right data of node "+ data);
            int rightData = sc.nextInt();
            if(rightData!=-1){

                TreeNode right = new TreeNode(rightData);
                front.right=right;
                q.add(right);
            }

        }

        return root;
    }

    public static void main(String[]args){

        TreeNode root = CreateTree();
        Display(root);

    }
}