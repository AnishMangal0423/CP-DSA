package DSA.BinarySearch;

import java.util.Scanner;

/**
 *
 * Concept :- Binary Search -
 *
 * Approch :- After reading probelm will find that .. always there is the answer exist except a single case
 *            and  we have to check for cetain days , using logN time.
 *
 *            Step-1 ;- Edge Case when number of Total flowers available < required flowers.
 *            Step-2 ;- use maximum no as e and s=1 and ans = 1e9 and then solve it.. just.. simple.
 *
 *
 *            TC - O(N * log(Maximum Element))  ~~ O(N * log(10^9))
 *            SC - O(1)
 *
 * ***/


public class Q_Minimum_Number_of_Days_to_Make_M_bouquotes{

    public static long CountBouqoutes(long[]arr, long mid, long N_flowers){

        long pairs = 0;

        int val=0;
        for(int i=0; i<arr.length; i++){

            if(arr[i] <= mid){
                val++;
            }
            if(val==N_flowers){
                pairs++;
                val=0;
            }

            if(arr[i] > mid)val=0;
        }

        return pairs;
    }
    public static long BinarySearch(long[]arr, long N_Bouqoutes, long N_flowers){

        int n = arr.length;
        long maxi = -1;
        for(int i=0; i<n; i++)maxi = Math.max(maxi, arr[i]);

        long s = 1;
        long e = maxi;
        long ans = Integer.MAX_VALUE;

        while (s <= e){

            long mid = (s + e)/2;

            long temp_count = CountBouqoutes(arr, mid, N_flowers);

            if(temp_count >= N_Bouqoutes){
                  ans = Math.min(ans , mid);
                  e= mid-1;
            }

            else{
               s = mid+1;
            }
        }

return  ans;
    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Size of Array :- ");
        int n = sc.nextInt();

        long[]arr=new long[n];
        for(int i=0; i<n; i++)arr[i]=sc.nextLong();

        System.out.println("Enter the Number of Bouquotes and Numbers of Flowers in each :- ");
        long N_bouquotes = sc.nextLong();
        long N_flowers = sc.nextLong();

        if(n >= N_bouquotes*N_flowers) {
            System.out.println("Number of Days ?: " + BinarySearch(arr , N_bouquotes, N_flowers));
        }
        else{
            System.out.println(-1);
        }

    }
}
