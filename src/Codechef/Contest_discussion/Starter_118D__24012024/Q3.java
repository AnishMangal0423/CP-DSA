package Codechef.Contest_discussion.Starter_118D__24012024;

import java.util.Scanner;

public class Q3 {
    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);

        int tc=sc.nextInt();

        while (tc-- >0){

            int n=sc.nextInt();
            int m=sc.nextInt();

            int[]arr=new int[n];

            int cnt=0; int val=0;
            for(int i=0; i<n; i++){

                arr[i]=sc.nextInt();
                val+=arr[i];

                if(val >= m){
                    cnt++;
                    val=0;
                }
            }
        }
    }
}
