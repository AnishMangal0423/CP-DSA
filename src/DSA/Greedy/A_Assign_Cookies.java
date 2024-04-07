package DSA.Greedy;

import java.util.Arrays;
import java.util.Scanner;

public class A_Assign_Cookies {

    public static int Contents(int[]gridFactor, int[]sizeCookie){

        int n1 = gridFactor.length;
        int n2 = sizeCookie.length;

        Arrays.sort(gridFactor); Arrays.sort(sizeCookie);
        int count = 0;
        int i=0; int j=0;
        while (i<n1 && j<n2){

            if(sizeCookie[j] >= gridFactor[i]){
                count++;
                i++;
                j++;
            }

            else if(sizeCookie[j] < gridFactor[i]){
                  j++;
            }
        }

        return count;
    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int gn = sc.nextInt();
        int sn = sc.nextInt();
        int[]gridFactor = new int[gn];
        int[]sizeCookie = new int[sn];
        for(int i=0; i<gn; i++)gridFactor[i]=sc.nextInt();
        for(int i=0; i<sn; i++)sizeCookie[i]=sc.nextInt();

        System.out.println("Number of Contents is :: " + Contents(gridFactor, sizeCookie));

    }
}
