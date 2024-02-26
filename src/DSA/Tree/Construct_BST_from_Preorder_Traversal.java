package DSA.Tree;

import java.awt.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 *
 * Concept :- Managing Indexes and Forming The tree From Array.
 * Learning :- Not So , Much this is the Same Concept Based Question that Requires the Knowledge of How to pass the indexes in
 *             the Recursive Tree's and Creating the Bonds.
 *
 * Time Complexity :- O(N) --> Size of array.
 * Space Complexity :- O(H) --> Height of Tree that is stack space. $ Aauxilary.
 *
 * **/
public class Construct_BST_from_Preorder_Traversal {

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



    public static TreeNode Create_BST(int[]preorder , int ls , int re){

        if(ls > re)return null;
        TreeNode root = new TreeNode(preorder[ls]);

        // Now we are finding the Left elements -
        int i = ls+1;
        while (i<=re) {

            if (preorder[i] < preorder[ls]) {
                i++;
            }
            else break;
        }
        root.left = Create_BST(preorder , ls+1, i-1);

        // Now we are Going to Right index Elements -

        root.right = Create_BST(preorder , i , re);


        return root;
    }


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[]preorder = new int[n];
        for(int i=0; i<n; i++)preorder[i]=sc.nextInt();

        TreeNode root = Create_BST(preorder , 0, n-1);

        Display(root);
    }
}
