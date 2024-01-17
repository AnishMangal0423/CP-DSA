//
//# Height and Depth of Binary Tree's -
//        .......................................
//
//        Height - It is considerd as the maximum depth of Tree or the distance of Farthest Leaf Node from Root Node of Tree.
//
//        Depth - It is considerd as the Number of Edges from Target Node to the Root Node of the Tree.
//
//        MAx_Depth - It is basically Height(Dis between root and Farthest Root).
//
//        Min_Depth - It is basically distance between root and nearest Leaf Node.
//
//        * Depth of Root Node is 0.



package DSA.Tree;

public class Height_and_Depth {


    public static int Depth (TreeNode root, int target, int level){

        if(root==null) return 0;

        if(root.data==target) return level;

        return Depth(root.left, target, level+1) +Depth(root.right, target, level+1);
    }
    public static int Height(TreeNode root){

        if(root==null)return 0;

        return 1+Math.max(Height(root.left), Height(root.right));
    }

    public static int Min_Depth(TreeNode root, int level){

        if(root.left==null && root.right==null) return level;

        int left=Integer.MAX_VALUE; int right = Integer.MAX_VALUE;
        if(root.left!=null){
            left = Min_Depth(root.left, level+1);
        }

        if(root.right!=null){
            right = Min_Depth(root.right, level+1);
        }
        return Math.min(left, right);
    }

    public static void main(String[] args) {

        TreeNode root = Tree.CreateTree();
        int height = Height(root);

        System.out.println("Height is : "+height);
        int depth = Depth(root, 50, 0);
        System.out.println("Depth is : "+ depth);

        int min_depth=Min_Depth(root, 0);
        System.out.println("Minimum Depth of Binary Tree : " + min_depth);
    }
}
