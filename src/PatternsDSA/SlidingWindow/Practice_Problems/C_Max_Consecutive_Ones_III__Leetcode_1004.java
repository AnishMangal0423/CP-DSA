package PatternsDSA.SlidingWindow.Practice_Problems;
import java.util.Scanner;

/**
 * Notes - This problem Involves the pattern 2 , as we just have to calculate the longest subarray
 * that contains all 1. as we have also given a condition as threshold.
 *
 * Time - O(2n) or you can optimize it as well if we will be using the if condition rather then while in shrink phase.
 *              for more info you can check the pattern B , optimal approach.
 * Space - O(1)
 *
 * Belongs to Pattern B.
 * **/
public class C_Max_Consecutive_Ones_III__Leetcode_1004 {

    public static int longestones(int[] arr, int k) {

        int n = arr.length;
        int l = 0, r = 0, maxlen = 0, flippedzeros = 0;

        while (r < n) {
            if (arr[r] == 0) flippedzeros++;

            while (flippedzeros > k) {
                if (arr[l] == 0) flippedzeros--;
                l++;
            }

            maxlen = Math.max(maxlen, r - l + 1);
            r++;
        }
        return maxlen;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the length of Binary Array : ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the Elements of Array : ");
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();
        System.out.println("Enter the No of O's we can flip : ");
        int k = sc.nextInt();
        System.out.println("No of maximum Consecutive 1's are : " + longestones(arr, k));
    }
}
