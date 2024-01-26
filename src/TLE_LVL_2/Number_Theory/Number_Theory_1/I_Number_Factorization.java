package TLE_LVL_2.Number_Theory.Number_Theory_1;

import java.util.*;
import java.util.HashMap;
import java.util.Scanner;

public class I_Number_Factorization{

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int tc  = sc.nextInt();

        while (tc-->0){

            int N = sc.nextInt();
            int maxi=0;

            HashMap<Integer, Integer>map=new HashMap<>();
            for(int i=2; i*i<=N; i++){

                if(N % i == 0){

                    while (N % i ==0){
                       map.put(i, map.getOrDefault(i, 0)+1);
                        N /= i;
                    }

                    maxi=Math.max(maxi, map.get(i));
                }
            }
        if(N > 1){
            map.put(N, 1);
            maxi=Math.max(maxi, 1);
        }

        long ans=0;
        for(int i=1; i<=maxi; i++){

            long sans=1;
//            System.out.println(map.keySet());
            for (int kii : new HashSet<>(map.keySet())) {
                sans *= kii;
                if (map.get(kii) == 1) {
                    map.remove(kii);
                } else {
                    map.put(kii, map.get(kii) - 1);
                }
            }
            ans+=sans;
        }

            System.out.println(ans);

        }

    }
}
