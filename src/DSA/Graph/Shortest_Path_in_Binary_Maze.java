package DSA.Graph;

import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;

class MatrixPair {

    int distance;
    int i;
    int j;

    MatrixPair(int distance, int i, int j) {
        this.distance = distance;
        this.i = i;
        this.j = j;
    }

}



public class Shortest_Path_in_Binary_Maze{


    public static int Dijkastra_Algo(int[][]matrix , int[][]dis, int i, int j, int m, int n){

        dis[i][j]=0;
        PriorityQueue<MatrixPair>pq=new PriorityQueue<>((a, b)->{

            if(a.distance!=b.distance)return a.distance-b.distance;
            if(a.i!=b.i)return a.i-b.i;
            return a.j-b.j;
        });
        if(matrix[i][j]==0)pq.add(new MatrixPair(1, i, j));

        while (!pq.isEmpty()){

            int size=pq.size();

            for(int k=0; k<size; k++){

                MatrixPair pair=pq.poll();
                int distance = pair.distance;
                int ii=pair.i;
                int jj=pair.j;

                if(ii==m-1 && jj==n-1)return dis[ii][jj];
                int[]xcor={0, 1, 1, 1, 0, -1, -1, -1};
                int[]ycor={1, 1, 0, -1, -1, -1, 0, 1};


                for(int path=0; path<8; path++){

                    int tempx=ii+xcor[path];
                    int tempy=jj+ycor[path];


                    if(tempx>=0 && tempx<m && tempy>=0 && tempy<n && matrix[tempx][tempy]==0 && distance+1 < dis[tempx][tempy]){
                        dis[tempx][tempy]=distance+1;
                        pq.add(new MatrixPair(distance+1 , tempx, tempy));
                    }

                }


            }
        }
return -1;

    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int m=sc.nextInt();
        int n=sc.nextInt();

        int[][]matrix=new int[m][n];
        int[][]dis=new int[m][n];

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                matrix[i][j]=sc.nextInt();
                dis[i][j]=Integer.MAX_VALUE;
            }
        }

        System.out.println(Dijkastra_Algo(matrix, dis, 0, 0, m, n));

    }
}
