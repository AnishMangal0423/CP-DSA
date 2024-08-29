package DSA.DynamicProgramming;

import java.util.*;

public class ZD_Maximize_CutSegments {

    public static int MaximumCuts(int len, int[]arr , int index, int[][]dp){

        if(index == 3)return Integer.MIN_VALUE;
        if(len ==0 ){
            return 0;
        }
        if(dp[len][index]!=-1)return dp[len][index];

        // non_take -
        int Non_take = MaximumCuts(len , arr , index+1, dp);

        int take = Integer.MIN_VALUE;
        if(len - arr[index]>=0) {

            take = 1+ MaximumCuts(len - arr[index], arr, index, dp);
        }

        return dp[len][index] = Math.max(take , Non_take);
    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[]arr = new int[3];

        for(int i=0; i<3; i++){
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);

        int[][]dp = new int[n+1][3];
        for(int i=0; i<=n; i++)Arrays.fill(dp[i] , -1);
        System.out.println("Maximum Cut that we Can Make is ?: " + MaximumCuts(n , arr, 0, dp));
        
    }
}
