package CodeForces.Contest_Discussion.Div_3__06022024;

import java.util.Scanner;

public class Q4 {

    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);

//        int n=sc.nextInt();
//
//        int[]arr=new int[n];
//        for(int i=0; i<n; i++)arr[i]=sc.nextInt();



        int tc=scanner.nextInt();

        while (tc-->0){


//            Scanner scanner = new Scanner(System.in);

            int n = scanner.nextInt();
            long[] a = new long[n];
            int[] prev = new int[n];
            int[] next = new int[n];
            prev[0] = -1;
            next[n - 1] = n + 1;

            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextLong();
            }

            int el1 = 0;
            for (int i = 1; i < n; i++) {
                if (a[i] == a[el1]) {
                    prev[i] = prev[i - 1];
                } else {
                    prev[i] = i - 1;
                    el1 = i;
                }
            }

            int el2 = n - 1;
            for (int i = n - 2; i >= 0; i--) {
                if (a[i] == a[el2]) {
                    next[i] = next[i + 1];
                } else {
                    next[i] = i + 1;
                    el2 = i;
                }
            }

            int q = scanner.nextInt();
            for (int i = 0; i < q; i++) {
                int l = scanner.nextInt();
                int r = scanner.nextInt();
                if (next[l - 1] > r - 1 && prev[r - 1] < l - 1) {
                    System.out.println(-1 + " " + -1);
                } else if (next[l - 1] < r - 1) {
                    System.out.println(l + " " + (next[l - 1]+1));
                } else {
                    System.out.println((prev[r - 1] +1) + " " + (r));
                }
            }



        }


    }
}
