package DSA.BinarySearch;

import java.util.Scanner;

/**
 *
 * Concept :- Binary search in terms of maximum element.
 * Approch :- Linear search O(N).
 *
 * Binary Search Approch :- Hme ye pata h ki peak ka matlab maximum hota h , aab agar kisi bhi mid ke addosi padosi
 *                          Bade hue too we will move in that direction.
 *
 *                          It means it was the question of Binary serach of finding local maximum.
 *                          BS on min/max.
 *
 *     TC - O(LOgn)
 *     sc - O(1)
 *
 *
 * Constraints -->
 *             1. Both extremes are -Infinity , so helping to do BS.
 *             2. arr[i] != arr[i+1]
 *
 *
 *Note --->  It is not mandatory that array should be sorted because we are dealing with only 3 numbers (i-1, i, i+1) and cndition
 *           of -infinity is helping us to rely the maximum to be as peak. and Binary serach apply.
 *
 * **/
public class L_Peak_Element_in_an_Array{

    public static int BinarySearch(int[]arr){
        int n = arr.length;

        if(n==1 || arr[0]> arr[1])return 0;
        if(arr[n-1] > arr[n-2])return n-1;

        int s = 1;
        int e = n-2;

        while (s < e){

            int mid = (s + e)/2;

            if(arr[mid] > arr[mid-1] && arr[mid] > arr[mid+1])return mid;

            else if(arr[mid] < arr[mid-1]) e= mid-1;

            else s = mid+1;
        }

        return s;
    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of array :");
        int n = sc.nextInt();

        int[]arr=new int[n];
        for(int i=0; i<n; i++) arr[i]=sc.nextInt();

        System.out.println("Index of Peak Element in an Array is : " + BinarySearch(arr));
    }
}
