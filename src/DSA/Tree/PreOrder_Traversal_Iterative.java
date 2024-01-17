/**
 *  TC - O(N)
 *  SC - O(N) in wworst Case Secanario.
 * **/

package DSA.Tree;

import java.util.Stack;

public class PreOrder_Traversal_Iterative{

    public static void PreOrder_Traversal_Iterative(TreeNode root){

        Stack<TreeNode>stk = new Stack<>();
        stk.add(root);

        while(!stk.isEmpty()){

            TreeNode front = stk.pop();
            System.out.print(front.data+", ");

            if(front.right!=null)stk.add(front.right);
            if(front.left!=null)stk.add(front.left);
        }

    }

    public static void main(String[] args) {

        TreeNode root = Tree.CreateTree();
        PreOrder_Traversal_Iterative(root);
    }
}
