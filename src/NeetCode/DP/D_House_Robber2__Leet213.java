package NeetCode.DP;
import java.util.*;
/**
 * Chapter - 1D DP.
 *   - SubTopic - various Paths & Max, Min Sum, Smartly Handling Follow Up.
 * Brute Force -
 * TC - O(2^(N)) -> Every index has 2 posibilties.
 * SC - O(N) -> Recursive calls
 * Optimized -
 * TC - O(2n)
 * SC - O(2n)
 * **/
public class D_House_Robber2__Leet213 {

    public static int dfs(int[]nums, int index, int n, int[]dp){

        if(index > n) return 0;
        if(dp[index]!=-1)return dp[index];
        int rob = nums[index] + dfs(nums, index+2, n, dp);
        int not_rob = dfs(nums, index+1, n, dp);

        return dp[index] = Math.max(rob , not_rob);
    }

    public static int rob(int[] nums) {
        if(nums.length==1)return nums[0];  // Special Case because use of Indexes.
        int[]dp1 = new int[nums.length];
        int[]dp2 = new int[nums.length];
        Arrays.fill(dp1, -1);
        Arrays.fill(dp2, -1);
        return Math.max(dfs(nums, 0, nums.length-2, dp1), dfs(nums, 1, nums.length-1, dp2));
    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the N");
        int n = sc.nextInt();
        int[]nums = new int[n];
        for(int i=0; i<n; i++)nums[i]=sc.nextInt();
        System.out.println("The maximum Amount Robbed is : " + rob(nums));
    }
}
