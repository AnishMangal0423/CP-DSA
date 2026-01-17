package PatternsDSA.SlidingWindow.Practice_Problems;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Notes - So overall after solving problem G, H ,, we got the expereince to solve these types of Problems that belongs
 *         to pattern C, where we have to calculate the no of subarrays where some condition occurs.
 *         so in this what's happening is we have to calculate the no of subarrays that contains exactly k disctinct
 *         elements so using pattern B , we can calculate the no of subarrays that contains exactly <=k distinct
 *         elements and same do for <= k-1, and subtract both.
 *
 *
 *         Time - O(2n)*2
 *         Space - O(hashmap size)
 *
 *  Belongs to pattern C.
 * **/
public class I_Subarrays_with_K_Different_Integers__LeetCode__992 {

    public static int Subarrays(int[]arr, int k){

        // Main Goal of this fn is to calculate the no of subarrays where number of distinct elements in every
//           Subarray is <= k.
        int n = arr.length;
        int l=0, r=0, count =0;    // Step-1 : Declaration.
        HashMap<Integer, Integer>map = new HashMap<>();

        while (r < n){
            map.put(arr[r], map.getOrDefault(arr[r], 0)+1);   // Step-2 : Add entries in MAP.

            while(map.size() > k){   // Step-4 : Shrink the window and maintain the next equlibrium.
                map.put(arr[l], map.get(arr[l])-1);
                if(map.get(arr[l])==0)map.remove(arr[l]);
                l++;
            }

            count+= (r-l+1);  // Step-3: Print and add answer & expand the range.
            r++;
        }
        return count;
    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of array : ");
        int n = sc.nextInt();
        int[]arr = new int[n];
        System.out.println("Enter the elements of array : ");
        for(int i=0; i<n; i++)arr[i]=sc.nextInt();
        System.out.println("Enter the value of k : ");
        int k = sc.nextInt();

        int first = Subarrays(arr, k);
        int second = Subarrays(arr, k-1);

        System.out.println("Number of subarrays that contains exactly k integers are : " + (first-second));

    }
}
