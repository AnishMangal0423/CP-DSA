package POTD.GFG;
import java.util.*;

public class C_Bus_Ticket_Change_03Jan2026 {
/*
     INTUITION:
     ----------
     Each lemonade costs 5.
     Customers pay with 5, 10, or 20.

     We must give correct change immediately.
     The greedy idea is:
     - Always keep track of 5 and 10 notes
     - For 20, give (10 + 5) if possible, else (3 × 5)

     Why?
     - 5 is most important for future customers
     - Preserving 5s avoids future failure
    */

    static class Solution {

        public boolean canServe(int[] arr) {

            int five = 0;
            int ten = 0;

            for (int note : arr) {

                if (note == 5) {
                    five++;
                }

                else if (note == 10) {
                    if (five == 0) return false;
                    five--;
                    ten++;
                }

                else { // note == 20
                    if (ten > 0 && five > 0) {
                        ten--;
                        five--;
                    }
                    else if (five >= 3) {
                        five -= 3;
                    }
                    else {
                        return false;
                    }
                }
            }

            return true;
        }
    }

    // ================= MAIN FUNCTION =================
    public static void main(String[] args) {

        Solution sol = new Solution();

        int[] arr1 = {5, 5, 5, 10, 20};
        int[] arr2 = {5, 5, 10, 10, 20};

        System.out.println("Input: " + Arrays.toString(arr1));
        System.out.println("Can Serve? " + sol.canServe(arr1));

        System.out.println();

        System.out.println("Input: " + Arrays.toString(arr2));
        System.out.println("Can Serve? " + sol.canServe(arr2));
    }
}
