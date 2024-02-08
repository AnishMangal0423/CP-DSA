package DSA.Tree;

import java.util.Scanner;

public class BST_Floor_in_Bst {

    public static int Recursion(TreeNode root, int x, int closest){

        if(root==null) return closest;

        if(root.data == x) closest = x;
        if(root.data < x)closest=Math.max(closest, root.data);

        if(root.data > x){
            return Recursion(root.left , x, closest);

        }

        else if(root.data < x){
            return Recursion(root.right , x, closest);
        }
        return closest;
    }
    public static void main(String[] args) {

        TreeNode root = Tree.CreateTree();

        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();


        System.out.println(Recursion(root, x, -1));


    }
}
