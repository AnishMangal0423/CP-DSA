package Codechef.Contest_discussion;

//import java.util.Scanner;
//
//public class Q{
//
//    public static void main(String[] args) {
//
//        Scanner sc= new Scanner(System.in);
//
//        int tc=sc.nextInt();
//
//        while (tc-- > 0) {
//            int n = sc.nextInt();
//
//            int[]arr=new int[n];
//            for(int i=0; i<n; i++)arr[i]=sc.nextInt();
//        }
//
//        int n=sc.nextInt();
//
//    }
//}
import java.util.*;
import java.lang.*;
import java.io.*;

public class Q
{
    public static void main (String[] args) throws java.lang.Exception
    {
        // your code goes here

        Scanner sc= new Scanner(System.in);

        int tc=sc.nextInt();

        while (tc-- > 0) {
            int n1 = sc.nextInt();
            int n2=sc.nextInt();
            int[]a=new int[n1];
            int[]b=new int[n2];
            for(int i=0; i<n1; i++)a[i]=sc.nextInt();

            int maxi=-1;
            for(int i=0; i<n2; i++){
                b[i]=sc.nextInt();
                maxi=Math.max(maxi, b[i]);
            }

            ArrayList<Integer>arr=new ArrayList<>();

            for(int i=n1-maxi; i<n1; i++){
             arr.add(a[i]);
            }

            Collections.sort(arr);
            int k=0;
            for(int i=n1-maxi; i<n1; i++){
                a[i]=arr.get(k);
                k++;
            }

            for(int i=0; i<n1; i++){
                System.out.print(a[i]+" ");
            }

            System.out.println(" ");
        }

//        int n=sc.nextInt();

    }
}
