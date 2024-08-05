package DSA.Tree;
import java.util.*;


/***
 *
 * Few Changes in Bottom View of Tree is -
 *
 * Agar Hmm Normally Tree Ka Bottom View Nikalenge to hme HashMap Ki jarurat to Padegi hi.
 * takki hmm Updated Values Ko Rakh Payee . But hme TreeMap rkhte h. takki ans sorted order mai aaye. But agar
 * tab time complexity :-
 *
 * TC - O(NlogN)
 * SC - O(N)   Hoga.
 *
 *
 *
 * Lekin Agar tum HashMap mai rkho and then Baad mai array Bna kar ke os ko minDis jo minus mai h os Hisab se bhi kr sakte ho.
 *
 * TC - O(N)
 * SC - O(N)
 *
 * **/

class BViewPair{
    TreeNode node;
    int dis;

    BViewPair(TreeNode node, int distance){
        this.node=node;
        this.dis=distance;
    }
}
public class Bottom_View{

    public static void BootomView(TreeNode root, Map<Integer, Integer>map){

        if(root!=null) {
            Queue<BViewPair> q = new LinkedList<>();
            q.add(new BViewPair(root, 0));

            while (!q.isEmpty()){

                BViewPair front = q.poll();
                TreeNode node=front.node;
                int distance = front.dis;

                map.put(distance, node.data);

                if(node.left!=null) q.add(new BViewPair(node.left, distance-1));
                if(node.right!=null) q.add(new BViewPair(node.right, distance+1));

            }
        }
    }

    public static void main(String[] args) {

        TreeNode root = Tree.CreateTree();
        Map<Integer, Integer>map=new TreeMap<>();

        BootomView(root, map);
        ArrayList<Integer>ans=new ArrayList<>();
       for(int kii : map.keySet()){
           ans.add(map.get(kii));
       }

        System.out.println(ans);
    }
}
