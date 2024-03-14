package TLE_LVL_2.CS31_Sheet._1200;

import java.util.*;

public class I_Matryoshkas {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int tc=sc.nextInt();

        while (tc-->0){

            int n = sc.nextInt();
            long []arr= new long[n];
            for(int i=0; i<n; i++)arr[i]=sc.nextLong();

            Arrays.sort(arr);

            ArrayList<ArrayList<Long>>map=new ArrayList<>();

            long[]dp=new long[n];
            dp[0]=1;
            for(int i =1; i<n; i++){

                if(arr[i-1]==arr[i])dp[i]=1+dp[i-1];
                else{
                    ArrayList<Long>ttemp=new ArrayList<>();
                    ttemp.add(arr[i-1]);
                    ttemp.add(dp[i-1]);
                    map.add(ttemp);
                    dp[i]=1;
                }
          }
            ArrayList<Long>ttemp=new ArrayList<>();
            ttemp.add(arr[n-1]);
            ttemp.add(dp[n-1]);
            map.add(ttemp);
//            System.out.println(map);

            HashMap<Long, Long>mmap = new HashMap<>();

            for(ArrayList<Long>arb : map){

                long prev = arb.get(0)-1;
                long freq = arb.get(1);
                if(mmap.containsKey(prev)==false){
                    mmap.put(prev+1, freq);
                }

                else{

                    long count = mmap.get(prev);

                    if(count > 0){
                        if(freq > count){
                            long rem = freq-count;
                            mmap.put(prev, (long)0);
                            mmap.put(prev+1, freq);
                        }

                        else{
                          long rem = count-freq;
                            mmap.put(prev+1, freq);
                            mmap.put(prev, rem);
                        }
                    }

                    else  mmap.put(prev+1, freq);

//                    System.out.println(mmap);
                }
            }



            long ans = 0;
            for(long kii : mmap.keySet()){
                ans += mmap.get(kii);
            }

            System.out.println(ans);

        }
    }
}
