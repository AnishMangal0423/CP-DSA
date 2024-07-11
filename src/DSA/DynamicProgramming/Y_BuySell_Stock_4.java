package DSA.DynamicProgramming;

import java.util.Arrays;
import java.util.Scanner;

/****

 Overall -
 Time Complexity - O(N * 2 * k)
 Space Complexity - O(N * 2 * k)

 */
public class Y_BuySell_Stock_4{

    public static int Profit_Memoization(int[]prices, int index, int Status, int TurnsLeft, int[][][]dp){

        int n = prices.length;
        if(TurnsLeft==0 || index>=n)return 0;
        if(dp[index][Status][TurnsLeft]!=-1) return dp[index][Status][TurnsLeft];

        // non_take -

        int non_take = Profit_Memoization(prices, index+1, Status, TurnsLeft, dp);

        // Take -

        int take =0;
        if(Status == 0){
            // Buy Time -
            take = (-1)*prices[index] + Profit_Memoization(prices, index+1, (Status+1)%2, TurnsLeft, dp);
        }

        else{

            take = prices[index] + Profit_Memoization(prices, index+1, (Status+1)%2, TurnsLeft-1, dp);
        }

        return dp[index][Status][TurnsLeft] = Math.max(take, non_take);
    }

    public static int Profit_Tabulation(int[]prices, int[][][]dp, int noOfTransactions) {

        /***

         Base Case ka ese soch sakte h ki last din ya to bechke pesse kama lo agar status 1 h to
         Nhi to agar status 0 h to value bhi 0 hogi..
         fir oper wali values bhar do. simple.
         */

        // Writing the Base Cases -

        for (int k = 1; k <= noOfTransactions; k++) {
            dp[dp.length-1][1][k] = prices[prices.length-1];
        }



        // Now Writing Recursive Relation -

        for (int i = dp.length-2; i >=0 ; i--) {

            for (int j = 0; j < dp[0].length; j++) {

                for (int k = 1; k < dp[0][0].length; k++) {

                    int non_take = dp[i + 1][j][k];

                    int take = 0;

                    if (j == 0) {
                        // Buy time -
                        take = (-1) * prices[i] + dp[i + 1][(j+1)%2][k];
                    } else{
                        // Sell Time -
                        take = prices[i] + dp[i + 1][(j + 1) % 2][k - 1];
                    }


                    dp[i][j][k] = Math.max(take, non_take);
                }
            }

        }

        return dp[0][0][noOfTransactions];
    }
    public static void main(String[] args) {

        System.out.println("Enter the Number of Days ?: ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println("Enter the Prices at ith Day ?: ");
        int[]prices = new int[n];
        for(int i=0; i<n; i++)prices[i]=sc.nextInt();
        System.out.println("Enter the Number of At Most Transactions ");

        int k = sc.nextInt();

        int[][][]dp1 = new int[n][2][3];
        for(int i=0; i<n; i++){
            for(int j=0; j<=1; j++) Arrays.fill(dp1[i][j], -1);
        }
        System.out.println("Maximum Profit we can Attain By AtMax 2 Transactions Memoization is ?: " + Profit_Memoization(prices, 0, 0, k, dp1));


        int[][][]dp2 = new int[n][2][k+1];

        System.out.println("Maximum Profit we can Attain By AtMax 2 Transactions Tabulation is ?: " + Profit_Tabulation(prices,  dp2, k));
    }
}
