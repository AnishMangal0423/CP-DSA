package Codechef.Contests.Starter__120D__07022024;

import java.util.Scanner;

public class Q6 {

    static final int mod = 998244353;

    static long power(long a, long b) {
        if (b == 0) return 1;

        long ans = 1;
        while (b > 0) {
            if ((b & 1) == 1) {
                ans = (ans * a) % mod;
            }
            a = (a * a) % mod;
            b >>= 1;
        }
        return ans;
    }
    public static void main(String[] args) {

//        Scanner sc = new Scanner(System.in);


        Scanner scanner = new Scanner(System.in);

        int tc=scanner.nextInt();

        while (tc-->0) {
            long n = scanner.nextLong();
            long k = scanner.nextLong();

            if (k == 0) {
                System.out.println(1);
                return;
            }

            long ans = power(2, n - 1);
            System.out.println(power(ans, k) % mod);

        }

    }
}
