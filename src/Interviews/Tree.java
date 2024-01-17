package Interviews;

import  java.util.*;
// Inorder Traversal-

class TreeNode{

    int data;
    TreeNode left=null;
    TreeNode right=null;

    TreeNode(int d){
        data=d;
    }


}

public class Tree{


    public static void display(TreeNode root){

        if(root==null) return;


        if(root.left!=null) display(root.left);

        System.out.println(root.data);
        if(root.right!=null) display(root.right);

    }
    public static TreeNode CreateTree(){


        System.out.println("Enter the RootData");
        Scanner sc = new Scanner(System.in);

        int rootData = sc.nextInt();
        TreeNode root = new TreeNode(rootData);

        Queue<TreeNode>q=new LinkedList<>();

        q.add(root);

        while(!q.isEmpty()){

            TreeNode front = q.poll();
            int data = front.data;


            System.out.println("Enter the left child of TreeNode" + data);

            int leftData = sc.nextInt();

            if(leftData!=-1){
                TreeNode leftChild = new TreeNode(leftData);
                q.add(leftChild);
                front.left = leftChild;
            }
            System.out.println("Enter the Right child of TreeNode" + data);

            int RightData = sc.nextInt();

            if(RightData!=-1){
                TreeNode RightChild = new TreeNode(RightData);
                q.add(RightChild);
                front.right = RightChild;
            }

        }

        return root;

    }


    public static void main(String[]args){

        TreeNode root = CreateTree();

        display(root);

    }

}