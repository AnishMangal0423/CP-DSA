package CodeForces.Practice;

import java.util.Map;
import java.util.Scanner;

public class E_Good_Bye {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int tc=sc.nextInt();

        while (tc-->0){

            int n=sc.nextInt();
            int k=sc.nextInt();

            double pro=1;

            for(int i=0; i<n; i++)pro*=sc.nextInt();

            double d=(double)2023/pro;

            if(Math.floor(d)!=Math.ceil(d)) System.out.println("NO");
            else{
                System.out.println("YES");
                System.out.print((int)d+" ");
                k--;
                for(int i=0; i<k; i++) System.out.print(1+" ");
                System.out.println("");
            }

        }
    }
}
