package DSA.Tree;

public class Preorder_Morris_Traversal {

    static void Make_Connection(TreeNode curr){

        if(curr.left!=null){

            TreeNode temp = curr.left;

            while (temp.right!=null)temp=temp.right;

            temp.right=curr.right;
        }
    }
    public static void print_Morris_Preorder(TreeNode root){

           TreeNode curr = root;

           while (curr!=null) {
               System.out.print(curr.data+", ");

               if (curr.left != null) {
                   Make_Connection(curr);
                   curr = curr.left;
               } else curr = curr.right;

           }

    }
    public static void main(String[] args) {

        TreeNode root = Tree.CreateTree();

        System.out.print("Preorder Traversal is : ");
        print_Morris_Preorder(root);
    }
}
