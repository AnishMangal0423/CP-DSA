package DSA.Graph;

import java.util.*;

public class Detect_Cycle_DFS{
    public static boolean Detect_Cycle(ArrayList<ArrayList<Integer>>adj, boolean[]visited, int sv, int parent){

        visited[sv] = true;
        for(int child : adj.get(sv)){

            if(visited[child] == false){

                visited[child]=true;
                return false || Detect_Cycle(adj, visited, child, sv);
            }

            else if(child != parent) return true;
        }

        return false;

    }



    public static void main(String[]args){

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the Num of Vertexes and Edges");
        int v = sc.nextInt();
        int e = sc.nextInt();

        ArrayList<ArrayList<Integer>>adj = new ArrayList<>();

        for(int i=0; i<v; i++)adj.add(new ArrayList<>());

        for(int i=0; i<e; i++){

//            System.out.println("Enter the pair vertexes values" + i+1);
            int v1= sc.nextInt();
            int v2=sc.nextInt();

            adj.get(v1).add(v2);
            adj.get(v2).add(v1);
        }

        ArrayList<Integer>output = new ArrayList<>();
        boolean[]visited = new boolean[v];

        System.out.println(Detect_Cycle(adj, visited, 0, -1));

    }
}