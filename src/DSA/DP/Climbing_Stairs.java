package DSA.DP;

import java.util.Arrays;
import java.util.Scanner;

public class Climbing_Stairs{


    public static int Ways(int n, int[]dp){

        if(n==0 || n==1)return 1;

        if(dp[n]!=-1) return dp[n];

        return dp[n] = Ways(n-1,dp)+Ways(n-2,dp);
    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of stairs");
        int stairs = sc.nextInt();
        int[]dp = new int[stairs+1];
        Arrays.fill(dp , -1);
        System.out.println(Ways(stairs, dp));

    }
}
