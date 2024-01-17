package DSA.Graph;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class Topological_Sort_DFS {

    public static void Topological_DFS(ArrayList<ArrayList<Integer>>adj, boolean[]visited, Stack<Integer>stk, int sv){

        visited[sv]=true;

        for(int child : adj.get(sv)){
            if(visited[child]==false){
                Topological_DFS(adj, visited, stk, child);
            }
        }

        stk.add(sv);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int v = sc.nextInt();
        int e = sc.nextInt();

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < v; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < e; i++) {
            int v1 = sc.nextInt();
            int v2 = sc.nextInt();

            adj.get(v1).add(v2);


        }

        boolean[] visited = new boolean[v];
        Stack<Integer>stk = new Stack<>();
        for(int i=0; i<v; i++){
            if(visited[i]==false)  Topological_DFS(adj, visited, stk,i);
        }

        while(!stk.isEmpty()){
            System.out.print(stk.pop()+" ");
        }
        System.out.println(" ");
    }
}
