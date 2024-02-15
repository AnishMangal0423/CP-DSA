package TLE_LVL_2.CS31_Sheet._1200;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeMap;

public class D_Assembly_via_Minimums {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int tc=sc.nextInt();

        while (tc-->0){

            int Na=sc.nextInt();
            int Nb = ((Na) *(Na - 1)) / 2;

            TreeMap<Integer, Integer>map=new TreeMap<>();

            for(int i=0; i<Nb; i++){

                int val = sc.nextInt();

                map.put(val , map.getOrDefault(val , 0) + 1);
            }

            ArrayList<Integer>ans = new ArrayList<>();

            for(int i=0; i<Na-1; i++){

                int kii = map.firstKey();
                ans.add(kii);
                if(map.get(kii) - ((Na-1)-i) != 0){
                    map.put(kii, map.get(kii) - ((Na-1)-i));
                }

                else{
                    map.remove(kii);
                }
            }

            int nvalues=ans.size();

            while (nvalues!=Na){

                if(ans.get(ans.size()-1)==(int)1e9){
                    ans.add((int)1e9);
                }
                else {
                    ans.add(ans.get(ans.size() - 1) + 1);
                }
                nvalues++;
            }

            for(int kk : ans){
                System.out.print(kk+" ");
            }

            System.out.println();
        }
    }
}










