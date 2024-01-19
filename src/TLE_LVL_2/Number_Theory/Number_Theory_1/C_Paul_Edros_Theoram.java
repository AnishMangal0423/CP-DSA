package TLE_LVL_2.Number_Theory.Number_Theory_1;

import java.util.Scanner;

public class C_Paul_Edros_Theoram{

    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);

        int size=10000000;

        int[]sieve=new int[size];

        sieve[0]=1;
        sieve[1]=1;
        for(int i=2; i<size; i++) {

            if(sieve[i]==0) {
                for(int j=2*i; j<size; j+=i){
                    sieve[j]=1;
                }
            }
        }

        int[]ans=new int[size];
        for(int x=0; x<=5000; x++){
            for(int y=0; y<100; y++){

                int res = x*x + y*y*y*y;

                if(res >= size) break;
                if(sieve[res]==0) ans[res]=1;

            }
        }

        for(int i=2; i<size; i++){
            ans[i]+=ans[i-1];
        }

        int tc=sc.nextInt();

        while (tc-->0){

            int n=sc.nextInt();

            System.out.println(ans[n]);
        }

        }
    }

