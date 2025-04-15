package CodeForces.Contests.Div3.Div3__Round970__01092024;
//
//import java.util.Scanner;
//
//public class Q2 {
//
//    public static void main(String[] args) {
//
//        Scanner sc  = new Scanner(System.in);
//        int tc = sc.nextInt();
//
//        while (tc-->0){
//
//            int n = sc.nextInt();
////            int[]arr = new int[n];
////            for(int i=0; i<n; i++)arr[i]=sc.nextInt();
//
//            String s = sc.nextLine();
//
//            // checkplain-
//
//            int c=0;
//         for(int i=0; i<s.length(); i++){
//
//             if(s.charAt(i)!=0)c++;
//             else break;
//         }
//
//         c--;
//
//         double r = (s.length())/c;
//
//         int r1 = (int)r;
//
//         double sqr = r*r;
//         int sqr2=
//        }
//    }
//}

import java.util.Scanner;

public class Q2{

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int t = scanner.nextInt();  // number of test cases
        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt();  // length of the string
            String s = scanner.next();  // the binary string

            // Check if n is a perfect square
            int sqrtN = (int) Math.sqrt(n);
            if (sqrtN * sqrtN == n) {
                int k = sqrtN;
                boolean isBeautiful = true;

                // Check the edges of the k x k matrix
                for (int row = 0; row < k; row++) {
                    for (int col = 0; col < k; col++) {
                        int index = row * k + col;
                        // If it's an edge, expect '1', otherwise '0'
                        if (row == 0 || row == k - 1 || col == 0 || col == k - 1) {
                            if (s.charAt(index) != '1') {
                                isBeautiful = false;
                                break;
                            }
                        } else {
                            if (s.charAt(index) != '0') {
                                isBeautiful = false;
                                break;
                            }
                        }
                    }
                    if (!isBeautiful) break;
                }

                if (isBeautiful) {
                    System.out.println("Yes");
                } else {
                    System.out.println("No");
                }
            } else {
                System.out.println("No");
            }
        }

        scanner.close();
    }
}
