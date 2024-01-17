package DSA.DP;

import java.util.* ;
import java.io.*;
public class Frog_Jump {

    public static int FrogJump(int n, int heights[], int index) {

        if (index <= 0) return 0;
        if (index == 1) return Math.min(heights[1], Math.abs(heights[1] - heights[0]));

        int i = Math.min(Math.abs(heights[index] - heights[index - 1]) + FrogJump(n, heights, index - 1), Math.abs(heights[index] - heights[index - 2]) + FrogJump(n, heights, index - 2));
        return i;

    }

    public static int frogJump(int n, int heights[]) {

        return FrogJump(n, heights, n - 1);


    }


    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);

        int tc = sc.nextInt();

        while (tc-- > 0) {

            int n = sc.nextInt();

            int[] arr = new int[n];

            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }


            System.out.println(frogJump(n, arr));
        }

    }

}