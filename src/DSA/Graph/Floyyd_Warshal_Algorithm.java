package DSA.Graph;

import java.util.Arrays;
import java.util.Scanner;


/**
 * This is Do it in Place.. Algorithm as , Mentioned in GFG Question..
 *
 *
 *   TC - O(N^3)
 *   SC - O(1)
 *
 *   Approch - It is like dp we can store some Base cases like dp[i][i]=0 , some direct edge weights ..
 *             and do n^3 approch..
 *
 *
 *             if there will be negative cycle then dp[i][i] will be < 0 which is not possible.
 * **/
public class Floyyd_Warshal_Algorithm{


    public static void Fill(int[][]matrix){

        int n = matrix.length;


        for(int via=0; via<n; via++){

            for(int i=0; i<n; i++){

                for(int j=0; j<n; j++){


                    if(matrix[i][via]!=-1 && matrix[via][j]!=-1){
                        if(matrix[i][j]!=-1) matrix[i][j]= Math.min(matrix[i][j], matrix[i][via] + matrix[via][j]);
                        else  matrix[i][j]=matrix[i][via] + matrix[via][j];

                    }

                }
            }


        }

    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n=sc.nextInt();

        int[][]matrix=new int[n][n];

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++)matrix[i][j]=sc.nextInt();
        }


        Fill(matrix);

    }
}
