package LeetCode.POTD;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 *
 * Time Complexity :- O()
 *
 *
 *
 * **/

class pqpair{

    public double weight;
    public int node;

    pqpair(double w, int n){
        this.weight=w;
        this.node = n;
    }
}


class adjlistPair{

    int dest;
    double weight;

    adjlistPair(int d, double w){
        this.dest = d;
        this.weight = w;
    }
}


public class ZA_Pathwith_MaximumProbability__31082024 {

    public static double Calc_Probability(ArrayList<ArrayList<adjlistPair>> adj, int start, int end, int v){

        double[]upprob = new double[v];
        Arrays.fill(upprob , Double.MIN_VALUE);
        upprob[start] = 1.0;

        PriorityQueue<pqpair>pq = new PriorityQueue<>((a, b)->{
            return Double.compare(b.weight , a.weight);
        });
        pq.add(new pqpair(1.0 , start));
        
        
        while (!pq.isEmpty()){
            
            pqpair front = pq.poll();
            double weight = front.weight;
            int node = front.node;
            
            for(adjlistPair  p: adj.get(node)){
                
                int dest = p.dest;
                double wt = p.weight;
                
                double nextweight = wt * weight;
                
                if(upprob[dest] < nextweight){
                    upprob[dest] = nextweight;
                    
                    pq.add(new pqpair(nextweight , dest));
                }
            }
        }
        
        double val =upprob[end];
       return (val==Double.MIN_VALUE) ? 1.000 : val;
    }
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int v = sc.nextInt();
        int e = sc.nextInt();
        int[][]edges = new int[e][2];

        for(int i=0; i<e; i++){
            edges[i][0]=sc.nextInt();
            edges[i][1] = sc.nextInt();
        }

        double[]prob= new double[e];

        for(int i=0; i<e; i++) prob[i] = sc.nextDouble();
        int start = sc.nextInt();
        int end = sc.nextInt();

        ArrayList<ArrayList<adjlistPair>> adj = new ArrayList<>();

        for(int i=0; i<v; i++)adj.add(new ArrayList<>());

        for(int i=0; i<e; i++){

            int a = edges[i][0];
            int b = edges[i][1];
            double w = prob[i];

        adj.get(a).add(new adjlistPair( b, w));
        adj.get(b).add(new adjlistPair(a, w));
        }

        System.out.println("The Maxiumum Probability to Reach Destination is ?: " + Calc_Probability(adj, start , end, v));
    }
}
