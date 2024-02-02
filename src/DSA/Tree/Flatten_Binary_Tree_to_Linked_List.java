package DSA.Tree;

import java.util.LinkedList;
import java.util.Queue;

public class Flatten_Binary_Tree_to_Linked_List{

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

    static  TreeNode prev = null;

    public static void  Make_Linked_List_Recursive(TreeNode root){

        if(root==null)return;

        Make_Linked_List_Recursive(root.right);
        Make_Linked_List_Recursive(root.left);

        root.right=prev;
        root.left=null;

        prev=root;

    }


    public static void Make_Linked_List_Iterative(TreeNode root){

        TreeNode curr = root;

        while (curr!=null){

            if(curr.left!=null){

                TreeNode prev = curr.left;

                while (prev.right!=null)prev=prev.right;

                prev.right=curr.right;
                curr.right=curr.left;
                curr.left=null;
            }

            curr=curr.right;

        }
    }


    public static void main(String[] args) {

        TreeNode root = Tree.CreateTree();

        Make_Linked_List_Recursive(root);
        Make_Linked_List_Iterative(root);

        Display(root);
    }
}
