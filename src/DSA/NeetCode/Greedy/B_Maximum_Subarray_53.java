package DSA.NeetCode.Greedy;
import java.util.Scanner;
/**
 * This is the 2 Pointer type problem , in which you have to use greedy or logic to obtain
 * its result.
 *
 * LeetCode Problem - 53
 * Name - Maximum_Subarray.
 *
 * Intuition - Basically we are calculating the sum and whenever sum starts to become negative we reinitialize
 *             the sum to zero. and this(sum) is working like the left pointer and iterating the array is behaving like
 *             right pointer.
 *
 *
 * Complexity - O(N), O(1).

 * ***/
public class B_Maximum_Subarray_53 {

    public static int maxSubArray(int[] nums) {
        int n = nums.length;
        int tsum=Integer.MIN_VALUE;
        int sum= 0;
        for(int i=0; i<n; i++){

            int curr = nums[i];
            tsum = Math.max(tsum, (sum + curr));
            if((curr+sum) <=0)sum=0;
            else sum = sum+curr;

        }

        return tsum;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[]nums = new int[n];
        for(int i=0; i<n; i++)nums[i]=sc.nextInt();
        System.out.println("The maximum Subarray Sum is : " + maxSubArray(nums));
    }
}
