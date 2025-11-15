package NeetCode.DP;
import java.util.Arrays;
import java.util.Scanner;
/***
 *Chapter - 1D DP.
 *   - SubTopic - Digits Pairs & Combinations.
 *
 * Brute Force -
 * TC - O(2^N) -> Every index has 2 posibilties.
 * SC - O(N) -> Recursive calls
 *
 * Optimized -
 * TC - O(n)
 * SC - O(n)
 *
 * Best part is , It has a lot of edge cases to handle. & that makes it interesting.
 * **/
public class G_Decode_Ways__Leet__91 {

    public static int dfs(String s, int index, int[]dp){

        if(index == s.length())return 1;
        if(s.charAt(index)=='0') return 0;
        if(index == s.length()-1)return 1;
        if(dp[index]!=-1)return dp[index];


        int singles =0, doubles =0;
        singles = dfs(s, index+1, dp);
        if(Integer.parseInt(""+s.charAt(index) + s.charAt(index+1))<=26){
            doubles = dfs(s, index+2, dp);
        }

        return dp[index] = singles + doubles;
    }

    public static int numDecodings(String s) {

        int n = s.length();
        int[]dp = new int[n];
        Arrays.fill(dp, -1);
        return dfs(s, 0, dp);

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the string to decode : ");
        String s = sc.nextLine();
        System.out.println("Number of ways to decode the string is : "+ numDecodings(s));
    }
}
