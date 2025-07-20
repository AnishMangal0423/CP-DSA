package DSA.NeetCode.Greedy;

import java.util.Scanner;
/***
Leetcode - 45
Qn - we have given an array and every value at an index is the value of jump we can take from that index
     so we have to tell in how many minimum number of operations we can reach to end
     and it is confirmed that we can reach the end.

 Brute Force - By DP Array - O(N ^ 2), O(N)
 Optimized - By Using BFS Solutions meaning making the levels or windows
 like for every window calculate the maximum farthest point by iterating on this window
 and then switch the window and do jump++.
 and this is how minimum jumps it will take.
 O(N), O(1).

    [2, 3, 1 , 1, 4]
lvl  0    1      2
 */
public class F_Jump_Game_2__45 {


    public static int JumpGame2(int[]nums){

        int n = nums.length;
        int jumps = 0;
        int l = 0, r = 0;

        while (r < n - 1) {
            int farthest = 0;
            for (int i = l; i <= r; i++) {
                farthest = Math.max(farthest, i + nums[i]);
            }
            l = r + 1;
            r = farthest;
            jumps++;

        }

        return jumps;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[]arr=new int[n];
        for(int i=0; i<n; i++)arr[i]=sc.nextInt();
        System.out.println("Will reach at End : "+ JumpGame2(arr));
    }
}
