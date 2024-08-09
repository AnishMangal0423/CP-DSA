package LeetCode.POTD;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class X__SpiralMatrix_3 {


    public static int[][] MakePath(int[][]grid, int rstart  , int cstart){

        int m = grid.length;
        int n = grid[0].length;

        int[]dx  = {0, 1, 0, -1};
        int[]dy = {1, 0, -1, 0};

        int dir = 0;
        int increments = 1;

        int newRow = rstart;
        int newCol = cstart;

        int[][]ans = new int[grid.length * grid[0].length][2];

        ans[0][0] = newRow;
        ans[0][1] = newCol;

        int count = 1;
        while (count < m*n){

            for(int itr=0; itr < 2; itr++){

                for(int j=0; j<increments; j++){


                     newRow += dx[dir];
                     newCol +=  dy[dir];


                    if(newRow >=0 && newCol >=0 && newRow < m && newCol < n){
                        ans[count][0] = newRow;
                        ans[count][1] = newCol;
                        count++;
                    }
                }
               dir=(dir+1)%4;

            }

            increments++;

            System.out.println(ans);
        }

        return ans;
    }


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int rows = sc.nextInt();
        int cols= sc.nextInt();
        int rstart = sc.nextInt();
        int cstart = sc.nextInt();

        int[][]grid = new int[rows][cols];

        System.out.println("The 2D matrix Path we will Follow is ?: ");


        int[][] ans = MakePath(grid , rstart , cstart);

        for(int i=0; i<ans.length; i++){
            System.out.println(Arrays.toString(ans[i]));
        }
    }
}
