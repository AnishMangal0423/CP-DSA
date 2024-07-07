package DSA.DynamicProgramming;
import java.util.Arrays;
import java.util.Scanner;


/**
 Memoization Complexity --

 TC - O(LenofRod * LenofRod)
 SC - O(LenofRod * LenofRod) + 2 O(LenofRod) [arr space , stack space]

 Tabulation Complexity --

 TC - O(LenofRod * LenofRod)
 SC - O(LenofRod * LenofRod) + O(LenofRod)


 Hint :- Ek simple si Baat btata ta hu Agar tumhe Rod cut ki problem ko solve krna h to thik wesa hi Manoo , jese hmme koi array
         Given h and osme se kuch elements take non_take krna h , and saath ke saath lenRem ko 0 bhi bnana h ..
         to take pieces ki value hi hmara max ans Hoga.. (Same as array Subsequence. )
 **/
public class S_RodCut {

    public static int RodCut_Memoization(int[]arr, int[]prices, int index, int lenRem, int[][]dp1){

        if(index < 0) return 0;
        if(lenRem==1) return prices[0];
        if(dp1[index][lenRem]!=-1)return dp1[index][lenRem];
        // Non_Take -

        int Non_Take = RodCut_Memoization(arr, prices, index-1, lenRem, dp1);

        int Take = 0;

        if(lenRem-arr[index]>=0){
            Take = prices[index] + RodCut_Memoization(arr, prices, index, lenRem-(arr[index]), dp1);
        }

        return dp1[index][lenRem] = Math.max(Non_Take, Take);
    }

    public static int RodCut_Tabulation(int[]arr, int[]prices, int[][]dp){

        // Base Cases + Recurence For Loops and fill the Dp and Get the Answers.  --> Tabulation Rule.

        // 1. Base Case.
        for(int i=0; i<dp[0].length; i++) dp[0][i] = (i*prices[0]);

        // 2. Recurence Relation for Loops-
        for(int i=1; i<dp.length; i++){
            for(int j=1; j<dp[0].length; j++){

                int Non_take = dp[i-1][j];

                int take = 0;

                if(j-arr[i] >=0){
                    take = prices[i] + dp[i][j - arr[i]];
                }

                dp[i][j] = Math.max(take, Non_take);
            }
        }

        return dp[dp.length-1][dp[0].length-1];
    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // n= 8 -> {1, 2....8}
        int[]arr = new int[n]; for(int i=0; i<arr.length; i++)arr[i]=i+1;
        int[]prices = new int[n];
        for(int i=0; i<n; i++)prices[i]=sc.nextInt();

        int[][]dp1 = new int[n][n+1];
        for(int i=0; i<dp1.length; i++) Arrays.fill(dp1[i], -1);

        int[][]dp2 = new int[n][n+1];
        System.out.println("Maximum Price that I will Get By Memoization is ?: " + RodCut_Memoization(arr, prices, n-1, n, dp1));
        System.out.println("Maximum Price that I will Get By Tabulation is ?: " + RodCut_Tabulation(arr, prices, dp2));
    }
}

