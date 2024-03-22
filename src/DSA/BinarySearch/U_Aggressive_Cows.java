package DSA.BinarySearch;

import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;

/***
 *
 *  Concept :- Binary Search on Answers.
 *  Problem Statement  :-
 *      Hame kuch cows Given h aur ek stalls array given h , aab hme kuch cows ko place krna h.
 *      Place kuch is trah se krna h ki minimum ko max kra ja sake.
 *
 *
 *  Approches :-
 *       Approch-1 : Brute Force.
 *           [1, 5, 8, 9, 11] cows = 3. thik h to hmm dis =1 par arram se teen cows place ho jayegi.
 *           dis=2 par bhi ho jayegi, 3 par bhi ho jayegi , par 4 par bhi hogi so ans is i-1.
 *
 *           1,2,3,4,5,6,7,.... agar 4 par nhi hui to age bhi nhi hogi, ...
 *
 *        1. TC - O( N * (MAX - MIN)) ~  ( 10^5 * 10^9) Overflow.
 *        2. SC - O(1)
 *
 *
 *       Approch-2 :- Binary serach on Answers.
 *
 *       1. TC - O( N * ( log(MAX - MIN))   ~ O(10^6)
 *       2. SC - O(1)
 *
 * **/

public class U_Aggressive_Cows{

    public static boolean isPossibleAns(int[]arr, int cows, int diff){

        int N_cows=1 , prev = arr[0];

        for(int i=1; i<arr.length; i++){

            if((arr[i] - prev) >= diff){
                N_cows++;
                prev=arr[i];
            }

            if(N_cows == cows)return true;
        }
        return false;
    }
    public static int Minimum_Distance_Linear_Solution (int[]arr, int cows){

        int n = arr.length;
        int min = arr[0];
        int max = arr[n-1];

        for(int i=1; i<=(max-min); i++){

            if(isPossibleAns(arr, cows , i)==false){
                return i-1;
            }
        }

        return (max-min);
    }

    public static int Minimum_Distance_Binary_Solution(int[]arr, int cows){

        int n = arr.length;
        int min = arr[0] , max = arr[n-1];

        int s = 1;
        int e = max-min;
        int ans = 1;

        while (s <= e){

            int mid = (s + e)/2;

            if(isPossibleAns(arr , cows , mid)==true){
                ans = Math.max(ans, mid);
                s=mid+1;
            }

            else e= mid-1;
        }

    return ans;

    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the Number of Stalls : ");
        int n = sc.nextInt();
        int[]arr=new int[n];
        for(int i=0; i<n; i++)arr[i]=sc.nextInt();
        Arrays.sort(arr);
        System.out.println("Enter the Number of Cows : ");
        int cows = sc.nextInt();


//        System.out.println("Maximum Possible of Minimum Distance Between Two Cows is ?: " + Minimum_Distance_Linear_Solution(arr, cows));

        System.out.println("Maximum Possible of Minimum Distance Between Two Cows is ?: " + Minimum_Distance_Binary_Solution(arr, cows));

    }
}
