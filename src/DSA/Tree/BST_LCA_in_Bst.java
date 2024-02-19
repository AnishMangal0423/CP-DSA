package DSA.Tree;

import java.util.Scanner;

/**
 Time Complexity - O(H) or LogN
 Space complixty - O(H) or LogN

 */
public class BST_LCA_in_Bst {


    public static TreeNode lca(TreeNode root, TreeNode p, TreeNode q){

        if(p.data < root.data && q.data < root.data)return lca(root.left, p, q);
        else if(p.data > root.data && q.data > root.data) return lca(root.right, p, q);
        else return root;


    }
    public static TreeNode Find_Node(TreeNode root, int data){

        if(root.data == data)return root;

        else if(data < root.data){
         return Find_Node(root.left, data);
        }

        else return Find_Node(root.right, data);
    }
    public static void main(String[] args) {

        TreeNode root = Tree.CreateTree();

        Scanner sc = new Scanner(System.in);
        int v1d1=sc.nextInt();
        int v2d2 = sc.nextInt();

        TreeNode v1 = Find_Node(root, v1d1);
        TreeNode v2 = Find_Node(root, v2d2);
        TreeNode LCA_BST = lca(root, v1, v2);

        System.out.println(LCA_BST.data);
    }
}
