package DSA.Tree;

import java.util.*;

class RightViewPair{

    TreeNode node;
    int level;

    RightViewPair(TreeNode node, int l){
        this.node=node;
        this.level=l;
    }
}
public class Right_View{


    public static ArrayList<Integer> View(TreeNode root){
        ArrayList<Integer>ans=new ArrayList<>();
        if(root!=null){
            Queue<RightViewPair>q=new LinkedList<>();
            q.add(new RightViewPair(root, 0));
            int start=-1;

            while (!q.isEmpty()){

                RightViewPair front = q.poll();
                TreeNode node = front.node;
                int level=front.level;

                if(start!=level){
                    start=level;
                    ans.add(node.data);
                }

                if(node.right!=null)q.add(new RightViewPair(node.right, level+1));
                if(node.left!=null )q.add(new RightViewPair(node.left, level+1));


            }

        }
        return ans;
    }
    public static void main(String[] args) {

        TreeNode root= Tree.CreateTree();

        System.out.println(View(root));

    }
}
