package DSA.BinarySearch;

import java.util.Arrays;
import java.util.BitSet;
import java.util.Scanner;


/***
 *
 * Concept :- Normal Binary Search.
 * Approch:- Normal Bianry Search via Recursion.
 *           TC - O(2LogN)  --> Can be done in a Single fn.
 *           SC - O(logN)
 *
 *          Iterative Method
 *          TC - O(2LogN)
 *          SC - O(1)     --> we have to make 2 fns like lower and upper bound and necause while can't do two recursive work simoutanously.
 *
 * Goals :- 1. Can find Lower Bound.
 *          2. Can find Upper Bound.
 *          3. Can Found Number of Occurances of a Key in sorted array.
 *          in O(logN) time.
 *
 *
 *
 *
 * **/


public class E_Find_First_and_Last_Occurance_of_an_Element{

    public static void BinarySearch(int[]arr, int target, int[]ans, int s, int e){

        if(s > e)return;

        int mid = (s + e)/2;

        if(arr[mid]==target){
            if(ans[0] > mid) ans[0] = mid;
            if(ans[1] < mid) ans[1] = mid;

            BinarySearch(arr, target, ans, s, mid-1);
            BinarySearch(arr, target, ans, mid+1, e);
        }

        else if(arr[mid] > target) BinarySearch(arr, target, ans, s, mid-1);
        else BinarySearch(arr, target, ans, mid+1, e);
    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of Array :- ");
        int n = sc.nextInt();
        int[]arr = new int[n];
        for(int i=0; i<n; i++)arr[i]=sc.nextInt();

        System.out.println("Enter the Target Element , whose range to be found :- ");
        int target = sc.nextInt();

        int[]ans = new int[2];
        ans[0]=Integer.MAX_VALUE; ans[1]=-1;

        BinarySearch(arr, target, ans, 0, n-1);
       if(ans[0]==Integer.MAX_VALUE)ans[0]=-1;

        System.out.println("First and Last Occurance Index is :- "+Arrays.toString(ans));

        if(ans[0]==-1) System.out.println("Count of Target Elements in sorted Array is 0 ");
        else System.out.println("Count of TARGET elements in Sorted Array is "+ (ans[1]-ans[0]+1));

    }
}
