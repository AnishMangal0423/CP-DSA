package TLE_LVL_2.CS31_Sheet._900;

import java.util.Scanner;

public class Make_it_0 {

    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        int tc=sc.nextInt();

        while (tc-- >0){

            int n=sc.nextInt();

            int[]arr=new int[n];

            for(int i=0; i<n; i++)arr[i]=sc.nextInt();
            int z=n-1;
            if(n%2==0){
                System.out.println(2);
                System.out.println(1 +" "+n);
                System.out.println(1 +" "+n);
            }


            else {

                System.out.println(4);
                System.out.println(1 +" "+ z);
                System.out.println(1+" "+z);
                System.out.println(z+" "+n);
                System.out.println(z+" "+n);

            }
        }
    }
}
