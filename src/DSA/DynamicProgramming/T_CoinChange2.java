package DSA.DynamicProgramming;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 *  Memoization -
 *  Time - O(DifferentTypesofCoins * Amount)
 *  Space - O(DifferentTypesofCoins * Amount) + O(Diff..)
 *
 *  Tabulation -
 *  Just time and space same.
 *
 *  Hint - Use take and Non_Take Top to down Approch - in Memoization and also same in tabulation by filling Base cases.
 *
 * **/
public class T_CoinChange2 {

    public static int CoinChange_Memoization(int[]coins, int index, int amountRemaining, int[][]dp){

        if(index<0)return 0;
        if(amountRemaining==0)return 1;
        if(dp[index][amountRemaining]!=-1)return dp[index][amountRemaining];

        int Non_take = CoinChange_Memoization(coins, index-1, amountRemaining, dp);
        int take = 0;
        if(amountRemaining-coins[index]>=0){
            take = CoinChange_Memoization(coins, index, amountRemaining-coins[index], dp);
        }

        return dp[index][amountRemaining] = take+Non_take;
    }

    public static int CoinChange_Tabulation(int[]coins, int amount, int[][]dp){

        // Base Case Condition -
        // Base Case - 1
        for(int i=0; i<dp[0].length; i++){
            if(i%coins[0]==0)dp[0][i]=1;
        }
        // Base Case - 2
        for(int i=0; i<dp.length; i++)dp[i][0]=1;

        // Recurance Relation -
        for(int i=1; i<dp.length; i++){
            for(int j=1; j<dp[0].length; j++){

                int Non_take = dp[i-1][j];

                int take = 0;
                if(j-coins[i] >=0){
                    take = dp[i][j-coins[i]];
                }

                dp[i][j]= take+Non_take;
            }
        }

        return dp[dp.length-1][dp[0].length-1];
    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Different Type of Coins Array Size -");
        int n = sc.nextInt();
        int[]coins = new int[n]; for(int i=0; i<n; i++)coins[i]=sc.nextInt();
        System.out.println("Enter the Amount :- ");
        int amount = sc.nextInt();

        int[][]dp1 = new int[n][n+1];
        for(int i=0; i<dp1.length; i++) Arrays.fill(dp1[i], -1);

        int[][]dp2 = new int[n][amount+1];
        System.out.println("The Number of Ways of Coin Change via Memoization is ?: " + CoinChange_Memoization(coins, n-1, amount, dp1));
        System.out.println("The Number of Ways of Coin Change via Tabulation is ?: " + CoinChange_Tabulation(coins, amount, dp2));

    }
}
