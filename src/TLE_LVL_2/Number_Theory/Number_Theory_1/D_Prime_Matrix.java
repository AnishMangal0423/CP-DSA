package TLE_LVL_2.Number_Theory.Number_Theory_1;

import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;

public class D_Prime_Matrix{

    public static void main(String[] args) {

        int N=1005000;

        int[]sieve=new int[N];
        Arrays.fill(sieve, 0);

        sieve[0]=1;
        sieve[1]=1;
        for(int i=2; i<N; i++){
            if(sieve[i]==0){
                for(int j=2*i; j<N; j+=i){
                    sieve[j]=1;
                }
            }
        }

//        System.out.println(Arrays.toString(sieve));

        Scanner sc = new Scanner(System.in);
        int m=sc.nextInt();
        int n=sc.nextInt();

        int[][]matrix=new int[m][n];
        int[][]ans=new int[m][n];

        int min=Integer.MAX_VALUE;
        for(int i=0; i<m; i++){

            int oprn=0;
            for(int j=0; j<n; j++){
                matrix[i][j]=sc.nextInt();

                int k=matrix[i][j];
                int val=0;
                while (k<N && sieve[k]!=0){
                    val++;
                    k++;
                }
                ans[i][j]=val;
                oprn+=val;
            }
            min= Math.min(min, oprn);
        }



        for(int j=0; j<n; j++){

            int oprn=0;
            for(int i=0; i<m; i++){

                oprn+=ans[i][j];
            }
            min=Math.min(min, oprn);
        }

        System.out.println(min);

    }
}
