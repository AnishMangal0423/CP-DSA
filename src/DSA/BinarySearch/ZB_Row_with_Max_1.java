package DSA.BinarySearch;

import java.util.Scanner;
/**
 *
 * Approch :- Just found the lower bound of every array with 1 then direct compare.
 *
 * **/
public class ZB_Row_with_Max_1{

    public static int OnesCount(int[][]grid, int rowNo){

        int row = grid.length;
        int col = grid[0].length;

        int s = 0;
        int e = col-1;
        int ans = Integer.MAX_VALUE;

        while (s <= e){

            int mid = (s + e)/2;

            if(grid[rowNo][mid]==1){
                ans = Math.min(ans, mid);
                e=mid-1;
            }

            else s=mid+1;

        }
        return ans;
    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int row = sc.nextInt();
        int col = sc.nextInt();

       int[][]grid = new int[row][col];
       for(int i=0; i<row; i++){
           for(int j=0; j<col; j++)grid[i][j]=sc.nextInt();
       }

       // finding the maximum's-
        int ans = Integer.MAX_VALUE;
       int index = -1;

       for(int i=0; i<row; i++){

            int count = OnesCount(grid, i);
            if(count < ans){
                index = i;
                ans = count;
            }
       }

        System.out.println("row with maximum Number of one's is ?: " + (index));


    }
}
