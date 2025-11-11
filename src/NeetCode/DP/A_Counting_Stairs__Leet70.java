package NeetCode.DP;

import java.util.*;

/**
 * Complexity Analysis -
 * Brute Force -
 * TC - O(2^n)
 * SC - O(n) --> Recursive Stack.
 *
 * Optimize -
 * TC - O(n)
 * SC - O(n) --> DP Array.
 * **/
public class A_Counting_Stairs__Leet70 {

    public static int dfs(int n, int index, int[]dp){
            if(index == n)return 1;
            if(index>n)return 0;
            if(dp[index]!=-1)return dp[index];
            return dp[index] = dfs(n, index+1, dp) + dfs(n, index+2, dp);

    }
    public static int climbStairs(int n){
        int[]dp = new int[n];
        Arrays.fill(dp, -1);
        return dfs(n, 0, dp);
    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number of stairs : ");
        int n = sc.nextInt();

        System.out.println(climbStairs(n));
    }
}
