package POTD.GFG;
import java.util.*;

public class D_Remove_K_Digits_19Jan2026 {


        public static void main(String[] args) {
            D_Remove_K_Digits_19Jan2026 sol = new D_Remove_K_Digits_19Jan2026();

            String s = "4325043";
            int k = 3;

            System.out.println("My Approach Result       : " + sol.removeKDigits_MyApproach(s, k));
            System.out.println("Interview Stack Result   : " + sol.removeKDigits_InterviewFriendly(s, k));
        }

        /**
         * ============================================================
         * APPROACH 1: MY APPROACH (Selection / Window based)
         * ------------------------------------------------------------
         * Idea:
         * - To build the smallest number of length (n - k)
         * - For each position, select the minimum digit from
         *   a valid window [end ... start]
         * - Maintain relative order
         *
         * This approach is intuitive and logical,
         * but not always preferred in interviews.
         * ============================================================
         */
        public static String removeKDigits_MyApproach(String s, int k) {

            StringBuilder result = new StringBuilder();

            int n = s.length();

            // window boundaries
            int end = 0;
            int start = k;

            // We need to pick (n - k) digits
            while (start < n) {

                int minDigit = 10;
                int minIndex = -1;

                // Find minimum digit in window [end ... start]
                for (int i = end; i <= start; i++) {
                    int digit = s.charAt(i) - '0';
                    if (digit <= minDigit) {
                        minDigit = digit;
                        minIndex = i;
                    }
                }

                // Add chosen digit to result
                result.append(minDigit);

                // Move window
                end = minIndex + 1;
                start++;
            }

            // Remove leading zeros
            while (result.length() > 0 && result.charAt(0) == '0') {
                result.deleteCharAt(0);
            }

            return result.length() == 0 ? "0" : result.toString();
        }

        /**
         * ============================================================
         * APPROACH 2: INTERVIEW FRIENDLY (Greedy + Monotonic Stack)
         * ------------------------------------------------------------
         * Idea:
         * - Use stack to maintain increasing digits
         * - If current digit is smaller than stack top
         *   and k > 0, remove stack top
         * - Greedy removal gives smallest number
         *
         * This is the MOST EXPECTED interview solution.
         * ============================================================
         */
        public static String removeKDigits_InterviewFriendly(String s, int k) {

            Stack<Character> stack = new Stack<>();

            // Traverse digits
            for (char digit : s.toCharArray()) {

                // Remove bigger digits from left if possible
                while (!stack.isEmpty() && k > 0 && stack.peek() > digit) {
                    stack.pop();
                    k--;
                }

                stack.push(digit);
            }

            // If k still remains, remove from end
            while (k > 0 && !stack.isEmpty()) {
                stack.pop();
                k--;
            }

            // Build result from stack
            StringBuilder result = new StringBuilder();
            while (!stack.isEmpty()) {
                result.append(stack.pop());
            }
            result.reverse();

            // Remove leading zeros
            while (result.length() > 0 && result.charAt(0) == '0') {
                result.deleteCharAt(0);
            }

            return result.length() == 0 ? "0" : result.toString();
        }

}
