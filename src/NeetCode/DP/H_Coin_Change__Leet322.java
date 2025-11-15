package NeetCode.DP;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Brute Force -
 * TC - O(2^(amount)/min coin value)
 * SC - O(amount/min coin value) -> Recursive calls
 *
 * Optimized -
 *  TC - O(n*amount)
 *  SC - O(n*amount)
 * **/
public class H_Coin_Change__Leet322 {

    public static final int INF = Integer.MAX_VALUE/2;

    public static int dfs(int[]coins, int amount, int index, int[][]dp){
        if(amount < 0)return INF;
        if(amount == 0)return 0;
        if(index >=coins.length)return INF;
        if(dp[index][amount]!=-1)return dp[index][amount];

        int left = 1 + dfs(coins, amount - coins[index], index, dp);
        int right = dfs(coins, amount, index+1, dp);

        return dp[index][amount]=Math.min(left, right);

    }

    public static int coinChange(int[] coins, int amount) {
        int[][]dp=new int[coins.length][amount+1];
        for(int i=0; i<coins.length; i++) Arrays.fill(dp[i], -1);
        int ans = dfs(coins, amount, 0, dp);
        return ans>=INF ? -1 : ans;
    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of coins : ");
        int n = sc.nextInt();
        int[]coins = new int[n];
        System.out.println("Enter the coins : ");
        for(int i=0; i<n; i++)coins[i]=sc.nextInt();
        System.out.println("Enter the amount : ");
        int amount = sc.nextInt();
        System.out.println("Minimum number of coins required is : " + coinChange(coins, amount));
    }
}
