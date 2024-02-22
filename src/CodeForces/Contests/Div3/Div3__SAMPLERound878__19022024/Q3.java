package CodeForces.Contests.Div3.Div3__SAMPLERound878__19022024;

import java.util.Scanner;

public class Q3 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();

        while (tc-- > 0) {
            int n = sc.nextInt();
            long q = sc.nextLong();
            long k = sc.nextLong();

            long[] arr = new long[n];
            long[] dp = new long[n];

            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextLong();
            }

            if (arr[0] <= k) dp[0] = 1;
            for (int i = 1; i < n; i++) {

                if (arr[i] <= k) {

                    dp[i] = dp[i - 1] + 1;

                } else {

                    dp[i] = 0;
                }

            }


            long sum = 0;

            int p=n-1;

            while (p>=0){

                if(dp[p]>=q){
                    while (p>=0 && dp[p]!=0){
                        sum+=dp[p];
                        p--;
                    }
                }

                p--;
            }

            System.out.println(sum);

        }
    }
}
