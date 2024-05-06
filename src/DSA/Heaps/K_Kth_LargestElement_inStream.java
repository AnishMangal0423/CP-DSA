package DSA.Heaps;

import java.util.PriorityQueue;
import java.util.Scanner;

class KthLargest {

    int k;
    PriorityQueue<Integer>pq = new PriorityQueue<>();

    public KthLargest(int k, int[] nums) {
       this.k=k;
       for(int i=0; i<nums.length; i++){

           pq.add(nums[i]);
           if(pq.size() > k)pq.poll();
       }
    }

    public int add(int val) {

        pq.add(val);
        if(pq.size() > k)pq.poll();
        return pq.peek();
    }
}

public class K_Kth_LargestElement_inStream{

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[]arr=new int[n];
        for(int i=0; i<n; i++)arr[i]=sc.nextInt();

        KthLargest obj1 = new KthLargest(k, arr);
        System.out.println(obj1.add(0));
        System.out.println(obj1.add(100));
        System.out.println(obj1.add(3));


    }
}
