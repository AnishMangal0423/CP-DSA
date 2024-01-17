package DSA.DP;

import java.nio.file.Path;
import java.util.Scanner;

public class Minimum_Path_Sum{

    public static int PathSum(int[][]grid, int m , int n , int i, int j){

        if(i==m-1 && j==n-1) return grid[i][j];
        if(i>=m || j>=n) return 10000;

        return Math.min(grid[i][j]+PathSum(grid, m, n, i+1, j), grid[i][j]+PathSum(grid, m, n, i, j+1));
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int m=sc.nextInt();
        int n=sc.nextInt();

        int[][]grid=new int[m][n];

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){

                grid[i][j]=sc.nextInt();
            }
        }


        System.out.println(PathSum(grid, m, n, 0, 0));

    }
}
