package DSA.BinarySearch;

import java.util.Scanner;

/***
 *
 * Concept :- Binary Search on Number Line.
 * Approch :- Root N approch of using for loop from i=0 till i=rootN.
 *            TC - O(Root N) --> aachi nhi hoti h jayada.
 *
 *            Using Binary search kyuki aadhe numbers ko reject kr skate h.
 *            so TC - O(LogN)
 *               SC - O(1)
 * **/
public class M_Square_Root_of_a_Number{

    public static long SquareRoot(long n){

        long s = 1;
        long e = n;

        if(s==e)return 1;
        while (s < e){

            long mid = (s + e)/2;
            long val = (mid*mid);
            if(val == n)return mid;
            else if(val < (long) n) s = mid+1;
            else e = mid;
        }

        return s-1;
    }
    public static void main(String[] args) {

        System.out.println("Enter the Number :- ");

        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();

        System.out.println("Square Root of "+n + " is : " + SquareRoot(n));

    }
}
