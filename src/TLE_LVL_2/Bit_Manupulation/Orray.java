package TLE_LVL_2.Bit_Manupulation;

import java.util.Scanner;

public class Orray{

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int tc=sc.nextInt();

        while (tc-- > 0) {
            int n = sc.nextInt();
            int[] arr = new int[n];

            for (int i = 0; i < n; i++) arr[i] = sc.nextInt();

            int[] ans = new int[n];
            boolean[] visited = new boolean[n];

            int ans_index = 0;

            int maxior = 1;
            for (int itr = 0; itr <= 30; itr++) {

                int or = maxior;
                int index = -1;

                for (int i = 0; i < n; i++) {

                    if (visited[i] == false && (maxior | arr[i]) > or) {
                        index = i;
                        or = maxior|arr[i];
                    }
                }
                if (index != -1) {
                    ans[ans_index] = arr[index];
                    ans_index++;
                    visited[index] = true;
                }
                maxior = Math.max(maxior, or);
            }

            for(int i=0; i<n; i++){
                System.out.print(ans[i]+" ");
            }
            System.out.println(" ");

        }
    }
}
