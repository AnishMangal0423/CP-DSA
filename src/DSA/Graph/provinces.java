package DSA.Graph;

import java.util.*;

public class provinces{

    public static void provinces(int[][]matrix, boolean[]visited, int sv, int v){

        visited[sv] = true;

        for(int i=1; i<=v; i++){

            if(matrix[sv][i]==1 && visited[i]==false) provinces(matrix, visited, i, v);
        }

    }

    public static void main(String[]args){

        Scanner sc = new Scanner(System.in);

        int v = sc.nextInt();
        int e = sc.nextInt();

        int[][]matrix = new int[v+1][v+1];
        for(int i=0; i<e; i++){

            int v1 = sc.nextInt();
            int v2 = sc.nextInt();
            matrix[v1][v2] = 1;
            matrix[v2][v1] = 1;
        }

        boolean[]visited = new boolean[v+1];
        int k =0;
        for(int i=1; i<=v; i++)
            if(visited[i] == false){
                k++;
                provinces(matrix, visited, 0, v);

            }
        System.out.println(k);
    }

}