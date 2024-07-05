package DSA.DynamicProgramming;

import java.util.Arrays;
import java.util.Scanner;

public class M_TargetSubsetSum {


    // Normal , Memoization Method -
    public static boolean MakeSum(int[]arr, int target, int ind , int[][]dp){

        if (target == 0) return true;
        if (ind == 0) return arr[0] == target;
        if (dp[ind][target] != -1) return dp[ind][target] == 1;

        boolean notTake = MakeSum(arr, target, ind - 1, dp);
        boolean take = false;
        if (arr[ind] <= target) take = MakeSum(arr, target - arr[ind], ind - 1, dp);

        dp[ind][target] = (take || notTake) ? 1 : 0;
        return dp[ind][target] == 1;
    }

    // Normal Tabulation Method -
    public static boolean MakeSumTabulate(int[]arr, int target, boolean[][]dp){

        int rows = arr.length;
        // Base Case Condition -1

        if(arr[0]<= target){
            dp[0][arr[0]]=true;

        }


        for(int i=0; i<rows; i++)dp[i][0]=true;


        for(int i=1; i<rows; i++){
            for(int j=1; j<=target; j++){

                if(j-arr[i] >=0){
                    dp[i][j] = dp[i-1][(j-arr[i])] || dp[i-1][j];
                }

                else {
                    dp[i][j] = dp[i-1][j];
                }


            }
        }
//     for(int i=0; i<rows; i++) System.out.println(Arrays.toString(dp[i]));
        return dp[rows-1][target];
    }
    public static void main(String[] args) {

        System.out.println("Enter the Size of Array :- ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[]arr=new int[n];
        int sum = 0;
        for(int i=0; i<n; i++){
            arr[i]=sc.nextInt();
            sum+=arr[i];
        }
        int target = sc.nextInt();

        boolean[][]dp1 = new boolean[n][target+1];
        int[][]dp2 = new int[n][target+1];
        for(int i=0; i<n; i++) Arrays.fill(dp1[i], false);
        for(int i=0; i<n; i++) Arrays.fill(dp2[i], -1);
        System.out.println("Is Possible to Make the Target with subset Memoization ?: " + MakeSum(arr,target , n-1 , dp2));
        System.out.println("Is Possible to Make the Target with subset Tabulation ?: " + MakeSumTabulate(arr, target,dp1));
    }
}
