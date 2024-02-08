package DSA.Graph;

import java.util.Arrays;
import java.util.Scanner;

public class City_with_Minimum_Neighbours_at_Threshold_Distance{


    public static void  Floyyd_Warshal(int[][]edges_Modified, int v){

        for(int via =0; via < v; via ++){

            for(int i=0; i<v; i++){

                for(int j=0; j<v; j++){


               if(edges_Modified[i][via]!=Integer.MAX_VALUE && edges_Modified[via][j]!=Integer.MAX_VALUE)
                   edges_Modified[i][j] = Math.min(edges_Modified[i][j] , edges_Modified[i][via] + edges_Modified[via][j]);

                }
            }
        }


    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int v=sc.nextInt();
        int e = sc.nextInt();

        int[][]edges_Modified = new int[v][v];
        for (int i=0; i<v; i++){
            for(int j=0; j<v; j++){
                if(i==j)edges_Modified[i][j]=0;
                else edges_Modified[i][j]=Integer.MAX_VALUE;
            }
        }

        for(int i=0; i<e; i++){

            int v1 = sc.nextInt();
            int v2 = sc.nextInt();
            int wt = sc.nextInt();

            edges_Modified[v1][v2]=wt;
            edges_Modified[v2][v1]=wt;
        }

        int threshold = sc.nextInt();

        Floyyd_Warshal(edges_Modified , v);


        int mini = v ,city =-1;

        for(int i=0; i<v; i++){

            int count =0;
            for(int j=0; j<v; j++){

                if(i==j)continue;
                if(edges_Modified[i][j] <= threshold)count++;
            }
//            System.out.println("hii : "+count);
            if(count <= mini){
                mini=count;
                city=i;
            }
        }

        System.out.println(city);
    }
}
