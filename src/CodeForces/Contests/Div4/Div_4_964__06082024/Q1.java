package CodeForces.Contests.Div4.Div_4_964__06082024;

import java.util.Scanner;

public class Q1 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-->0){

            int n = sc.nextInt();

            int sum = 0;

           int nn = n/10;
           sum+= n%10;
           sum+=nn%10;

            System.out.println(sum);

        }
    }
}
