package Codechef.Contests.Starter__123D__28022024;

import java.util.Arrays;
import java.util.Scanner;

public class Q3 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int tc = sc.nextInt();

        while (tc-->0){

            int n = sc.nextInt();
            int[]arr = new int[n];
            int sum=0;
            for(int i=0; i<n; i++){
                arr[i]=sc.nextInt();
                sum+=arr[i];
            }

            int val =0;
            for(int i=0; i<n; i++)val+=arr[i]+arr[i];

            Arrays.sort(arr);
            sum-=arr[0];
            sum-=arr[1];


          int min = 0;
            for(int i=0; i<n; i++){

                min+=arr[i]+arr[i];
            }

            sum-=arr[n-1];
            sum-=arr[n-2];

            int q = sc.nextInt();

            for(int i=0; i<q; i++){

                int x = sc.nextInt();

                if(x>=min && x<= sum){

                    int[]temp = new int[n];

                    int rem = val - x;

                    for(int l=0; l<n; l++){
                        for(int m = l+1; m<n; m++){

                            if(arr[l]+arr[m]==rem){
                                temp[0]=arr[l];
                                temp[n-1]=arr[m];
                                break;
                            }

                            if(temp[0]!=0)break;
                        }
                    }

                    int k=1;int cnt = 0;
                    for(int p=0; p<n; p++){
                        if(cnt<2 && arr[p]==temp[0] || arr[p]==temp[n-1]){
                            cnt++;
                        }

                       else{
                           temp[k]=arr[i];
                           k++;
                        }

                    }


                }

                else{
                    System.out.println(-1);
                }
            }

        }


    }
}
