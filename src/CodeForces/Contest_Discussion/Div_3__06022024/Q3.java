package CodeForces.Contest_Discussion.Div_3__06022024;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Q3 {

    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);

        int tc=sc.nextInt();


        while (tc-->0) {
            int n = sc.nextInt();
            int m=sc.nextInt();
            int k=sc.nextInt();
//            int[] a = new int[n];
//            for (int i = 0; i < n; i++) a[i] = sc.nextInt();
//
//
//            int[] b = new int[m];
//            for (int i = 0; i < m; i++) b[i] = sc.nextInt();


            HashMap<Integer, Integer>m1=new HashMap<>();

            for(int i=0; i<n; i++){
                int aa=sc.nextInt();
                m1.put(aa, 1);
            }

            HashMap<Integer, Integer>m2=new HashMap<>();

            for(int i=0; i<m; i++){
                int aa=sc.nextInt();
                m2.put(aa, 1);
            }


            int kk=k/2;

            int c1=kk, c2=kk;
boolean flag=true;
            ArrayList<Integer>arr=new ArrayList<>();
            for(int i=1; i<=k; i++){

                if(m1.containsKey(i)==true && m2.containsKey(i)==false){
                    c1--;
                }

                else if(m1.containsKey(i)==false && m2.containsKey(i)==true){
                    c2--;
                }


                else if(m1.containsKey(i)==false && m2.containsKey(i)==false){
                    flag=false;
                    System.out.println("NO");
                    break;
                }
                else arr.add(i);
            }



            for(int i :arr){

                if(c1==c2){
                    c1--;
                }

                else if(c1<c2)c2--;

                else c1--;
            }

if(flag==true) {
    if (c1 == 0 && c2 == 0) System.out.println("YES");
    else System.out.println("NO");
}
        }
    }
}
