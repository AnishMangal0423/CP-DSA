package LeetCode.POTD;

import java.util.*;

class TreeNode{

    int data;
    TreeNode left=null;
    TreeNode right=null;

    TreeNode(int d){

        data = d;
    }

}
public class V__CreateBinaryTree_Description__15072024{

    public static TreeNode CreateBinaryTree(int[][]descriptions){

        HashMap<Integer, int[]> childsmap = new HashMap<>();
        HashMap<Integer, Integer>FindRoot = new HashMap<>();
        for(int i=0; i<descriptions.length; i++){

            int a = descriptions[i][0];
            int b = descriptions[i][1];
            int c = descriptions[i][2];

            FindRoot.put(b, a);
            if(childsmap.containsKey(a)==false){
                int[]childs = new int[2];
                childs[c]=b;
                childsmap.put(a, childs);
            }

            else{
                int[]childs = childsmap.get(a);
                childs[c]=b;
                childsmap.put(a, childs);
            }

        }
       for(int kii : childsmap.keySet()){
           System.out.println(kii +" "+ Arrays.toString(childsmap.get(kii)));
       }

        int rootValue = -1;
        for(int i=0; i<descriptions.length; i++){
            int a = descriptions[i][0];

            if(FindRoot.containsKey(a)==false){
                rootValue=a;
                break;
            }
        }


        // Actual Part of Creating Tree -

        TreeNode root = new TreeNode(rootValue);
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()){

            TreeNode front  = q.poll();

            if(childsmap.containsKey(front.data)==true) {
                int[] childs = childsmap.get(front.data);

                if (childs[0] != 0) {
                    TreeNode leftNode = new TreeNode(childs[0]);
                    front.left = leftNode;
                    q.add(leftNode);
                }

                if (childs[1] != 0) {
                    TreeNode rightNode = new TreeNode(childs[1]);
                    front.right = rightNode;
                    q.add(rightNode);
                }
            }
        }
return root;
    }

    public static void Display(TreeNode root){

        // Level Order Printing -
        if(root==null) return;

        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        System.out.print("Root"+root.data+", ");

        while (!q.isEmpty()){

            TreeNode front = q.poll();
            int data = front.data;

            if(front.left!=null){
                q.add(front.left);
                System.out.print(data + "->L"+front.left.data+", ");
            }
            if(front.right!=null){
                q.add(front.right);
                System.out.print(data + "->R"+front.right.data+", ");
            }
        }

    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Number of Nodes?: ");
        int n = sc.nextInt();
        System.out.println("Enter the Tree's Description ?: ");

        int[][]descriptions = new int[n][3];

        for(int i=0; i<descriptions.length; i++){
            for(int j=0; j<3; j++)descriptions[i][j]=sc.nextInt();
        }


        Display(CreateBinaryTree(descriptions));

    }
}
