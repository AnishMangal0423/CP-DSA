package TLE_LVL_2.CS31_Sheet._1200;

import javax.lang.model.type.IntersectionType;
import java.util.Scanner;

public class C_Plus_Minus_Permutation{


    public static long gcd(long a, long b){

        if(b==0)return a;

        return gcd(b, a%b);
    }
    public static long Intersection(long a, long b,long n){

        long lcm = (a * b) / gcd(a, b);

        return n / lcm;

    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int tc=sc.nextInt();

        while (tc-->0) {
            long n = sc.nextLong();
            long x = sc.nextLong();
            long y = sc.nextLong();

             long totalXpositions = n / x;
             long totalYpositions = n / y;


             long IntersectionPositions = Intersection(x, y, n);

             long remainingXpositions = totalXpositions - IntersectionPositions;
             long remainingYpositions = totalYpositions - IntersectionPositions;

             long LastRemainingValues=n-remainingXpositions;
             long sum1 = ((n*(n+1))/2) - (LastRemainingValues*(LastRemainingValues+1))/2;
             long sum2 = (remainingYpositions * (remainingYpositions+1)) / 2;

            System.out.println(sum1 - sum2);

        }
    }
}
