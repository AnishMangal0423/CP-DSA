package DSA.Graph;

import java.util.Arrays;
import java.util.Scanner;

/***
 *
 *  Approch --> We have Given Some Computers as Nodes and we have to Make all Nodes connected and we have some available
 *              Nodes so .. Approch is We can make some connected Nodes in Mst and then Number of Total Edges - Mst_Edges
 *              if it will be Less then Disconnected Computers then it will Be ok.
 *
 *
 *              TC - O(E + 4Alpha) becuase E edges will form the MST and then using the 4 alpha tc.
 *              SC - O(N + E) connections + Disjoint set array Space.
 *
 * */

class Disjoint_SetQ1{

    int N;
    int[]parent;
    int[]size;

    Disjoint_SetQ1(int N){

        this.N=N;

        parent=new int[N+1];
        for(int i=0; i<N; i++)  parent[i]=i;

        size=new int[N+1];
        Arrays.fill(size, 1);

    }

    int Ultimate_Parent(int Node){

        if(parent[Node]==Node)return Node;

        return parent[Node] = Ultimate_Parent(parent[Node]);
    }

    void UnionNodes(int c1, int c2){

        int Ulp_c1 = Ultimate_Parent(c1);
        int Ulp_c2 = Ultimate_Parent(c2);

        if(Ulp_c1 != Ulp_c2){

              if(size[Ulp_c2] > size[Ulp_c1]){
                  size[Ulp_c2]+=size[Ulp_c1];
                  parent[Ulp_c1] = Ulp_c2;
              }

              else{
                  size[Ulp_c1] += size[Ulp_c2];
                  parent[Ulp_c2] = Ulp_c1;

              }

        }
    }


}
public class Number_of_Operations_to_Make_Network_Connected{


    public static int Get_Mst_Edges(int[][]connections,  Disjoint_SetQ1 dSet){

        int Min_Edges_Count = 0;
//        System.out.println("pii");
        // Now as we know that every Edge weight will Not matter so we will Directly make the DSU and use it.
        for(int i=0; i<connections.length; i++){
//            System.out.println("hii");
            int v1 = connections[i][0];
            int v2 = connections[i][1];

            if(dSet.Ultimate_Parent(v1)!=dSet.Ultimate_Parent(v2)){
                Min_Edges_Count++;
                dSet.UnionNodes(v1, v2);
            }
        }

        return Min_Edges_Count;
    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N_computers = sc.nextInt();
        int E = sc.nextInt();
        int[][]connections = new int[E][2];

        for(int i=0; i<connections.length; i++){
            for(int j=0; j<2; j++){
                connections[i][j]=sc.nextInt();
            }
        }
        Disjoint_SetQ1 dSet = new Disjoint_SetQ1(N_computers);

//        System.out.println("jii");
        int Minimum_Edges = Get_Mst_Edges(connections,  dSet);
//        System.out.println(Minimum_Edges);
        int remaining_edges = connections.length - Minimum_Edges;

        int N_disconnected_Computers = 0;
       for(int i=1; i<N_computers; i++){
           if(dSet.Ultimate_Parent(0)!=dSet.Ultimate_Parent(i)){
               N_disconnected_Computers++;
               dSet.UnionNodes(0, i);
           }
       }


        if(remaining_edges >= N_disconnected_Computers) System.out.println(N_disconnected_Computers);
        else System.out.println(-1);

    }
}
