package Codechef.Contests.Starter__123D__28022024;

import java.util.Scanner;

public class Q4 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int tc = sc.nextInt();

        while (tc-->0){

            long n = sc.nextInt();
//            int[]arr = new int[n];
//            for(int i=0; i<n; i++)arr[i]=sc.nextInt();

   long sum =0;
    int val=0;


    if((n-1)%2==0){
        for(int i=0; i<(n-1)/2; i++){
            sum+=(i+1)+(i+1);
        }

        System.out.println(sum);
    }
else{
    int i=0;
        for(; i<(n-1)/2; i++){
            sum+=(i+1)+(i+1);
        }
  sum +=(i+1);
        System.out.println(sum);

    }

        }


    }
}
