package Codechef.Contests.Starter__126C__20032024;

import java.util.Scanner;

public class Q2 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int tc=sc.nextInt();
        while (tc-->0){

            int n = sc.nextInt();
            int[]arr=new int[n];
            int sum1=0;
            for(int i=0; i<n; i++) {
                arr[i]=sc.nextInt();
              sum1+=arr[i];
            }

            int ans = -1;
            int sum2=0;
     for(int i=0; i<n; i++){

         sum2+=arr[i];

         int rem=(sum1-sum2);

         if(arr[i] > rem){
             ans = sum2+ arr[i];
             break;
         }
     }
            System.out.println(ans);


        }

    }
}
