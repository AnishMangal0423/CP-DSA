package DSA.Tree;

public class Same_Tree{

    public static boolean isSame(TreeNode root1, TreeNode root2){

         if(root1==null && root2!=null)return false;
         else if(root1!=null && root2==null)return false;
         else if (root1==null && root2==null)return true;

         else {
             if(root1.data==root2.data){
                return isSame(root1.left, root2.left) && isSame(root1.right, root2.right);
             }
             else return false;
         }

    }


    public static void main(String[] args) {
        System.out.println("Enter the Tree 1 Data : ");
        TreeNode root1=Tree.CreateTree();
        System.out.println("Enter the Tree 2 Data : ");
        TreeNode root2 = Tree.CreateTree();

        System.out.println("Is Tree Same : "+ isSame(root1, root2));
    }
}
