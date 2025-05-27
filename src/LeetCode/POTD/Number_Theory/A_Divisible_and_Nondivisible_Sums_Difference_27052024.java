package LeetCode.POTD.Number_Theory;

import java.util.Scanner;

/***
 *
 * Problem No :- 2894
 * We have given 2 Numbers as input , suppose n, m.
 * Now we have to make 2 numbers num1, num2.
 * such that -
 * num1 = sum[1, n] where every i is not divisible by m.
 * num2 = sum[1, n] where every i is divisible by m.
 *
 * we have to return sum1-sum2;
 * ans can also be negative.
 *
 * */
public class A_Divisible_and_Nondivisible_Sums_Difference_27052024 {

    public static int summations_On(int n, int m){

        long sum1=0;
        long sum2=0;

        for(int i=1; i<=n; i++){
            if((i)%m!=0)sum1+=i;
            else sum2+=i;
        }

        return (int)(sum1-sum2);
    }

    public static int summations_Ologn(int n, int m){
        long total_sum = (long) (n) * (n + 1) / 2;

        if (m == 1)
            return ((-1) * ((int)total_sum));
        long sum2 = 0;

        for (int k = m; k <= n; k += m) {
            sum2 += k;
        }

        long sum1 = total_sum - sum2;

        return (int) (sum1 - sum2);
    }

    public static int summations_O1(int n, int m){

        int k = n/m;  // m , 2m , 3m , 4m .. which km = n so k = n/m.  
        long sum2 = (long) m * (k)* (k+1)/2; // find sum of all k. 

        long sum1 = (long) (n) *(n+1)/2 - sum2; // find non-divisible elements.

        return (int) (sum1-sum2);

    }
    
    
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        System.out.println(summations_On(n, m));

        System.out.println(summations_Ologn(n, m));

        System.out.println(summations_O1(n, m));




    }
}
