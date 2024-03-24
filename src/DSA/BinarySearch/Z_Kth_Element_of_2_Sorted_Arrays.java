package DSA.BinarySearch;

import java.util.Scanner;
/**
 *
 * Discalmer :- These is an Very Important Question In terms of Interviews Prospective , Specially this Question itself.
 *
 * Problem Statement :- Hame 2 arrays given h and they are sorted , aab hmse ye pocha gya h ki jab dono ko mila dete h tab
 *                      kth element kya hoga ..
 *
 *
 *  Solution Part :-
 *        Approch-1 :- Brute Force -
 *                   1. Traverse both the arrays and store the mixed part of arrays in an another spaced array of
 *                      size ( m + n) and return the kth Value.
 *
 *                   2. TC - O(M + N)
 *                   3. SC - O(M + N)
 *
 *        Approch-2 :- Better Solution -
 *
 *                   1. Hame puri array store karne ki jarurat nhi h , we only want the kth value .
 *                      so we can use the count variable and index1 and our ans storage variables.
 *
 *                   2. TC - O(M + N)
 *                   3. SC - O(1)
 *
 *       Approch-3 :- Best-optmized Solution -
 *
 *                   1. Hamara focus sirf kth elemnent  par h agar even array h to agar wo do-values mil gyi to we are over.
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
 *
 *
 *               ** Big Edge Cases **  --->> Ye problem median wali ye aise hi alag h ki yha par do edge acases hote h.
 *                                1.  pos = 8 ho , aur array1 se sirf do element aaye and array2 to khud 4 length ki ho
 *                                    to hmm , jante h ki array1 se jada lene padnge elements to ya to meri trah baad mai ek condn
 *                                    ad krdo ya fir s par hi condition laga do shuru mai e ki trah.
 *
 *
 *
 *                                2. Dusra edge case ye hoga ki pos = 2 h and array1 se mid1 hi 6 hogya is baat ka to koi
 *                                   sense hi nhi isi liye e=min(pos, n1).
 *
 * ***/
public class Z_Kth_Element_of_2_Sorted_Arrays{

    public static int BinarySolution(int[]arr1, int[]arr2, int pos){

        int n1 = arr1.length;
        int n2 = arr2.length;
        int n = n1 + n2;
        if(n1 > n2) return BinarySolution(arr2, arr1 , pos);

        int LeftGroupSize = pos;

        int s = 0;
        int e = Math.min(n1 , pos);

        while (s <= e){

            int mid = (s + e)/2;
            int mid1 = mid;
            int mid2 = (LeftGroupSize - mid1);

            if(mid2 > n2){
                s = mid1+1;
                continue;
            }
            int l1 = Integer.MIN_VALUE;
            int l2 = Integer.MIN_VALUE;
            int r1 = Integer.MAX_VALUE;
            int r2 = Integer.MAX_VALUE;

            if(mid1 > 0) l1 = arr1[mid1-1];
            if(mid2 > 0) l2 = arr2[mid2-1];
            if(mid1 < n1) r1 = arr1[mid1];
            if(mid2 < n2) r2 = arr2[mid2];

            if(l1 <= r2 && l2 <= r1){
                return Math.max(l1, l2);
            }

            else if ( l1 > r2 ){
                e = mid1-1;
            }

            else s = mid1 + 1;
        }

        return -1;
    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n1=sc.nextInt();
        int n2=sc.nextInt();
        int[]arr1=new int[n1];
        int[]arr2=new int[n2];
        for(int i=0; i<n1; i++)arr1[i]=sc.nextInt();
        for(int i=0; i<n2; i++)arr2[i]=sc.nextInt();

        System.out.println("Enter the kth Position of Element : ");
        int pos = sc.nextInt();

        System.out.println("Value of Element at kth Position is ?: " +  BinarySolution(arr1 , arr2, pos));
    }
}
