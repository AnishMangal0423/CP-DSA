package DSA.DynamicProgramming;
import java.util.Arrays;
import java.util.Scanner;

/***
 Memoization -
 Time Compelxity - O(N * (Sum+1))
 Space Complexity - O(N * (Sum+1)) + O(N) stack space .

 Tabulation -
 Time Compelxity - O(N * (Sum+1))
 Space Complexity - O(N * (Sum+1).


 Hint :- Is Question mai Ek point h Ki Hmm Log Direct Taregt ko second Variable nhi maan
 sakte Kyuki target negative bhi h to memoization/dp mai dikaat krge.
 so Imagine the subsequence of {+, + , +} and {-, -, -} and hme pata h sab milke sum
 hi hone h to whai shuru mai negativesum ko sum ke barabar rkho matlab positive mai abhi
 kuch nhi liya, fir take/non-take laga Do.
 */
public class U_TargetSum {

    public static int Ways_Memoization(int[]arr,int index ,int negativeSum,  int target, int sum, int[][]dp){

        int positiveSum = sum - negativeSum;
        if((positiveSum-negativeSum == target) && index<0)return 1;
        if(index<0)return 0;
        if(dp[index][negativeSum]!=-1)return dp[index][negativeSum];

        int take = Ways_Memoization(arr, index-1, negativeSum-arr[index], target, sum, dp);
        int non_take = Ways_Memoization(arr, index-1, negativeSum, target, sum, dp);

        return dp[index][negativeSum] = take+ non_take;

    }

    public static int Ways_Tabulation(int[]arr, int[][]dp, int target, int sum){

        // Base Case + Recursive Relation -
        for(int i=0; i<dp[0].length; i++){
            int positiveSum = sum - i;
            if(positiveSum- i == target)dp[0][i]=1;
        }

        // Recursive Relation -
        for(int i=1; i<dp.length; i++){
            for(int j=0; j<dp[0].length; j++){

                // Non_take -

                int Non_take = dp[i-1][j];

                // Take -
                int take = 0;
                if(j-arr[i-1]>=0) {
                    take = dp[i - 1][j - arr[i-1]];
                }

                dp[i][j]=take+Non_take;

            }
        }

        return dp[dp.length-1][dp[0].length-1];
    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[]arr=new int[n];
        for(int i=0; i<n; i++)arr[i]=sc.nextInt();
        int target = sc.nextInt();

        int sum = 0;
        for(int i=0; i<n; i++)sum+=arr[i];
        int[][]dp1 = new int[n][sum+1];
        for(int i=0; i<n; i++) Arrays.fill(dp1[i], -1);
        System.out.println("The Number of Ways by which we can make the Target in Memoization are ?: " + Ways_Memoization(arr,n-1, sum, target, sum, dp1));

//        -------------------------------------------------------------------------------------------------------------------------

        int[][]dp2 = new int[n+1][sum+1];
        System.out.println("The Number of Ways by which we can make the Target in Tabulation are ?: " + Ways_Tabulation(arr,  dp2, target, sum));


    }
}
