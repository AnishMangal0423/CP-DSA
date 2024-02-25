package LeetCode.Contest.Weekly_386_25022024;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/**
 *
 * Concept --> Calculate the Area of Intresection of Many Squares.
 *
 * Learning --> Understanded , How to Deal with Finding the Intersection Points of Figures ( Use the Concept of min/max Bundries and
 *              and make the condition that in actual gap(area/intresection) is Created or not.
 *
 *
 * Time Complexity  --> O(N^2) 2 Loops.
 * Space Complexity --> O(1) Constant Space.
 *
 *
 * **/
public class Q2 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n_Squares = sc.nextInt();

        int[][]bottomLeft = new int[n_Squares][2];
        int[][]topRight = new int[n_Squares][2];

        for(int i=0; i<n_Squares; i++){
            for(int j=0; j<2; j++){
                bottomLeft[i][j]=sc.nextInt();
            }
        }

        for(int i=0; i<n_Squares; i++){
            for(int j=0; j<2; j++){
                topRight[i][j]=sc.nextInt();
            }
        }

        int side = 0;

        for(int i=0; i<n_Squares; i++){

// ------------------------------ Method I used During Contest ---------------------------------------------------------
//            int sx1 = bl[i][0];
//            int ex1 = tr[i][0];
//            int sy1 = bl[i][1];
//            int ey1 = tr[i][1];
//
//
//            for(int j = i+1; j<n; j++){
//
//                int sx2 = bl[j][0];
//                int ex2 = tr[j][0];
//                int sy2 = bl[j][1];
//                int ey2 = tr[j][1];
//
//
//                int val1 =0, val2=0;
//                if(sx2 >= sx1 && ex2 <= ex1) val1 =(ex2-sx2);
//
//                if(sx2 >= sx1 && ex2 > ex1) val1 = (ex1-sx2);
//
//                if(sx2 < sx1 && ex2 >= sx1) val1 = (ex2-sx1);
//
//
//                if(sy2 >= sy1 && ey2 <= ey1) val2 =(ey2-sy2);
//
//                if(sy2 >= sy1 && ey2 > ey1) val2 = (ey2-sy2);
//
//                if(sy2 < sy1 && ey2 >= sy1) val2 = (ey2-sy1);
//
//
//                mm.add(Math.min(val1 , val2));

// ----------------------------------- Lengthy and Not Good Practice ----------------------------------------------------



// ---------------------------------- Good and Correct Practice --------------------------------------------------------


            // I will find the bottomLeft coord1 , TopRight coord2 of Insertected Square -->

            for(int j= i+1; j<n_Squares; j++) {

                int coord1x = Math.max(bottomLeft[i][0] , bottomLeft[j][0]);   // It is BootomLeft x new Coordinate of New Intresected Square.
                int coord1y = Math.max(bottomLeft[i][1] , bottomLeft[j][1]);   // It is BootomLeft y new Coordinate of New Intresected Square.


                int coord2x = Math.min(topRight[i][0] , topRight[j][0]);     // It is topRight x new Coordinate of New Intresected Square.
                int coord2y = Math.min(topRight[i][1] , topRight[j][1]);     // It is topRight y new Coordinate of New Intresected Square.

                // It is necessary condition to remove all Mutually Exculsive Cases.
                if(coord1x < coord2x && coord1y < coord2y){

                    side = Math.max(side , Math.min(coord2x - coord1x , coord2y - coord1y));
                }


            }
        }

        System.out.println(side*side);

    }
}
