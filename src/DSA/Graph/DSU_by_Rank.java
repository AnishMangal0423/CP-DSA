package DSA.Graph;


import java.util.Arrays;

class DSU_Rank{

    int n;
    int[]parent;
    int[]rank;

    DSU_Rank(int n){

        this.n=n;
        parent=new int[n+1];
        for(int i=0; i<=n; i++)parent[i]=i;
        rank = new int[n+1];
    }

   public int UltimateParent(int node){

        if(parent[node] == node)return node;

        return parent[node] = UltimateParent(parent[node]);

    }

    public void unionByRank(int u, int v){

        int ultimateP_u = UltimateParent(u);
        int ultimateP_v = UltimateParent(v);

        if(ultimateP_u == ultimateP_v)return;

        else{

            if(rank[ultimateP_u] == rank[ultimateP_v]){
                parent[ultimateP_v] = ultimateP_u;
                rank[ultimateP_u]++;
            }

            else if(rank[ultimateP_u] > rank[ultimateP_v]){

                parent[ultimateP_v]=ultimateP_u;
            }

            else if(rank[ultimateP_v] > rank[ultimateP_u]){

                parent[ultimateP_u] = ultimateP_v;
            }


        }
    }
}
public class DSU_by_Rank{

    public static void main(String[] args) {

       DSU_Rank d1 = new DSU_Rank(7);

       d1.unionByRank(1, 2);
       d1.unionByRank(2, 3);
       d1.unionByRank(4, 5);
       d1.unionByRank(6, 7);
       d1.unionByRank(5, 6);

        System.out.println(d1.UltimateParent(3) == d1.UltimateParent(7));

        d1.unionByRank(3, 7);

        System.out.println(d1.UltimateParent(3) == d1.UltimateParent(7));

        System.out.println(Arrays.toString(d1.parent));
    }
}
