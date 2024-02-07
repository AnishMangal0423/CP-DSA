package CodeForces.Contests;

import java.util.Scanner;

public class Q1 {

    public static boolean Calculate(int x, int n, int m){

        if(x<=0) return true;
        boolean a=false, b=false;
        if(n>0){
             a= Calculate((x/2)+10 , n-1, m);
        }


        if(m>0){
            b= Calculate(x-10 , n, m-1);
        }

        return a||b;
    }

    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);

        int tc=sc.nextInt();

        while (tc-- >0){

            int x=sc.nextInt();
            int n=sc.nextInt();
            int m=sc.nextInt();

            boolean ans = Calculate(x, n, m);

           if(ans) System.out.println("Yes");
           else System.out.println("No");


        }
    }
}
