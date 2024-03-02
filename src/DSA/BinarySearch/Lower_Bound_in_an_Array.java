package DSA.BinarySearch;

import java.util.Scanner;

/**
 *
 * Lower Bound Defination :- The Main Thing in  this Question is to understand the Correct Defination of
 *                           Lower Bound in an Array for a Number .
 *
 *               Mathematical Defination :-  Samllest index at which arr[ind] >= x
 *               Emotional Defination  :-  Index at which i can insert a Certain value sarting point
 *
 *               If(element is present) : it's lowest index value will be our ans.
 *               if (not present ) : element that is bigger then it's index will be our ans .. because we can insert
 *                                   our element on that index.
 *
 *
 *      Brute Force :-  Linear Search
 *
 *      Optimized Solution :-
 *      Time Complexity :- O(logN)
 *      Space Complexity :- O(logN)  ~ Can also reduce it to 1 by linear Binary search Iterative soln also.
 *
 *
 * **/
public class Lower_Bound_in_an_Array{

    public static int LowerBound(int[]arr, int x, int l, int r){

        if(l > r)return l;
        int mid = (l + r) / 2;

        if(arr[mid] == x) return LowerBound(arr , x, l, mid-1);
        else if(arr[mid] > x)return LowerBound(arr, x, l, mid-1);
        else return LowerBound(arr, x, mid+1, r);


    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Size of Array : ");
        int n = sc.nextInt();

        int[]arr = new int[n];
        for(int i=0; i<n; i++)arr[i]=sc.nextInt();

        System.out.println("Enter the value of Key : ");
        int x = sc.nextInt();

        System.out.println("The Lower Bound Index of x is : "+ LowerBound(arr, x, 0, n-1));
    }
}
