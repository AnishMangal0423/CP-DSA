package LeetCode.POTD;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * Time complexity : (2^N * N) --> Shuru mai esa Lagta h Ki , N^N hogi time complexity but exactly it is 2^N , ese socho like
 *                                 every gap had 2 choices ki yrr wha par hm partition kre ya nhi kre.
 *                                 and then make the decision tree then we will find ki n height ka 1 tree bn gya h and have total
 *                                 2^N nodes and aab haar node par Palindrome bhi check ho rha h so , total tc is 2^N * N
 *
 *
 * Space Complexity : (2^N * N)  --> There can be 2*N total palindrome cases and every case can be of length n .
 *
 *
 * **/


public class C_Palindrome_Partitioning__22052024{

    public static boolean isPalindrome(String s){

        int i=0;
        int j=s.length()-1;

        while (i<=j){
            if(s.charAt(i)!=s.charAt(j))return false;
            i++; j--;
        }

        return true;
    }
    public static void Substrings(String s ,ArrayList<String>helper, ArrayList<ArrayList<String>>ans){

        if(s.length()==0){
            ans.add(new ArrayList<>(helper));
            return;
        }

        for(int i=1; i<=s.length(); i++){

            String s1 = s.substring(0,i);
            String s2 =  s.substring(i, s.length());

            if(isPalindrome(s1)==true){


                helper.add(s1);
                Substrings(s2, helper, ans);
                helper.remove(helper.size()-1);
            }

        }
    }
    public static void main(String[] args) {

        Scanner sc =  new Scanner(System.in);
        String s = sc.nextLine();

        ArrayList<ArrayList<String>>ans = new ArrayList<>();
        ArrayList<String>helper = new ArrayList<>();
        Substrings(s, helper, ans);
        System.out.println("All Palindromic Substrings are ?: " + ans);
    }
}
