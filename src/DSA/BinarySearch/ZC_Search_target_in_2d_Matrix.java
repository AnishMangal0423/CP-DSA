package DSA.BinarySearch;

import java.util.Scanner;
/***
 *
 * Just use simple 2d method only
 *
 * TC - O(Log(m * n))
 * SC - O(1)
 *
 * */
public class ZC_Search_target_in_2d_Matrix{

    public static int GetValue(int[][]grid, int value){

        int cols = grid[0].length;

        int rowNo = value/cols;
        int colNo = value%cols;

        return grid[rowNo][colNo];
    }
    public static boolean isPresent(int[][]grid, int target){

        int row = grid.length;
        int col = grid[0].length;

        int s = 0;
        int e = row*col-1;

        while (s <= e){

            int mid = (s + e)/2;

            int val = GetValue(grid, mid);

            if(val==target)return true;
            else if(val > target)e=mid-1;
            else s = mid+1;
        }

        return false;
    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int row = sc.nextInt();
        int col = sc.nextInt();

        int[][]grid = new int[row][col];
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++)grid[i][j]=sc.nextInt();
        }
        System.out.println("Enter the Target element : ");
        int target = sc.nextInt();

        System.out.println("is Traget Element in grid ?: " + isPresent(grid, target));

    }
}
