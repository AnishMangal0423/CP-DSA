package DSA.Graph;

import java.util.*;

public class Topological_Sort_BFS {

    public static void Topological_BFS(ArrayList<ArrayList<Integer>>adj, int[]InDegree, Queue<Integer>q){

        while(!q.isEmpty()) {
            int front = q.peek();
            System.out.print(q.poll()+ " ");

            for (int child : adj.get(front)) {
                InDegree[child]--;
                if (InDegree[child] == 0) {
                    q.add(child);
                }
            }

        }

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

        int[]InDegree = new int[v];

        for(int i=0; i<v; i++){
            for(int child : adj.get(i)){
                InDegree[child]++;
            }
        }

        Queue<Integer>q = new LinkedList<>();
        for(int i=0; i<InDegree.length; i++){
            if(InDegree[i]==0) q.add(i);
        }

            Topological_BFS(adj, InDegree, q);
    }
}
