package DSA.Heaps;

import java.util.PriorityQueue;
import java.util.Scanner;

class RankPair{
    int val;
    int ind;

    RankPair(int v, int i){
        val=v;
        ind=i;
    }
}
public class F_ReplaceIndex__withRank {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[]arr = new int[n];
        for(int i=0; i<n; i++)arr[i]=sc.nextInt();

        int[]ans = new int[n];

        PriorityQueue<RankPair>pq=new PriorityQueue<>((a, b)->{
            if(a.val!=b.val)return a.val-b.val;
            return a.ind-b.ind;
        });
        for(int i=0; i<n; i++)pq.add(new RankPair(arr[i] , i));

        int rank = 1;
        while (!pq.isEmpty()){
            RankPair p = pq.poll();
            ans[p.ind] = rank;
            rank++;
        }
        for(int ii : ans) System.out.print(ii+" ");
    }
}
