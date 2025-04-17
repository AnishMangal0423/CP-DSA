package DSA.Sliding_Window.NeetCode;
import java.util.*;

/**
 * Leetcode Problem :- 219.
 * This is the Fundamental Question based on sliding window pattern. where window size should be at max k.
 * and we have to check the duplicate elements.
 *
 * TC - O(N) -> only one time we are adding the elements to Map.
 * SC - O(k) -> The size of Map.
 * **/
public class A_Contains_Duplicate_2 {
    public static boolean containsNearbyDuplicate(int[] nums, int k) {

        HashMap<Integer, Integer> map = new HashMap<>();
        int n = nums.length;

        int L = 0;
        for (int R = 0; R < n; R++) {
            if (Math.abs(L - R) > k) {
                map.remove(nums[L]);
                L++;
            }
            if (map.containsKey(nums[R]) == true)
                return true;
            else {
                map.put(nums[R], 1);
            }
        }
        return false;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of array :- ");
        int n = sc.nextInt();
        System.out.println("Enter the Array Elements :- ");
        int[]nums = new int[n];
        for(int i=0; i<n; i++)nums[i]=sc.nextInt();
        System.out.println("Enter the Value of K :- ");
        int k = sc.nextInt();
        System.out.println(containsNearbyDuplicate(nums, k));
    }
}
