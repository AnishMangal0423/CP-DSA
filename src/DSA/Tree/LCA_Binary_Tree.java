package DSA.Tree;

import java.util.Scanner;

public class LCA_Binary_Tree{

    public static int LCA(TreeNode root, int p, int q){

        if(root==null)return 0;
        if(root.data==p)return p;
        if(root.data==q)return q;

        int left = LCA(root.left, p, q);
        int right = LCA(root.right, p, q);

        if(left!=0 && right!=0)return root.data;
        else if(left==0)return right;
        else if(right==0)return left;

        return -1;
    }
    public static void main(String[] args) {

        TreeNode root=Tree.CreateTree();

        Scanner sc=new Scanner(System.in);

        int p=sc.nextInt();
        int q=sc.nextInt();

        System.out.println(LCA(root, p, q));
    }
}
