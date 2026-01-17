package PatternsDSA.SlidingWindow.Practice_Problems;
import java.util.Scanner;

/**
 * Notes - If we will be doing the Normal 2 pointers with sliding window as follwoed in Pattern B. we would found
 *         that it is suitable if we just have to find the longest types of things , so when we have to count few things
 *         it is imp to count all, so if we will follow pattern B , we would miss out some cases ..
 *         Do Dry run for -
 *         [1, 0, 0, 1, 1, 0], goal = 2
 *         so what we can do is just calculate the noofsubarrays_withsum<=k - noofsubarrays_withsum<=k-1.
 *         then all cases will be covered. & this is the fundamental concept of Pattern C.
 *
 *         Time - O(2n)*2
 *         Space - O(1)
 *
 *  Belongs to pattern C.
 *
 * ***/
public class G_Binary_Subarrays_with_Sum__Leetcode_930 {
    public static int maxSubarraysWithSum(int[]arr, int k){

        if(k==-1)return 0; // Step-5 : A Just base Case Condition.
        int n = arr.length;
        int l=0, r=0, sum=0, count =0;   // Step-1 : Declaration Time.

        while (r < n){
            sum += arr[r];    // Step-2 : Adding elements in start and make constrains Active.

            while(sum > k){  // Step-4 : Shrink the window and again come back to equilibrium.
                sum-=arr[l];
                l++;
            }

            count+=(r-l+1);   // Step-3 : Counting phase & expanding phase.
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
        System.out.println("Enter the threshold sum k : ");
        int k = sc.nextInt();
        int first =  maxSubarraysWithSum(arr, k);
        int second = maxSubarraysWithSum(arr, k-1);

        System.out.println("Number of subarrays with sum equals K is : "+ (first-second));
    }
}
