package CodeForces.Contests;

import java.util.Scanner;

public class Q3 {


    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);

        int tc=sc.nextInt();

        while (tc-- >0){

            int n=sc.nextInt();

            long z=sc.nextInt();

            long[]arr=new long[n];


           for(int i=0; i<n; i++){
               arr[i]=sc.nextLong();
           }

        long maxi=-1;

           long st=arr[0];
           for(int i=0; i<n; i++){


               st=arr[i] | z;
               z=arr[i] &  z;

               maxi=Math.max(maxi, st);

           }

            System.out.println(maxi);


        }
    }
}
