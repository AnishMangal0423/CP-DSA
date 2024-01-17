package DSA.Graph;
import java.util.*;

public class Normal_DFS_BFS {


    public static void DFS(ArrayList<ArrayList<Integer>>adj, int v, ArrayList<Integer>output, boolean[]visited , int sv){


        visited[sv] = true;
        output.add(sv);

        for(int child : adj.get(sv)){

            if(visited[child]==false) DFS(adj, v , output, visited , child);
        }

    }

    public static void BFS (ArrayList<ArrayList<Integer>>adj, int v, ArrayList<Integer>output2, boolean[]visited2, int sv){

        Queue<Integer>q = new LinkedList<>();
        visited2[sv]=true;
        q.add(sv);

        while(!q.isEmpty()){

            int front = q.poll();
            output2.add(front);

            for(int child : adj.get(front)){

                if(visited2[child] == false){
                    q.add(child);
                    visited2[child]=true;
                }
            }
        }

    }

    public static void main(String[]args){

        Scanner sc = new Scanner(System.in);

//        System.out.println("Enter the Num of Vertexes and Edges");
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


    }

}

//
//        8 9
//        0 1
//        1 2
//        2 3
//        1 3
//        0 4
//        4 5
//        5 7
//        7 6
//        4 6