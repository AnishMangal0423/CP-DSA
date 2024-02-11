package DSA.Tree;

import java.util.Scanner;

public class Bst_Kth_Largest_Smallest_Element{

    static int count =0;
    public static void findkthSmallest(TreeNode root, int k){

      if(root==null)return;

      findkthSmallest(root.left , k);

      count++;
      if(count == k){
          System.out.println("Kth smallest Element of BST is : "+root.data);
          return;
      }

      findkthSmallest(root.right , k);
    }
    public static void main(String[] args) {

        TreeNode root = Tree.CreateTree();

        Scanner sc = new Scanner(System.in);

        int k=sc.nextInt();

        findkthSmallest(root , k);
    }
}
