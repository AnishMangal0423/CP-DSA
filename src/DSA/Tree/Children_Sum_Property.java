package DSA.Tree;

public class Children_Sum_Property{

    public static boolean children_sum(TreeNode root){

        if(root==null)return true;

        boolean aa = children_sum(root.left) && children_sum(root.right);

       if(aa) {
           if (root.left != null && root.right != null) return root.data == root.left.data + root.right.data;
           else if (root.left != null) return root.data == root.left.data;
           else if(root.right!=null) return root.data == root.right.data;
       }

       return aa;
    }
    public static void main(String[] args) {

        TreeNode root = Tree.CreateTree();
        System.out.println("Is Tree Children Sum : "+ children_sum(root));

    }
}
