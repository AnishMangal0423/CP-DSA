package PatternsDSA.SlidingWindow.Practice_Problems;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Notes - As we can see that we just have to find the longest substring with some condition, so it belongs to payyyern 2
 *         and we use 3 approaches , brute, better, optimal.. I have implemented Better one.
 *
 *         Time - O(2n)  --> Can also be reduced to O(n) using optimal one.
 *         space - O(26)
 *
 *
 * Pattern - Belongs to Pattern 2.
 * **/
public class B_Longest_Substring_Without_Repeating_Characters__LeetCode_3 {

    public static int maxLen(String s) {

        int n = s.length(), l = 0, r = 0, maxlen = 0;
        Map<Character, Integer> map = new HashMap<>();

        while (r < n) {
            map.put(s.charAt(r), map.getOrDefault(s.charAt(r), 0) + 1);

            while (map.get(s.charAt(r)) > 1) {
                int val = map.get(s.charAt(l));
                map.put(s.charAt(l), val - 1);
                l++;
            }
            maxlen = Math.max(maxlen, (r - l + 1));
            r++;
        }

        return maxlen;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the String :");
        String s = sc.next();
        System.out.println("Longest Substring length is : " + maxLen(s));
    }
}
