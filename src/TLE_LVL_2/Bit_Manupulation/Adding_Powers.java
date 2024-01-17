package TLE_LVL_2.Bit_Manupulation;

import java.util.Scanner;

public class Adding_Powers {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int tc = sc.nextInt();

        while (tc-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            long[] arr = new long[n];

            long maxi = Long.MIN_VALUE;
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextLong();
                maxi = Math.max(maxi, arr[i]);
            }

            int j = 0;

            while ((long) Math.pow(k, j) < maxi) j++;

            boolean flag = false;
            for (int l = j; l >= 0; l--) {

                int count = 0, index = -1;
                long target = (long) Math.pow(k, l);
                for (int i = 0; i < n; i++) {

                    if (arr[i] >= target) {
                        count++;
                        index = i;
                    }
                }
                if (count > 1) {
                    System.out.println("No");
                    flag = true;
                    break;
                } else if (count == 1) {
                    arr[index] -= target;
                }
            }

            int check = 0;
            while (check < n) {
                if (arr[check] != 0) break;
                check++;
            }
            if (check == n) System.out.println("Yes");
            else if(flag==false) System.out.println("No");
        }
    }
}
