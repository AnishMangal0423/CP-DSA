package CodeForces.Contests.Div_4_918__01012024;

import java.util.Scanner;

public class C_Is_Number_Perfect_Square {

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        int tc = sc.nextInt();
        sc.nextLine();

        while(tc-- > 0){

            int n = sc.nextInt();

            long sum =0;

            for(int i=0; i<n; i++){
                int val = sc.nextInt();
                sum+=val;
            }

            double sqrt = Math.sqrt(sum);
            if(Math.ceil(sqrt) == Math.floor(sqrt)) System.out.println("Yes");
            else System.out.println("No");
        }
    }
}
