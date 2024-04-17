import java.util.Scanner;

public class p{
    public static int solve(String A, String B) {
        int len_A = A.length();
        int len_B = B.length();
        int[][] dp = new int[len_A + 1][len_B + 1];

        for (int i = 0; i <= len_A; i++) {
            for (int j = 0; j <= len_B; j++) {
                if (i == 0) {
                    dp[i][j] = j;
                } else if (j == 0) {
                    dp[i][j] = i;
                } else if (A.charAt(i - 1) == B.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = 1 + Math.min(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[len_A][len_B];
    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        String s2 =sc.nextLine();
        System.out.println(solve(s1,s2));

    }
}
