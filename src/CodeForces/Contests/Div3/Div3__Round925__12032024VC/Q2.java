package CodeForces.Contests.Div3.Div3__Round925__12032024VC;

import java.util.Scanner;

public class Q2 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int tc = sc.nextInt();

        while (tc-- > 0) {

            int n = sc.nextInt();
            long[] arr = new long[n];

            long sum = 0;
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
                sum += arr[i];
            }

            long val = (sum / n);
//            System.out.println("val" + val);

            long jj = 0;
            boolean flag = false;

            for (int i = n - 1; i >= 0; i--) {

                jj += arr[i] - val;

                if (jj > 0) {
                    System.out.println("NO");
                    flag = true;
                    break;
                }

            }

            if (jj != 0 && flag == false) {
                System.out.println("NO");
            } else {
                if (flag==false)System.out.println("YES");
            }
        }
    }


}
