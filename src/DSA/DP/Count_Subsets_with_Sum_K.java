package DSA.DP;

import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;

public class Count_Subsets_with_Sum_K{

    static int mod = (int)(1e9+7);
    public static int Subsets(int[]arr, int[][]dp, int i, int target){

        if(target==0) return 1;
        if(i >= arr.length) return 0;
        if(dp[i][target]!=-1)return dp[i][target];


        // take -
        int take = 0;
        if(target-arr[i] >= 0){
            take = Subsets(arr, dp,i+1, target-arr[i]);
        }

        // Non-take-

        int Non_take = Subsets(arr, dp,i+1, target);

        return dp[i][target]= (take+ Non_take) % mod;


    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n=sc.nextInt();
        int k=sc.nextInt();
        int[]arr=new int[n];


        for(int i=0; i<n; i++)arr[i]=sc.nextInt();

        int[][]dp=new int[n][k+1];
        for(int i=0; i<n; i++) Arrays.fill(dp[i], -1);

        int ans = Subsets(arr, dp , 0, k);

        System.out.println(ans);
    }
}
