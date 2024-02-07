package CodeForces.Contests.Div3.Div3__Round923__06022024;

import java.util.Scanner;

public class Q1 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);


        int tc = sc.nextInt();

        while (tc-- > 0) {
            int n = sc.nextInt();

            String ss = sc.next();

            int si = 0, ei = 0;

            for (int i = 1; i <= n; i++) {

                if (ss.charAt(i - 1) == 'B') {
                    si = i;
                    break;
                }
            }

            for (int i = n; i >= 1; i--) {

                if (ss.charAt(i - 1) == 'B') {
                    ei = i;
                    break;
                }
            }
            System.out.println(ei - si + 1);

        }
    }
}
