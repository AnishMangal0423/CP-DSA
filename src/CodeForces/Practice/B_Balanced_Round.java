package CodeForces.Practice;

import java.util.*;

public class B_Balanced_Round {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int tc = sc.nextInt();

        while (tc-- > 0) {
            int n = sc.nextInt();
            long dif = sc.nextLong();

//            long[] arr = new long[n];
    ArrayList<Long>arr=new ArrayList<>();
            for (int i = 0; i < n; i++) arr.add(sc.nextLong());

            Collections.sort(arr);

            int maxilen = 1, len = 1;
            for (int i = 0; i < n - 1; i++) {

                if (arr.get(i+1) - arr.get(i) > dif) {
                    len = 1;
                } else len++;

                maxilen = Math.max(maxilen, len);

            }

            System.out.println(arr.size() - maxilen);

        }
    }
}