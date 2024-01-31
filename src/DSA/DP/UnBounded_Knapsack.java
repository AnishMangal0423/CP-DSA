package DSA.DP;

import java.util.Arrays;
import java.util.Scanner;

public class UnBounded_Knapsack{

    public static int Max_Cost(int[]val, int[]wt,int[][]dp, int ind, int remaining_wt){

        if(ind >= val.length)return 0;
        if(dp[ind][remaining_wt]!=-1)return dp[ind][remaining_wt];

        int take =0;
        if(remaining_wt-wt[ind] >=0 )take = val[ind] + Max_Cost(val, wt,dp, ind, remaining_wt - wt[ind]); // take


        int Non_take = Max_Cost(val, wt, dp,ind+1, remaining_wt); // Non-take

        return dp[ind][remaining_wt]=Math.max(take, Non_take);
    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int W = sc.nextInt();

        int val[]=new int[N];
        int[]wt = new int[N];

        for(int i=0; i<N; i++)val[i]=sc.nextInt();
        for(int j=0; j<N; j++)wt[j]=sc.nextInt();

        int[][]dp=new int[N][W+1];

        for(int i=0; i<N; i++) Arrays.fill(dp[i], -1);

        System.out.println(Max_Cost(val, wt, dp,0, W));


    }
}
