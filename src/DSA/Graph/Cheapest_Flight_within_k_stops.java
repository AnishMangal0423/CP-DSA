package DSA.Graph;

import java.lang.module.FindException;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

class Cheapest_Pair{

    int stops;
    int dis;
    int city;

    public Cheapest_Pair(int stops, int dis, int city) {
        this.stops = stops;
        this.dis=dis;
        this.city=city;
    }
}
public class Cheapest_Flight_within_k_stops{


    public static int Find_Flights(int[][]flights, int[]cost, int src, int dst, int k){

        cost[src]=0;
        PriorityQueue<Cheapest_Pair>pq=new PriorityQueue<>((a, b)->{
            if(a.stops!=b.stops)return a.stops-b.stops;
            else if (a.dis!=b.dis)return a.dis-b.dis;
            return a.city-b.city;
        });

        pq.add(new Cheapest_Pair(0, 0, src));

        while (!pq.isEmpty()){

            int size = pq.size();

            for(int i=0; i<size; i++){

                Cheapest_Pair front = pq.poll();
                int stops = front.stops;
                int city = front.city;
                int distance = front.dis;

//                System.out.println("city : "+city);
                for(int j=0; j<flights.length; j++){

                    if(flights[j][0]==city && stops<= k && distance + flights[j][2] < cost[flights[j][1]]){
//                        System.out.println("city: "+flights[j][0] + " target: "+flights[j][1]+" cost: "+flights[j][2]);
                        cost[flights[j][1]]=distance+flights[j][2];
                        pq.add(new Cheapest_Pair(stops+1, distance+flights[j][2], flights[j][1]));
                    }


                }

            }
        }


return cost[dst];
    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int e=sc.nextInt();

        int[][]flights = new int[e][3];

        for(int i=0; i<e; i++){
            for(int j=0; j<3; j++){

                flights[i][j]=sc.nextInt();
            }
        }

        int src=sc.nextInt();
        int dst = sc.nextInt();
        int k=sc.nextInt();

        int[]cost=new int[n];
        Arrays.fill(cost, Integer.MAX_VALUE);

        System.out.println(Find_Flights(flights, cost, src, dst, k));



    }
}
