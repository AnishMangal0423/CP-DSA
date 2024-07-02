package DSA.Trie;


import javax.swing.tree.TreeNode;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class TrieNode{

    TrieNode[]childrens;

    int Rank = 1;
    boolean endOfWord=false;

    TrieNode(){
        childrens = new TrieNode[26];
        Arrays.fill(childrens, null);
    }

}
public class Trie {


/**
 *
 * Time Complexity - O(Sum of All letters)  for Creating the Whole Trie. , If You have to add One string then Tc - O(Length of New string)
 * Space Complexity - O(26^h * 26) and h = Maximum String length , At worst secanario.  or O(Sum of all elements )
 *
 *
 * In worst Case to add any string Tc - O(len of string)
 * But in case of tree it would be - O(leng of string * logN) or LogN
 * **/


    public static void DeleteString(TrieNode root){

        System.out.println("Enter the String You Want to Delete :- ");
        Scanner sc = new Scanner(System.in);
        String InputString = sc.next();

        TrieNode parent = root;
        for(int i=0; i<InputString.length(); i++){

            char InputStringLetter = InputString.charAt(i);
            int index = InputStringLetter-'a';

            if(parent.childrens[index].Rank==1){
                parent.childrens[index]=null;
                return;
            }

            else{
                parent.childrens[index].Rank--;
                if(i==InputString.length()-2){
                    parent.childrens[index].endOfWord=false; break;
                }
                parent=parent.childrens[index];

            }
        }

    }


// Worst Time Complexity of Search - O(Maximum Length String)
    public static boolean SearchString(TrieNode root){

        TrieNode parent = root;

        System.out.println("Enter the String You want to search- ");
        Scanner sc = new Scanner(System.in);
        String Inputstring = sc.next();
        for(int i=0; i<Inputstring.length(); i++){

            char letter = Inputstring.charAt(i);
            if(parent.childrens[letter-'a']==null)return false;
            if(i==Inputstring.length()-1 && parent.endOfWord==true)return true;

            parent=parent.childrens[letter-'a'];
        }

        return false;
    }
    public static TrieNode CreateTrie(){


        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the Number of Strings - ");
        int n= sc.nextInt();
        String[]arr=new String[n];
        TrieNode root = new TrieNode();

        System.out.println("Enter the Strings Input - ");
        for(int i=0; i<n; i++) arr[i]=sc.next();

        // Now Filling the Trie Data Structure with String Words -


        for(String s : arr){
            TrieNode parent = root;
            for(int i=0; i<s.length(); i++){

                char wordChar = s.charAt(i);

                if(parent.childrens[wordChar - 'a']==null){
                    TrieNode newNode = new TrieNode();
                    parent.childrens[wordChar-'a']=newNode;
                }

                else{
                    TrieNode Childnode = parent.childrens[wordChar-'a'];
                    Childnode.Rank++;
                }
                if(i==s.length()-1)parent.endOfWord = true;

                parent = parent.childrens[wordChar-'a'];

            }
        }

     return root;
    }

    public static void PrintTrie(TrieNode root){

        Queue<TrieNode>q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()){

            TrieNode front = q.poll();

            for(int i=0; i<26; i++){
                if(front.childrens[i]!=null){
                    if(front.endOfWord==true){
                        System.out.print((char)('a'+ i)+""+(front.childrens[i].Rank) + " WordEnd ");
                    }
                    else System.out.print((char)('a'+ i) +""+(front.childrens[i].Rank)+ " ");
                    q.add(front.childrens[i]);
                }
            }

        }
        System.out.println("");

    }
    public static void main(String[] args) {

        TrieNode trie = Trie.CreateTrie();
        PrintTrie(trie);
        System.out.println("Is String Available in Trie :- " + SearchString(trie));
//        System.out.println("Is String Available in True :- " + SearchString(trie));
        DeleteString(trie);
        PrintTrie(trie);

    }
}
