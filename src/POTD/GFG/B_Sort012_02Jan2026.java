package POTD.GFG;
import java.util.*;

public class B_Sort012_02Jan2026 {

    /*
     INTUITION:
     ----------
     Since the array contains only 0s, 1s, and 2s,
     we don’t need a full sorting algorithm.

     We divide the array into 3 regions:
     [ 0s | 1s | unknown | 2s ]

     - low  → boundary of 0s
     - mid  → current element being processed
     - high → boundary of 2s

     We scan the array once and place each element
     into its correct region.
    */

    static class Solution {

        // Utility function to swap elements
        public void swap(int[] arr, int i, int j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }

        /*
         APPROACH (Dutch National Flag Algorithm):
         ---------------------------------------
         1. Initialize three pointers:
            low = 0, mid = 0, high = n - 1

         2. Traverse the array while mid <= high:
            - If arr[mid] == 0:
                Swap with low
                Move both low and mid forward
            - If arr[mid] == 1:
                Just move mid forward
            - If arr[mid] == 2:
                Swap with high
                Move high backward
                (Do NOT move mid, because swapped value is unchecked)

         WHY THIS WORKS:
         --------------
         - 0s are pushed to the left
         - 2s are pushed to the right
         - 1s naturally stay in the middle
         - Each element is processed at most once
        */

        public void sort012(int[] arr) {

            int low = 0, mid = 0, high = arr.length - 1;

            while (mid <= high) {

                if (arr[mid] == 0) {
                    swap(arr, low, mid);
                    low++;
                    mid++;
                }
                else if (arr[mid] == 1) {
                    mid++;
                }
                else { // arr[mid] == 2
                    swap(arr, mid, high);
                    high--;
                }
            }
        }
    }

    // ================= MAIN FUNCTION =================
    public static void main(String[] args) {

        int[] arr = {0, 1, 2, 0, 1, 2};

        System.out.println("Before Sorting:");
        System.out.println(Arrays.toString(arr));

        Solution sol = new Solution();
        sol.sort012(arr);

        System.out.println("After Sorting:");
        System.out.println(Arrays.toString(arr));
    }
}
