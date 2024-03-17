package TLE_LVL_2.CS31_Sheet._1200;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

/***
 *Problem Link :- https://codeforces.com/contest/1734/problem/C
 *
 * Problem :- We have given an array of Numbers from 1 to n and we have also given an Binary string of length n and we have to
 *            remove those elements from set which has character 0 in string.
 *            But there are certain permuattion and all see in questions..
 *
 *  Key Points :-
 *          1. Question Understanding was a concern in this. ( First of all Read the problem with constratints , Imagine testCase Properly. )
 *          2. Remember that -
 *             n (1 + 1/2 + 1/3 + 1/4 + 1/5 +....+ 1/n) = O(nLogN)
 *          3. Kaii barr n <= 10^6 par bhi work kar jaata h.
 *
 *          4. Upto 1200 Rating NlogN solutions , maximum solutions they asks.
 *
 *
 * **/
public class K_Removing_Smallest_Multiples{

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int tc = sc.nextInt();
        while (tc-->0){
            int n = sc.nextInt();
            String s = sc.next();

            HashMap<Integer, Integer>map = new HashMap<>();
            for(int i=0; i<n; i++){
                if(s.charAt(i)=='1'){
                    map.put(i+1, 1);
                }
            }

            int[]dp=new int[n+1];
            Arrays.fill(dp, 0);
            dp[0]=-3;

            for(int i=1; i<=n; i++){
               for(int j=i; j<=n; j+=i){
                   if(map.containsKey(j)==false && dp[j]==0){
                       dp[j]=i;
//                       break;
                   }

                   else if(map.containsKey(j)==true) break;
               }
            }


            long sum = 0;
            for(int i=1; i<=n; i++){
                sum+=dp[i];
            }

            System.out.println(sum);
        }
    }
}
