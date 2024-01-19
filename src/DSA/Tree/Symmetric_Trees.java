package DSA.Tree;

import com.sun.jdi.Mirror;

public class Symmetric_Trees {

    public static boolean CheckMirror(TreeNode root1, TreeNode root2){

        if(root1==null && root2==null)return true;
        if(root1==null || root2==null)return false;
        if(root1.data!=root2.data) return false;

        return CheckMirror(root1.left, root2.right) && CheckMirror(root1.right, root2.left);

    }
    public static boolean is_Symmetric(TreeNode root){

        return CheckMirror(root.left, root.right);
    }
    public static void main(String[] args) {

        TreeNode root=Tree.CreateTree();

        System.out.println("Is Tree Symmetric About Root : "+is_Symmetric(root));

    }
}
