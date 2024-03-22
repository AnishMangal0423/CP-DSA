package DSA.BinarySearch;
import java.util.Scanner;

/**
 *
 * Concept :- Binary Search on Intervals.
 * Approch :- Brute Force-
 *            1. TC - O(N)
 *            2. SC - O(1)
 *
 *
 * Approch-2 :- Binary Search-
 *            Step-1:- Hmm , given array par normal Binary search to Nhi laga sakte.
 *
 *            Ste-2:-  Binary search on Numbers isliye nhi lagega kyuki wo to ans ko minimum ya maximum ki traf lekar jata h
 *                     isliye left or right half bhi delete hote h.
 *
 *            Step-3:- Hmm array ke kisi bhi index par ye nikal sakte h ki osse phle kitne elements missing h via (arr[i]-(i+1))
 *                     se.
 *
 *            Step-4:- to bas hmm interval nikal lenge jisme hmara ans lie karega.
 *
 *            Step-5:- Hamesha interval kuch esa banega [high , low] in an array to high + 1 + pos ans hoga, ye to derive bhi
 *                     kar sakte h.
 *
 *            1. Arrays is sorted.
 *            2. Interviewer will tell you to optimize.
 *            3. TC - O( logN )
 *            4. SC - O( 1 )
 *
 *
 *
 * ***/

public class T_kth_Missing_Number_Positive_Number{
    public static int BinarySearch(int[]arr, int pos){

        int n = arr.length;
        int s = 0;
        int e = n-1;

        while (s <= e){

            int mid = (s + e)/2;
            int missingNumbers = arr[mid] - (mid+1);

            if(missingNumbers < pos) s = mid+1;
            else e=mid-1;
        }

        return e + pos + 1;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[]arr=new int[n];

        for(int i=0; i<n; i++)arr[i]=sc.nextInt();

        int pos = sc.nextInt();

        System.out.println("Kth Missing Number in an Array is ?: " + BinarySearch(arr , pos));

    }
}
