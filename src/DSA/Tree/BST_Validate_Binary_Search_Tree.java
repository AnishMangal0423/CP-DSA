package DSA.Tree;

/**
 *
 *   Time and Space Complexities of this Solution-
 *
 *   1. Time Compelxitiy --> O(N) -- becuause we are Moving to every Element.
 *      Space Complexity --> O(1) + O(Stack space/ H)
 *
 *
 *
 *   Approch-2 : Inorder Traversal-
 *       1. TC - O(N)
 *          SC - O(Stack Space).
 *
 *
 * **/



public class BST_Validate_Binary_Search_Tree{


    public static boolean isBst(TreeNode root, long l, long r){

        if(root==null)return true;
//-----------------------------------------  Wrong Method XD ------------------------------------------------------------
//        if(root==null)return true;
//
//        boolean left = isBst(root.left);
//        boolean right = isBst(root.right);
//
//        if(root.left!=null && root.right!=null) return left && right && (root.data > root.left.data && root.data < root.right.data);
//        else if(root.left!=null) return left && right && (root.data > root.left.data);
//        else if(root.right!=null)return right && left && (root.data < root.right.data);
//        else return left && right;
// -----------------------------------------  Wrong Method XD ------------------------------------------------------------


   // Correct Method :- Method Of Range-
        return (root.data > l && root.data < r) && isBst(root.left , l, root.data) && isBst(root.right, root.data, r);


    }
    public static void main(String[] args) {

        TreeNode root = Tree.CreateTree();

        System.out.println("Is tree is a Binary Search Tree :: "+ isBst(root, Long.MIN_VALUE, Long.MAX_VALUE));
    }
}
