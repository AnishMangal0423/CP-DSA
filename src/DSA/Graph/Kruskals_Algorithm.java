package DSA.Graph;

import java.util.*;

/**
 *
 * Approch -> First of Collect all Edges and then Sort them accordings to their weights and then use DSU if their
 *            Ultimate Parents are not same(are in Diff Components) we can add them in MST and then made Mst with paths and all.
 *
 *
 *            TC - O(ElogV or ElogE for sorting) + 4 alpha and all
 *            SC - O(E)
 *
 *
 * **/

class Disjoint_Set{

    int N;
    int[]parent;
    int[]size;

    Disjoint_Set(int N){
        this.N = N;
        parent = new int[N+1];
        size = new int[N+1];

        for(int i=0; i<=N; i++){
            parent[i]=i;
        }

        Arrays.fill(size, 1);
    }

    int Ultimate_Parent(int node){

        if(parent[node]==node)return node;

        return parent[node] = Ultimate_Parent(parent[node]);
    }

    void Union_By_Size(int v1, int v2){

        int ulp_v1 = Ultimate_Parent(v1);
        int ulp_v2 = Ultimate_Parent(v2);

        if(ulp_v1 != ulp_v2){

            if(size[ulp_v1] < size[ulp_v2]){
                size[ulp_v2]+=size[ulp_v1];
                parent[ulp_v1] = ulp_v2;
            }

            else {
                size[ulp_v1]+=size[ulp_v2];
                parent[ulp_v2]=ulp_v1;
            }
        }

        else return;

    }

}



class Kruskal_Pair{

    int weight;
    int v1;
    int v2;

    Kruskal_Pair(int w, int v, int vv){

        weight = w;
        v1 = v;
        v2 = vv;
    }
}
public class Kruskals_Algorithm {


    static int Mst_weight = 0;
    public static void Implement_Kruskals(int[][]edges, ArrayList<ArrayList<Integer>>ans, int V){

        // After doing this we will got the sorted order of all weigths...
        ArrayList<Kruskal_Pair>Edges = new ArrayList<>();
        for(int i=0; i<edges.length; i++){
            Edges.add(new Kruskal_Pair(edges[i][2] , edges[i][0] , edges[i][1]));
        }
        Collections.sort(Edges , Comparator.comparingInt(p -> p.weight));


        // Now we will use the DSU Algorithm to create mst.

        Disjoint_Set ds = new Disjoint_Set(V);
        for(Kruskal_Pair p : Edges){
            int w = p.weight;
            int v1 = p.v1;
            int v2 = p.v2;

            if(ds.Ultimate_Parent(v1)!= ds.Ultimate_Parent(v2)){
                Mst_weight+=w;
                ds.Union_By_Size(v1, v2);
                ArrayList<Integer>temp = new ArrayList<>();
                temp.add(v1);
                temp.add(v2);
                ans.add(temp);
            }

        }


    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int V = sc.nextInt();
        int E = sc.nextInt();

        int[][]edges = new int[E][3];

        for(int i=0; i<E; i++){
            edges[i][0]=sc.nextInt();
            edges[i][1]=sc.nextInt();
            edges[i][2]=sc.nextInt();
        }

        ArrayList<ArrayList<Integer>>ans=new ArrayList<>();
        Implement_Kruskals(edges, ans, V);

        System.out.println(Mst_weight);
        System.out.println(ans);
    }
}
