package DSA.DynamicProgramming;
import java.util.Arrays;
import java.util.Scanner;


/***
 *
 * The Most Important Thing  in this Question is , Ye Figure Out krna ki Dono saath mai kese Chalenge and Hmm kese Chalenge
 * Oske (Exploration ways) ko Ppaer pe Matrix bnakar wo jo 9 possibilities wali chizz h that's is the most Important.
 *
 *
 * Memoization -
 *
 * TC - O(N * M * M)
 * SC - O(N * M * M) + O(N) --> Stack Space.
 *
 *
 *Tabulation -
 *
 * TC - O(N * M * M)
 * SC - O(N * M * M)
 *
 * **/
public class L_Ninja_andits_Friends {


    public static int MaxChoclatesTabulate(int[][]matrix, int[][][]dp, int row, int col1, int col2){

        int rows = matrix.length;
        int cols = matrix[0].length;

        // Base Case Condition -
        for(int i=0; i<cols; i++){
            for(int j=0; j<cols; j++){
                if(i==j){
                    dp[(rows-1)][i][j] = matrix[(rows-1)][i];
                }

                else{
                    dp[(rows-1)][i][j] = matrix[(rows-1)][i] + matrix[(rows-1)][j];
                }
            }
        }


        // Tabulation -

        for(int i=(rows-2); i>=0; i--){
            for(int j=0; j<cols; j++){
                for(int k=0; k<cols; k++){

                    for(int l=-1; l<2; l++){
                        for(int m=-1; m<2; m++) {

                            if (j + l >= 0 && j + l < cols && k + m >= 0 && k + m < cols) {
                                if (j == k) {
                                    dp[i][j][k] = Math.max(dp[i][j][k], matrix[i][j] + dp[i + 1][j + l][k + m]);
                                } else {
                                    dp[i][j][k] = Math.max(dp[i][j][k], matrix[i][j] + matrix[i][k] + dp[i + 1][j + l][k + m]);
                                }
                            }
                        }
                    }

                }
            }
        }

        return dp[0][col1][col2];
    }
    // Memoized Code -
    public static int MaxChoclates(int[][]matrix, int[][][]dp, int row, int col1, int col2){

        int rows = matrix.length;
        int cols = matrix[0].length;
        if(col1<0 || col2<0 || col1 >=cols || col2>=cols)return 0;
        if(dp[row][col1][col2]!=-1)return dp[row][col1][col2];
        if(row >= rows)return 0;

        if(row == rows-1){
            if(col1==col2)return matrix[row][col1];
            else return matrix[row][col1] + matrix[row][col2];
        }

        int[]dir = {-1, 0, 1};
        int maxi = -1;

      for(int i=0; i<3; i++) {
          for (int j = 0; j < 3; j++) {

              if (col1 == col2) {

                  maxi = Math.max(maxi, matrix[row][col1]+ MaxChoclates(matrix, dp, row+1, col1+dir[i] , col2+dir[j]));
              } else {
                  maxi = Math.max(maxi, matrix[row][col1] + matrix[row][col2] + MaxChoclates(matrix, dp, row + 1, col1 + dir[i], col2 + dir[j]));
              }
          }

      }

        return dp[row][col1][col2]=maxi;

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
        int[][][]dp = new int[rows][cols][cols];
        for(int i=0; i<rows; i++) {
         for(int j=0; j<cols; j++){
             Arrays.fill(dp[i][j], -1);
         }
        }

        System.out.println("Maximum Choclates PickedUp are :- " + MaxChoclatesTabulate(matrix, dp, 0, 0, cols-1));
    }
}
