package DSA.Heaps;

import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 *
 * Concept :- Frequency of Numbers in Array.
 * Approch :- we can Priority queue on Frequencies.
 *            so total entries in Pq will be K at max , or more formally we can say it would be RootN
 *            becuase Frequencies are distinct and in worst case it would be frequencies like-
 *            freq : number
 *            1 : no1
 *            2 : no2
 *            3 : no3
 *            4 : no4
 *            .. : ..
 *            so on
 *            Now K will be approx RootN
 *
 *            so Time Complexity would be K log K
 *            or TC - O(RootN logN)
 *               SC - O(2K) Or O(2RootN)
 *
 *          which is less then < nlogN
 * **/
class FrequentPair{
    int freq;
    int val;

    FrequentPair(int f, int v){
        freq=f;
        val=v;
    }
}
public class M_Top_kFrequent_Elements {

    public static int[] TopFrequent(int[]arr, int k){
        int n = arr.length;
        HashMap<Integer, Integer>map = new HashMap<>();
        for(int i=0; i<n; i++) map.put(arr[i] , map.getOrDefault(arr[i] , 0) + 1);

        PriorityQueue<FrequentPair>pq=new PriorityQueue<>((a, b)->{
            if(a.freq!=b.freq)return b.freq-a.freq;
            return b.val-a.val;
        });

        for(int kii : map.keySet())pq.add(new FrequentPair(map.get(kii) , kii));


       int[]ans=new int[k];
       int ind=0;

       while (k-->0){
           ans[ind]=pq.poll().val;
           ind++;
       }

       for(int ii : ans) System.out.print(ii+" ");
       return ans;
    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[]arr=new int[n];
        for(int i=0; i<n; i++)arr[i]=sc.nextInt();
        int k = sc.nextInt();
        System.out.println("Top K Most Frequent Elements is ?: " + (TopFrequent(arr, k).toString()));

    }
}
