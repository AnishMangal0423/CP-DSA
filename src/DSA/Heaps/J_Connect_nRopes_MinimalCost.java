package DSA.Heaps;

import java.util.*;
import java.util.Scanner;

public class J_Connect_nRopes_MinimalCost{

    public static int TotalCost(int[]arr){
        int n = arr.length;
        int ans = 0;
        PriorityQueue<Integer>pq=new PriorityQueue<>();
        for(int i=0; i<n; i++)pq.add(arr[i]);

        while (!pq.isEmpty()){

            if(pq.size()==1) break;

            int rope1 = pq.poll();
            int rope2 = pq.poll();

            ans += rope1 + rope2;
            pq.add(rope1+rope2);
        }

        return ans;
    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[]arr=new int[n];
        for(int i=0; i<n; i++)arr[i]=sc.nextInt();

        System.out.println("Minimum cost of Connecting N Ropes is ?: " + TotalCost(arr));
    }
}
