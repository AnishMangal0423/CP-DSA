package TLE_LVL_2.CS31_Sheet._1200;

import java.util.Arrays;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;

class Activities_Pair{

    int val;
    int ind;

    Activities_Pair(int val, int ind){
        this.val=val;
        this.ind=ind;
    }
}
public final class A_Three_Activities {


    public static  PriorityQueue<Activities_Pair> Fill(int[]arr){

        PriorityQueue<Activities_Pair>pq = new PriorityQueue<>((a, b)->{
            if(a.val!=b.val)return a.val-b.val;
            return a.ind-b.ind;
        });

        for(int i=0; i<arr.length; i++){

            pq.add(new Activities_Pair(arr[i] , i));

            if(pq.size()>3)pq.poll();
        }

        return pq;
    }

    public static int[][] Fillm(PriorityQueue<Activities_Pair>pq){

        int[][]m = new int[3][2];
        int i=0;
        while (!pq.isEmpty()){

            Activities_Pair front = pq.poll();

            m[i][0]=front.val;
            m[i][1]=front.ind;
            i++;
        }
        return m;
    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int tc=sc.nextInt();

        while (tc-->0){

            int n=sc.nextInt();

            int[]a=new int[n];
            int[]b=new int[n];
            int[]c=new int[n];

            for(int i=0; i<n; i++)a[i]=sc.nextInt();
            for(int i=0; i<n; i++)b[i]=sc.nextInt();
            for(int i=0; i<n; i++)c[i]=sc.nextInt();



            PriorityQueue<Activities_Pair>pq1= Fill(a);
            PriorityQueue<Activities_Pair>pq2= Fill(b);
            PriorityQueue<Activities_Pair>pq3=Fill(c);


            int[][]m1=Fillm(pq1);
            int[][]m2=Fillm(pq2);
            int[][]m3=Fillm(pq3);

            int maxi=3;
            for(int i=0; i<3; i++){

                for(int j=0; j<3; j++){

                    if(m2[j][1]==m1[i][1])continue;

                    for(int k=0; k<3; k++){

                        if(m3[k][1]==m2[j][1] || m3[k][1]==m1[i][1])continue;
                        else maxi=Math.max(maxi, m1[i][0]+m2[j][0]+m3[k][0]);

                    }
                }

            }

            System.out.println(maxi);

        }
    }
}
