package DSA.Graph;

import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * Ok so we can use Dijstra Algo in this with weight of energy Difference.
 *
 * TC - ElogV  --> M*N*4* log(M*N)
 * SC - E      --> M*N
 * **/

public class Path_with_Minimum_Effort {

    public static int Calculate_Minimum(int[][]heights, int[][]efforts, int i, int j){

        int m=heights.length;
        int n=heights[0].length;
        efforts[i][j]=0;
        PriorityQueue<MatrixPair>pq=new PriorityQueue<>((a, b)->{
            if(a.distance!=b.distance)return a.distance-b.distance;
            if(a.i!=b.i)return a.i-b.i;
            return a.j-b.j;
        });
        pq.add(new MatrixPair(0, i, j));

        while (!pq.isEmpty()){

            int size = pq.size();

            for(int l=0; l<size; l++){

                MatrixPair front = pq.poll();
                int maxieffort=front.distance;
                int ii=front.i;
                int jj = front.j;

//                System.out.println("Maxeffort : "+maxieffort +" II: "+ii+" JJ: "+jj);
                if(ii==m-1 && jj==n-1) return efforts[ii][jj];
                int[]dx={0, -1, 0, 1};
                int[]dy={-1, 0, 1, 0};


                for(int k=0; k<4; k++){

                    int x = ii + dx[k];
                    int y = jj + dy[k];

                    if(x>=0 && x<m && y>=0 && y<n && Math.max(efforts[ii][jj],Math.abs(heights[x][y]- heights[ii][jj])) < efforts[x][y]){

                        int neweffort=Math.abs(heights[x][y]- heights[ii][jj]);
                        efforts[x][y]=Math.max(efforts[ii][jj], neweffort);
                        pq.add(new MatrixPair(efforts[x][y], x, y));
                    }

                }

            }

        }

return -2;
    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int m=sc.nextInt();
        int n=sc.nextInt();

        int[][]heights=new int[m][n];
        int [][]efforts = new int[m][n];
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                heights[i][j]=sc.nextInt();
                efforts[i][j]=Integer.MAX_VALUE;
            }
        }

        System.out.println(Calculate_Minimum(heights,efforts, 0, 0));
    }
}
