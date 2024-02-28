package DSA.Tree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 *
 * Concept :- Handling All Cases while Deletion of Nodes.
 * Approch :- Manupulate all 4 cases and Handling them.
 * Edge Cases :-
 *          1. Always whenever You are Hndling the Things on root.left.val something like that then Always give the check for
 *             root.left should not be Null.
 *
 *          2. Hanling the Case of Root Node Deletion so we will make it as Parent as Null and Now will make the condition
 *             for all 4 Cases that if parent is null we will do that.
 *
 *          3. 3rd Edge case is when we will Not Find any Key in tree then we have to return null and print the statement.
 *
 *
 *  Time Complexity :-  O(H)
 *  Space Complexity :- O(H)
 *
 *
 * **/

public class Delete_a_Node_in_BST{

    public static TreeNode FindNode(TreeNode root, int Key){
         if(root == null  || root.data == Key)return root;  // Edge Case - 1
         else if(root.data > Key) return FindNode(root.left , Key);
         else return FindNode(root.right , Key);
    }

    public static TreeNode FindParent(TreeNode root, TreeNode KeyNode){

         if((root.left!=null && root.left.data == KeyNode.data) || (root.right!=null && root.right.data == KeyNode.data))return root;   // Edge Case - 2

         else if(root.data > KeyNode.data)return FindParent(root.left , KeyNode);
         else return FindParent(root.right , KeyNode);

    }

    public static TreeNode FindSuccessor(TreeNode root, TreeNode KeyNode){

        TreeNode curr= KeyNode.left;

        while(curr.right!=null){
            curr=curr.right;
        }

        return curr;
    }

    public static TreeNode DeleteNode(TreeNode root, TreeNode KeyNode){

        TreeNode leftChild = KeyNode.left;
        TreeNode rightChild = KeyNode.right;
        TreeNode parent = null;
        if(root.data!=KeyNode.data) parent = FindParent(root, KeyNode);  // Edge Case - 3

        // Case -1 : When it is Leaf Node-
        if(leftChild==null && rightChild==null){

            if(parent.left==KeyNode)parent.left=null;
            else parent.right = null;
        }


        // Case -2 : When Deleting Node has One child-
        else if(leftChild==null){
            if(parent.data > rightChild.data)parent.left = rightChild;
            else parent.right = rightChild;

        }

        else if(rightChild == null){
            if(parent.data < rightChild.data)parent.left = leftChild;
            else parent.right = leftChild;

        }


        // Case -3 :- when Deleting Node has 2 Childs -

        else{

           TreeNode Successor = FindSuccessor(root, KeyNode);
           Successor.right = KeyNode.right;

           if(parent.left==KeyNode) parent.left = leftChild;
           else parent.right = leftChild;
        }

        return root;
    }

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

    public static void main(String[] args) {

        TreeNode root = Tree.CreateTree();
        Scanner sc = new Scanner(System.in);
        int Key = sc.nextInt();
        TreeNode KeyNode = FindNode(root, Key);
        if(KeyNode==null) System.out.println("Key is Not Found in the Tree !");
        else {
            TreeNode Newroot = DeleteNode(root, KeyNode);
            Display(Newroot);
        }
    }
}
