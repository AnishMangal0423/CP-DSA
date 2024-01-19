package TLE_LVL_2.Number_Theory.Number_Theory_1;

import java.util.Scanner;


public class F_t_Primes{

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n=sc.nextInt();

        long[]arr=new long[n];

        for(int i=0; i<n; i++)arr[i]=sc.nextLong();

        int N= 1000007;
        int[]sieve = new int[N];

        sieve[0]=1;
        sieve[1]=1;
        for(int i=2; i<N; i++){

           if(sieve[i]==0){
               for(int j=2*i; j<N; j+=i)sieve[j]=1;
           }
        }

        for(int i=0; i<n; i++){

            if(arr[i]==4) System.out.println("YES");
            else if((arr[i] & 1)==0) System.out.println("NO");
            else{
                long sqrt=(long)Math.sqrt(arr[i]);

                if((sqrt*sqrt)!=arr[i]) System.out.println("NO");
                else {
                    if(sieve[(int)sqrt]==0) System.out.println("YES");
                    else System.out.println("NO");
                }
            }
        }
    }
}

