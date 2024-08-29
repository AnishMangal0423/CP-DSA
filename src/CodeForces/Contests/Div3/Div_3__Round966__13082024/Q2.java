package CodeForces.Contests.Div3.Div_3__Round966__13082024;

import java.util.HashMap;
import java.util.Scanner;

public class Q2 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-->0){

            int n = sc.nextInt();
            int[]arr = new int[n];
            for(int i=0; i<n; i++)arr[i]=sc.nextInt();

            HashMap<Integer , Integer>map = new HashMap<>();

            boolean fl = false;
            map.put(arr[0] , 1);
            for(int i=1; i<n; i++){

//                System.out.println(map);
                int seatno = arr[i];

                int prev1 = (map.containsKey(seatno-1)==true) ? map.get(seatno-1) : 0;
                int prev2 = (map.containsKey(seatno+1)==true) ? map.get(seatno+1) : 0;

                if(prev1== 0 && prev2 == 0){
                    fl=true;
                    break;
                }
                else {
                    map.put(seatno , i+1);
                }
            }

            if(fl==false) System.out.println("YES");
            else System.out.println("NO");

        }
    }
}

