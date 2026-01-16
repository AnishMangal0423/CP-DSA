package PatternsDSA.SlidingWindow.Patterns.Pattern_A;

import java.util.Scanner;

public class Constant_Window_Size {

    public static int Maxsum(int[]arr, int k){

        int n = arr.length;
        int l=0, r=0, maxsum=0, sum=0, len=0;  //Step-1

        if(k > n) return -1;

        while(r < n){
            sum += arr[r];   //Step-2

            if(r-l+1 == k){    // Step-3
                maxsum = Math.max(maxsum, sum);
                sum -= arr[l];
                l++;
            }

            r++;  // Step-4
        }


        return  maxsum;
    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[]arr = new int[n];
        System.out.println("Enter the elements of array :");
        for(int i=0; i<n; i++)arr[i]=sc.nextInt();
        System.out.println("Enter the size of subarrays you want to encounter :");
        int k = sc.nextInt();
        System.out.println("Subarray with maximum sum of fixed length k is : " + Maxsum(arr, k));
    }
}
