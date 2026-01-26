package POTD.GFG;
import  java.util.*;

public class H_Generate_Permutations_of_an_array_26Jan2026 {

        public static void main(String[] args) {

            Scanner sc = new Scanner(System.in);

            System.out.print("Enter number of elements: ");
            int n = sc.nextInt();

            int[] arr = new int[n];
            System.out.println("Enter elements:");
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }

            System.out.println("\n--- Brute Force (Visited Array) ---");
            ArrayList<ArrayList<Integer>> brute = permuteBrute(arr);
            printResult(brute);

            System.out.println("\n--- Optimized (Swap Method) ---");
            ArrayList<ArrayList<Integer>> opt = permuteOptimized(arr);
            printResult(opt);

            sc.close();
        }

        // Utility to print permutations
        private static void printResult(ArrayList<ArrayList<Integer>> res) {
            for (ArrayList<Integer> list : res) {
                System.out.println(list);
            }
            System.out.println("Total permutations: " + res.size());
        }

        /**
         * ============================================================
         * BRUTE FORCE APPROACH (Visited Array)
         * ------------------------------------------------------------
         * Pick each unused element and build permutation step by step
         *
         * Time  : O(n!)
         * Space : O(n! * n) ans array, O(n) recursion + O(n) visited + O(n) helper array.
         * ============================================================
         */
        public static ArrayList<ArrayList<Integer>> permuteBrute(int[] arr) {

            ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
            boolean[] visited = new boolean[arr.length];
            ArrayList<Integer> helper = new ArrayList<>();

            dfsBrute(arr, visited, helper, ans);
            return ans;
        }

        private static void dfsBrute(int[] arr, boolean[] visited,
                                     ArrayList<Integer> helper,
                                     ArrayList<ArrayList<Integer>> ans) {

            if (helper.size() == arr.length) {
                ans.add(new ArrayList<>(helper));
                return;
            }

            for (int i = 0; i < arr.length; i++) {
                if (visited[i]) continue;

                visited[i] = true;
                helper.add(arr[i]);

                dfsBrute(arr, visited, helper, ans);

                helper.remove(helper.size() - 1); // backtrack
                visited[i] = false;
            }
        }

        /**
         * ============================================================
         * OPTIMIZED APPROACH (Swap Method)
         * ------------------------------------------------------------
         * Fix one index and swap with all possible elements
         *
         * Time  : O(n!)
         * Space : O(n! * n) ans array, O(n) recursion
         * ============================================================
         */
        public static ArrayList<ArrayList<Integer>> permuteOptimized(int[] arr) {

            ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
            dfsSwap(0, arr, ans);
            return ans;
        }

        private static void dfsSwap(int index, int[] arr,
                                    ArrayList<ArrayList<Integer>> ans) {

            if (index == arr.length) {
                ArrayList<Integer> temp = new ArrayList<>();
                for (int num : arr) temp.add(num);
                ans.add(temp);
                return;
            }

            for (int i = index; i < arr.length; i++) {

                swap(arr, index, i);       // choose
                dfsSwap(index + 1, arr, ans);
                swap(arr, index, i);       // backtrack
            }
        }

        private static void swap(int[] arr, int i, int j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }

