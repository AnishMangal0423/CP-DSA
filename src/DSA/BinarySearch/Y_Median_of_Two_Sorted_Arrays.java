package DSA.BinarySearch;

import java.util.Scanner;
/**
 *
 * Discalmer :- These is an Very Important Question In terms of Interviews Prospective , Specially this Question itself.
 *
 * Problem Statement :- Hame 2 arrays given h and they are sorted , aab hmse ye pocha gya h ki jab dono ko mila dete h tab
 *                      median of the whole array kya hoga.
 *
 *
 *  Solution Part :-
 *        Approch-1 :- Brute Force -
 *                   1. Traverse both the arrays and store the mixing part of arrays in an another spaced array of
 *                      size ( m + n) and return the median Value.
 *
 *                   2. TC - O(M + N)
 *                   3. SC - O(M + N)
 *
 *        Approch-2 :- Better Solution -
 *
 *                   1. Hame puri array store karne ki jarurat nhi h , we only want the median and middle value
 *                      so we can use the count variable and index1 and index2 and our ans storage variables.
 *
 *                   2. TC - O(M + N)
 *                   3. SC - O(1)
 *
 *       Approch-3 :- Best-optmized Solution -
 *
 *                   1. Hamara focus sirf median par h agar even array h to agar wo do-values mil gyi to we are over.
 *                      ho skata h , wo dono values array1 ki ho or array2 or of both.
 *
 *                   2. To hmm kya karenge partition use karenge..ki mai hamesha choti array -> array1 ko hi maan rha huun.
 *
 *                   3. Now , mai aab ye bol rha lets suppose n1 + n2 = 8 h to 4-4 ke 2 groups bna lo.
 *                      aab hmm ye bol rhe h lets suppose left half mai , array1 ka 0 element lo to array2 ka 4-0 lene padenge
 *                      array1 ka ek liya to array2 ke 3 ...
 *
 *                  4. jitne elements le rhe h wo binary serach ke mid mai chle jayenge and l1= arr[mid-1] and r=arr[mid] as represented l1,l2,r1,r2.
 *
 *                  5. koi na koi situation par tumhari situation satisfy ho jayegi ki l1 <= r2 && l2 <= r1
 *                     and agar koi oper niche h too idhar-odhar kardo.
 *
 *                  6. Edge cases --> a.  mid=0, mid==n to us case mai l1, l2 ko min rhne do , r1,r2 ko maximum.
 *
 *                  7. TC - O(log(min(n1, n2)))
 *                     SC - O(1)
 *
 *
 * ***/
public class Y_Median_of_Two_Sorted_Arrays{

    public static double BinarySolution(int[]arr1, int[]arr2){

        int n1 = arr1.length;
        int n2 = arr2.length;

        // Step-1 :- Left-Half Group ki length nikal lo, +1 isliye odd, even dono ka kaam ho jayega.

        int totalLeft = (n1 + n2 + 1)/2;

        if(n1 > n2)return BinarySolution(arr2, arr1);
        int n = n1 + n2;
        int s = 0;
        int e = n1;  // Kyuki choices array1 par hi ki kitne elements rkhne h array1 se osi hisab se array2 ek calculate ho jayenge.

        while (s <= e){

            // Step-2 :- Variables assinged kardo partition ke wha par.
            int l1 = Integer.MIN_VALUE;
            int l2 = Integer.MIN_VALUE;
            int r1 = Integer.MAX_VALUE;
            int r2 = Integer.MAX_VALUE;

            int mid = (s + e)/2;

            int mid1=mid;
            int mid2=totalLeft-mid1;


            // Step-3 :- ye Edge Cases handle bhi ho gya aache se.
            if(mid1 > 0) l1=arr1[mid1-1];
            if(mid2 > 0) l2 = arr2[mid2-1];
            if(mid1 < n1) r1 = arr1[mid1];
            if(mid2 < n2) r2= arr2[mid2];

            // It's time to do Binary search conditions-

//            System.out.println(l1 +" "+ l2+" "+r1 +" "+ r2);


            // Step-4 :- Jab ans sahi baith jaye.
            if(l1 <= r2 && l2 <= r1){

                if(n % 2 == 0){

                    return (double) (Math.max(l1, l2) + Math.min(r1, r2))/(double)2;
                }

                else{
                    return Math.max(l1, l2);
                }
            }

            // Step-5 :- matlab left-half mai array1 ke jada elements ho gye h tabhi to l1 r2 mai jana cha rha h.
            if(l1 > r2){
                e=mid-1;
            }


            // Step-6 :- Matlab left-half mai array1 ke kam elements ka count ose badao.
            else if(l2 > r1){
                s = mid+1;
            }

        }

        // Step-7 :- Ye kabhi return hi nhi hoga.
     return -1;

    }
    public static double LinearSolution(int[]arr1, int[]arr2){

        int n1 = arr1.length;
        int n2 = arr2.length;

        int ind1=((n1+n2)/2)-1; int ind2=ind1+1;
        int ptr1Val =-1, ptr2Val =-1;
        int count=0;
        int i=0, j=0;


            while (i < n1 && j < n2) {

                if (arr1[i] <= arr2[j]) {

                    if(count==ind1)ptr1Val =arr1[i];
                    if(count==ind2)ptr2Val =arr1[i];
                    i++;
                    count++;
                } else {

                    if(count==ind1)ptr1Val =arr2[j];
                    if(count==ind2)ptr2Val =arr2[j];
                    j++;
                    count++;
                }
            }

            while (i < n1) {
                if(count==ind1)ptr1Val =arr1[i];
                if(count==ind2)ptr2Val =arr1[i];
                i++;
                count++;
            }

            while (j < n2) {
                if(count==ind1)ptr1Val =arr2[j];
                if(count==ind2)ptr2Val =arr2[j];
                j++;
                count++;
            }

            if((n1+n2)% 2==0)return (double) (ptr1Val + ptr2Val)/(double) 2;
            else return (double) ptr2Val;

        }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n1=sc.nextInt();
        int n2=sc.nextInt();
        int[]arr1=new int[n1];
        int[]arr2=new int[n2];
        for(int i=0; i<n1; i++)arr1[i]=sc.nextInt();
        for(int i=0; i<n2; i++)arr2[i]=sc.nextInt();

        System.out.println("Median of 2 Sorted Arrays is ?: " +  LinearSolution(arr1 , arr2));
        System.out.println("Median of 2 Sorted Arrays is ?: " +  BinarySolution(arr1 , arr2));

    }
}
