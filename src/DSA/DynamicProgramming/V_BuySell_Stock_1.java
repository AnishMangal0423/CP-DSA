package DSA.DynamicProgramming;
import java.util.Scanner;

/***

 Time Complexity -- O(N)
 Space Complexity -- O(1)

 */
public class V_BuySell_Stock_1 {

    public static int Max_Profit(int[]prices){

        int n = prices.length;
        int maxi = prices[n-1];
        int profit = 0;

        for(int i=n-2; i>=0; i--){

            profit = Math.max(profit, maxi - prices[i]);
            maxi = Math.max(maxi, prices[i]);
        }

        return profit;
    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Number of Days ?: ");
        int noofDays = sc.nextInt();

        int[]prices = new int[noofDays];
        for(int i=0; i<noofDays; i++)prices[i]=sc.nextInt();

        System.out.println("Maximum Profit we can Earn is ?: "+ Max_Profit(prices));

    }
}
