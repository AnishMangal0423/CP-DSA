package NeetCode.DP;
import java.util.*;
/**
 * Topic - Greedy
 *   SubTopic - Indexes & Constraints.
 * Brute Force -
 *  TC - O(N ^ 3)
 *  sc - o(1)
 *
 *  Optimized -
 *  TC - O(N ^ 2)
 *  SC - O(1)
 *
 *  Approach - Whenever there are questions about palindromes always deal about middle element and then
 *             Increase the window size.
 *             Middle element is unique for any string, so they will generate all strings in O()
 * **/
public class F_Count_Palindromic_Substrings__Leet647 {

    public static int countSubstrings(String s) {
        int n = s.length();
        int count =0;

        for(int i=0; i<n; i++){
            // odd case-
            int l = i, r = i;
            while(l>=0 && r<n && s.charAt(l)==s.charAt(r)){
                count++;
                l--;
                r++;
            }

            // even case-
            l=i; r=i+1;
            while(l>=0 && r<n && s.charAt(l)==s.charAt(r)){
                count++;
                l--;
                r++;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println("Number of Palindromic Substring is : " + countSubstrings(s));
    }
}
