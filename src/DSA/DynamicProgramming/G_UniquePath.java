package DSA.DynamicProgramming;

import java.util.Arrays;
import java.util.Scanner;

public class G_UniquePath {

    public static int UniquePaths(int rows, int cols, int[][]dp){

        dp[rows-1][cols-1]=1;

        for(int i=rows-1; i>=0; i--){
            for(int j=cols-1; j>=0; j--){

                if(dp[i][j]!=-1){

                    dp[i][j] = (i+1 < rows)?dp[i+1][j]:0 + ((j+1<cols)?dp[i][j+1]:0);
                }
            }
        }
        return dp[0][0];
    }
    public static void main(String[] args) {

        System.out.println("Enter the Number of Rows -");
        Scanner sc = new Scanner(System.in);
        int rows = sc.nextInt();
        System.out.println("Enter the Number of Cols - ");
        int cols = sc.nextInt();


        int[][]dp = new int[rows][cols];
        for(int i=0; i<rows; i++) Arrays.fill(dp[i], -1);


        System.out.println("Number of Unique Paths is :- " + UniquePaths(rows, cols, dp));

    }
}
