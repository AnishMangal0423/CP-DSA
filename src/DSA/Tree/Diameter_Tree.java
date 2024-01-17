package DSA.Tree;

public class Diameter_Tree{

    public static int Height(TreeNode root){

        if(root==null) return 0;

        return 1+Math.max(Height(root.left), Height(root.right));
    }
    public static int Diameter(TreeNode root){

        return Height(root.left)+Height(root.right);
    }

    public static void main(String[] args) {

        TreeNode root = Tree.CreateTree();
        int diameter = Diameter(root);
        System.out.println("Diameter of Tree is : "+diameter);

    }
}
