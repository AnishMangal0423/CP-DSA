package DSA.DynamicProgramming;
import java.util.Arrays;
import java.util.Scanner;

/***
 *
 * Tabulation Method -
 *  Time Compelxity - O( Row * Col )
 *  Space Complexity - O(Row * Col )
 * */

public class G_UniquePath {
    public static int UniquePaths(int rows, int cols, int[][]dp){

       for(int i=0; i<cols; i++)dp[rows-1][i]=1;
       for(int j=0; j<rows; j++)dp[j][cols-1]=1;

       for(int i=rows-2; i>=0; i--){
            for(int j=cols-2; j>=0; j--){

                dp[i][j] = dp[i+1][j] + dp[i][j+1];

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
