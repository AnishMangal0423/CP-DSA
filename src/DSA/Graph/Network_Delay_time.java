package DSA.Graph;

import java.util.*;
import java.util.Scanner;

class Network_Pair{

    int time;
    int i;

    Network_Pair(int t, int i){
        this.time=t;
        this.i=i;
    }
}
public class Network_Delay_time {

    public static void Fill_Cost(int[][]times, int[]cost, int src){
        cost[src]=0;
        int e=times.length;
        PriorityQueue<Network_Pair>pq=new PriorityQueue<>((a, b)->{
            if(a.time!=b.time)return a.time-b.time;
            else return a.i-b.i;
        });
        pq.add(new Network_Pair(0, src));

        while (!pq.isEmpty()){
            int size = pq.size();

            for(int m=0; m<size; m++){

                Network_Pair front = pq.poll();
                int time = front.time;
                int i=front.i;

                for(int n=0; n<e; n++){

                    if(times[n][0]==i && time + times[n][2] < cost[times[n][1]]){
                        cost[times[n][1]]=time+times[n][2];
                        pq.add(new Network_Pair(time+times[n][2] , times[n][1]));
                    }
                }


            }

        }



    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int e = sc.nextInt();
        int src = sc.nextInt();
        int[][] times = new int[e][3];

        for (int i = 0; i < e; i++) {

            for (int j = 0; j < 3; j++) times[i][j] = sc.nextInt();
        }


        int[] cost = new int[n+1];
        Arrays.fill(cost, Integer.MAX_VALUE);
        cost[0]=-1;

        Fill_Cost(times, cost, src);

        int maxi=Integer.MIN_VALUE;

        for(int i=0; i<cost.length; i++) maxi=Math.max(maxi, cost[i]);

        if(maxi==Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(maxi);
}

}
