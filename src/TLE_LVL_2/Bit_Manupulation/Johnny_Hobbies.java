package TLE_LVL_2.Bit_Manupulation;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Johnny_Hobbies{

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int tc=sc.nextInt();
        sc.nextLine();

        while (tc-- > 0){

            int n = sc.nextInt();
            HashMap<Integer, Integer>map=new HashMap<>();

            for(int i=0; i<n; i++) {
                int element = sc.nextInt();
                map.put(element, map.getOrDefault(element, 0) + 1);
            }

            boolean flag =false;
            for(int k=1; k<1024; k++){

                int l=0;

                for(int key : map.keySet()){
                    if(map.containsKey(key ^ k)==false) break;
                    l++;
                }

                if(l==n){
                    flag = true;
                    System.out.println(k);
                    break;
                }
            }

            if(flag==false) System.out.println(-1);
        }
    }
}
