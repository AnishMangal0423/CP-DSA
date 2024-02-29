package DSA.Tree;

import java.util.Scanner;
import java.util.Stack;


/**
 *
 * Concept  -->  Making the Iterator over Inrder Traveral of BST.
 * Learning --> The Approch that People Generally uses in it is Just Traverse the Whole Tree and store it in Queue
 *              But here SC - O(N) , we are not having any Benefit of BST.
 *
 *              The second Approch we can have is Stack Approch in which we can use the Concept of Filling only Left
 *              elements (Upto height h ) and then first call the next , and then remove the first minimum element.
 *              Now again to maintain the h height call the left-same by deletednode.right . and put in stack
 *              Now again h height is Maintained.
 *
 *
 * Time Complexity - O(N / N ) ~ O(1) Time.
 * Space Complexity - O(H)
 *
 * **/


class BSTIterator {

    Stack<TreeNode>stk;

    public void AddElements(Stack<TreeNode>stk , TreeNode root){

        if(root==null)return;
        stk.add(root);
        AddElements(stk, root.left);
    }
    BSTIterator(TreeNode root) {

        stk = new Stack<>();
        AddElements(stk, root);
    }


    public int next() {

        if(stk.size() > 0){

            TreeNode front = stk.pop();

            if(front.right!=null)AddElements(stk, front.right);
            return front.data;
        }

        else return -1;
    }

    public boolean hasNext() {

        return stk.size() > 0;
    }
}
public class BST_Iterator_Optimized{

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        TreeNode root = Tree.CreateTree();

       BSTIterator t1 = new BSTIterator(root);
        System.out.println(t1.next());
        System.out.println(t1.next());
        System.out.println(t1.hasNext());
        System.out.println(t1.next());
        System.out.println(t1.next());
        System.out.println(t1.hasNext());
    }
}
