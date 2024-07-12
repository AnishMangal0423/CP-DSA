package DSA.DynamicProgramming;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Time Complexity :- O(N * 2 )
 * Space Complexity :- O(n * 2)
 *
 * **/
public class ZA_BuySell_Stock_6_Fee {

    public static int MaxProfit_Memoization(int[]prices, int index, int Status, int[][]dp, int fee){

        int n = prices.length;
        if(index >= n)return 0;
        if(dp[index][Status]!=-1)return dp[index][Status];

        int take = 0; int non_take = 0;
        if(Status == 0){
            // Buy Time-
            take = (-1)* prices[index] + MaxProfit_Memoization(prices, index+1, (Status+1)%2,dp,  fee);
        }

        else{
            // Sell Time -
            take = prices[index] - fee + MaxProfit_Memoization(prices, index+1, (Status+1)%2,dp, fee);
        }

        non_take = MaxProfit_Memoization(prices, index+1, Status,dp, fee);


        return dp[index][Status] = Math.max(take, non_take);
    }

    public static int MaxProfit_Tabulation(int[]prices, int[][]dp, int fee){

        int n = prices.length;
        // Base Case Condition for Dp array.
         dp[n-1][1] = prices[n-1] - fee;


         // Now writing the Recurence Relation -

        for(int i=dp.length-2; i>=0; i--){
            for(int j=0; j<dp[0].length; j++){

                int take = 0; int non_take = 0;

                if(j==0){
                    // Buy Time -
                    take = (-1)*prices[i] + dp[i+1][(j+1)%2];
                }
                else {
                    // Sell Time -
                    take = prices[i] - fee + dp[i+1][(j+1)%2];
                }

                non_take = dp[i+1][j];

                dp[i][j] = Math.max(take, non_take);
            }
        }

        return dp[0][0];
    }
    public static void main(String[] args) {

        System.out.println("Enter the No of Days you want to Consider for Transaction ?: ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[]prices = new int[n];
        for(int i=0; i<n; i++)prices[i] =sc.nextInt();

        System.out.println("Enter the fee for Every Transaction ?: ");
        int fee = sc.nextInt();

        int[][]dp1 = new int[n][2];
        for(int i=0; i<n; i++) Arrays.fill(dp1[i], -1);
        System.out.println("Maximum Profit You can Earn is ?: "+ MaxProfit_Memoization(prices, 0, 0, dp1, fee));

        int[][]dp2 = new int[n][2];
//        for(int i=0; i<n; i++) Arrays.fill(dp1[i], -1);
        System.out.println("Maximum Profit You can Earn is ?: "+ MaxProfit_Tabulation(prices,dp2, fee));
    }
}
