package DSA.BinarySearch;

import java.util.Scanner;

/**
 *
 *Concept :- Simple Binary Search.
 * Learning :- Bas wahi h same 1 jese bas isme duplicates bhi h to index nhi bta sakte h isliye , true/false par baat kr rhe.
 *
 * Tc - o(logN)
 * Sc - o(1)
 * **/
public class H_Search_In_Rotated_Sorted_Array_2{

    public static boolean BianrySearch(int[]arr, int target){

        int s = 0;
        int e = arr.length-1;

        while (s <= e){

            int mid = (s + e)/2;

            if(arr[mid]==target)return true;

            else if(arr[s] <= arr[mid]){
                 if(target >= arr[s] && target<=arr[mid]) e = mid-1;
                 else s = mid+1;
            }

            else {
                if(target >= arr[mid] && target<= arr[e]) s = mid+1;
                else e = mid-1;
            }

        }

        return false;
    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("enter the size of array- ");
        int n = sc.nextInt();
        int[]arr = new int[n];
        for(int i=0; i<n; i++)arr[i]=sc.nextInt();

        System.out.println("Enter the target element in array- ");
        int target = sc.nextInt();

        System.out.println("Is Target Element Present in an Array :- " + BianrySearch(arr, target));
    }
}
