package DSA.DP;

import java.util.*;



/**
 *   s1 + s2 = totalsum
 *   s1 - s2 = d
 *
 *   s2 = (totalsum - d)/2
 *
 *   we can do space Optimization/time complexity in it also.
 *
 * **/
public class Partiton_with_Given_Difference{

    static int MOD =(int)Math.pow(10, 9) + 7;
    public static int Ways(int[]arr,int diff, int i, int s1_sum, int sum, int[][]dp){

        int s2_sum = sum - s1_sum;
        if(s1_sum - s2_sum == diff) return 1;
        if(i>=arr.length)return 0;
        if(dp[i][s1_sum]!=-1)return dp[i][s1_sum];
        // take-

        int take = Ways(arr, diff, i+1, s1_sum+arr[i], sum, dp);

        // non-take
        int non_take = Ways(arr, diff,i+1, s1_sum, sum, dp);

        return dp[i][s1_sum]= (take%MOD + non_take%MOD) %MOD;

    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n=sc.nextInt();
        int d=sc.nextInt();

        int[]arr=new int[n];
        for(int i=0; i<n; i++){
            arr[i]=sc.nextInt();
        }
        int sum=0;
        for(int i=0; i<n; i++)sum+=arr[i];
        int[][]dp=new int[n][sum+1];

        for(int i=0; i<n; i++)Arrays.fill(dp[i], -1);

        int a =(Ways(arr, d,0, 0, sum, dp));
        for(int i=0; i<n; i++) System.out.println(Arrays.toString(dp[i]));
        System.out.println(a);
    }
}
