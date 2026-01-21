package POTD.GFG;
import java.util.*;

public class E_Stock_Span_Problem_21Jan2026 {


        public static void main(String[] args) {

            Scanner sc = new Scanner(System.in);

            // Input size
            System.out.print("Enter number of days: ");
            int n = sc.nextInt();

            int[] arr = new int[n];

            // Input array
            System.out.println("Enter stock prices:");
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }

            E_Stock_Span_Problem_21Jan2026 sol = new E_Stock_Span_Problem_21Jan2026();
            ArrayList<Integer> result = sol.calculateSpan(arr);

            // Output
            System.out.println("Stock Span:");
            for (int val : result) {
                System.out.print(val + " ");
            }

            sc.close();
        }

        /**
         * ============================================================
         * STOCK SPAN PROBLEM (Monotonic Stack)
         * ------------------------------------------------------------
         * Stack stores indices of elements
         * Stack maintains decreasing order of stock prices
         *
         * For each day:
         * - Remove previous days with price <= current
         * - Span = distance to previous greater element
         * ============================================================
         *
         * Time Complexity  : O(n)
         * Space Complexity : O(n)
         */
        public ArrayList<Integer> calculateSpan(int[] arr) {

            int n = arr.length;
            ArrayList<Integer> span = new ArrayList<>();

            // Stack stores indices
            Stack<Integer> stack = new Stack<>();

            for (int i = 0; i < n; i++) {

                // Pop all smaller or equal elements
                while (!stack.isEmpty() && arr[stack.peek()] <= arr[i]) {
                    stack.pop();
                }

                // If stack empty → no greater element on left
                if (stack.isEmpty()) {
                    span.add(i + 1);
                } else {
                    span.add(i - stack.peek());
                }

                // Push current index
                stack.push(i);
            }

            return span;
        }

}
