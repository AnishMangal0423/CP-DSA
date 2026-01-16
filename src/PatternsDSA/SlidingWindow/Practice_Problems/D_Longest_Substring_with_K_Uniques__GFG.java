package PatternsDSA.SlidingWindow.Practice_Problems;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Notes - As we can see that we have to calculate the longest substring that has atmost k distinct characters
 *         so we are following the pattern B.
 *
 *         Time - O(2n)
 *         Space - O(256)
 *
 * Belongs to Pattern B.
 *
 * **/
public class D_Longest_Substring_with_K_Uniques__GFG {

    public static int longestKSubstr(String s, int k){
        int n = s.length();
        int l=0, r=0, maxlen =0;
        HashMap<Character, Integer>map = new HashMap<>();

        while (r < n){
            map.put(s.charAt(r), map.getOrDefault(s.charAt(r), 0)+1);

            while(map.size() > k){
                map.put(s.charAt(l), map.get(s.charAt(l))-1);
                if(map.get(s.charAt(l))==0)map.remove(s.charAt(l));
                l++;
            }
            maxlen = Math.max(maxlen, (r-l+1));
            r++;
        }

        return maxlen;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the String s : ");
        String s = sc.nextLine();
        System.out.println("Enter the threshold K : ");
        int k = sc.nextInt();
        System.out.println("Longest substring length is : " + longestKSubstr(s, k));
    }
}
