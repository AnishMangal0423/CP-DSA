package DSA.Tree;

import java.util.Scanner;

/***
 *
 * Approch-1 : TC - O(N + NlogN) , SC - O(N)
 *
 * Approch-2 : TC - O(N) , SC - O(N) + O(N)sstackspace --> Inorder , use space.
 *
 *
 * Approch-3 : TC - O(N) , SC- O(N)Or LogN  --> Simple Inorder with only stack space.
 *
 *
 * Approch-4 : TC- O(N) , SC - O(1)    --> Interatively.
 *
 *
 *
 * Approch-3 : Done here.
 * */

public class Bst_Kth_Largest_Smallest_Element{


    public static int NumberofElements(TreeNode root){
        if(root==null)return 0;

        return 1+NumberofElements(root.left) + NumberofElements(root.right);
    }


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

//------------------------------  For finding first kth smallest element -----------------------------------------------
        System.out.println("Enter the k for which you want to find first kth smallest element");
        int k=sc.nextInt();
        findkthSmallest(root , k);

 //------------------------------ For finding Kth Maximum Element --------------------------------------------------

        System.out.println("Enter the k for which you want to find kth Maximum element : ");
        int k2=sc.nextInt();
        count=0;          // Because I have decrealred as Global so initilaize as 0.
        findkthSmallest(root , NumberofElements(root)-k2+1);

    }
}
