package TLE_LVL_2.CS31_Sheet._1200;

import java.util.Scanner;

/**
 *
 * Question :- Hme ek array given h , aur hme os array se do indexes ans krne h l, r and aab jo l, r se subsegment bnega..
 *             [l...r] to us subsegment ka min and maximum element l, r nhi hone chaiye ya fir hmm khe , min and max'm dono
 *             os range bich mai lie koi extremee pe nhi hona chaiye ..
 *             if possible print l, r.
 *             if not print -1.
 *
 *
 *
 * Approch-1 :- Step-1 :- Sbase phle maine sorting ka socha , it will not work because position agar xhange krdi to
 *                        window ke elements change ho jayenge min max bagera.
 *
 *              Step-2 :-  prefix/suffix min max mai kaam nhi karte h. kyuki prefix suffix tab kaam karte h jab onke Oppositess
 *                         Ex- add/sub , mul/divide, xor/xor, and all.
 *
 *              Step-3 :- Two Pointers --> if l or r will be belong to any min or max then it will not be possible to
 *                                         make the smaller set by having that element.
 *
 *                        Now we have to find the min and max in o(1) time so we used the [1...n] perumutation and two pointers on it as well.
 *
 *
 *
 *  TC - O(N)
 *  SC - O(N)
 *
 *  It was Done by me.
 *
 *
 *
 *
 * ***/
public class H_Dora_and_the_Search{
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int tc=sc.nextInt();
        while (tc-->0) {
            int n = sc.nextInt();
            int[] arr1 = new int[n];
            int[] arr2 = new int[n];

            for (int i = 0; i < n; i++) arr1[i] = sc.nextInt();
            for (int i = 0; i < n; i++) arr2[i] = i + 1;

            int l = 0, r = n - 1, s = 0, e = n - 1;

            boolean flag = false;
            while (l < r) {

                 if(arr1[l]==arr2[s]){
                     l++;
                     s++;
                 }
                 else if(arr1[l]==arr2[e]){
                     l++;
                     e--;
                 }

                 else if(arr1[r]==arr2[s]){
                     r--;
                     s++;
                 }

                 else if(arr1[r]==arr2[e]){
                     r--;
                     e--;
                 }

                 else{
                     System.out.println(l+1 + " "+ (r+1));
                     flag=true;
                     break;
                 }
            }

            if (flag == false) System.out.println(-1);
        }
    }
}
