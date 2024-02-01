package DSA.Tree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * NOTE - Point to be Noted , this Question is truely Based on Indexes so .. Always keep in Mind that we have to give
 *        Indexes from A fixed value for every Iteration.
 *
 *
 *   TC - O(N)
 *   SC - O(2N) --> stack, hashmap.
 * **/
public class Create_Tree_from_Postorder_and_Inorder{

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
    public static TreeNode Make_Tree(int[]inorder, int inS, int inE, HashMap<Integer, Integer>map,
                                     int[]postorder, int poS, int poE){

//[9,3,15,20,7], postorder = [9,15,7,20,3]
        if(inS > inE || poS > poE)return null;


        TreeNode root = new TreeNode(postorder[poE]);

        // These three lines will be for Calculating the Number of Elements in right and left Tree Respectively for a Root.
        int inorder_root_index=map.get(postorder[poE]);
        int no_of_elements = inE - inorder_root_index;
        int no_of_elements_right = inorder_root_index - inS;

        root.right = Make_Tree(inorder , inorder_root_index+1, inE, map,
                               postorder, poE - no_of_elements, poE-1);

        root.left = Make_Tree(inorder , inS, inorder_root_index-1, map,
                postorder, poS , poS+no_of_elements_right- 1);

        return root;

    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n =sc.nextInt();

        int[]inorder=new int[n];
        int[]postorder=new int[n];

        for(int i=0; i<n; i++)inorder[i]=sc.nextInt();
        for(int i=0; i<n; i++)postorder[i]=sc.nextInt();

        HashMap<Integer, Integer>map=new HashMap<>();
        for(int i=0; i<n; i++)map.put(inorder[i] , i);

        TreeNode root = Make_Tree(inorder , 0, n-1, map, postorder, 0, n-1);
        Display(root);
    }
}
