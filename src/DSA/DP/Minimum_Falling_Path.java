package DSA.DP;

import java.util.Scanner;

public class Minimum_Falling_Path {

    public static int Path(int[][]grid, int i, int j, int m, int n){

        if(i>=m || j>=n || j<0) return 100000;

        if(i==m-1) return grid[i][j];



        return grid[i][j]+Math.min(Path(grid, i+1, j-1, m ,n), Math.min(Path(grid, i+1, j, m, n), Path(grid, i+1, j+1,m,n)));
    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int m = sc.nextInt();
        int n = sc.nextInt();

        int[][] grid = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) grid[i][j] = sc.nextInt();
        }

      int mini=Integer.MAX_VALUE;
        for (int i = 0; i < n; i++){

            mini=Math.min(mini, Path(grid, 0, i, m, n));
        }

        System.out.println(mini);
    }

}