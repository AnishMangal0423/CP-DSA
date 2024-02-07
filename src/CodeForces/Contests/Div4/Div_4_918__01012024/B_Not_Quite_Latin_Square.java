package CodeForces.Contests.Div4.Div_4_918__01012024;

import java.util.HashMap;
import java.util.Scanner;

public class B_Not_Quite_Latin_Square {

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

//        int tc = sc.nextInt();
//
//
//        while(tc-- > 0){
//            char[][]m = new char[3][3];
//            int ii=0, jj=0;
//            for(int i=0; i<3; i++){
//
//                String a = sc.nextLine();
//
//                for(int j=0; j<a.length(); j++){
//
//                    m[i][j]=a.charAt(j);
//                    if(a.charAt(j)=='?'){
//                        ii=i;
//                        jj=j;
//                    }
//                }
//            }
//            HashMap<Character , Integer>map = new HashMap<>();
//
//            map.put('A', 1);
//            map.put('B', 1);
//            map.put('C', 1);
//
//
//           for(int i=0; i<3; i++){
//               if(m[ii][i]!='?'){
//
//                   map.remove(m[ii][i]);
//               }
//           }
//
//           for(char key : map.keySet())
//            System.out.println(key);
//
//        }


        int tc = sc.nextInt();
        sc.nextLine(); // Consume the newline character

        while (tc-- > 0) {
            char[][] m = new char[3][3];
            int ii = 0, jj = 0;
            for (int i = 0; i < 3; i++) {
                String a = sc.nextLine();
                for (int j = 0; j < a.length(); j++) {
                    m[i][j] = a.charAt(j);
                    if (a.charAt(j) == '?') {
                        ii = i;
                        jj = j;
                    }
                }
            }
            HashMap<Character, Integer> map = new HashMap<>();
            map.put('A', 1);
            map.put('B', 1);
            map.put('C', 1);

            for (int i = 0; i < 3; i++) {
                if (m[ii][i] != '?') {
                    map.remove(m[ii][i]);
                }
            }

            for (char key : map.keySet())
                System.out.println(key);
        }




    }
}

