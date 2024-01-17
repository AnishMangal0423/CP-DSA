package DSA.Graph;

import java.util.*;

class pair{

       int val;
       int actual_dist;

       pair(int v, int a){

           val = v;
           actual_dist = a;
       }

        }

public class Shortest_Distance{


    public static void DFS_TOPO(ArrayList<ArrayList<pair>>adj, boolean[]visited, Stack<Integer>stk, int sv){

        visited[sv]=true;

        for(pair child : adj.get(sv)){

            if(visited[child.val]==false) DFS_TOPO(adj, visited, stk, child.val);

        }

        stk.add(sv);

    }


    public static void Shortest(ArrayList<ArrayList<pair>>adj , Stack<Integer>stk , int[]distance, int sv){

        while(!stk.isEmpty()){
            int element = stk.pop();
            int shortest_dis = distance[element];

            for(pair p : adj.get(element)){

                int val = p.val;
                int actual_dist = p.actual_dist;

                distance[val] = Math.min(distance[val], shortest_dis + actual_dist);


            }

        }

    }

    public static void main(String[]args){

        Scanner sc = new Scanner(System.in);

        int v = sc.nextInt();
        int e = sc.nextInt();

        ArrayList<ArrayList<pair>>adj = new ArrayList<>();

        for(int i=0; i<v; i++) adj.add(new ArrayList<>());

        for(int i=0; i<e; i++){

            int v1 = sc.nextInt();
            int v2 = sc.nextInt();
            int dist = sc.nextInt();

            adj.get(v1).add(new pair(v2, dist));
        }


        boolean[] visited = new boolean[v];
        Stack<Integer>stk = new Stack<>();

        for(int i=0; i<v; i++){
            if(visited[i]==false) DFS_TOPO(adj, visited, stk, i);

        }

        int[]distance = new int[v];

        Arrays.fill(distance , Integer.MAX_VALUE);

        distance[stk.peek()]= 0;
        Shortest(adj, stk , distance, stk.peek());


        System.out.println(Arrays.toString(distance));

    }

}