package NeetCode.DP;
import java.util.*;

/**
 * Chapter - 1D DP.
 *   - SubTopic - Ladder Question.
 * Brute Force -
 * TC - O(2^N) -> Every index has 2 posibilties.
 * SC - O(N) -> Recursive calls
 *
 * Optimized -
 * TC - O(n)
 * SC - O(n)
 * **/
public class B_Min_Cost_Climbing_Stairs__Leet746 {

    public static int dfs(int[]cost, int index, int[]dp){

        if(index == cost.length) return 0;
        if(index > cost.length)return 1000000000;
        if(dp[index]!=-1)return dp[index];
        int one_steps = cost[index] + dfs(cost, index+1, dp);
        int two_steps = cost[index] + dfs(cost, index+2, dp);

        return dp[index] = Math.min(one_steps, two_steps);

    }
    public static int minCostClimbingStairs(int[] cost) {
        int[]dp = new int[cost.length];
        Arrays.fill(dp, -1);
        return Math.min(dfs(cost, 0, dp), dfs(cost, 1, dp));
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the length of array : ");
        int n = sc.nextInt();
        int[]cost = new int[n];
        for(int i=0; i<n; i++)cost[i] = sc.nextInt();
        System.out.println("The minimum Cost to Reach the End Floor : " + minCostClimbingStairs(cost));
    }
}
