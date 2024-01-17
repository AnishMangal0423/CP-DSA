package DSA.Tree;

/**
 * TC - O(N)
 * SC - O(N)
 *
 * Approch - Just Changed the Height Calculation Function and Remember whenever there is two mixups like int Traversal and then
 *           Boolean checking for every Nodes Go for -1 and all .
 * **/

public class Balanced_Binary_Tree {

    public static int checkBalance(TreeNode root){

        if(root == null) return 0;

        int lh = checkBalance(root.left);
        if(lh==-1) return -1;
        int rh = checkBalance(root.right);
        if(rh==-1) return -1;

        if(Math.abs(lh-rh) > 1) return -1;

        return 1+Math.max(lh, rh);

    }
    public static boolean isBalanced(TreeNode root){

        return checkBalance(root)!=-1;
    }

    public static void main(String[] args) {

        TreeNode root = Tree.CreateTree();

        System.out.println("Tree is Balanced : "+isBalanced(root));
    }

}
