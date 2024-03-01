package DSA.Tree;

import java.util.Scanner;
import java.util.Stack;

/**
 *
 * Concept -->  Finding the 2 Sum In Bst for a Target .
 * Approch -->  Mtd-1: That is Brute force is just to do the inorder array and then do Simple 2 sum.
 *               TC - O(N) , SC - O(N)
 *
 *              Mtd-2 : Space Optimizided Solution -
 *              So we will make the 2 Iteraators or stacks and then add left eleemnts and right elements in Seperate
 *              Order.
 *              LeftStack --> It will contain Increasing order of Elements .=
 *              RightStack --> It will contain Decresing order of Elements.
 *              Main thing is they are not storeing the whole O(n) elements . so storing O(h) elements.
 *              and we will do then mathematics./logic u can see.
 *
 *              TC - O(N) , SC - O(H + H) .
 *
 * **/


class BSTIterator2Sum{

    Stack<TreeNode> stk;
    boolean flag;

    public void AddElements(Stack<TreeNode>stk , TreeNode root, boolean flag){

        if(root==null)return;
        stk.add(root);
        if(flag==false) AddElements(stk, root.left, flag);
        else AddElements(stk, root.right , flag);
    }
    BSTIterator2Sum(TreeNode root, boolean flag) {

        stk = new Stack<>();
        this.flag=flag;
        AddElements(stk, root, flag);
    }


    public int next() {

        if(stk.size() > 0){

            TreeNode front = stk.pop();

            if(front.right!=null && flag==false) AddElements(stk, front.right, flag);
            else if(front.left!=null && flag==true)AddElements(stk, front.left , flag);
            return front.data;
        }

        else return -1;
    }

    public boolean hasNext() {

        return stk.size() > 0;
    }
}



public class Two_Sum_in_BST {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        TreeNode root = Tree.CreateTree();
        System.out.println("Enter the Total Sum You want to achieve : ");
        int target = sc.nextInt();


      // Now making 2 stacks -

        BSTIterator2Sum sLeft = new BSTIterator2Sum(root, false);
        BSTIterator2Sum sRight = new BSTIterator2Sum(root , true);

        Stack<TreeNode>leftStack = sLeft.stk;
        Stack<TreeNode>rightStack = sRight.stk;

        while (leftStack.peek()!=rightStack.peek()){

            int first = leftStack.peek().data;
            int second = rightStack.peek().data;

            if(first+second == target){
                System.out.println(true);
                break;
            }

            else if (first +second > target) {
                int d = sRight.next();
            }

            else{
                int d = sLeft.next();
            }
        }

        if(leftStack.peek() == rightStack.peek()) System.out.println(false);

    }
}
