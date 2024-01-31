package DSA.Tree;

import java.awt.*;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 *
 * TC - O(N) --> Considering that hashmap will have O(1) time Complexity.
 * SC - O(2N) --> Stack and HashMap space.
 * **/

public class Create_Tree_from_Preorder_and_Inorder{

    public static void Display(TreeNode root){

        // Level Order Printing -
        if(root==null) return;

        Queue<TreeNode> q=new LinkedList<>();
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
    public static TreeNode Build_Recursion(int[]preorder, int preS, int preE, HashMap<Integer, Integer>map,
                                           int[]inorder, int inS, int inE){

        if(preS > preE || inS > inE)return null;

        TreeNode root = new TreeNode(preorder[preS]);

        int Root_index_inorder = map.get(preorder[preS]);
        int No_Elements = Root_index_inorder - inS;


        root.left = Build_Recursion(preorder, preS+1, preS+No_Elements, map,
                                   inorder , inS , Root_index_inorder-1);

        root.right = Build_Recursion(preorder, preS+No_Elements+1, preE, map,
                                     inorder , Root_index_inorder+1 , inE);

        return root;
    }
    public static TreeNode BuildTree(int[]preorder, int[]inorder){

        int n=preorder.length;
        HashMap<Integer, Integer>map=new HashMap<>();

        for(int i=0; i<inorder.length; i++)map.put(inorder[i],i);

        return Build_Recursion(preorder, 0, n-1, map, inorder, 0, n-1);
    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n=sc.nextInt();

        int[]preorder=new int[n];
        int[]inorder=new int[n];

        for(int i=0; i<n; i++)preorder[i]=sc.nextInt();
        for(int j=0; j<n; j++)inorder[j]=sc.nextInt();

        TreeNode root = BuildTree(preorder, inorder);
        System.out.print("Level order Traversal of Made Tree : ");
        Display(root);
    }
}
