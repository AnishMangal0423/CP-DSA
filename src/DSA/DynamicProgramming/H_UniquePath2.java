package DSA.DynamicProgramming;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Tabulation Method -
 *
 *  TC - O(ROW * COL)
 *  SC - O(ROW * COL)
 *
 * **/
public class H_UniquePath2 {

    public static int Unique_Paths(int[][]matrix, int[][]dp){

        int rows = matrix.length;
        int cols = matrix[0].length;
//        System.out.println("Rows "+ rows+" "+ cols);
        dp[rows-1][cols-1]=1;

        for(int i=rows-1; i>=0; i--){
            for(int j=cols-1; j>=0; j--){

                if(dp[i][j]!=1){

                    if(matrix[i][j]==1)dp[i][j]=0;
                    else{
                        dp[i][j] = ((i + 1 < rows) ? dp[i + 1][j] : 0) + ((j + 1 < cols) ? dp[i][j + 1] : 0);
                    }
                }
            }
        }
     for(int i=0; i<rows; i++) System.out.println(Arrays.toString(dp[i]));
        return dp[0][0];
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
        for(int i=0; i<rows; i++) Arrays.fill(dp[i], -1);

        System.out.println("The Number of Unique Paths are ?:- "+ Unique_Paths(matrix, dp));

    }


}
