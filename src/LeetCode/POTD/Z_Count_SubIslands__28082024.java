package LeetCode.POTD;

import java.util.Scanner;

public class Z_Count_SubIslands__28082024 {

    static int[]dx = {0, -1, 0, 1};
    static int[]dy = {-1, 0, 1, 0};
    public static int CallIsland(int[][]grid1 , int[][]grid2 , boolean[][]visited, int i, int j){

        visited[i][j] = true;
        int ans = 1;
        if (grid1[i][j] != 1) {
            ans = 0;
        }

        for(int x=0; x<4; x++){

            int xnew = i+dx[x];
            int ynew = j + dy[x];

            if(xnew>=0 && xnew < grid2.length && ynew>=0 && ynew<grid2[0].length && visited[xnew][ynew]==false && grid2[xnew][ynew]==1){
                visited[xnew][ynew]=true;
               ans &=  CallIsland(grid1 , grid2 , visited , xnew , ynew) ;
            }

        }

        return ans;
     }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int r = sc.nextInt();
        int c = sc.nextInt();

        int[][] grid1 = new int[r][c];
        int[][]grid2 = new int[r][c];


      for(int i=0; i<r; i++){
          for(int j=0; j<c; j++)grid1[i][j] = sc.nextInt();
      }

      for(int i=0; i<r; i++){
          for(int j=0; j<c; j++)grid2[i][j] = sc.nextInt();
      }


        System.out.println("Number of Good Islands are ?: ");

      boolean[][]visited = new boolean[r][c];
      int ans = 0;
      for(int i=0; i<r; i++){

          for(int j=0; j<c; j++){

              if(visited[i][j]==false && grid2[i][j]==1){

                  visited[i][j] = true;
                  int val = CallIsland(grid1 , grid2 , visited , i, j);

                  ans += val;
              }
          }
      }

        System.out.println(ans);
    }
}
