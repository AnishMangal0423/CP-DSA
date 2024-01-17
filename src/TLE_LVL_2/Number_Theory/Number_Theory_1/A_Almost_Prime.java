package TLE_LVL_2.Number_Theory.Number_Theory_1;

import java.util.HashSet;
import java.util.Scanner;

public class A_Almost_Prime{

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
          int ans=0;

        for (int j= 2; j <= n; j++) {

            int count =0;
            int nn=j;
            for (int i = 2; i * i <=nn; i++) {
                if(nn % i ==0) {
                    count++;
                    while (nn % i == 0) {
                        nn /= i;
                    }
                }
            }

            if (nn > 1) count++;

            if (count==2)ans++;
        }

        System.out.println(ans);

    }
}
