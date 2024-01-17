package CodeForces.Contest_Discussion.Hello_2024;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Q3 {
    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);

        int tc=sc.nextInt();
//        sc.nextInt();

        while(tc-- > 0){

            int n=sc.nextInt();

            int[]arr=new int[n];

            for(int i=0; i<n; i++)arr[i]=sc.nextInt();

            ArrayList<Integer>a1=new ArrayList<>();
            ArrayList<Integer>a2=new ArrayList<>();

            long ans=0;
            a1.add(arr[0]);
            for(int i=1; i<n; i++){

                int val = arr[i];
                int last1=a1.get(a1.size()-1);


                if(a2.size() >0 && val < last1 && val <  a2.get(a2.size()-1)){
                    if(last1< a2.get(a2.size()-1))a1.add(val);
                    else a2.add(val);
                }

                else if(val <= last1)a1.add(val);

                else if(a2.size()==0){
                    a2.add(val);
                }

                else if(val <=  a2.get(a2.size()-1))a2.add(val);

                else{
                    a1.add(val);
                    ans++;
                }
            }
            System.out.println(ans);



        }

    }
}
