package DSA.Tree;

import java.util.*;
import java.lang.*;

public class Root_to_Leaf_Paths{
    public static void Paths(TreeNode root,ArrayList<String>ss, List<String>ans){

        ss.add(String.valueOf(root.data)+" ");
        if(root.left==null && root.right==null){
            StringBuilder temp=new StringBuilder("");
            for(String s : ss){
                temp.append(s);
            }
            ans.add(temp.toString());
            return;
        }

        if(root.left!=null){
            Paths(root.left, ss, ans);
            ss.remove(ss.size()-1);
        }

        if (root.right!=null){
            Paths(root.right, ss, ans);
            ss.remove(ss.size()-1);
        }



    }
    public static void main(String[] args) {

        TreeNode root = Tree.CreateTree();

        ArrayList<String>ans=new ArrayList<>();
        Paths(root, new ArrayList<>() , ans);

        for(String ss : ans){

           for(int i=0; i<ss.length(); i++){
               System.out.print(ss.charAt(i));
           }

            System.out.println("");
        }
    }
}
