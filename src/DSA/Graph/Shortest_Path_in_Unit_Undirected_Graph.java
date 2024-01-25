package DSA.Graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class UG_Pair{

    int vertex;
    int distance;

    UG_Pair(int v, int d){
        this.vertex=v;
        this.distance=d;
    }
}
public class Shortest_Path_in_Unit_Undirected_Graph{

    public static void Fill_Distances(int[][]matrix, int v, int[]dist, int src){

        dist[src]=0;
        Queue<UG_Pair>q=new LinkedList<>();
        q.add(new UG_Pair(src, 0));

        while(!q.isEmpty()){
            int size=q.size();

            for(int i=0; i<size; i++){

                UG_Pair front = q.poll();
                int vertex=front.vertex;
                int distance = front.distance;

                for(int j=0; j<v; j++){

                    if(matrix[vertex][j]==1 && distance+1 < dist[j]){
                        dist[j]=distance+1;
                        q.add(new UG_Pair(j, distance+1));
                    }
                }

            }
        }

    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int v=sc.nextInt();
        int e=sc.nextInt();

        int[][]matrix=new int[v][v];

        for(int i=0; i<e; i++) {

            int v1 = sc.nextInt();
            int v2 = sc.nextInt();

            matrix[v1][v2] = 1;
            matrix[v2][v1] = 1;
        }

        int src=sc.nextInt();

        int[]dist=new int[v];
        Arrays.fill(dist, Integer.MAX_VALUE);

        Fill_Distances(matrix, v, dist, src);

        System.out.println(Arrays.toString(dist));
    }
}
