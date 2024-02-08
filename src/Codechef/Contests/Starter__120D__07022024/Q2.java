package Codechef.Contests.Starter__120D__07022024;

import java.util.Scanner;

public class Q2 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int tc=sc.nextInt();

        while (tc-->0) {
            int n = sc.nextInt();

//            int[] arr = new int[n];
//
//            for (int i = 0; i < n; i++) arr[i] = sc.nextInt();


            if(n<127) System.out.println("NO");
            else System.out.println("YES");
        }

    }
}
