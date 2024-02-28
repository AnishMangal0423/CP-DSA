package DSA.Graph;

import java.util.*;


/**
 *
 * Topic --> Graphs & Compnoents Discussion .
 * Concept --> Calculation of Componoents Size.
 * Approch --> 1. We will go to Every Compnoents and Calculate Their Sizes.
 *             2. Fill that Component with The Size of Compnoent.
 *             3. Store the Component serial Number in Visited Matrix.
 *             4. Now Go for every 0 and check it's 4 Boundries islands if that is only 1 islands then islands +1 ans hoga.
 *             5. Else adosi padosi islands ka sum +1 ko maximise karna h .
 *
 *
 * Edge Cases -->
 *             1. Will have to use HashSet to Solve the probem of Same Island in all 4 Directions.
 *
 *
 * Time Complexity :- O(N * N)
 * Space Complexity :- O(N * N)
 *
 * Learning --> 1. Working of HashSet with Pairs.
 *              2. Calculation of size of Compnenets.
 *              3. Edge Cases Logic.
 *
 * **/
class IslandsPair{

    int i;
    int j;

    IslandsPair(int i, int j){
        this.i=i;
        this.j=j;
    }

}
public class Making_a_Large_Island{

    static int[][]coord = {{-1, 0} , {0, 1}, {1, 0}, {0, -1}};
    public static int Size_of_Island(int[][]grid, int[][]visited1, int i, int j, int n){

        visited1[i][j]=1;

        int maxi = 1;
        for(int[]cord : coord){

            int x = i + cord[0];
            int y = j + cord[1];

            if(x>=0 && y>=0 && x<n && y<n && visited1[x][y]==0 && grid[x][y]==1){
                visited1[x][y] = 1;
                maxi = Math.max( maxi, maxi + Size_of_Island(grid , visited1 , x, y, n));
            }
        }
        return maxi;
    }

    public static void  Fill_By_Size(int[][]newGrid, int[][]visited1, int val, int i, int j, int n, int Island_Number){

        visited1[i][j]=Island_Number;
        newGrid[i][j]=val;

        for(int[]cord : coord){

            int x = i + cord[0];
            int y = j + cord[1];

            if(x>=0 && y>=0 && x<n && y<n && visited1[x][y]==1){
                Fill_By_Size(newGrid , visited1 , val, x , y , n, Island_Number);
            }
        }

    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[][]grid = new int[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++)grid[i][j] = sc.nextInt();
        }

        int[][]visited1 = new int[n][n];
        int[][]newGrid =  new int[n][n];

        // Method to move for all Islands and mark them Visited -

        int Island_Number = 3;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j]==1 && visited1[i][j]==0){

                    int size = Size_of_Island(grid , visited1 ,  i , j, n);
                    System.out.println(size);
                     Fill_By_Size(newGrid ,visited1 , size, i, j, n, Island_Number);
                     Island_Number++;
                }
            }
        }


        int maxSize = 0;

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(newGrid[i][j]==0){
                    HashSet<String>set = new HashSet<>();
                    for(int[]cord : coord){

                        int x = i + cord[0];
                        int y = j + cord[1];
                        if(x>=0 && y>=0 && x<n && y<n){
                            set.add(newGrid[x][y] +","+visited1[x][y]);
                        }
                    }


                   ArrayList<Integer>temp = new ArrayList<>();
                    for(String s : set){
                        String[]arr = s.split(",");
                        temp.add(Integer.parseInt(arr[0]));
                    }
                    Collections.sort(temp);
                    int nn = temp.size();

                    int sum = 0;
                    for(int ii : temp)sum+=ii;

                    maxSize= Math.max(maxSize , 1+ sum);
                }
            }
        }

         if(maxSize==0) System.out.println(n*n);
        else System.out.println(maxSize);

    }
}


//7
//        0 0 0 0 0 0 0
//        0 1 1 1 1 0 0
//        0 1 0 0 1 0 0
//        1 0 1 0 1 0 0
//        0 1 0 0 1 0 0
//        0 1 0 0 1 0 0
//        0 1 1 1 1 0 0