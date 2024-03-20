package DSA.BinarySearch;

import java.util.Scanner;

/**
 *
 * Concept :- Binary Search on Numbers.
 *
 * Approch-
 *    Approch1- Brute force- check for every Number like till 10^6 * n it will give tle.
 *           TC - O(MaximumElement * N)
 *           SC - O(1)
 *
 *
 *   Approch-2 ;- Use the Binary Search to find the relevent divisor becuase big divisor will give small ans and small divisor will generate
 *                Large ans and find suitable divisor.
 *          TC - O(N * log(Maximum in array))
 *          SC - O(1)
 *
 *
 * **/
public class R_Smallest_Divisor_to_Achieve_Threshold{

    public static int Division(int[]arr, int midValue){

        int n = arr.length;

        int sum = 0;
        for(int i=0; i<n; i++){
            sum+=(arr[i]/midValue + (((arr[i] % midValue) > 0) ? 1 : 0));
        }
        return sum;
    }
    public static int BinarySearch(int[]arr, int threshold){

        int n = arr.length;
        int maxi = arr[0];
        for(int i=0; i<n; i++)maxi = Math.max(maxi, arr[i]);

        int s = 1;
        int e = maxi;
        int ans = (int)1e9;

        while (s <= e){

            int mid = (s + e)/2;

            int DivisionSum = Division(arr, mid);

            if(DivisionSum <= threshold){
                e=mid-1;
                ans = Math.min(ans, mid);
            }

            else s = mid+1;
        }
return ans;
    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Size of Array :- ");
        int n = sc.nextInt();

        int[]arr=new int[n];
        for(int i=0; i<n; i++)arr[i]=sc.nextInt();

        System.out.println("Enter the Threshold Value : ");
        int threshold = sc.nextInt();

        System.out.println("Smallest Relevant Divisor is : " + BinarySearch(arr, threshold));

    }
}
