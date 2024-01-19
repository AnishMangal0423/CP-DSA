package TLE_LVL_2.CS31_Sheet;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

public class Satisfying_Constraints{

    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);

        int tc=sc.nextInt();
        sc.nextLine();

        while (tc-->0){

            int n=sc.nextInt();
            ArrayList<Integer>arr=new ArrayList<>();

            int y2=Integer.MAX_VALUE;
            int y1=Integer.MIN_VALUE;
            for(int i=0; i<n; i++){
                int a=sc.nextInt();
                int b=sc.nextInt();

                if(a==1){
                    y1= Math.max(y1, b);
                }
                if(a==2){
                    y2=Math.min(y2, b);
                }

                if(a==3){
                    arr.add(b);
                }
            }


         if(y2 < y1) System.out.println(0);

         else{
             int len=y2-y1+1;
         for(int i : arr){

             if(i>=y1 && i<=y2)len--;
         }

             System.out.println(len);
         }



        }
    }
}
