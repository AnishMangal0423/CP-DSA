package DSA.DynamicProgramming;

import java.util.Arrays;
import java.util.Scanner;

/***

 TC - O(days * 6)
 SC - O(days * 6)   Because Limit is 2.

 or In General Complexity...
 O(days * 2 * Limit(Number of stocks we can Buy))

 */
public class W_BuySell_Stock_2 {

    public static int Maximum_Profit_Memoization(int[]prices, int index, int status, int[][]dp){

        int noOfDays = prices.length;
        if(index >= noOfDays)return 0;
        if(dp[index][status]!=-1)return dp[index][status];

        int take = 0; int non_take = 0;
        if(status == 0){
            // Buy krna h -
            take = (-1)*prices[index] + Maximum_Profit_Memoization(prices, index+1, (status+1)%2, dp);
        }
        else {
            // Sell Krna h -
            take = prices[index] + Maximum_Profit_Memoization(prices, index+1, (status+1)%2, dp);
        }

        non_take = Maximum_Profit_Memoization(prices, index+1, status, dp);

        return dp[index][status] = Math.max(take, non_take);
    }

    public static int Maximum_Profit_Tabulation(int[]prices, int[][]dp){

        int n = prices.length;

        // Base Case Done -
        dp[n-1][1]= prices[n-1];

        // Recursive Relation -
        for(int i= n-2; i>=0; i--){

            dp[i][0] =  Math.max(dp[i+1][0], (-1)* prices[i] + dp[i+1][1]);
            dp[i][1] =  Math.max(dp[i+1][0] + prices[i], dp[i+1][1]);
        }

        return dp[0][0];
    }


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int noOfDays = sc.nextInt();
        int[]prices = new int[noOfDays];
        for(int i=0; i<noOfDays; i++)prices[i] = sc.nextInt();

        /** Memoization Method ---------------------------------------------------------------------  **/
        int[][]dp1 = new int[noOfDays][2];
        for(int i=0; i<noOfDays; i++) Arrays.fill(dp1[i], -1);
        System.out.println("The Total Maximum Profit is ?: " + Maximum_Profit_Memoization(prices, 0, 0, dp1));

        /** Tabulation Method --------------------------------------------------------------------- **/

        int[][]dp2 = new int[noOfDays][2];
        System.out.println("The Total Maximum Profit is By Tabulation Method ?: " + Maximum_Profit_Tabulation(prices, dp2));
    }
}
