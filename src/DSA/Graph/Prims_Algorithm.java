package DSA.Graph;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 *
 * Priority Queue Solution :
 * Used DataStructure is : Visited array , Priority Queue , ArrayList<ArrayList<Pair>>adjcent Matrix
 * Intution : Go for every imndex and explore all paths and add them to pq with parent(because anyone satisy node-parent will be stored in ans)
 *            and sort them according to weight and then at last store visited[node] as visited.
 *
 *
 *
 * TC - O(ElogE + ElogE) = ElogE
 * SC - O(V^2) or O(E)
 *
 *
 * **/


class PrimsPair{

    int wt;
    int node;
    int parent;

    PrimsPair(int wt, int node, int parent){
        this.wt=wt;
        this.node=node;
        this.parent=parent;
    }
}


class PrimsadjPair{

    int v2;
    int weight;

    PrimsadjPair(int v2, int w){
        this.v2=v2;
        this.weight=w;

    }
}
public class Prims_Algorithm {

    static int MstWeight=0;
    public static void Fill_mst(ArrayList<ArrayList<PrimsadjPair>>adj , int[]visited ,ArrayList<ArrayList<Integer>>mst){


        PriorityQueue<PrimsPair>pq=new PriorityQueue<>((a, b)->{
            if(a.wt!=b.wt)return a.wt-b.wt;
            if(a.node!=b.node)return a.node-b.node;
            return a.parent-b.parent;
        });

        // I am Always Considering 0 As source Vertex.
        pq.add(new PrimsPair(0, 0, -1));

        while (!pq.isEmpty()){

            PrimsPair front = pq.poll();
            int wt=front.wt;
            int node = front.node;
            int parent = front.parent;



           if(visited[node]==0){
               visited[node]=1;
               MstWeight+=wt;
               ArrayList<Integer>temp=new ArrayList<>();
               temp.add(node);
               temp.add(parent);
               if(parent!=-1)mst.add(temp);

           }

            for(PrimsadjPair pair : adj.get(node)){

                int v2 = pair.v2;
                int weight = pair.weight;

               if(visited[v2]==0){

//                   System.out.println(weight+" "+v2+" "+node);
                   pq.add(new PrimsPair(weight , v2, node));
               }
            }
        }

    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int V = sc.nextInt();
        int E =sc.nextInt();

        int[][]edges = new int[E][3];

        for(int i=0; i<E; i++){
            int a = sc.nextInt();
            int b=sc.nextInt();
            int c=sc.nextInt();

            edges[i][0]=a;
            edges[i][1]=b;
            edges[i][2]=c;
        }

     ArrayList<ArrayList<PrimsadjPair>>adj = new ArrayList<>();
        for(int i=0; i<V; i++)adj.add(new ArrayList<>());

        for(int i=0; i<E; i++){

            adj.get(edges[i][0]).add(new PrimsadjPair(edges[i][1] , edges[i][2]));
            adj.get(edges[i][1]).add(new PrimsadjPair(edges[i][0] , edges[i][2]));
        }


   int[]visited=new int[V];
   ArrayList<ArrayList<Integer>>mst=new ArrayList<>();
//        System.out.println(adj);
        Fill_mst(adj, visited , mst);

        System.out.println(mst);
        System.out.println(MstWeight);
    }
}
