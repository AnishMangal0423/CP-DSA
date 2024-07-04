package DSA.DynamicProgramming;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class J_Triangle {

    public static int Min_Sum(List<List<Integer>>triangle, int i, int j, int m){

        if(i==m-1) return triangle.get(i).get(j);
        if(j-i > 0) return 1000000;
        return triangle.get(i).get(j)+ Math.min(Min_Sum(triangle, i+1, j, m), Min_Sum(triangle, i+1, j+1, m));

    }

    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        int m=sc.nextInt();
//        int n=sc.nextInt();

        List<List<Integer>>triangle=new ArrayList<>();

        for(int i=0; i<m; i++){

            triangle.add(new ArrayList<>());


            for (int j = 0; j < i+1; j++) {
                int element =sc.nextInt();
                triangle.get(i).add(element);
            }
        }

        System.out.println(Min_Sum(triangle, 0, 0, m));

    }
}
