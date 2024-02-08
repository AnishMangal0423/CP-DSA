package Codechef.Contests.Starter__120D__07022024;

import java.util.*;

public class Q5 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);


        Scanner scanner = new Scanner(System.in);

        int tc = scanner.nextInt();

       while (tc-->0){
            int n = scanner.nextInt();
            ArrayList<Long> v = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                long x = scanner.nextLong();
                v.add(x);
            }

            ArrayList<Long> u = new ArrayList<>(n + 1);
            for (int i = 0; i <= n; i++) {
                u.add(0L);
            }

            for (int i = 0; i < n; i++) {
                int temp = i;
                long curSum = 0;

                while (temp < n && curSum + v.get(temp) <= n) {
                    curSum += v.get(temp);
                    u.set((int) curSum, u.get((int) curSum) + 1);
                    temp++;
                }
            }

            for (int i = 1; i <= n; i++) {
                System.out.print(u.get(i) + " ");
            }

            System.out.println();
        }

    }
}
