package CodeForces.Contests.Div3.Div_3__Round966__13082024;

import java.util.Scanner;

public class Q1 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-->0){

            int n = sc.nextInt();

            String s = Integer.toString(n);

            if(s.length() <=2){
                System.out.println("NO");
            }
            else{

                String s1 = s.substring(0, 2);
                String s2 = s.substring(2, s.length());

                int a = Integer.parseInt(s1);
                int b = Integer.parseInt(s2);

                if(a!=10){
                    System.out.println("NO");
                }

                else{

                    if(s2.charAt(0)=='0' || b < 2){
                        System.out.println("NO");
                    }

                    else{
                        System.out.println("YES");
                    }
                }
            }



        }
    }
}
