package DSA.Tree;

public class PreOrder_Traversal_Recursive{


    public static void PreOrder_Display(TreeNode root){

        if(root==null) return;
        System.out.print(root.data+", ");
        PreOrder_Display(root.left);
        PreOrder_Display(root.right);
    }
    public static void main(String[] args) {

        TreeNode root = Tree.CreateTree();
        Tree.Display(root);
        System.out.println(" ");
        PreOrder_Display(root);
    }
}
