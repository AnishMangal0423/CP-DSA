package DSA.DP;

import java.util.Scanner;

  /***
          TC - O(days * 6)
                  SC - O(days * 6)   Because Limit is 2.

                  or In General Complexity...
                  O(days * 2 * Limit(Number of stocks we can Buy))

**/

public class Buy_and_Sell_Stock_3 {

    public static int Make_Recursion(int[]prices, int index, int Buy_status, int Limit, int profit, int[][][]dp){

        if(Limit==0 || index>=prices.length )return 0;
        if(dp[index][Buy_status][Limit]!=-1) return dp[index][Buy_status][Limit];
        // Means we are Going to buy the stock..
        if(Buy_status==1){
            profit+=Math.max((-1)*prices[index] + Make_Recursion(prices, index+1, 0 , Limit, profit, dp) ,
                              Make_Recursion(prices, index+1, Buy_status , Limit , profit,dp));
        }

        else{

            profit+=Math.max(prices[index]+Make_Recursion(prices , index+1, 1, Limit-1, profit,dp),
                              Make_Recursion(prices, index+1, 0, Limit , profit,dp));
        }

        return dp[index][Buy_status][Limit] = profit;
    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int days = sc.nextInt();

        int[]prices = new int[days];
        for(int i=0; i<days; i++){
            prices[i]=sc.nextInt();
        }

        int[][][]dp = new int[days][2][3];

        for(int i=0; i<days; i++){
            for(int j=0; j<2; j++){
                for(int k=0; k<3; k++){
                    dp[i][j][k]=-1;
                }
            }
        }

        System.out.println("Maximum Profit we can Earn : "+ Make_Recursion(prices, 0, 1, 2, 0, dp));
    }
}
