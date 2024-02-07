package CodeForces.Contests;

import java.util.Scanner;

public class Q2 {

    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);

        int tc=sc.nextInt();

        while (tc-- >0){

            int n=sc.nextInt();

            int[]arr=new int[n];

            int xor=0;

            for(int i=0; i<n; i++){

                arr[i]=sc.nextInt();

            }

//
//            for(int i=0; i<n; i++){
//
//                int x=0;
//                for(int j=0; j<n; j++){
//
//                  if(i==j)continue;
//
//                  x=x^arr[j];
//                }
//
//                if(x == arr[i]){
//                    System.out.println(arr[i]);
//                    break;
//                }
//            }


            for(int i=0; i<n; i++){
                xor = xor ^ arr[i];
            }

//            System.out.println("xor "+xor);
         for(int i=0; i<n; i++){

             if((xor ^ arr[i])==arr[i]){
                 System.out.println(arr[i]);
                 break;
             }
         }



        }
    }
}
