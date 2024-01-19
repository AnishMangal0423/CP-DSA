package TLE_LVL_2.Number_Theory.Number_Theory_1;

import java.util.ArrayList;
import java.util.Scanner;

public class E_K_Factorization{

    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);

        int n=sc.nextInt();
        int k=sc.nextInt();

        ArrayList<Integer>ans=new ArrayList<>();
        for(int i=2; i*i<=n; i++){

            if(n%i==0){
                while (n%i==0){
                 n/=i;
                 k--;
                 ans.add(i);
                 if(k==1)break;
                }
            }
        }

        if((n>1 && k==1) || (n==1 && k==0)){
            ans.add(n);
            for(int i : ans) System.out.print(i);
        }
        else System.out.println(-1);


    }
}
