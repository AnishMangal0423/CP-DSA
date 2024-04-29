package DSA.Heaps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;


/**
 *
 * Brute Force :- 1. Simply make the array of size n.k and sort the elements
 *
 *             TC - O(N.k log(N.k))
 *             SC - O(N.k)
 *
 * Better Approch :- 2. Merge Solution --> Merge 2 Array, then other 2ARRAY, Then other 2Array and so on..
 *  *                  TC - O(N.k.K) because (N.k + N.(k-1) + N.(K-2) + N.(K-3)+....) k times.
 *  *                  SC - O(1)
 *
 * Best Approch :- 3. Use Priority Queue with pairs and first Insert first elemnts of all arrays and if someone is minimum
 *                    push it to forward and add all the Elements in it. and store in array.
 *
 *                    TC - O(n.k log(k))
 *                    SC - O(k)
 *
 *                    where n.k = Total Number of Elements .
 *
 * **/


class ArrayPair{
    int data;
    int i;
    int j;

    ArrayPair(int data, int ii, int jj){
        this.data=data;
        i=ii;
        j=jj;

    }
}
public class D_Merge_K_SortedArrays {

    public static ArrayList MergedArray(ArrayList<Integer>[]arr){

        ArrayList<Integer>ans = new ArrayList<>();

        PriorityQueue<ArrayPair>pq = new PriorityQueue<>((a, b)->{
              if(a.data!=b.data)return a.data-b.data;
              else if(a.i!=b.i)return a.i-b.i;
              else return a.j-b.j;
        });

        int n = arr.length;

        for(int i=0; i<n; i++){
            pq.add(new ArrayPair(arr[i].get(0), i, 0));
        }


        while (!pq.isEmpty()){
            ArrayPair front = pq.poll();
            int data = front.data;
            int x = front.i;
            int y=front.j;
//            System.out.println(data+" "+x+" "+y);
            ans.add(data);
             if(y+1 < arr[x].size()) pq.add(new ArrayPair(arr[x].get(y+1), x, y+1));
//            System.out.println(ans);
        }

        return ans;

    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer>[]arr = new ArrayList[n];
        for(int i=0; i<n; i++){
            ArrayList<Integer>demo = new ArrayList<>();
            int nn = sc.nextInt();
            for(int j=0; j<nn; j++)demo.add(sc.nextInt());
            arr[i]=demo;
        }

//        System.out.println(Arrays.toString(arr));

        System.out.println("Merged Sorted Array is ?: " + MergedArray(arr));
    }
}
