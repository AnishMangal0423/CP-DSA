package TLE_LVL_2.Number_Theory.Number_Theory_1;

import java.util.*;

public class G_Fadi_and_LCM{


    public static long __gcd(long a, long b){

        if(b==0)return a;

        return __gcd(b, a%b);
    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        long N = sc.nextLong();
        long a=1, b=N;


        for(long i=2; i*i <= N; i++){

            if(N % i ==0 && __gcd(i, N/i)==1){
                    a = i;
                    b = N / i;
            }
        }
        System.out.println(a+" "+b);

    }
}
