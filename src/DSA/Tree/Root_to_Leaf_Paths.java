package DSA.Tree;

import java.util.*;
import java.lang.*;

public class Root_to_Leaf_Paths{
    public static void Paths(TreeNode root, StringBuilder sb, ArrayList<String>ans){

        sb.append(root.data);
        if(root.left==null && root.right==null){
                  ans.add(sb.toString());
                  return;
        }

        if(root.left!=null) Paths(root.left, sb, ans);
        sb.deleteCharAt(sb.length()-1);
        if (root.right!=null)Paths(root.right, sb, ans);
        sb.deleteCharAt(sb.length()-1);


    }


    public static void main(String[] args) {

        TreeNode root = Tree.CreateTree();

        ArrayList<String>ans=new ArrayList<>();
        Paths(root, new StringBuilder(""), ans);

        for(String ss : ans){

           for(int i=0; i<ss.length(); i++){
               System.out.print(ss.charAt(i)+" ");
           }

            System.out.println("");
        }
    }
}
