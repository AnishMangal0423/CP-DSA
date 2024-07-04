package DSA.DynamicProgramming;

import java.util.Arrays;
import java.util.Scanner;

/***
 *
 * Recursion -
 * TC - O(2 ^ noOfRows )
 * SC - O( noOfRows )  --> Stack space.
 *
 *
 * Memoization -
 * TC - O( ROW * COL )
 * SC - O( ROW * COL ) --> dp space + O(Rows) as Stack space..
 *
 * Tabulation -
 *
 * TC - O(ROW * COL )
 * SC - O( ROW * COL )  --> Not Any Stack Space..
 *
 *
 *
 * */
public class F_NinjaTraining {


    // Memoization Method -
    public static int MeritPoints(int[][]matrix, int i, int j, int[][]dp){

        if(i>=matrix.length)return 0;
        if(dp[i][j]!=-1)return dp[i][j];
        int maxi = Integer.MIN_VALUE;
        for(int k=0; k<matrix[0].length; k++){
            if(k==j)continue;
//            System.out.println(i+" "+ j+" "+ maxi);
            maxi= Math.max(maxi , matrix[i][j] + MeritPoints(matrix ,i+1, k, dp));
        }

        return dp[i][j]=maxi;
    }


    // Tabulation Method -

    public static int MaxMeritPointsTabulation(int[][]matrix, int i, int[][]dp){

        int rows = matrix.length;
        for(int k=0; k<matrix[i].length; k++)dp[(rows-1)][k] = matrix[(rows-1)][k];

        for(int row=rows-2; row>=0; row--){
             for(int col = 0; col<matrix[0].length; col++){

                 // Get the Maximum Value for it -

                 int maxi = Integer.MIN_VALUE;

                 for(int cols=0; cols<matrix[0].length; cols++){
                     if(col!=cols){

                         maxi=Math.max(maxi , matrix[row][col]+dp[row+1][cols]);
                     }
                 }

                 dp[row][col]=maxi;
             }
         }

       int maximum =0;
        for(int z=0; z<matrix[0].length; z++){
            maximum = Math.max(maximum, dp[0][z]);
        }

        return maximum;
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


        // By This we can Calculate via Memoization-
        int maximumPoints = 0;
        for(int j=0; j<cols; j++){
            int a = MaxMeritPointsTabulation(matrix , 0, j, dp);
            System.out.println("A "+a);
            maximumPoints=Math.max(maximumPoints , a);
        }


        // BY This we will go via Tabulation-
        System.out.println("Maximum Merit Points that Ninja Can Earn is - " +  MaxMeritPointsTabulation(matrix , 0, dp));

        for(int i=0; i<cols; i++) System.out.println(Arrays.toString(dp[i]));
    }
}
