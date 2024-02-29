package Codechef.Contests.Starter__123D__28022024;

import java.util.Map;
import java.util.Scanner;

public class Q2 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int tc = sc.nextInt();

        while (tc-->0){

            int n = sc.nextInt();

            int c=0;
            for(int i=0; i<n; i++) {

             int aa = sc.nextInt();

             c += (int)Math.ceil(aa/2);

            }
            System.out.println(c);

        }


    }
}
