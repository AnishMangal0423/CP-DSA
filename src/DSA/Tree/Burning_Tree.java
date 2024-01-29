package DSA.Tree;

import java.lang.annotation.Target;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Burning_Pair{

    TreeNode node;
    int level;

    public Burning_Pair(TreeNode node, int level) {
        this.node = node;
        this.level=level;
    }
}
public class Burning_Tree{

    public static TreeNode Target = null;


    public static int Call_BFS(TreeNode root, HashMap<TreeNode, TreeNode>map, TreeNode Target, HashMap<TreeNode, Integer>visited){

        Queue<Burning_Pair>q = new LinkedList<>();
        int maxi=0;
        q.add(new Burning_Pair(Target, 0));


        while (!q.isEmpty()){

            int size= q.size();

            for(int i=0; i<size; i++){

                Burning_Pair front = q.poll();
                TreeNode node = front.node;
                int level = front.level;
                maxi=Math.max(maxi, level);
                System.out.println("Data: "+node.data +" level: "+level);
                visited.put(node, 1);

                if(node.left!=null && visited.containsKey(node.left)==false){
                    q.add(new Burning_Pair(node.left, level+1));
                }

                if(node.right!=null && visited.containsKey(node.right)==false){
                    q.add(new Burning_Pair(node.right, level+1));
                }

                if(map.containsKey(node) && visited.containsKey(map.get(node))==false){
                    q.add(new Burning_Pair(map.get(node), level+1));
                }

            }

        }
        return maxi;
    }

  public static void Store_Parents(TreeNode root, HashMap<TreeNode, TreeNode>map, int tar) {

      Queue<TreeNode> q = new LinkedList<>();
      q.add(root);

      while (!q.isEmpty()) {

          int size = q.size();

          for (int i = 0; i < size; i++) {

              TreeNode node = q.poll();
              if(node.data==tar)Target=node;

              if(node.left!=null){
                 q.add(node.left);
                 map.put(node.left, node);
              }

              if(node.right!=null){
                  q.add(node.right);
                  map.put(node.right, node);
              }

          }
      }
  }

    public static void main(String[] args) {

        TreeNode root = Tree.CreateTree();
        System.out.print("Enter the Target Node : ");
        Scanner sc = new Scanner(System.in);
        int target = sc.nextInt();

        HashMap<TreeNode, TreeNode>map=new HashMap<>();
        Store_Parents(root, map, target);
        System.out.println(Target.data);
        HashMap<TreeNode, Integer>visited=new HashMap<>();
        System.out.println(Call_BFS(root, map, Target, visited));
    }
}
