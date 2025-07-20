package DSA.NeetCode.Greedy;

import java.util.Scanner;


/**
 * Q. We have given an array and we have to return the length of longest subarray in such a way that
 *    in subaary the parity of signs [> , <] should be alternate like [< , > , < , >] is allowed but
 *    [> , >] or [< , <] is not allowed.
 *
 * Ans - We used the approach of comparision between two but you get the code messs in it. so it is always better
 *       to handle the case of len=1, len=2 and then handle by making len=3
 *
 * Some Hints-
 * 1. How you will handle the comparisions in Subarrays Problem
 * 2. How you will handle the consicutive duplicate elements.
 * ***/
public class D_Longest_Turbulent_Subarray_978 {

    public static int maxTurbulenceSize(int[] arr) {
        int n = arr.length;
        if(n <=1)return 1;
        if(n==2 && arr[0]==arr[1])return 1;
        if(n == 2)return 2;
        int len =1;
        int maxi=1;

        for(int r=1; r<n-1; r++){

            if(arr[r-1] > arr[r] && arr[r] < arr[r+1]){
                len++;
            }
            else if( arr[r-1] < arr[r] && arr[r] > arr[r+1]){
                len++;
            }

            else if(arr[r] == arr[r+1]){
                len=1;
                continue;
            }
            else len=1;

            maxi = Math.max(maxi, len+1);
        }
        return maxi;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[]arr = new int[n];
        for(int i=0; i<n; i++)arr[i]=sc.nextInt();
        System.out.println("The maximum Length of Turbulent Subarray :" + maxTurbulenceSize(arr));
    }
}

