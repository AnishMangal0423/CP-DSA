package TLE_LVL_2.CS31_Sheet._1200;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * Concept :- Finding the Count of Local Minimums Points in an Array.
 *Approches :-
 *           1st Approch :- I have tried of using the dp array or something like that, But it was Not satisfying Anymore.
 *           2nd Approch :- Maintaining Decreasing and Increasing counter and Toggling according to situations.
 *
 *    Edge Cases(Approch-3) :- Is problem mai Duplicates bhi the too log jada confuse hote rhte h about more edge cases, sabse acha tarika
 *                  To yhi h nayi , array bna lo..
 *                  and Now aab to simple i=1, i=n-2 tk peak elements dekh lo and i=0, i=n-1 to hamesha hi answer honge.
 *
 *  Learning :- Jab kabhi bhi hme ek array given ho aur, there can be repetion of Elements also allowed  aur hme ye dikh
 *              Rha ho ki hmm repetation se chutkara mil sakta h , do it ..
 *              aur jab bhi distinct elements ka Local min points nikalne ho hmaesha , prev, curr, and next ka
 *              Concept hi best h , first and last element to hamesha hi ans mai rhenge if size of array > 1.
 *
 *
 *
 *              TC - O(N)
 *              SC - O(N) At worst case.
 *
 *
 *
 * **/
public class F_Constrast_Value {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();

        while (tc-- > 0) {

            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) arr[i] = sc.nextInt();

            ArrayList<Integer> ar = new ArrayList<>();

            int prev = -1;
            for (int i = 0; i < n; i++) {
                if (arr[i] != prev) {
                    ar.add(arr[i]);
                    prev = arr[i];
                }
            }

          int count = 1;

            for(int i=1; i<ar.size()-1; i++){

                int prevv = ar.get(i-1);
                int curr = ar.get(i);
                int next = ar.get(i+1);

                if(prevv>curr && curr<next || prevv<curr&& curr>next)count++;

            }


            if(ar.size() > 1)count++;
            System.out.println(count);
        }
    }
}
