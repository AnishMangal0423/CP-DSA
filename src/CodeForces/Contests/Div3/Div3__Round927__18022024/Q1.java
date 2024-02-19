//package CodeForces.Contests.Div3.Div3__Round927__18022024;
//
//import java.util.Scanner;
//
//public class Q1 {
//
//    public static void main(String[] args) {
//
//        Scanner sc = new Scanner(System.in);
//
//        int tc = sc.nextInt();
//
//        while (tc-->0){
//
//            int n = sc.nextInt();
//
//            String s = sc.nextLine();
//
//            int ans =0;
//
//            for(int i=0; i<n-1; i++){
//
//
//                if(s.charAt(i)=='*' && s.charAt(i+1)=='*'){
//                    break;
//                }
//
//                if(s.charAt(i)=='@')ans++;
//            }
//            System.out.println(ans);
//        }
//    }
//}


package CodeForces.Contests.Div3.Div3__Round927__18022024;

import java.util.Scanner;

public class Q1 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int tc = sc.nextInt();

        while (tc-- > 0) {

            int n = sc.nextInt();

            String s = sc.next();  // Use sc.next() instead of sc.nextLine()

            int ans = 0;
      int i=0;
            for (; i < n - 1; i++) {
                if (s.charAt(i) == '*' && s.charAt(i + 1) == '*') {
                    break;
                }

                if (s.charAt(i) == '@' ) ans++;
            }

            if(s.charAt(n-1)=='@' && i == n-1)ans++;
            System.out.println(ans);
        }
    }
}
