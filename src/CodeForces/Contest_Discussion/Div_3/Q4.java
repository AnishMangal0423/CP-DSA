package CodeForces.Contest_Discussion.Div_3;

import java.util.*;

public class Q4 {

    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);

        int tc=sc.nextInt();

        while (tc-->0) {

            int n = sc.nextInt();


            long[] arr1 = new long[n];
            int m = sc.nextInt();
            for (int i = 0; i < n; i++) arr1[i] = sc.nextLong();
            long[] arr2 = new long[m];

            for (int i = 0; i < m; i++) arr2[i] = sc.nextLong();


            Arrays.sort(arr1);
            Arrays.sort(arr2);

                int i=0; int j=n-1;

                int k=0; int l=m-1;

                long diff=0;

                while(i<=j){

                    if(Math.abs(arr1[i]-arr2[l]) > Math.abs(arr1[j]-arr2[k])){
                        diff+=Math.abs(arr1[i]-arr2[l]);

                        i++;
                        l--;
                    }

                    else{
                        diff+=Math.abs(arr1[j]-arr2[k]);
                        j--;
                        k++;
                    }
                }


                System.out.println(diff);

        }
    }
}
