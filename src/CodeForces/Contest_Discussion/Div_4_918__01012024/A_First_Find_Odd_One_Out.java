package CodeForces.Contest_Discussion.Div_4_918__01012024;


import java.util.Scanner;

public class A_First_Find_Odd_One_Out {


    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);


        int tc = sc.nextInt();

        while(tc-- > 0) {
            int a = sc.nextInt();

            int b = sc.nextInt();
            int c = sc.nextInt();


            if(a== b && b!=c) System.out.println(c);
            else if(a!=b && b==c) System.out.println(a);
            else if(a==c && b!=c) System.out.println(b);

        }
    }
}
