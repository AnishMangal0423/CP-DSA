package DSA.Tree;

public class Count_Complete_Binary_Tree_Nodes{

    public static int left_height(TreeNode root){

        if(root==null)return 0;

        return 1 + left_height(root.left);

    }

    public static int right_height(TreeNode root){
        if(root==null)return 0;

        return 1+ right_height(root.right);
    }
    public static int Count_Nodes(TreeNode root){

        if(root == null) return 0;

        int lh = left_height(root.left);
        int rh = right_height(root.right);

        if(lh==rh) return ((2<<lh) - 1);

        else return Count_Nodes(root.left) + Count_Nodes(root.right) + 1;
    }
    public static void main(String[] args) {

        TreeNode root = Tree.CreateTree();

        System.out.println("Number of Nodes in Complete Binary Tree : "+Count_Nodes(root));
    }
}
