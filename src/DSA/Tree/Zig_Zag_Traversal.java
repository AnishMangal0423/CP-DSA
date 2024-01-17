package DSA.Tree;

import java.util.*;

class Pair{
    TreeNode Node;
    int level;

    Pair(TreeNode N, int l){
        Node=N;
        level=l;
    }

}

public class Zig_Zag_Traversal{

    public static List<List<Integer>> Zig_Zag(TreeNode root){


        List<List<Integer>>ans=new ArrayList<>();
        if(root!=null) {
            Queue<Pair> q = new LinkedList<>();
            q.add(new Pair(root, 1));

            while (!q.isEmpty()) {

                Pair front = q.poll();
                TreeNode Node = front.Node;
                int level = front.level;

                if (ans.size() < level) ans.add(new ArrayList<>());

                    ans.get(level-1).add(Node.data);


                if (Node.left != null) q.add(new Pair(Node.left, level + 1));
                if (Node.right != null) q.add(new Pair(Node.right, level + 1));

            }

           for(int i=1; i<ans.size(); i+=2){
               Collections.reverse(ans.get(i));
           }
        }

        return ans;
    }

    public static void main(String[] args) {

        TreeNode root=Tree.CreateTree();

        System.out.println(Zig_Zag(root));
    }
}
