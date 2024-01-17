package TLE_LVL_2.Bit_Manupulation;

import java.util.Scanner;

public class And_0_Sum_Big{


    public static long Calculate(long n, long k){
        if(k==0) return 1;

        long val = Calculate(n, k-1);

        return (n*val)%1000000007;

    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int tc = sc.nextInt();

        while(tc-- > 0){

            long n = sc.nextLong();
            long k = sc.nextLong();

            double mod = Math.pow(10,9)+7;

          long val = Calculate(n, k);

            System.out.println(val);
        }

    }
}
