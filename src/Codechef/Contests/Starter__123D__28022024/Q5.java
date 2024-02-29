package Codechef.Contests.Starter__123D__28022024;

import java.util.Scanner;

public class Q5 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int tc = sc.nextInt();

        while (tc-->0){

            long n = sc.nextInt();
//            int[]arr = new int[n];
//            for(int i=0; i<n; i++)arr[i]=sc.nextInt();

    long sum = 0;

    sum = ((long)n*(long)(n+1))/2 - 1 +n;

            System.out.println(sum);


        }


    }
}
