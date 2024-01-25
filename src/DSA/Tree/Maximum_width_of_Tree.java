package DSA.Tree;


import java.util.LinkedList;
import java.util.Queue;
import java.util.WeakHashMap;

class width_Pair{
    TreeNode node;
    int index;

    width_Pair(TreeNode n, int i){
        node=n;
        index=i;
    }
}
public class Maximum_width_of_Tree{

    public static int Maximum_width(TreeNode root){
        if(root==null)return 0;

        Queue<width_Pair>q=new LinkedList<>();
        q.add(new width_Pair(root, 1));

        int start = -1, end=-1, ans=0;
        while (!q.isEmpty()){

            int size=q.size();

            for(int i=0; i<size; i++){

                width_Pair front = q.poll();
                TreeNode node = front.node;
                int index=front.index;

                if(i==0)start=index;
                if(i==size-1)end=index;

                if(node.left!=null)q.add(new width_Pair(node.left, 2*index));
                if(node.right!=null)q.add(new width_Pair(node.right, 2*index+1));
            }

            ans=Math.max(ans, Math.abs(start-end)+1);

        }

        return ans;
    }

    public static void main(String[] args) {

        TreeNode root = Tree.CreateTree();

        System.out.println("Maximum width of Tree is : "+Maximum_width(root));
    }
}
