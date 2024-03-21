package Codechef.Contests.Starter__126C__20032024;

import java.util.*;

public class Q4 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int tc=sc.nextInt();
        while (tc-->0){

            int n = sc.nextInt();
            int[]arr=new int[n];
            for(int i=0; i<n; i++) arr[i]=sc.nextInt();

            HashMap<Integer, ArrayList<Integer>>map=new HashMap<>();

            for(int i=0; i<n; i++){

                int ai=arr[i];
                if(!map.containsKey(ai)){
                    ArrayList<Integer>temp=new ArrayList<>();
                    temp.add(i);
                    map.put(ai, temp);
                }

                else{
                    ArrayList<Integer>tempp=map.get(ai);
                    tempp.add(i);
                    map.put(ai, tempp);

                }

            }
            System.out.println(map);
            HashSet<String>ans = new HashSet<>();

            for(int i=0; i<n; i++){

                 int ai=arr[i];
                 if(ai==3)continue;
                 double aj = (double) (ai)/(double) (ai-3);

//                System.out.println(Math.floor(aj) +" nn "+ Math.ceil(aj));

                 if(Math.ceil(aj)== Math.floor(aj)){
                     int ajj = (int)aj;
                     if(map.containsKey(ajj)==true){
//                         System.out.println("hii");
                         for (int kk : map.get(ajj)) {

                             if (kk > i) ans.add("" + ai + kk + "");
                         }
                     }
                 }
            }
            System.out.println(ans);

            System.out.println(ans.size());
        }

    }
}
