package LeetCode.Contest.Weekly_388_10032024;

import java.util.*;

/**
 *
 * Question --> Question ye h ki ek happiness array Given h , aab ek ye mentioned h ki hmm ek turn mai sirf ek number hi select
 *              kar sakte h , aur we have k turns to matlab in toatal k numbers liye ja sakte h,
 *              jab hmm jis no ko lete h to bakki nos Math.max(0, no-1) ho jata h. matlab bakki no's saree 1 se gir jaate h.
 *              aab nikalna ye h ki sum of choosen k numbers.
 *
 *
 *  Approch :- simple h ki -
 *             1. Arrays.sort()  --> takki maximum's piche aa jaye, whai ans maximum bna sakte h.
 *             2. Reverse karlo array ko.
 *             3. aab k numbers ke liye ans+=Math.max(0, happiness[i]-i);
 *             4. Edge cases to kuch nhi honge kyuki
 *                 1 <= k<=n  ( to koi overflow nhi krega)
 *                 long use kro.
 *                 aur approch bhi nlogn tak hi leni thi.
 *
 *
 * Learnings :- Question Understanding Mistake.
 *              1. Sabse phle to question ko clear kare bina hi Logic par chal dena is a problem, Kyuki question hota
 *                 chota h , but logic mai clarity nhi atti h fir.
 *
 *              2. Jo nikalna tha , wo bhi Glat pad liya tha. So Read and Understand Properly.
 *
 *              3. Use long when Constarints are high.
 *
 *              4. And use only NlogN when n <= 2*10^5
 *
 * Complexities :-
 *            TC - O(NlogN)
 *            SC - O(1)
 *
 * **/
public class Q2 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[]happiness = new int[n];
        for(int i=0; i<n; i++)happiness[i]=sc.nextInt();
        int k = sc.nextInt();

        Arrays.sort(happiness);

        int var = 0;
        int ss=0;
        int minus=0;
        for(int i=n-1; i>=0; i--){

            if(k>var){
                ss+=Math.max(0, happiness[i] + minus);
                minus--;
            }
            var++;
        }

        System.out.println(ss);

    }
}
