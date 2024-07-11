package LeetCode.POTD;

import java.util.Scanner;
import java.util.Stack;

public class R_ReverseSubstring_BetweenBrackets__11072024 {


    public static String GetString_OptimizedSoln(String s){
/**
 *
 * Intution --> We were Thinking Ki why we Should Reverse the InBetween Substring aur Fir collab kre , aab Hmne socha
 *              Ki koi esi Tarkib Ho jis se Last ka print Ho fir () ke ander aake wha first print ho .. and then top wali ka
 *              last print hoo ..
 *              to Hmm kya krenge shurat mai stack se () () () ke indexes to rkh hi skate h and then fir ose array mai rkh lenge
 *              lets suppose -- (a(b)c) --> arr mai hmm 0 pe 6 and 6 pe 0 , 2 pe 4 and 4 pe 2. store kr lenge. and
 *              pointer lenge direction jo ( || ) aate hi direction ko -1 se multiply krega and oske arr[] index pe pocha dega
 *              lets suppose shuru mai dir=1 h aab ( aate hi dir reverse aur hmm last mai poch jayenge and karte jayenge
 *              we get our ans when i==n .
 *
 *    TC - O(2*N)  --> Stack se array bharne mai , Direction and i pointer ko chalane mai.
 *    SC - ON) --> Stack and array ke wajay se.

 * **/

        int n = s.length();
        int[]arr = new int[n];
        Stack<Integer>stk = new Stack<>();

        for(int i=0; i<n; i++){
            char character = s.charAt(i);
            if(character=='(')stk.push(i);
            if(character==')'){
                int pop = stk.pop();
                arr[pop]=i;
                arr[i]=pop;
            }
        }

        // Initilaly Taking direction  as 1 means Forward..

        int direction = 1;
        int i=0;
        StringBuilder ans = new StringBuilder();

        while (i < n){

            char character = s.charAt(i);

            if(character==')' || character=='('){
                direction = (-1)* direction;
                i=arr[i]+direction;
            }

            else{
                ans.append(character);
                i=i+direction;
            }
        }

        return ans.toString();
    }
    public static String GetString_BruteForce(String s){

        /** Time Complexity --> O(N * N )  --> For N open Bractes , N time Reverse and Merge.
         Space Complexity --> O(N)      --> For N Open Bractes then Stack will have N Length.
         worst Case --> (a(b(c(d(e(f(h)a)b)a)a)s)..
         **/


        Stack<String>stk = new Stack<>();
        int n = s.length();

        for(int i=0; i<n; i++){

            char character = s.charAt(i);

            if(character=='('){
                stk.push("");
            }

            else if(character==')'){
                String ss = stk.pop();
                char[] charArray = ss.toCharArray();
                for (int k = 0; k < charArray.length / 2; k++) {
                    char temp = charArray[k];
                    charArray[k] = charArray[charArray.length - 1 - k];
                    charArray[charArray.length - 1 - k] = temp;
                }
                String reversed = new String(charArray);

                String sss ="" ;
                if(!stk.isEmpty())sss = stk.pop();
                sss+=reversed;
                stk.push(sss);
            }

            else if(stk.isEmpty()){
                stk.push(""+character);
            }

            else{
                String ss = stk.pop();
                ss+=character;
                stk.push(ss);
            }
        }

        return stk.pop();
    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();


        // ----------------------------------------- Brute Force Solution ------------------------------------------------
        System.out.println("String After Reverse ?: " + GetString_BruteForce(s));

      // -----------------------------------  Optimized Solution -----------------------------------------------------------
        System.out.println("String After Reverse By Optimized Soln is ?: " + GetString_OptimizedSoln(s));

    }
}
