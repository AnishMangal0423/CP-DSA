package DSA.Graph;

import java.util.*;
class Pair{

    int val;
    int parent;

    Pair(int v, int p){
        val =v;
        parent = p;
    }
}

public class Detect_Cycle_BFS{


    public static boolean Detect(ArrayList<ArrayList<Integer>>adj, int v, boolean[]visited, int sv){

        visited[sv]=true;
        Queue<Pair>q=new LinkedList<>();
        q.add(new Pair(sv, -1));

        while(!q.isEmpty()){

            Pair front = q.poll();
            int val = front.val;
            int parent = front.parent;


            for(int child : adj.get(val)){

                if(visited[child]==false){

                    visited[child] =true;
                    q.add(new Pair(child, val));
                }

                else if(child != parent) return true;
            }

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

            int v1= sc.nextInt();
            int v2=sc.nextInt();

            adj.get(v1).add(v2);
            adj.get(v2).add(v1);
        }

        ArrayList<Integer>output = new ArrayList<>();
        boolean[]visited = new boolean[v];
        System.out.println( Detect(adj,v, visited, 0));



    }
}