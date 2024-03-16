package TLE_LVL_2.CS31_Sheet._1200;

import java.util.*;

/**
 * Qn Link :- https://codeforces.com/problemset/problem/1790/D
 *
 * Problem :- We have N dolls and we have to make the sets and Pairs such that their sizes should be consecutive and increased by one.
 *            eg- 2,3,4,5,. allowed , but 2,3,4,5,5 --> not allowed.
 *
 *
 * Approch :- Simple Apporch use TreeMap.
 *
 * Learning :- There are a Lot of Learning in this Question.
 *            1. Never-ever use Arrays and Arrays.sort(), becuase in worst case it gives tle via O(N^2) quick sort.
 *            2. Always use Collection becuase it applies on object and uses Merge sort.
 *            3. Jada se Jada Sorting bagera karne ki wajay treemap use kiya karo.
 *            4. Question ko acche se pdkar hi approch pe shift hoo.
 *
 *
 * **/
public class I_Matryoshkas {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int tc=sc.nextInt();

        while (tc-->0){

            int n = sc.nextInt();
            long []arr= new long[n];
            for(int i=0; i<n; i++)arr[i]=sc.nextLong();

//            Arrays.sort(arr);
//
//            ArrayList<ArrayList<Long>>freq=new ArrayList<>();
//
//            long[]dp=new long[n];
//            dp[0]=1;
//            for(int i =1; i<n; i++){
//
//                if(arr[i-1]==arr[i])dp[i]=1+dp[i-1];
//                else{
//                    ArrayList<Long>ttemp=new ArrayList<>();
//                    ttemp.add(arr[i-1]);
//                    ttemp.add(dp[i-1]);
//                    freq.add(ttemp);
//                    dp[i]=1;
//                }
//          }
//            ArrayList<Long>ttemp=new ArrayList<>();
//            ttemp.add(arr[n-1]);
//            ttemp.add(dp[n-1]);
//            freq.add(ttemp);
//             System.out.println(map);
//
//            HashMap<Long, Long>mmap = new HashMap<>();
//
//            for(ArrayList<Long>arb : map){
//
//                long prev = arb.get(0)-1;
//                long freq = arb.get(1);
//                if(mmap.containsKey(prev)==false){
//                    mmap.put(prev+1, freq);
//                }
//
//                else{
//
//                    long count = mmap.get(prev);
//
//                    if(count > 0){
//                        if(freq > count){
//                            long rem = freq-count;
//                            mmap.put(prev, (long)0);
//                            mmap.put(prev+1, freq);
//                        }
//
//                        else{
//                          long rem = count-freq;
//                            mmap.put(prev+1, freq);
//                            mmap.put(prev, rem);
//                        }
//                    }
//
//                    else  mmap.put(prev+1, freq);
//
////                    System.out.println(mmap);
//                }
//            }
//

//
//            long ans = 0;
//            for(long kii : mmap.keySet()){
//                ans += mmap.get(kii);
//            }

//            System.out.println(ans);

//            System.out.println(freq);

            TreeMap<Long, Long>map=new TreeMap<>();

            for(int i=0; i<n; i++){
                map.put(arr[i] , map.getOrDefault(arr[i] , (long)0) + 1);
            }

             long ans = 0;

            for(Long kii : map.keySet()){

                long val = map.get(kii);

                if(map.containsKey(kii-1)==false){
                    ans += val;
                }

                else{
                    long prevcount = map.get(kii-1);
                    long currcount = map.get(kii);
                    if (prevcount < currcount) {
                        ans += (currcount - prevcount);
                    }

                }
            }


//            long ans = freq.get(0).get(1);
//
//            for(int i=1; i<freq.size(); i++){
//
//                ArrayList<Long>prev = freq.get(i-1);
//                ArrayList<Long>curr = freq.get(i);
//
//                if(curr.get(0)-prev.get(0)!=1){
//                    ans += curr.get(1);
//                }
//
//                else {
//                    long prevcount = prev.get(1);
//                    long currcount = curr.get(1);
//
//                    if (prevcount < currcount) {
//                        ans += (currcount - prevcount);
//                    }
//                }
//            }

            System.out.println(ans);




        }
    }
}
