package CodeForces.Contests.Div3.Div3__Round925__12032024VC;

import java.util.HashMap;
import java.util.Scanner;

public class Q3 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int tc=sc.nextInt();

        while (tc-->0){

              int n = sc.nextInt();
              int[]arr=new int[n];
              for(int i=0; i<n; i++)arr[i]=sc.nextInt();

       // first-

//            int fir=arr[0];
//            int l=0; int e=n-1;
//
//            while (l <= e &&(arr[l]==fir || arr[e]==fir)){
//                System.out.println("l "+l+""+e);
//                if(arr[l]==fir)l++;
//                else if (arr[e]==fir) e--;
//            }
//
//
//            int sec=arr[n-1];
//            int a=0; int b=n-1;
//
//            while (a <= b && arr[a]==sec || arr[b]==sec ){
//                if(arr[a]==sec)a++;
//                else if (arr[b]==sec) b--;
//            }


            int fir = arr[0];
            int l = 0;
            int e = n - 1;

            while (l <= e && (arr[l] == fir || arr[e] == fir)) {
//                System.out.println("l " + l + " " + e);
                if (arr[l] == fir) l++;
                else if (arr[e] == fir) e--;
            }

            int sec = arr[n - 1];
            int a = 0;
            int b = n - 1;

            while (a <= b && (arr[a] == sec || arr[b] == sec)) {
                if (arr[a] == sec) a++;
                else if (arr[b] == sec) b--;
            }
            System.out.println(Math.min((e-l+1) , (b-a+1)));



//            System.out.println(ans);
        }
    }
}
