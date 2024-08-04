import java.util.ArrayList;
import java.util.HashSet;
import java.util.*;

class Islandpair{

        int ii;
        int  jj;

        Islandpair(int i, int j){

        ii=i;
        jj=j;
        }
        }

        public class Islands{


    public static void callBfs(int i, int j, int[][]grid , boolean[][]visited, HashSet<ArrayList<ArrayList<Integer>>> set){
        int m = grid.length;
        int n = grid[0].length;

        int rowNo = i;
        int ColNo = j;

        int[]dx = {0, -1, 0, 1};
        int[]dy = {-1, 0, 1, 0};

        ArrayList<ArrayList<Integer>>Island = new ArrayList<>();
        Queue<Islandpair> q = new LinkedList<>();
        q.add(new Islandpair(i, j));

        ArrayList<Integer>temp = new ArrayList<>();
        while(!q.isEmpty()){

            Islandpair p = q.poll();

            int ii=p.ii;
            int jj=p.jj;


            temp.add(ii-rowNo);
            temp.add(jj-ColNo);
            Island.add(temp);

            for(int l=0;l<4; l++){

                int newRow = ii+dx[l];
                int newCol = jj + dy[l];


                if(newRow>=0 && newRow <m && newCol>=0 && newCol <n && visited[newRow][newCol]==false && grid[newRow][newCol]==1 ){
                    q.add(new Islandpair(newRow, newCol));
                    visited[newRow][newCol]=true;
                }
            }

        }

        set.add(Island);

    }

    public static void main(String[]args){


        Scanner sc = new Scanner(System.in);

        int n =sc.nextInt();
        int m = sc.nextInt();

        int[][]grid = new int[n][m];
        for(int i=0; i<n; i++){

            for(int j=0; j<m; j++){

                grid[i][j] = sc.nextInt();
            }
        }


        boolean[][]visited = new boolean[n][m];
        HashSet<ArrayList<ArrayList<Integer>>>set = new HashSet<>();

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){

                if(grid[i][j]==1 && visited[i][j] == false){
                    visited[i][j]=true;
                    callBfs(i, j, grid, visited, set);
                }


            }
        }
        System.out.println(set.size());
    }
}
