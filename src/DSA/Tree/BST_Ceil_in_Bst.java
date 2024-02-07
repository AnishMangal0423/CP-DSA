package DSA.Tree;

import java.util.Scanner;

public class BST_Ceil_in_Bst{


    public static int ceil(TreeNode root, int X, int closest){

        if(root==null)return -1;

        if(root.data >=X)closest=Math.min(closest, root.data);

        if(root.data==X)return closest;

        else if(root.data < X && root.right!=null){
            return ceil(root.right, X, closest);
        }

        else if(root.data > X && root.left!=null){

            return ceil(root.left, X, closest);
        }
   return closest==Integer.MAX_VALUE ? -1 : closest;
    }


    public static void main(String[] args) {

        TreeNode root = Tree.CreateTree();

        Scanner sc=new Scanner(System.in);
        int X = sc.nextInt();
        int closest = Integer.MAX_VALUE;
        System.out.println("Ceil of value X is : "+ ceil(root, X, closest));
    }
}
