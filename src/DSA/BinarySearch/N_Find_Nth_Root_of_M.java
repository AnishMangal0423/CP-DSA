package DSA.BinarySearch;

import java.util.Map;
import java.util.Scanner;

/***
 *
 * Concept/Problem :- We have to find Mth root of Number N.
 *
 * Given --> n<=30
 *           m <= 10^9
 *
 * Approch :- There are Many approches-
 *     Approch-1 :- for starting from 1 till N go and do check if its multiplication >= N or Not.
 *                  O(M*N) think that M = 1, N = 10^9 .. Now N will go till 10^9.
 *                                    M = 2, N = 10^9
 *                                    M = 3 , N = 10^9 it means from n=1 till 10^9 we will go and no m loop for every i, in worst case when m=1.and n = 10^9.
 *
 *                                    TC - O(M*logN) in worst case. because math.pow() will take logN time.
 *
 *
 *   Approch-2 :- Binary serach :- it will take -
 *                   TC - O(LogM * LogN)
 *                   sc - O(1).
 *
 *
 *   Learning :- Math.pow() takes , logN time.
 * **/
public class N_Find_Nth_Root_of_M{

    public static long MthRoot(long m, long n){

        long s = 1;
        long e = n;

        while (s <= e){

            long mid = (s + e)/2;
            long exponentVal = (long) Math.pow(mid ,m);
            if( exponentVal == n)return mid;
            else if(exponentVal < n) s = mid+1;
            else e=mid-1;
        }

        return -1;
    }
    public static void main(String[] args) {

        System.out.println("Enter the M and N :- ");

        Scanner sc = new Scanner(System.in);
        long m = sc.nextLong();
        long n = sc.nextLong();

        System.out.println("Square Root of "+n + " is : " + MthRoot(m , n));

    }
}
