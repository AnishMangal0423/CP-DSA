package TLE_LVL_2.Number_Theory.Number_Theory_1;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class B_Sherlock_and_his_Girlfriend{

    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);

        int n=sc.nextInt();

        int[]colors=new int[n+2];

        int start_color=1;
        Arrays.fill(colors, start_color);


        for(int i=2; i<n+2; i++){

            if(colors[i]==1){

                for(int j=2*i; j<n+2; j+=i){

                   if(colors[i]==colors[j]) colors[j]++;
                }
            }
        }

        HashSet<Integer>no_of_colors=new HashSet<>();

        for(int i=2; i<n+2; i++){
            no_of_colors.add(colors[i]);
        }

        System.out.println(no_of_colors.size());

        for (int i=2; i<n+2; i++){
            System.out.print(colors[i]+" ");
        }

    }
}
