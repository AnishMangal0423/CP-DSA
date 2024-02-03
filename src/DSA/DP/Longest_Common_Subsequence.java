package DSA.DP;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 *  Brute Force - (Make all SubSequences and Match them )
 *
 *             TC - 2^L1 * 2^L2  * (max(l1, l2))
 *             SC - 2^L1 + 2^L2
 *
 *
 * Memoized TC - M*N
 *          SC - M*N + M*N (Stack Space)
 *
 *
 * Tabulated TC - M*N
 *           SC - M*N
 *
 *
 * Fully Optmized - TC - M*N
 *                  SC - M
 *
 * **/




public class Longest_Common_Subsequence{


    public static int LCS_Memoized(String s1, String s2, int i, int j, int[][]dp){

           if(i>=s1.length() || j>= s2.length())return 0;
           if(dp[i][j]!=-1)return dp[i][j];

           if(s1.charAt(i)==s2.charAt(j))return dp[i][j] = 1+LCS_Memoized(s1, s2, i+1, j+1, dp);

           else return dp[i][j] = Math.max(LCS_Memoized(s1, s2, i+1, j, dp), LCS_Memoized(s1, s2, i, j+1, dp));
    }

    public static int LCS_Tabulated(String s1, String s2){

        int[][]dp=new int[s1.length()+1][s2.length()+1];

        for(int i=s1.length()-1; i>=0; i--){
            for(int j=s2.length()-1; j>=0; j--){

                if(s1.charAt(i)==s2.charAt(j))dp[i][j]=1+dp[i+1][j+1];
                else dp[i][j]=Math.max(dp[i][j+1], dp[i+1][j]);
            }
        }
        return dp[0][0];
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String s1 = sc.nextLine();
        String s2 = sc.nextLine();


        int[][]dp=new int[s1.length()][s2.length()];
        for (int i=0; i<s1.length(); i++) Arrays.fill(dp[i], -1);

        System.out.println(LCS_Memoized(s1, s2, 0, 0, dp));
        System.out.println(LCS_Tabulated(s1, s2));

    }
}
