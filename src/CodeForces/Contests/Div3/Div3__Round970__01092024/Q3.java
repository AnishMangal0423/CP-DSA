package CodeForces.Contests.Div3.Div3__Round970__01092024;

import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;

public class Q3 {
    public static void main(String[] args) {

        Scanner sc  = new Scanner(System.in);


     long[] vaal = new long[1000000];

     for(int i=0; i<1000000; i++){
         vaal[i]= (i*(i+1))/2;
     }
     vaal[0]=1;
//        System.out.println(Arrays.toString(vaal));
        int tc = sc.nextInt();

        while (tc-->0){

//            int n = sc.nextInt();
//            int[]arr = new int[n];
//            for(int i=0; i<n; i++)arr[i]=sc.nextInt();
//
//

            long l=sc.nextInt();
            long  r = sc.nextInt();
            long ans = 0;

            if(l==r) System.out.println(1);
            else{

                long diff = r-l;

   int k;
              for(k=1; k<1000000; k++){
                  if(vaal[k] < diff)ans =k;
                  else break;
              }

              long rr = diff - vaal[k];
              long r2 = vaal[k]-vaal[k-1];
//                System.out.println(rr+" jj "+r2);
              if(rr!=0 && rr<r2)ans--;
                System.out.println(ans+2);
            }


        }
    }
}
