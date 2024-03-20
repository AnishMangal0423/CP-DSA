package TLE_LVL_2.CS31_Sheet._1200;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class L_Friends_and_the_Restaurant{

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        while (tc-->0){
            int n = sc.nextInt();
            long[]arr1=new long[n];
            long[]arr2=new long[n];

            for(int i=0; i<n; i++)arr1[i]=sc.nextLong();
            for(int j=0; j<n; j++)arr2[j]=sc.nextLong();

            ArrayList<Long>diff=new ArrayList<>();
            for(int i=0; i<n; i++)diff.add(arr2[i]-arr1[i]);
            Collections.sort(diff);
//            System.out.println(diff);

            int s=0;
            int e=n-1;
            long count =0;
            while (s < e){

                if(diff.get(s)+diff.get(e) >= 0){
                    s++; e--; count++;
                }

                else{
                    s++;
                }
            }

            System.out.println(count);
        }
    }
}
