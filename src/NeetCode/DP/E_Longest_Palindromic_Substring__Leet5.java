package NeetCode.DP;
import java.util.Scanner;

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
 * **/
public class E_Longest_Palindromic_Substring__Leet5 {

    public static String longestPalindrome(String s) {
        int n = s.length();
        int maxlen = 0;
        String ans = "";

        for(int i=0; i<s.length(); i++){

            // Check for Odd lengths
            int l = i, r =i;
            while(l>=0 && r<n && s.charAt(l)==s.charAt(r)){
                if((r-l+1)>maxlen){
                    maxlen = r-l+1;
                    ans = s.substring(l, r+1);
                }
                l--;
                r++;
            }
            // Check for Even lengths
            l = i; r=i+1;
            while(l>=0 && r<n && s.charAt(l)==s.charAt(r)){
                if((r-l+1)>maxlen){
                    maxlen = r-l+1;
                    ans = s.substring(l, r+1);
                }
                l--;
                r++;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println("The Longest Palindromic Substring is : " + longestPalindrome(s));
    }
}
