package DSA.Greedy;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 *
 * Concept :-  Greedy
 * Approches :- Priority Queue-
 *              Phle Muje pta nhi tha ki direct kaam array se bhi ho rkta h isliye maine priority queue ko liya it takki maximum ratio
 *              wale pairs oper aa sake and then simple sa fractional ka logic.
 *              TC - O(NlogN)     --->   Pq takes insertion/deletion
 *              SC - O(N)         --->   due to Pq.
 *
 *
 *             Direct Arrays.sort() approch-
 *             Aab pata laga ki kisi bhi factor par hmm array ke pairs ko bhi sort kr sakte h.
 *             using Lambda fn it takes nlogn using quick sort only.
 *             TC - O(NlogN)     ----> Arrays.sort()
 *             SC - O(1)
 *
 *
 * Learning :- We can also use lambda in arrays.sort().
 * **/

class Item {
    int value, weight;
    Item(int x, int y){
        this.value = x;
        this.weight = y;
    }
}

class KnapsackPair{
    double ratio ;
    int index;

    KnapsackPair(double r, int i){
        ratio=r;
        index=i;
    }
}
public class B_Fractional_Kanpsack{
    public static void main(String[] args) {


  // -------------------------------------  Input Taking Starts -------------------------------------------------
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int w = sc.nextInt();
        Item[]arr = new Item[n];

        for(int i=0; i<n; i++){
            int val = sc.nextInt();
            int weight = sc.nextInt();
            arr[i] = new Item(val , weight);
        }
// --------------------------------------- Input Taking Ends ----------------------------------------------------


 // ---------------------------------------- Method-1 : Priority Queue Solution -----------------------------------
        PriorityQueue<KnapsackPair>pq = new PriorityQueue<>((a, b)->{
            if(a.ratio != b.ratio)return  Double.compare(b.ratio, a.ratio);
            return Integer.compare(b.index , a.index);
        });

        for(int i=0; i<n; i++){
            int value = arr[i].value;
            int weight = arr[i].weight;
            pq.add(new KnapsackPair((double) value / (double) weight , i));
        }

        double ans =0;

        while (!pq.isEmpty()){
            KnapsackPair front = pq.poll();
            int index = front.index;
            System.out.println(front.ratio +" kk "+ front.index);
            if(w >= arr[index].weight){
                w-=arr[index].weight;
                ans+=(double) arr[index].value;
            }

            else{
                ans+=(((double) w / (double) arr[index].weight) * (arr[index].value));
                break;
            }
        }

        System.out.println(ans);

// ------------------------------------------ Method-2 :: Direct Arrays.sort() Method on basis of ratio --------------------------------


        Arrays.sort(arr, (a, b) -> {
            return Double.compare((double) (b.value)/(double)(b.weight) , (double)(a.value)/(double)(a.weight));
        });

        System.out.println(Arrays.asList(arr));
        // and then do the stuff.

    }
}
