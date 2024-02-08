package Codechef.Contests.Starter__120D__07022024;

import java.util.Scanner;

public class Q4 {


    public static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return Math.abs(a);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);


        int tc=sc.nextInt();

        while (tc-->0) {
//            int n = sc.nextInt();
//
//            int[] arr = new int[n];
//
//            for (int i = 0; i < n; i++) arr[i] = sc.nextInt();
//


            int x=sc.nextInt();
            int y=sc.nextInt();


            System.out.println(gcd(x, y));
        }


    }

}
