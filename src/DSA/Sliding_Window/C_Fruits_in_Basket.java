package DSA.Sliding_Window;
import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * Concept :- 2-Pointer sliding Window
 *
 * Approches :- Main catch in this problem was to understand the Question Properly , Otherwise it is easy , Ki hame wo subarray dhundni h
 *              jisme sirf 2 trah ke fal ho of Maximum Length.
 *              To brute force se sochne ke baad , we come to 2-pointer + HashMap
 *
 *
 *              TC - O(N)
 *              SC - O(3)  --> HashMap of size 3 at worst case
 *
 *
 * */
public class C_Fruits_in_Basket{

    public static int MaximumFruits(int[]arr){

        int n = arr.length;
        HashMap<Integer , Integer>map = new HashMap<>();

        int start = 0, end = 0;
        int Maxlen = 0;

        // TC - O(N)
        while (end < n){

            map.put(arr[end] , map.getOrDefault(arr[end] , 0) + 1);

            if(map.size() > 2){
               map.put(arr[start] , map.get(arr[start])-1);

               if(map.get(arr[start])==0){
                   map.remove(arr[start]);
               }
               start++;
               end++;
            }

            else{
                Maxlen = Math.max(Maxlen , end-start+1);
                end++;
            }
        }
        return Maxlen;
    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[]arr = new int[n];

        for(int i=0; i<n; i++)arr[i] = sc.nextInt();

        System.out.println("Maximum Fruits in Baskets is ?: " + MaximumFruits(arr));

    }
}
