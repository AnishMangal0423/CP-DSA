package DSA.Graph;

import java.util.*;

class WDAG_Pair{

    int v2;
    int weight;

    WDAG_Pair(int v2, int weight){
        this.v2=v2;
        this.weight=weight;
    }
}
public class Shortest_Distance_in_Weighted_DAG{

    public static void Fill_Distance(ArrayList<ArrayList<WDAG_Pair>>matrix, int[]dis, int src){

        dis[src]=0;
        Queue<WDAG_Pair>q=new LinkedList<>();
        q.add(new WDAG_Pair(0, 0));

        while (!q.isEmpty()){

            int size = q.size();

            for(int i=0; i<size; i++){

                WDAG_Pair front = q.poll();
                int v1 = front.v2;
                int distance=front.weight;

                for(WDAG_Pair p : matrix.get(v1)){

                    int v2=p.v2;
                    int weight = p.weight;

                    if(v1!=v2 && distance+weight < dis[v2]){

                        dis[v2]=distance+weight;
                        q.add(new WDAG_Pair(v2, distance+weight));
                    }
                }


            }
        }

    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int v = sc.nextInt();
        int e = sc.nextInt();
        ArrayList<ArrayList<WDAG_Pair>>matrix=new ArrayList<>();

        for(int i=0; i<v; i++)matrix.add(new ArrayList<WDAG_Pair>());

        for(int i=0; i<e; i++){
            int v1=sc.nextInt();
            int v2=sc.nextInt();
            int w=sc.nextInt();

            matrix.get(v1).add(new WDAG_Pair(v2, w));
        }

        int[]dis=new int[v];
        Arrays.fill(dis, Integer.MAX_VALUE);

        Fill_Distance(matrix, dis, 0);

        for(int i=0; i<v; i++) if(dis[i]==Integer.MAX_VALUE)dis[i]=-1;

        System.out.println(Arrays.toString(dis));
    }
}
