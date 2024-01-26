package TLE_LVL_2.Number_Theory.Number_Theory_1;

import java.util.Scanner;

public class H_Longest_Divisors_Multiple{

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int tc=sc.nextInt();

        while (tc-->0){

            long N = sc.nextLong();

            if((N & 1)==1) System.out.println(1);
            else{

                int i=1;
                for(; i<=50; i++){
                    if(N % i != 0)break;
                }

                System.out.println(i-1);
            }
        }
    }
}
