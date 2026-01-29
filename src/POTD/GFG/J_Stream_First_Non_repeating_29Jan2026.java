package POTD.GFG;
import java.util.*;


public class J_Stream_First_Non_repeating_29Jan2026 {

        public static void main(String[] args) {

            Scanner sc = new Scanner(System.in);

            System.out.print("Enter string: ");
            String input = sc.nextLine();

            J_Stream_First_Non_repeating_29Jan2026 sol = new J_Stream_First_Non_repeating_29Jan2026();
            String result = sol.firstNonRepeating(input);

            System.out.println("Output: " + result);

            sc.close();
        }

        /**
         * ============================================================
         * APPROACH
         * ------------------------------------------------------------
         * We process characters one by one like a stream.
         *
         * 1. Use a HashMap to store frequency of each character.
         * 2. Use a Queue to store characters that might be non-repeating.
         * 3. For every new character:
         *      - Increase its frequency
         *      - If first time seen → add to queue
         *      - Remove characters from front of queue if they repeat
         * 4. Front of queue = first non-repeating character
         *    If queue empty → append '#'
         *
         * ============================================================
         * Time Complexity  : O(n)
         * Space Complexity : O(26) for map + O(n) for queue/output
         * ============================================================
         */
        public String firstNonRepeating(String s) {

            Queue<Character> q = new LinkedList<>();
            HashMap<Character, Integer> freq = new HashMap<>();
            StringBuilder sb = new StringBuilder();

            for (char c : s.toCharArray()) {

                // update frequency
                freq.put(c, freq.getOrDefault(c, 0) + 1);

                // if first occurrence, add to queue
                if (freq.get(c) == 1) {
                    q.add(c);
                }

                // remove repeating characters from queue front
                while (!q.isEmpty() && freq.get(q.peek()) > 1) {
                    q.poll();
                }

                // append answer
                if (q.isEmpty()) {
                    sb.append('#');
                } else {
                    sb.append(q.peek());
                }
            }

            return sb.toString();
        }
    }

