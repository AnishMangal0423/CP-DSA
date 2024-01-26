package Codechef.Contests.Starter_118D__24012024;

import java.util.Scanner;

public class Q4 {
    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);

        int tc=sc.nextInt();

        while (tc-- >0){

            int n=sc.nextInt();

            boolean ck=false;
            int a=0;
            int b=0;
            for(int i=31; i>=0; i--){

                int bit = (n>>i)&1;

                if(bit==1){
                    if(ck==false){
                        b|= (1<<i);
                        ck=true;
                    }
                    else{
                        a|=(1<<i);
                    }

                }
            }
            System.out.println(a +""+b);
        }
    }
}
