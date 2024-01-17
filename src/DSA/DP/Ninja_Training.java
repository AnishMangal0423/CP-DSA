package DSA.DP;

import java.util.*;

public class Ninja_Training{


    public static int Ninja_Recursion(int[][]matrix, int index, int tr){

        if(index < 0) return 0;
        int max= Integer.MIN_VALUE;
        for(int j=0; j<3; j++){
            if(j!=tr) {
                 max = Math.max(max, matrix[index][j] + Ninja_Recursion(matrix, index - 1, j));
            }
        }
        return max;
    }

    public static void main(String[]args){


        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int[][]matrix=new int[N][3];

        for(int i=0; i<N; i++){

            for(int j=0; j<3; j++){

                matrix[i][j]= sc.nextInt();

            }
        }
      int maxi=Integer.MIN_VALUE;
        for(int i=0; i<3; i++){

            maxi=Math.max(maxi, matrix[N-1][i]+Ninja_Recursion(matrix,N-2, i));
        }

        System.out.println(maxi);

    }

}