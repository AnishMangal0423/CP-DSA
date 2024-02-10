package TLE_LVL_2.CS31_Sheet._1200;

import java.util.Map;
import java.util.Scanner;

public class B_Make_Almost_Equal_to_Mod {

    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);

        int tc=sc.nextInt();

        while (tc-->0) {
            int n = sc.nextInt();

            long[] arr = new long[n];


            for (int i = 0; i < n; i++) arr[i] = sc.nextLong();


            for (int i = 0; i <= 63; i++) {

                int sum = 0;
                for (int j = 0; j < n; j++) {

                    sum+= ((arr[j] >> i) & 1);
                }

                if (sum!=0 && sum!=n) {
                    System.out.println(1 << (i + 1));
                    break;
                }

            }
        }

    }
}
