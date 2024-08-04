package DSA.DynamicProgramming;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class ZC_Print_LCS {

    public static int LCS_Tabulated(String s1, String s2, int[][]dp){

        for(int i=1; i< dp.length; i++){
            for(int j=1; j< dp[0].length ; j++){

                if(s1.charAt(i-1)==s2.charAt(j-1))dp[i][j]=1+dp[i-1][j-1];
                else dp[i][j]=Math.max(dp[i][j-1], dp[i-1][j]);
            }
        }

        for(int i=0; i<dp.length; i++) System.out.println(Arrays.toString(dp[i]));
        return dp[dp.length-1][dp[0].length-1];
    }

//    public static ArrayList<String> LCS(String s1, String s2, int[][]dp){
//
//        ArrayList<String>[][]newDp = new ArrayList[dp.length][dp[0].length];
//        for(int i=0; i<dp.length; i++)newDp[i][0] = new ArrayList<>();
//        for(int j=0; j<dp[0].length; j++)newDp[0][j] = new ArrayList<>();
//
//
//        int i = 1;
//        int j = 1;
//
//        while (i<dp.length && j<dp[0].length){
//
//            if(s1.charAt(i)==s2.charAt(j)){
//
//            }
//
//        }
//    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String s1 = sc.nextLine();
        String s2 = sc.nextLine();

//        System.out.println("All LCS are ?: " + LCS(s1, s2, 0, 0, new ArrayList<>()));
        int[][]dp=new int[s1.length()+1][s2.length()+1];
        System.out.println(LCS_Tabulated(s1, s2, dp));

//        System.out.println(LCS(s1, s2, dp));
    }
}
