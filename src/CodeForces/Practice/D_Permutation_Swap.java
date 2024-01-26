package CodeForces.Practice;

import java.util.Scanner;

public class D_Permutation_Swap{

    public static int GCD(int a, int b){

        if(b==0)return a;

        return GCD(b , a%b);
    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int tc=sc.nextInt();

        while (tc-->0){

            int n = sc.nextInt();

            int[]arr=new int[n];

            for(int i=1; i<=n; i++){

                int a = sc.nextInt();
                arr[i-1]=Math.abs(a-i);
            }

            int gcd=0;

            for(int i=0; i<n; i++){

                gcd=GCD(gcd, arr[i]);
            }

            System.out.println(gcd);
        }
    }
}
