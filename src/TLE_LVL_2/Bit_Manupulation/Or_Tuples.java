package TLE_LVL_2.Bit_Manupulation;

import java.util.Scanner;

public class Or_Tuples{

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int tc = sc.nextInt();


        while (tc-- > 0) {
            int P = sc.nextInt();
            int Q = sc.nextInt();
            int R = sc.nextInt();


            int ans = 1;
            for (int i = 0; i < 20; i++) {
                int pith = (P >> i) & 1;
                int qith = (Q >> i) & 1;
                int rith = (R >> i) & 1;

               int sum = pith+qith+rith;

               if(sum==1){
                   ans=0;
                   break;
               }
               else if(sum==3)ans*=4;
            }

            System.out.println(ans);
        }
    }
}
