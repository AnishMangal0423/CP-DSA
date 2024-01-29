package DSA.Graph;

import java.nio.file.Path;
import java.util.*;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

class Dijkstra_Pair {
    int distance;
    int vertex;

    public Dijkstra_Pair(int distance, int vertex) {
        this.distance = distance;
        this.vertex = vertex;
    }

}
    public class Dijkastra_Algo_PQ {


        public static void Fill_Distance(ArrayList<ArrayList<ArrayList<Integer>>> matrix, int[] dis, int src) {

            dis[src] = 0;


            PriorityQueue<Dijkstra_Pair> pq = new PriorityQueue<>((a, b) -> {
                if (a.distance != b.distance) return a.distance - b.distance;
                return a.vertex - b.vertex;
            });


            pq.add(new Dijkstra_Pair(0, src));

            while (!pq.isEmpty()) {

                int size = pq.size();

                for (int i = 0; i < size; i++) {

                    Dijkstra_Pair front = pq.poll();
                    int distance = front.distance;
                    int vertex = front.vertex;

                    for (ArrayList<Integer> m : matrix.get(vertex)) {

                        int v2 = m.get(0);
                        int weight = m.get(1);

                        if (vertex != v2 && dis[v2] > distance + weight) {
                            dis[v2] = distance + weight;
                            pq.add(new Dijkstra_Pair(dis[v2], v2));
                        }
                    }
                }
            }
        }

        public static void main(String[] args) {

            Scanner sc = new Scanner(System.in);
            int v = sc.nextInt();
            int e = sc.nextInt();

            ArrayList<ArrayList<ArrayList<Integer>>> matrix = new ArrayList<>();

            for (int i = 0; i < v; i++) matrix.add(new ArrayList<>());

            for (int i = 0; i < e; i++) {

                int sv = sc.nextInt();
                int ev = sc.nextInt();
                int w = sc.nextInt();

                ArrayList<Integer> temp1 = new ArrayList<>();
                temp1.add(ev);
                temp1.add(w);
                matrix.get(sv).add(temp1);

            }

            int src = sc.nextInt();

            int[] dis = new int[v];
            Arrays.fill(dis, Integer.MAX_VALUE);

            Fill_Distance(matrix, dis, src);

            System.out.println(Arrays.toString(dis));
        }

    }
