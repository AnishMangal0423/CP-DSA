package DSA.DynamicProgramming;

import java.util.Arrays;
import java.util.Scanner;

public class K_MinimumFalling_PathSum {

    public static int MinSum_Memoziation(int[][]matrix, int[][]dp, int i, int j){

        int rows = matrix.length;
        int cols = matrix[0].length;
        if(j<0 || j>=cols)return (int)1e6;
        if(i>=rows)return 0;

        int min = Integer.MAX_VALUE;
        for(int dj=-1; dj<=1; dj++){
            min = Math.min(min, matrix[i][j] + MinSum_Memoziation(matrix, dp, i+1, j+dj));
        }
        return min;
    }

    public static int MinSum_Tabulate(int[][]matrix, int[][]dp, int i, int j){

        int rows = matrix.length;
        int cols = matrix[0].length;
         // Base Case -

        for(int k=0; k<cols; k++)dp[rows-1][k] = matrix[rows-1][k];

        for(int row=rows-2; row>=0; row--){
            for(int col=0; col<cols; col++){

                for(int dj=-1; dj<=1; dj++){

                    int combinedcol = col + dj;

                    if(combinedcol >=0 && combinedcol < cols){
                        dp[row][col] = Math.min(dp[row][col] , matrix[row][col]+dp[row+1][combinedcol]);
                    }
                }
            }
        }
        int mini = Integer.MAX_VALUE;

        for(int z=0; z<cols; z++)mini=Math.min(mini, dp[0][z]);

        return mini;
    }
    public static void main(String[] args) {

        System.out.println("Enter the Number of Rows -");
        Scanner sc = new Scanner(System.in);
        int rows = sc.nextInt();
        System.out.println("Enter the Number of Cols - ");
        int cols = sc.nextInt();

        int[][]matrix = new int[rows][cols];
        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                matrix[i][j]=sc.nextInt();
            }
        }
        int[][]dp = new int[rows][cols];
        for(int i=0; i<rows; i++) Arrays.fill(dp[i], Integer.MAX_VALUE);

        int min = Integer.MAX_VALUE;
        for(int j=0; j<cols; j++) {
            min = Math.min(min,MinSum_Memoziation(matrix, dp, 0, j));

        }

        System.out.println("Minimum Fall Path sum is ?: " +MinSum_Tabulate(matrix, dp, 0, 0));
        System.out.println("Minimum Fall Path Sum is ?: " + min);
    }
}
