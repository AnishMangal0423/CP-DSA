package CodeForces.Contests.Div4.Div_4_964__06082024;

import java.util.Arrays;
import java.util.Scanner;

class pair{

    int fir;
    int sec;

    pair(int fir, int sec){
        this.fir=fir;
        this.sec=sec;
    }
}
public class Q3 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-->0){

            int n = sc.nextInt();
            int s = sc.nextInt();
            int m = sc.nextInt();

            pair[]arr = new pair[n];
            for(int i=0; i<n; i++){
                int a =sc.nextInt();
                int b =sc.nextInt();

                arr[i] = new pair(a, b);
            }
            Arrays.sort(arr, (a, b)->{
                if(a.fir!=b.fir)return a.fir-b.fir;
                return a.sec-b.sec;
            });



            boolean flg = false;


            for(int i=1; i<n; i++){

                if(arr[i].fir-arr[i-1].sec  >= s){
                    flg = true;
                    break;
                }
            }


            if(flg==false){

                if(arr[0].fir >=s){
                    flg=true;
                }
                else if(m - arr[n-1].sec >=s){
                    flg =true;
                }
            }

if(flg==true) System.out.println("YES");
else System.out.println("NO");

        }
    }
}
