package TLE_LVL_2.Stacks_Queues;

import java.util.PriorityQueue;
import java.util.Scanner;


class kth_Largest{

    PriorityQueue<Integer>pq;
    int k;

    kth_Largest(int k, int[]arr){

        this.k=k;
        pq=new PriorityQueue<>();

        for(int i=0; i<arr.length; i++){


            if(pq.size() <= k+1){
                pq.add(arr[i]);

                if(pq.size()==k+1) pq.poll();
            }
        }
    }


    public int add(int val){
        pq.add(val);
        pq.poll();
        return pq.peek();
    }

}
public class Kth_Largest_Element_in_a_Stream{

    public static void main(String[] args) {

        int[]arr={4, 5, 8, 2};
        kth_Largest obj1 = new kth_Largest(3, arr);

        System.out.println(obj1.add(3));
        System.out.println(obj1.add(5));
        System.out.println(obj1.add(10));
        System.out.println(obj1.add(9));
        System.out.println(obj1.add(4));


    }
}
