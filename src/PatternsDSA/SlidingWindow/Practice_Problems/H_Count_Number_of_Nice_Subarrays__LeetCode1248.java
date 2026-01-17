package PatternsDSA.SlidingWindow.Practice_Problems;
import java.util.Scanner;

/**
 *  * Notes - If we will be doing the Normal 2 pointers with sliding window as follwoed in Pattern B. we would found
 *  *         that it is suitable if we just have to find the longest types of things , so when we have to count few things
 *  *         it is imp to count all, so if we will follow pattern B , we would miss out some cases ..
 *  *         Do Dry run for -
 *  *         [1, 0, 0, 1, 1, 0], goal = 2
 *  *         so what we can do is just calculate the noofsubarrays_withsum<=k - noofsubarrays_withsum<=k-1.
 *  *         then all cases will be covered. & this is the fundamental concept of Pattern C.
 *  *
 *  *         Time - O(2n)*2
 *  *         Space - O(1)
 *  *
 *  *  Belongs to pattern C.
 *  I would suggest to do QN - G , first if you are not getting the concept.
 *
 * **/

public class H_Count_Number_of_Nice_Subarrays__LeetCode1248 {

    public static int numberOfSubarrays(int[]arr, int k){

        int n = arr.length;
        int l=0, r=0, noof_ods = 0, count=0;   // Step-1 : Declaration.

        while (r < n){
            if(arr[r]%2!=0)noof_ods++;   // Step-2 : Add as much as possible to come to constraint condition.

            while(noof_ods > k){    // Step-4 : Time to shrink the array.
                if(arr[l]%2!=0)noof_ods--;
                l++;
            }
            count += (r-l+1); // Step-3 : Print the result and add in ans.
            r++;
        }
        return count;
    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of subarray : ");
        int n = sc.nextInt();
        int[]arr= new int[n];
        System.out.println("Enter the array elements : ");
        for(int i=0; i<n; i++)arr[i]=sc.nextInt();
        System.out.println("Enter the no of ");
        int k = sc.nextInt();
        int first = numberOfSubarrays(arr, k);
        int second = numberOfSubarrays(arr, k-1);

        System.out.println("Number of subarrays with k odds : " + (first-second));
    }
}
