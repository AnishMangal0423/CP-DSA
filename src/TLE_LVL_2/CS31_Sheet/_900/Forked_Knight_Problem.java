package TLE_LVL_2.CS31_Sheet._900;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;


public class Forked_Knight_Problem{

    public static int Ways(int a, int b, int xK, int yK, int xQ, int yQ, HashSet<ArrayList<Integer>>h){

        int[]dx={a, a, -a, -a, b, b, -b, -b};
        int[]dy={b, -b, b, -b, a, -a, a, -a};

        int count=0;
        for(int i=0; i<8; i++){
            int x = xK+dx[i];
            int y=  yK+dy[i];

            for(int j=0; j<8; j++){

                int sx=x+dx[j];
                int sy=y+dy[j];

                if(sx==xQ && sy==yQ){
                    ArrayList<Integer>arr=new ArrayList<>();
                    arr.add(x);
                    arr.add(y);
                    h.add(arr);
                }
            }
        }
        return h.size();
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int tc=sc.nextInt();

        while(tc-- >0){

            int a=sc.nextInt();
            int b=sc.nextInt();
            sc.nextLine();

            int xK=sc.nextInt();
            int yK=sc.nextInt();
            sc.nextLine();

            int xQ=sc.nextInt();
            int yQ=sc.nextInt();
            sc.nextLine();

            HashSet<ArrayList<Integer>>h=new HashSet<>();
            System.out.println(Ways(a, b, xK, yK, xQ, yQ, h));
        }
    }
}
