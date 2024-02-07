package CodeForces.Contest_Discussion.Div_3__06022024;

import javax.swing.*;
import java.util.HashMap;
import java.util.Scanner;

public class Q2 {

    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);

        int tc=sc.nextInt();

        while (tc-->0) {


            int n = sc.nextInt();

            int[] arr = new int[n];
            for (int i = 0; i < n; i++) arr[i] = sc.nextInt();

            HashMap<Character, Integer>m=new HashMap<>();

            StringBuilder sb=new StringBuilder();
            char cc='a';

            for(char aa='a'; aa<='z'; aa++)m.put(aa, 0);


            for(int i=0; i<n; i++){

               if(arr[i]==0){
                   sb.append(cc);
                   m.put(cc, 1);
                   cc++;
               }

               else{

                   for(char kii : m.keySet()){
                       int val = m.get(kii);

                       if(val==arr[i]){
                           m.put(kii, val+1);
                           sb.append(kii);
                           break;
                       }


                   }

               }

            }
            System.out.println(sb.toString());
        }
    }
}
