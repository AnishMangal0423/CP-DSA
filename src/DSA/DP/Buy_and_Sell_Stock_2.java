package DSA.DP;

import java.util.*;


/**
 *
 * Approch--> Recursive Approchh / Memoziation-
 *           We have to maintain a Buy status Variable that will show either we can buy or sell the stock on a Particularday.
 *           so, if status is buy then i can either buy or not and same with sell.
 *
 *           I have to maximize the profit so think if day/size of array is 1.tehn think on size=2.
 *
 * Remember :- Whenever we have to think on Maximum/minimum in Recursion we first comes to bottom and then create logics .
 *
 * Time Complexity : O(days * 2)
 * Space Complexity : O(days * 2)
 *
 *
 * More optimized can be -
 * time - O(Days * 2)
 * Space - O(1)
 *
 *
 *
 * **/
public class Buy_and_Sell_Stock_2{


    public static int Maximum_profit(int[]prices, int day, int buy , int[][]dp){

        if(day >= prices.length)return 0;
        if(dp[day][buy]!=-1)return dp[day][buy];

        if(buy==1) {
            return dp[day][buy] = Math.max((-1)*(prices[day])+ Maximum_profit(prices, day+1,0, dp) , Maximum_profit(prices, day+1, 1, dp));
        }

        else{

            return dp[day][buy] = Math.max(prices[day]+ Maximum_profit(prices, day+1, 1, dp), Maximum_profit(prices, day+1, 0, dp));

        }
    }
    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);

        int days = sc.nextInt();

        int[]prices = new int[days];

        for(int i=0; i<days; i++)prices[i]=sc.nextInt();

        int[][]dp=new int[days][2];

        for(int i=0; i<days; i++)Arrays.fill(dp[i], -1);
        System.out.println(Maximum_profit(prices, 0, 1, dp));

    }
}
