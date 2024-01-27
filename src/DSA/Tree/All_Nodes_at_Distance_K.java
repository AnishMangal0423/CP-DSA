package DSA.Tree;

import java.util.*;


public class All_Nodes_at_Distance_K{


    public static void Parent_Connections(TreeNode root, HashMap<TreeNode, TreeNode>map){

        Queue<TreeNode>q=new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()){

            int size=q.size();
            TreeNode parent = q.poll();

            for(int i=0; i<size; i++){

                if(parent.left!=null){
                    q.add(parent.left);
                    map.put(parent.left, parent);

                }

                if(parent.right!=null){
                    q.add(parent.right);
                    map.put(parent.right, parent);
                }
            }
        }
    }


    public static void Print_Nodes(HashMap<TreeNode, TreeNode>map,List<Integer>ans, int taregt, int k){

//        .... Do bfs and get ans .. I am not doing because target node is node Not Integer
    }
    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        List<Integer>ans = new ArrayList<>();

        TreeNode root = Tree.CreateTree();
        int target = sc.nextInt();
        int k=sc.nextInt();
     // Bfs traversal to make parent connection in HashMap to traverse across....

        HashMap<TreeNode, TreeNode>map=new HashMap<>();
        Parent_Connections(root, map);


     // Now Going to do bfs for Printing nodes at Dis k.

       Print_Nodes(map, ans, target, k);



    }
}
