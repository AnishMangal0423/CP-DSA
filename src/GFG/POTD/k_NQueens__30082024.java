package GFG.POTD;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * Best Part is :- Is baar mene Queens ka isSafe fn bhi ache se optimize kar diya.
 *
 * Time Complexity  :- O(n factorial)
 * Space Complexity :- O(n* (No of Answers))
 *
 * **/
public class  k_NQueens__30082024 {

    public static boolean isSafe(boolean[][]matrix , int i, int j){

      int n = matrix.length;
      int[]dx = {0, -1, -1, -1, 0, 1, 1 , 1};
      int[]dy = {-1, -1, 0, 1, 1, 1, 0, -1};

      for(int dir=0; dir<8; dir++){

          int x = i+dx[dir];
          int y = j+dy[dir];

          while (x>=0 && y>=0 && x<n && y<n){

              if(matrix[x][y]==true)return false;

              x += dx[dir];
              y += dy[dir];
          }
      }

      return true;

    }
    public static void Backtracking(boolean[][]matrix , int i , ArrayList<ArrayList<Integer>>ans, ArrayList<Integer>helper){

        int n = matrix.length;
        if (i == n) {
            ans.add(new ArrayList<>(helper));
            return;
        }


        for(int j=0; j<matrix[0].length; j++){

            if(isSafe(matrix , i , j)==true){

                matrix[i][j] = true;
                helper.add(j+1);
                Backtracking(matrix ,i+1 ,  ans , helper);
                helper.remove(helper.size()-1);
                matrix[i][j] = false;

            }
        }
    }
    public static void main(String[]args){


        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        boolean [][] matrix = new boolean[n][n];

        ArrayList<ArrayList<Integer>>ans = new ArrayList<>();
        ArrayList<Integer>helper = new ArrayList<>();
        Backtracking(matrix , 0, ans, helper);

        System.out.println(ans);
    }
}
