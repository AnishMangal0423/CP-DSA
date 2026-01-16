package PatternsDSA.SlidingWindow.Patterns.Pattern_B;

import java.util.Scanner;

public class Dynamic_Window_Size {

    public static int Maxlen_betterSoln(int[] arr, int k) {

        /***
         * Time : O(2n) --> as left pointer is also using while condition and moving until sum comes in range.
         * Space : O(1)
         * */
        int n = arr.length;
        int l = 0, r = 0, maxlen = 0, sum = 0;

        while (r < n) {
            sum += arr[r];

            while (sum > k) {
                sum -= arr[l];
                l++;
            }

            maxlen = Math.max(maxlen, (r - l + 1));
            r++;


        }
        return maxlen;
    }

    public static int Maxlen_OptimalSoln(int[] arr, int k) {

        /**
         * Time Complexity : O(n)
         * Space : O(1)
         *
         * **/
        int n = arr.length;
        int l = 0, r = 0, maxlen = 0, sum = 0;

        while (r < n) {
            sum += arr[r];

            if (sum > k) {
                sum -= arr[l];
                l++;
            }

            maxlen = Math.max(maxlen, (r - l + 1));
            r++;

        }

        return maxlen;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();
        System.out.println("Enter the threshold Sum value k");
        int k = sc.nextInt();
        System.out.println("Btter Soln --> The longest length of subarray where sum <= k is : " + Maxlen_betterSoln(arr, k));
        System.out.println("Optimal Soln --> The longest length of subarray where sum <= k is : " + Maxlen_OptimalSoln(arr, k));
    }
}
