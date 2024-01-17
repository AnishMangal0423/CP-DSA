package DSA.Graph;

import java.util.ArrayList;
import java.util.Scanner;

public class Detect_Cycle_Directed_Graph {

    public static boolean Detect(ArrayList<ArrayList<Integer>> adj, boolean[] visited, boolean[] path_visited, int sv) {

        visited[sv] = true;
        path_visited[sv] = true;

        for (int child : adj.get(sv)) {

            if (visited[child] == true && path_visited[child] == true) return true;


            else if (visited[child] == false && Detect(adj, visited, path_visited, child) == true) return true;


        }

        path_visited[sv] = false;
        return false;

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
        boolean[] path_visited = new boolean[v];
        boolean aa = false;
        for (int i = 0; i < v; i++) {

            if (visited[i] == false && Detect(adj, visited, path_visited, i) == true) {

                System.out.println("true");
                return;
            }
            ;
        }
        System.out.println("False");

    }
}
