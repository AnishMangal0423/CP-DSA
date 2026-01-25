package POTD.GFG;
import java.util.*;
public class G_Number_ofValid_Parenthesis_25Jan2026 {


        public static void main(String[] args) {

            Scanner sc = new Scanner(System.in);

            System.out.print("Enter total length of parentheses string (n): ");
            int n = sc.nextInt();

            G_Number_ofValid_Parenthesis_25Jan2026 sol = new G_Number_ofValid_Parenthesis_25Jan2026();

            System.out.println("\nBrute Force (2^n) Ways: " + sol.countWays_BruteForce(n));
            System.out.println("Optimized DP Ways: " + sol.countWays_Optimized(n));

            sc.close();
        }

        /**
         * ============================================================
         * BRUTE FORCE APPROACH (2^n)
         * ------------------------------------------------------------
         * At every index we try:
         * 1. Add '('
         * 2. Add ')'
         *
         * We explore all possible strings of length n.
         * Invalid sequences are discarded using rules.
         *
         * Time  : O(2^n)
         * Space : O(n) recursion stack
         * ============================================================
         */
        public int countWays_BruteForce(int n) {
            if (n % 2 != 0) return 0;
            return dfsBrute(0, 0, 0, n);
        }

        private int dfsBrute(int index, int opening, int closing, int n) {

            if (index > n) return 0;
            if (opening > n / 2 || closing > n / 2) return 0;
            if (closing > opening) return 0;

            if (index == n) return 1;

            int addOpen = dfsBrute(index + 1, opening + 1, closing, n);
            int addClose = dfsBrute(index + 1, opening, closing + 1, n);

            return addOpen + addClose;
        }

        /**
         * ============================================================
         * OPTIMIZED APPROACH (DP + Memoization)
         * ------------------------------------------------------------
         * Instead of recomputing states, we store results in dp.
         * State defined by:
         * open = number of '(' used
         * close = number of ')' used
         *
         * Time  : O((n/2)^2)
         * Space : O((n/2)^2)
         * ============================================================
         */
        public int countWays_Optimized(int n) {
            if (n % 2 != 0) return 0;

            int[][] dp = new int[(n / 2) + 1][(n / 2) + 1];
            for (int[] row : dp) {
                Arrays.fill(row, -1);
            }

            return dfsDP(0, 0, n, dp);
        }

        private int dfsDP(int open, int close, int n, int[][] dp) {

            if (open > n / 2 || close > n / 2) return 0;
            if (close > open) return 0;
            if (open + close == n) return 1;

            if (dp[open][close] != -1) return dp[open][close];

            int addOpen = dfsDP(open + 1, close, n, dp);
            int addClose = dfsDP(open, close + 1, n, dp);

            return dp[open][close] = addOpen + addClose;
        }
    }

