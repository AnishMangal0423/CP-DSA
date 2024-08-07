package CodeForces.Contests.Div4.Div_4_964__06082024;

import java.util.Scanner;

public class Q4 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        sc.nextLine(); // Consume the newline character after the integer input

        while (t-- > 0) {

            String s = sc.nextLine();
            String tt = sc.nextLine();

            StringBuilder sb = new StringBuilder();
            int i = 0;
            int j = 0;

            while (i < s.length() && j < tt.length()) {

                char aa = s.charAt(i);
                char bb = tt.charAt(j);

                if (aa == bb || aa == '?') {
                    if(aa==bb)sb.append(aa);
                    else sb.append(bb);
                    i++;
                    j++;
                } else {
                    sb.append(aa);
                    i++;
                }
            }

            if (j == tt.length()) {

               for(int v=i; v<s.length(); v++){
                   if(s.charAt(v)=='?')sb.append('a');
                   else sb.append(s.charAt(v));
               }
                System.out.println("YES");
                System.out.println(sb.toString());
            } else {
                System.out.println("NO");
            }
        }
        sc.close();
    }
}
