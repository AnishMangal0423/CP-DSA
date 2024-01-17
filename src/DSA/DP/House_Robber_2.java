/***
 * Main Point i want to highlight that .. We cannot use baccktacking(visited) array and dp at some time because f(1)result
 * on one step by looted step will be different from f(1) result of step from non-looted visited array so using f(1) or
 * storing it in dp array is not correct. or wrong answer..
 *
 * So used a Different Approch .. 00 , 01 , 10, 11(Bas esi step ki mana kar rhe h wo log)
 * **/


package DSA.DP;
import java.util.*;

// class Solution {

//     public int Recursion(int[]nums, boolean[]Looted, int n,int[]dp, int index){

//         if(index<0) return 0;
//         if(dp[index]!=-1) return dp[index];
//         // Loot -
//          int loot = Integer.MIN_VALUE;
//         if(index !=0 || (index==0 && Looted[n-1]==false)){
//             Looted[index]=true;
//             loot = nums[index]+Recursion(nums, Looted, n, dp,index-2);
//               Looted[index]=false;
//         }

//         // Not Loot -
//         int Not_Loot = Recursion(nums, Looted, n,dp, index-1);
//          System.out.println(Arrays.toString(dp));
//         return dp[index] = Math.max(loot, Not_Loot);

//     }

//     public int rob(int[] nums) {

//          int n = nums.length;
//          boolean[]Looted=new boolean[n];
//          int[]dp=new int[n];
//          Arrays.fill(dp, -1);
//          return Recursion(nums, Looted, n,dp, n-1);
//     }
// }


import java.util.Scanner;

public class House_Robber_2{

    public static int Robber1(int[]nums, int[]dp, int index){

        if(index<0) return 0;
        if(dp[index]!=-1) return dp[index];

        return dp[index]=Math.max(nums[index]+Robber1(nums, dp, index-2), Robber1(nums, dp, index-1));
    }


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
            // Creating 2 Arrays - from index 0 to n-2 and 1 to n-1-
            int n=sc.nextInt();

            int[]nums=new int[n];

            for(int i=0; i<n; i++)nums[i]=sc.nextInt();

            if(n==1) System.out.println(nums[n-1]);
            int[]nums1=new int[n-1];
            int[]nums2=new int[n-1];

            for(int i=0; i<n; i++){

                if(i==0)nums1[i]=nums[i];
                else if(i==n-1)nums2[i-1]=nums[i];
                else{
                    nums1[i]=nums[i];
                    nums2[i-1]=nums[i];
                }
            }

            int[]dp1=new int[n-1];   Arrays.fill(dp1, -1);
            int[]dp2=new int[n-1];   Arrays.fill(dp2, -1);

        System.out.println(Math.max(Robber1(nums1, dp1, n-2), Robber1(nums2, dp2, n-2)));



    }
}
