//package CodeForces.Contest_Discussion.Div_3;
//
//import java.util.Scanner;
//
//public class Q2 {
//
//    public static void main(String[] args) {
//
//        Scanner sc=new Scanner(System.in);
//
//        int tc=sc.nextInt();
//
//        while (tc-->0){
//
//            int n=sc.nextInt();
////            int[]arr=new int[n];
////
////            for (int i=0; i<n; i++)arr[i]=sc.nextInt();
//
//
//                 String s=sc.nextLine();
//                 String p=sc.nextLine();
//
//
//              int a=0, b=0;
//
//                   for(int i=0; i<n; i++){
//                       char ch1=s.charAt(i);
//                       char ch2=p.charAt(i);
//
//                       if(ch1=='1' && ch2=='0') a++;
//                       else if(ch1=='0' && ch2=='1') b++;
//                   }
//            System.out.println(Math.abs(a-b));
//
//        }
//    }
//}
package CodeForces.Contests.Div3.Div_3__Round921;

import java.util.Scanner;

public class Q2 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int tc = sc.nextInt();

        while (tc-- > 0) {

            int n = sc.nextInt();
            sc.nextLine(); // Consume the newline character

            String s = sc.next();
            String p = sc.next();

            int a = 0, b = 0;

            for (int i = 0; i < n; i++) {
                char ch1 = s.charAt(i);
                char ch2 = p.charAt(i);

                if (ch1 == '1' && ch2 == '0') a++;
                else if (ch1 == '0' && ch2 == '1') b++;
            }
            System.out.println(Math.abs(a - b)+Math.min(a, b));

        }
    }
}
