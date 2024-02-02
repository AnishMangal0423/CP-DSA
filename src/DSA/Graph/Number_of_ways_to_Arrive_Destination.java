package DSA.Graph;

import org.w3c.dom.ls.LSOutput;

import java.util.*;

class Ways_Pair{

    int time;
    int vertex;

    Ways_Pair(int time, int vertex){
        this.time=time;
        this.vertex=vertex;
    }
}
public class Number_of_ways_to_Arrive_Destination{

    public static int No_of_Ways(int[][]roads, int[]time, int src, int v){

        time[src]=0;
        PriorityQueue<Ways_Pair>pq=new PriorityQueue<>((a, b)->{
            if(a.time!=b.time)return a.time-b.time;
            return a.vertex - b.vertex;
        });
        pq.add(new Ways_Pair(0, src));

        while (!pq.isEmpty()){


                Ways_Pair front = pq.poll();
                int NodeTime = front.time;
                int vertex=front.vertex;
//            System.out.println("finalv: "+vertex);
                if(vertex==v-1){

                    return pq.size()+1;
                }

                for(int j=0; j<roads.length; j++){

                    if(roads[j][0]==vertex && NodeTime + roads[j][2] <= time[roads[j][1]]){

                        time[roads[j][1]] = NodeTime + roads[j][2];

//                        System.out.println(time[roads[j][1]]+"  "+ roads[j][1]);

                        pq.add(new Ways_Pair(time[roads[j][1]], roads[j][1]));
//                        System.out.println("ssize : "+pq.size());
                    }
                }


        }
        return -1;
    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int e=sc.nextInt();
        int[][]roads=new int[2*e][3];

        for(int i=0; i<2*e; i+=2){
           int a=sc.nextInt();
           int b=sc.nextInt();
           int c=sc.nextInt();

           roads[i][0]=a;
           roads[i][1]=b;
           roads[i][2]=c;

           roads[i+1][0]=b;
           roads[i+1][1]=a;
           roads[i+1][2]=c;
        }

        int[]time=new int[n];
        Arrays.fill(time, Integer.MAX_VALUE);

        System.out.println(No_of_Ways(roads, time, 0, n));
//        System.out.println(time[n-1]);
    }
}
// [[0,6,7],[0,1,2],[1,2,3],[1,3,3],[6,3,3],[3,5,1],[6,5,1],[2,5,1],[0,4,5],[4,6,2]]

//7 10
//        0 6 7
//        0 1 2
//        1 2 3
//        1 3 3
//        6 3 3
//        3 5 1
//        6 5 1
//        2 5 1
//        0 4 5
//        4 6 2