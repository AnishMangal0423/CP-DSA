package CodeForces.Practice;

import java.util.Scanner;

public class F_Farm_Land {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int tc = sc.nextInt();

        while(tc-->0){

            int n = sc.nextInt();

            int cnt = n/4;

            n=n-(cnt*4);

            if(n==2)cnt++;


            System.out.println(cnt);

        }
    }
}
