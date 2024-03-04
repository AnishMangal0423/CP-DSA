package Codechef.Practice;

import java.util.Scanner;

public class Odd_Sum {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        while (tc-->0){
            long n = sc.nextLong();

            if(n == 1) System.out.println(1);
            else if (n ==2 ) System.out.println(1);
            else{

                long newN = n - 2;
                long sum = (newN)*(newN-1) + 1;
                System.out.println(sum);
            }
        }
    }
}
