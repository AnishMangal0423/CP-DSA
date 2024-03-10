package LeetCode.Contest.Weekly_388_10032024;

import java.util.*;

public class Q1{
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n1=sc.nextInt();
        int n2=sc.nextInt();
        int[]apple = new int[n1];
        int[]capacity = new int[n2];
        for(int i=0; i<n1; i++)apple[i]=sc.nextInt();
        for(int i=0; i<n2; i++)capacity[i]=sc.nextInt();

        int sum = 0;
        for(int i=0; i<apple.length; i++){
            sum+=apple[i];
        }


        Arrays.sort(capacity);
        int count =0;
        int sum1=0;
        int n = capacity.length;
        for(int i=n-1; i>=0; i--){
            if(sum1 < sum){
                count++;
                sum1+=capacity[i];
            }
            else break;
        }

        System.out.println(count);
    }
}
