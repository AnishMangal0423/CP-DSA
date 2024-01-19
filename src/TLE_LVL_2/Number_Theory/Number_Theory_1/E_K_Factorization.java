package TLE_LVL_2.Number_Theory.Number_Theory_1;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * Main thing in this was to Vizualize that it was a Qestion from Number Theory.
 * Whenever Fcatorization Comes Think on Number Theory .. for 1100 Rating Question.
 * **/

public class E_K_Factorization{

    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);

        int n=sc.nextInt();
        int k=sc.nextInt();

        ArrayList<Integer>ans=new ArrayList<>();

        int kold=k;
        for(int i=2; i*i<=n; i++){

              if(n%i==0){

                  while (n%i==0 && k > 1){
                      n/=i;
                      ans.add(i);
                      k--;
                  }
              }
        }

        if(k==1 && n>1)ans.add(n);


        if(ans.size()!=kold) System.out.println(-1);
        else  for(int i : ans) System.out.print(i+" ");

    }
}
