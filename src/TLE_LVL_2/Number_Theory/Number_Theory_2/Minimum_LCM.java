package TLE_LVL_2.Number_Theory.Number_Theory_2;

import java.util.Scanner;

public class Minimum_LCM{

    public static int gcd(int a, int b){

        if(b==0)return a;
        return gcd(b, a%b);
    }
    public static int lcm(int a, int b){
        return (a*b)/gcd(a, b);
    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int tc=sc.nextInt();

        while (tc-->0){

         int n = sc.nextInt();

         if((n & 1)==0) System.out.println(n/2 +" "+n/2);
         else{

             int a = 1, b = n-1;
             int mini_lcm=n-1;
             for(int i=2; i*i<=n; i++){

                 if(n % i == 0){
                     int temp_lcm = lcm(n/i , n - (n/i));
                     if(temp_lcm < mini_lcm){

                         mini_lcm=temp_lcm;
                         a=n/i;
                         b=n-n/i;

                     }
//                     System.out.println(a+" "+b+" "+temp_lcm);
                 }
             }

             System.out.println(a+" "+b);

         }

        }
    }
}
