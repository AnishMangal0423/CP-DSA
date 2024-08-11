package LeetCode.POTD;

import java.util.Scanner;

public class Y__MagicSqaures_inGrid {


    public static boolean CheckSquare(int[][]grid, int i, int j){

        // First Check rows-

        int sumrow = grid[i][j] + grid[i][j+1] + grid[i][j+2];
        for(int ii=i+1; ii<i+3; ii++){

            int sum1 = 0;
            for(int jj=j; jj<j+3; jj++){

                sum1+= grid[ii][jj];
            }

           if(sum1!=sumrow)return false;
        }


        int sumdiag1 = grid[i][j] + grid[i+1][j+1] + grid[i+2][j+2];
        int sumdiag2 = grid[i][j+2] + grid[i+1][j+1] + grid[i+2][j];

        if(sumdiag1!=sumdiag2)return false;

        return true;
    }

    public static int MagicSquares (int[][]grid){

        int rows = grid.length;
        int cols = grid[0].length;

        // Now going to Make the sqaures -

//rows = 3, cols = 4;
        int count = 0;
        for(int i=0; i<=rows-3; i++){
            for(int j=0; j<=cols-3; j++){

                count += (CheckSquare(grid , i , j) == true)?1 : 0;
            }
        }

        return count;
    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int row = sc.nextInt();
        int col = sc.nextInt();

        int[][]grid = new int[row][col];

        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){

                grid[i][j] = sc.nextInt();
            }
        }


        System.out.println("The Total Number of 3*3 Magic Sqaures are ?: " + MagicSquares(grid));

    }
}