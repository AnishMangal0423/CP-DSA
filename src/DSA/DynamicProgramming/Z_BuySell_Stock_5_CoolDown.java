package DSA.DynamicProgramming;

import java.util.Arrays;
import java.util.Scanner;
/***

 Time Compelxity - O(n * 2)
 Space Complexity - O(N * 2)
 */
public class Z_BuySell_Stock_5_CoolDown {


    public static int MaxProfit_Memoization(int[]prices, int index, int Status, int[][]dp){

        int n = prices.length;
        if(index >= n) return 0;
        if(dp[index][Status]!=-1)return dp[index][Status];

        int take = 0, non_take = 0;

        if(Status == 0){
            // Buy Time -
            take = (-1)*prices[index] + MaxProfit_Memoization(prices, index+1, (Status+1)%2, dp);
        }

        else{
            // Sell Time -
            take = prices[index] + MaxProfit_Memoization(prices, index+2, (Status+1)%2, dp);
        }

        non_take = MaxProfit_Memoization(prices, index+1, Status, dp);

        return dp[index][Status] = Math.max(take, non_take);

    }

    public static int MaxProfit_Tabulation(int[]prices, int[][]dp){

        int n = prices.length;
        // Base Case I have to write -
        dp[n-1][1] = prices[n-1];

        // Recursive Relations -

        for(int i=dp.length-2; i>=0; i--){
            for(int j=0; j<dp[0].length; j++){

                int take =0, non_take = 0;

                if(j==0){
                    // Buy time-
                    take = (-1)*prices[i] + dp[i+1][(j+1)%2];
                }

                else{
                    // Sell Time
                    if(i+2 < n ){
                        take = prices[i] + dp[i+2][(j+1)%2];
                    }
                    else {
                        take = prices[i];
                    }
                }

                non_take = dp[i+1][j];

                dp[i][j] = Math.max(take, non_take);
            }
        }

     return  dp[0][0];
    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Number of Days for Trading ?: ");
        int n = sc.nextInt();

        int[]prices = new int[n];
        System.out.println("Enter the Prices on Each DAY ?: ");
        for(int i=0; i<n; i++)prices[i]=sc.nextInt();

        int[][]dp1 = new int[prices.length][2];
        for(int i=0; i<prices.length; i++) Arrays.fill(dp1[i], -1);
        System.out.println("The Maximum Profit we will Earn is ?: " + MaxProfit_Memoization(prices, 0, 0, dp1));

        int[][]dp2 = new int[prices.length][2];
        System.out.println("The Maximum Profit we will Earn is ?: " + MaxProfit_Tabulation(prices,  dp2));


    }
}
