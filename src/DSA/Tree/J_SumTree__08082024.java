package DSA.Tree;
import static DSA.Tree.Serialize_and_Deserialize_Binary_Tree.Display;
import static DSA.Tree.Tree.CreateTree;


/***
 * Good Question :- This Shows ki kese Ek tree mai hme agar false wali condition and int value dono return krni ho
 *                  to Kaam chalta h.
 *
 *                  TC - O(n)
 *                  SC - O(n)
 *
 * */
public class J_SumTree__08082024 {

    public static int SumTree(TreeNode root){

        if(root==null)return 0;
        if(root.left==null && root.right==null)return root.data;

        int leftans = SumTree(root.left);

        int rightans =  SumTree(root.right);

        if(leftans == -1 || rightans==-1 || root.data != leftans + rightans){
            return -1;
        }
        return root.data+leftans+rightans;
    }
    public static void main(String[] args) {

        TreeNode root = CreateTree();
        Display(root);

        System.out.println("Is Tree SumTree ?: " + ((SumTree(root)==-1) ? false : true));
    }
}
