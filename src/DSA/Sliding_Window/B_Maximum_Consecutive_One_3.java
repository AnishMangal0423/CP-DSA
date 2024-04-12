package DSA.Sliding_Window;
import java.util.Scanner;

/**
 * Concept :- 2-Pointer Sliding Window.
 *
 * Approches :- Worst :- Brute Force Approch -
 *              Just use O(N*N) Solution to keep the track for every index and max will be our ans.
 *              TC - O(N^2) ,  SC = O(1)
 *
 *
 *
 *              Better :- 2-Pointer Approch -
 *              Use start and end pointer , lekin jab flips > maxflips ho jayee to start ko bhi aage badana with fast pointer remain at
 *              its position
 *              TC - O(2N)  SC - O(1)
 *
 *
 *              Best :- 2-Pointer Approch -
 *              so is approch mai hmm kabhi bhi end pointer ko start ke liye wait nhi karwayenge hmm hmaesha end ko chalate rhenge .
 *              so make the window.
 *              TC - O(N)  SC - O(1)
 *
 *  Note :- Do dry Run to understand more better.

 * **/
public class B_Maximum_Consecutive_One_3{

    public static int maxLength(int[]arr, int maxFlips){

        int start = 0; int end = 0;
        int maxlen = 0;
        int flips = 0;

        while (end < arr.length){

            if(arr[end]==0){

                if(flips >= maxFlips){
                    while (start <= end && arr[start]!=0){
                        start++;
                    }
                    start++;
                }

                else{
                    flips++;
                }
            }

            maxlen = Math.max(maxlen , end-start+1);
            end++;
        }

   return maxlen;
    }


    public static int maxlenOptmized(int[]arr, int maxFlips){

        int start = 0; int end = 0;
        int maxlen = 0;
        int flips = 0;

        while (end < arr.length){

               if(arr[end]==0)flips++;
               if(flips>maxFlips){
                   if(arr[start]==0)flips--;
                   start++;

               }

               if(flips <= maxFlips) maxlen= Math.max(maxlen , end-start+1);
               end++;
        }

        return  maxlen;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[]arr=new int[n];
        for(int i=0; i<n; i++)arr[i]=sc.nextInt();

        int maxFlips = sc.nextInt();

        System.out.println("Maximum Substring Length of Consectuive 1's is ?: " + maxlenOptmized(arr , maxFlips));
    }
}
