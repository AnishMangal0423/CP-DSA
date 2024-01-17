package CodeForces.Contest_Discussion.Hello_2024;

import java.util.Scanner;

public class Q2 {

    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);

        int tc=sc.nextInt();
//        sc.nextInt();

        while(tc-- > 0) {

            int n = sc.nextInt();

            String s = sc.next();

            long ans=0;
            for(int i=0; i<n; i++){
                if(s.charAt(i)=='+')ans++;
                else ans--;
            }
            System.out.println(Math.abs(ans));
        }
    }
}
