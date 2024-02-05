package DSA.Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * Approch -> Just relaxes edges for N-1 iteration till then we will got minimum distances .. But if there is Negative weight
 *            Cycle it will Again give less distances so if it is we will return -1 to all distances . Because there is
 *            Negative weight cycles.
 *
 *
 *
 *            TC - O(V * E)
 *            SC - O( V )
 *
 *
 *     While Dijastra has O(ElogV) TC.
 * **/
public class Bellman_Ford_Algorithm{

    public static void Fill_Bellman(ArrayList<ArrayList<Integer>>connections, int[]dis, int src){

        dis[src]=0;
        int v=dis.length;
        int e = connections.size();

        for(int i=0; i<v-1; i++){

            for(int j=0; j<e; j++){

                int p = connections.get(j).get(0);
                int q = connections.get(j).get(1);
                int wt = connections.get(j).get(2);

                if(dis[p]!=(int)1e8 && dis[p] + wt < dis[q]){

                    dis[q]=dis[p] + wt;
                }

            }
        }


        // Checking That if Graph will have Negative weight Cycle by using Nth iteration over all Edges.

        for(int j=0; j<e; j++){
            int p = connections.get(j).get(0);
            int q = connections.get(j).get(1);
            int wt = connections.get(j).get(2);

            if(dis[p]!=(int)1e8 && dis[p] + wt < dis[q]){

                Arrays.fill(dis, -1);
                break;
            }
        }


    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int v=sc.nextInt();

        int e=sc.nextInt();

        ArrayList<ArrayList<Integer>>connections=new ArrayList<>();

        for(int i=0; i<e; i++)connections.add(new ArrayList<>());

        for(int i=0; i<e; i++){

            for(int j=0; j<=2; j++) connections.get(i).add(sc.nextInt());
        }

        int src = sc.nextInt();

        int[]dis=new int[v];
        Arrays.fill(dis, (int)1e8);

        Fill_Bellman(connections, dis, src);

        System.out.println(Arrays.toString(dis));
    }
}
