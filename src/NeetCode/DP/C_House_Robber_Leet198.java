package NeetCode.DP;
import java.util.*;

/**
 * Chapter - 1D DP.
 *   - SubTopic - various Paths & Max, Min Sum.
 * Brute Force -
 * TC - O(2^N) -> Every index has 2 posibilties.
 * SC - O(N) -> Recursive calls
 * Optimized -
 * TC - O(n)
 * SC - O(n)
 * **/
public class C_House_Robber_Leet198 {

    public static int dfs(int[]nums, int index, int[]dp){

        if(index >= nums.length) return 0;
        if(dp[index]!=-1)return dp[index];

        int rob = nums[index] + dfs(nums, index+2, dp);
        int not_rob = dfs(nums, index + 1, dp);

        return dp[index] = Math.max(rob, not_rob);

    }
    public static int rob(int[] nums) {
        int[]dp = new int[nums.length];
        Arrays.fill(dp, -1);
        return dfs(nums, 0, dp);
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
