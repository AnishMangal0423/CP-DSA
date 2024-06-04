package GFG.POTD;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
/**
 *
 * Time Complexity ?: O(2^N)
 * Space Complexity ?: O(N)
 *
 *
 *
 * **/
public class F_LongestSubsequence1__27052024{

    public static int LongestLength(int[]arr,ArrayList<Integer>helper, int[]dp, int ind){

        System.out.println(helper+" helper");
        if(ind==arr.length) return 0;
        if(dp[ind]!=-1)return dp[ind];
        // take -
        int l1 = 0;
        if(helper.isEmpty() || Math.abs((helper.get(helper.size()-1))- arr[ind])==1){
            helper.add(arr[ind]);
            l1 =  1 + LongestLength(arr, helper, dp,ind+1);
            helper.remove(helper.size()-1);
        }
        else return 0;
        int l2 =  LongestLength(arr, helper,dp, ind+1);

        return dp[ind] = Math.max(l1, l2);
    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[]arr=new int[n];
        for(int i=0; i<n; i++)arr[i]=sc.nextInt();

        int[]dp= new int[n];
        ArrayList<Integer>helper = new ArrayList<>();
        Arrays.fill(dp, -1);
        System.out.println("Maximum Length of Longest Subsequence is ?: " + LongestLength(arr, helper, dp,0));
        System.out.println(Arrays.toString(dp));
    }
}
