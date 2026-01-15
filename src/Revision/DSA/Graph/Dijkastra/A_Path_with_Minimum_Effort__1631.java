package Revision.DSA.Graph.Dijkastra;

import java.util.Scanner;

public class A_Path_with_Minimum_Effort__1631 {


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int r = sc.nextInt();
        int c = sc.nextInt();
        int[][]heights = new int[r][c];
        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++){
                heights[i][j]=sc.nextInt();
    }
        }

//        System.out.println("The minimum Effort Path is : " + minEffortPath(heights));
    }
}
