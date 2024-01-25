package Codechef.Contest_discussion;

import java.util.Scanner;

public class Q5 {
    public static void main(String[] args) {


        Scanner sc=new Scanner(System.in);

        int tc=sc.nextInt();

        while (tc-- >0){

            int n=sc.nextInt();

            boolean ck=false;

            int cnt=1;
            for(int i=31; i>=0; i--){

                int bit = (n>>i)&1;

                if(bit==0){
                   cnt*=2;

                }
            }
            System.out.println(cnt);
        }
    }
}
