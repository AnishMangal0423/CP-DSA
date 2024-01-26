package Codechef.Contests.Starter_118D__24012024;

import java.util.Scanner;

public class Subset_GCD__Good {
    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);

        int tc=sc.nextInt();

        while (tc-- >0){

            int n=sc.nextInt();
            int k=sc.nextInt();

            int G=1;
            while (k*G <= n) G++;

           for(int i=1; i<=k; i++){
               System.out.print((G-1)*i);
           }
            System.out.println(" ");
        }
    }
}
