//package CodeForces.Contests.Div3.Div_3__Round966__13082024;
//
//import java.util.Scanner;
//
//public class Q4 {
//
//    public static void main(String[] args) {
//
//        Scanner sc = new Scanner(System.in);
//
//        int t = sc.nextInt();
//
//        while (t-->0){
//
//            int n = sc.nextInt();
//            int[]arr = new int[n];
//            for(int i=0; i<n; i++)arr[i]=sc.nextInt();
//
//            String s = sc.nextLine();
//
//            int i=0; int j = s.length()-1;
//
//            int ans = 0;
//            int[]pre = new int[n+1];
//            pre[0]=arr[0];
//            for(int k=1; k<=n; k++){
//                pre[k] = pre[k-1]+arr[k-1];
//            }
//
//
//
//            while (i < j){
//
//                char c1 = s.charAt(i);
//                char c2 = s.charAt(j);
//
//                if(c1=='L' && c2 =='R'){
//                    ans += (pre[j] - pre[i-1]);
//                    i++;
//                    j--;
//                }
//
//                else if(c1=='R'){
//                    i++;
//                }
//                else if(c2=='L'){
//                    j--;
//                }
//            }
//
//            System.out.println(ans);
//
//        }
//    }
//}
package CodeForces.Contests.Div3.Div_3__Round966__13082024;

import java.util.Scanner;

public class Q4 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        sc.nextLine(); // Consume leftover newline after reading integer

        while (t-- > 0) {

            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) arr[i] = sc.nextInt();

            sc.nextLine(); // Consume newline before reading the string
            String s = sc.nextLine();

            int i = 0;
            int j = n - 1;

            long ans = 0;
            long[] pre = new long[n + 1];
            pre[0] = 0; // Initialize the prefix sum array starting from 0
            for (int k = 1; k <= n; k++) {
                pre[k] = pre[k - 1] + arr[k - 1];
            }

            while (i < j) {

                char c1 = s.charAt(i);
                char c2 = s.charAt(j);

                if (c1 == 'L' && c2 == 'R') {
                    ans += (pre[j + 1] - pre[i]); // Adjust the prefix sum calculation
                    i++;
                    j--;
                }

                while(i<j && s.charAt(i) == 'R') {
                    i++;
                }
                while (i<j && s.charAt(j) == 'L') {
                    j--;
                }
            }

            System.out.println(ans);

        }
    }
}
