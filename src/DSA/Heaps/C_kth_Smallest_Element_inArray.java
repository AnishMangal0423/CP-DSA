package DSA.Heaps;

import java.util.PriorityQueue;
import java.util.Scanner;

/**
 *
 * Simple Solution -\
 *   TC - O(NlogK)
 *   SC - O(K)
 *
 * **/
public class C_kth_Smallest_Element_inArray{

    public static int PqSoln(int[]arr, int pos){

        PriorityQueue<Integer>pq = new PriorityQueue<>((a, b)-> b-a);
        int n = arr.length;

        if(pos>n)return -1;
        for(int i=0; i<n; i++){
            pq.add(arr[i]);
            if(pq.size()> pos) pq.poll();
        }

        return pq.poll();
    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i=0; i<n; i++)arr[i]=sc.nextInt();
        int pos = sc.nextInt();

        System.out.println("Smallest Element on Kth Position ?:" + PqSoln(arr, pos));
    }
}
