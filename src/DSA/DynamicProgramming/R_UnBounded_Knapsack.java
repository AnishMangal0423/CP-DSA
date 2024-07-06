package DSA.DynamicProgramming;

import java.util.Arrays;
import java.util.Scanner;

public class R_UnBounded_Knapsack{

    public static int MaxValue_Memoization(int[]val, int[]weights, int W, int index, int currentWeight, int[][]dp){


        if(currentWeight > W)return -10000;
        if(index < 0) return 0;
        if(dp[index][currentWeight]!=-1)return dp[index][currentWeight];

        int a = val[index]+ MaxValue_Memoization(val, weights, W, index, currentWeight+weights[index], dp);
        int b = MaxValue_Memoization(val, weights, W, index-1, currentWeight, dp);

        return dp[index][currentWeight] = Math.max(a, b);
    }

    // This Tabulation is Wrong --
    public static int MaxValue_Tabulation(int[]val , int[]weights, int W, int[][]dp){

        int rows = val.length;
        int cols = W+1;

        // Base Case for Tabulation -
        for(int i=0; i<cols; i++) dp[0][i] = ((W - i)/weights[0])*val[0];


        for(int i=1; i<rows; i++){
            for(int j=cols-1; j>=0; j--){

                int non_take = dp[i-1][j];

                int take = 0;

                if(j+weights[i] <= W){
                    take = dp[i][j+weights[i]];
                }

                dp[i][j] = Math.max(take, non_take);
                System.out.println(i +" "+j+" "+ take+" "+ non_take+" "+ dp[i][j]);
            }
        }

        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++) System.out.print(dp[i][j]+" ");
            System.out.println("Hii");
        }

        return dp[rows-1][0];
    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Number of Elements :- ");
        int n = sc.nextInt();
        int W = sc.nextInt();
        int[]weights = new int[n];
        int[]val = new int[n];
        for(int i=0; i<n; i++)val[i]=sc.nextInt();
        for(int i=0; i<n; i++)weights[i]=sc.nextInt();

        int[][]dp1 = new int[n][W+1];  for(int i=0; i<n; i++) Arrays.fill(dp1[i], -1);
        int[][]dp2 = new int[n][W+1];
        System.out.println("Maximum Value That can be Made is :- " + MaxValue_Memoization(val, weights, W, n-1, 0, dp1));
        System.out.println("Maximum Value That can be Made is :- " + MaxValue_Tabulation(val, weights,W, dp2));
    }
}

