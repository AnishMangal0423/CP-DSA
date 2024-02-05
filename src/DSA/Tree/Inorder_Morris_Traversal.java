package DSA.Tree;

public class Inorder_Morris_Traversal{

    public static boolean isVisited(TreeNode curr) {


        TreeNode temp = curr.left;

       if(temp!=null) {
            while (temp.right != null && temp.right!=curr) temp = temp.right;

            if (temp.right == curr) {
                temp.right = null;
                return true;
            } else {
                temp.right=curr;
                return false;
            }
        }

        return true;
    }

    public static void print_Morris(TreeNode root){

        TreeNode curr = root;

        while(curr!=null) {

            if (isVisited(curr) == false) {

                curr = curr.left;

            } else {
                System.out.print(curr.data + ", ");
                curr = curr.right;
            }
        }
    }
    public static void main(String[] args) {

        TreeNode root = Tree.CreateTree();

        print_Morris(root);
    }
}
