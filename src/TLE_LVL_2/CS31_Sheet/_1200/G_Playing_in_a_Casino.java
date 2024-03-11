package TLE_LVL_2.CS31_Sheet._1200;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/***
 * Problem :- We have given a 2d matrix of size n rows and m colums and we have to calculate the sum as -
 *            for all m columns, we have to perform the absolute difference in n rows-
 *
 *            eg->  1 2 3
 *                  3 2 1
 *                  1 2 1
 *                  4 2 7
 *
 *                  |1-3| + |1-1| + |1-4| +|3-1| + |3-4| + |1-4| + .. for all m.
 *
 * Approches 1 :- Just a Brute force as - TC - O(N * M * M)  --> TLE.
 *
 * Approch2 (Good Solution):-
 *
 *                 Matlab hme O(n * m * log(m)) tak bhi kaam ho jaye to ok h.
 *
 *           Step-1 --> Kyuki hme pairs mai deal krna h to to columns ke hisab se chlna hoga.
 *
 *           Step2 --> Sabse phle to hme ye baat samajni hogi ki O(M*M) h wo Saree pairs between two ko generate karta h, agar hmm
 *                     Numbers ka arrangemnet idhar odhar kar bhi de to bhi , it will not affect.
 *
 *           step-3 --> Now we will do sorting so that it will give some clarity.
 *
 *           step-4 --> Aab Absolute ka Matlab hota h distamce between x points, to hmm ye del=khenge ki par ek adajacent
 *                      Element kitni baar count hua hoga.
 *
 *           Step-5 --> Ye kaam to ek hi loop mai ho jayega.
 *
 *
 *Learnings :- 1. jo Pairs nikalne wali array hoti h osko sort krlo koi dikkat nhi , pairs to same hi bnayenge.
 *             2. Jab bhi mod aaye , distance kitrah dekho on number line.
 *             3. aur os distance ko fragments mai batoo.
 *             4. Jab bhi product, sum kr rhe ho hmesha har ek unit ke aage long use kro.
 *
 * Edge Case --> Penalty1 --> Use of long in Product and sum.
 *
 *
 *
 *
 * **/
public class G_Playing_in_a_Casino{

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();

        while (tc-->0){

            int n=sc.nextInt();
            int m = sc.nextInt();

            int[][]arr=new int[n][m];
            for(int i=0; i<n; i++){
                for(int j=0; j<m; j++){
                    arr[i][j]=sc.nextInt();
                }
            }

            long ans = 0;

            for(int i=0; i<m; i++){

                ArrayList<Integer>temp = new ArrayList<>();

                for(int j=0; j<n; j++){

                    temp.add(arr[j][i]);
                }

                Collections.sort(temp);

                int nn = temp.size();
                for(int k=0; k<nn-1; k++){
                    ans+=((long) (k+1)*(long) (nn-k-1)*(long) Math.abs(temp.get(k)-temp.get(k+1)));
                }

            }

            System.out.println(ans);
        }

    }
}
