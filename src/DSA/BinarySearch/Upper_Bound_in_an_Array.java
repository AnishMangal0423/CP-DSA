package DSA.BinarySearch;

import java.util.Scanner;


/**
 *
 * Upper Bound Defination :- The Main Thing in  this Question is to understand the Correct Defination of
 *                           Lower Bound in an Array for a Number .
 *
 *               Mathematical Defination :-  Samllest index at which arr[ind] >= x
 *               Emotional Defination  :-  Index at which i can insert a Certain value Ending point
 *
 *
 *               Eg - [1,2,2,3,3,3,6]  --> if x = 3 to fir 6th index par 3 aayega , matlab 6 ans h .. that's sit.
 *                                     --> if x = 5 to fir, 6th index par 5 aayega , matlab 6 ans h .. that's sit..
 *
 *                                     yhi lower.. upper bound h baaki sab to inke variation hote h..
 *
 *
 *      Brute Force :-  Linear Search
 *
 *      Optimized Solution :-
 *      Time Complexity :- O(logN)
 *      Space Complexity :- O(1)
 *
 *
 * **/
public class Upper_Bound_in_an_Array{


    public static int UpperBound(int[]arr, int x, int si, int ei){

        int ans = arr.length;

        while (si <= ei){

            int mid = (si + ei) / 2;

            if(arr[mid] > x){
                ans = mid;
                ei = mid - 1;
            }

            else si = mid + 1;
        }
    return ans;
    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Size of Array : ");
        int n = sc.nextInt();

        int[]arr = new int[n];
        for(int i=0; i<n; i++)arr[i]=sc.nextInt();

        System.out.println("Enter the value of Key : ");
        int x = sc.nextInt();

        System.out.println("The Upper Bound Index of x is : "+ UpperBound(arr, x, 0, n-1));
    }
}
