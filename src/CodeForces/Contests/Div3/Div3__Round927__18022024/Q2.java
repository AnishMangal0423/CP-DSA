package CodeForces.Contests.Div3.Div3__Round927__18022024;

import java.util.Scanner;

public class Q2 {
     static int calculateApocalypseYear(int n, int[] periodicities) {

         if(n==1)return periodicities[0];

         int year = periodicities[0];

         for(int i=1; i<n; i++){

             if(year > periodicities[i])year=periodicities[i]*2;

         }

        return year;
    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int tc = sc.nextInt();

        while (tc-->0){

            int n = sc.nextInt();  // Number of signs
            int[] periodicities = new int[n];

            // Read the periodicities of the signs
            for (int i = 0; i < n; i++) {
                periodicities[i] = sc.nextInt();
            }

            // Calculate the year when all signs will occur
            int year = calculateApocalypseYear(n, periodicities);

            // Output the result for the current test case
            System.out.println(year);


        }
    }
}
