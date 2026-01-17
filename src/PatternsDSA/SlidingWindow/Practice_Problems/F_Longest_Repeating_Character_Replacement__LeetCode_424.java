package PatternsDSA.SlidingWindow.Practice_Problems;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Notes - A very Good problem for 2 Pointers that follows the Pattern B and also the implementation and logic
 *         part in it is also fasicinating and good.
 *
 *         Time - O(N + N) * 26 because we are also updating the maxfreq in the shrink phase.
 *         Space - O(26)
 *
 *   Problem Belongs to Pattern B.
 *
 * **/
public class F_Longest_Repeating_Character_Replacement__LeetCode_424 {

    public static int maxLen(String s, int k) {

        int n = s.length();
        int l = 0, r = 0, maxlen = 0, maxfreq = 0;  // Step-1 : Declaration Phase.
        HashMap<Character, Integer> map = new HashMap<>();

        while (r < n) {
            map.put(s.charAt(r), map.getOrDefault(s.charAt(r), 0) + 1); // Step-2 : Adding the value that will become condition after some day.
            maxfreq = Math.max(maxfreq, map.get(s.charAt(r)));

            while ((r - l + 1) - maxfreq > k) {   // Time to shrink the array such that we can find our next ans.
                map.put(s.charAt(l), map.get(s.charAt(l)) - 1);
                maxfreq=0;
                for (char kii : map.keySet()) maxfreq = Math.max(maxfreq, map.get(kii));
                l++;
            }

            maxlen = Math.max(maxlen, (r - l + 1));  // Step-3 : Storing/Printing the ans & Time to expand the length by r++ .
            r++;
        }
        return maxlen;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the string s : ");
        String s = sc.nextLine();
        System.out.println("Enter the no of allowed Conversions k : ");
        int k = sc.nextInt();
        System.out.println("Maximum Length of Substring formed is : " + maxLen(s, k));
    }
}
