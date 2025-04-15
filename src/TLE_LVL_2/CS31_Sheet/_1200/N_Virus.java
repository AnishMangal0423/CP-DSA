package TLE_LVL_2.CS31_Sheet._1200;

import java.util.Arrays;
import java.util.Scanner;

public class N_Virus {

    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while(t-->0){

            int n, m;
            n=sc.nextInt();
            m=sc.nextInt();
            int[]arr1 = new int[m];
            for(int i=0; i<m; i++)arr1[i]=sc.nextInt();
            Arrays.sort(arr1);
            int[]arr2 = new int[m];
            for(int i=0; i<m; i++){
                if(i<m-1)arr2[i] = arr1[i+1]-arr1[i]-1;
                else arr2[i] =  (n-arr1[i] + arr1[0]-1);
            }

            Arrays.sort(arr2);
//            System.out.println(Arrays.toString(arr2));
            int time=0;
            int safe=0;
            for(int i=m-1; i>=0; i--){
                int x = arr2[i];
                int remx = x - 2*time;
//                System.out.println("Remx : " +remx);
                if(remx <=0)break;
                if(remx>2){
                    time+=2;
                    safe+=(remx-1);
                }

                else{
                    time++;
                    safe++;
                }
            }
            System.out.println("Total Infacted are : " + (n-safe));


        }
    }
}
