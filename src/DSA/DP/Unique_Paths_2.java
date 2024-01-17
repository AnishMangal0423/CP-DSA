package DSA.DP;

import java.util.Arrays;
import java.util.BitSet;
import java.util.Scanner;

public class Unique_Paths_2{

    public static int Paths(int m, int n, int[][]grid,int[][]dp ,int i, int j){

        if(i >= m || j>= n) return 0;
        if(dp[i][j]!=-1)return dp[i][j];
        if(grid[i][j]==1)return 0;
        if(i==m-1 && j==n-1) return 1;

        return Paths(m, n, grid, dp,i+1, j)+Paths(m, n,grid,dp, i, j+1);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int row=sc.nextInt();
        int col=sc.nextInt();

        int[][]dp=new int[row][col];
        for(int i=0; i<row; i++) Arrays.fill(dp[i], -1);
        int[][]grid=new int[row][col];
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++)grid[i][j]=sc.nextInt();
        }

        System.out.println(Paths(row, col, grid, dp,0, 0));



    }
}
