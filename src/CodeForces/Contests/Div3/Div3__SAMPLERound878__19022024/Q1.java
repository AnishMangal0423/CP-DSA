package CodeForces.Contests.Div3.Div3__SAMPLERound878__19022024;

import java.util.Scanner;

public class Q1{
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
//sc.nextInt();


        while (tc-->0){

            int n=sc.nextInt();
//            sc.nextInt();
            String s = sc.next();

            StringBuilder sb = new StringBuilder();

           char original = '%';

           for(int i=0; i<n; i++){

              if(original=='%'){
                  sb.append(s.charAt(i));
                  original=s.charAt(i);
              }

              else if(s.charAt(i)==original){
                  original = '%';
              }

           }

            System.out.println(sb.toString());

        }
    }
}
