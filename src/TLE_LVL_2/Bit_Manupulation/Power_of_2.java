package TLE_LVL_2.Bit_Manupulation;

import java.util.*;

public class Power_of_2{

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int k= sc.nextInt();
        ArrayList<Integer> arr = new ArrayList<>();

        int[]dp=new int[31]; Arrays.fill(dp, 0);
        int count = 0;
        for (int i = 0; i < 31; i++) {

            int val = (N & (1 << i));
            if (val!=0) {
                arr.add(val);
                dp[i]++;
                count++;
            }

        }

        if (k < count || k > N) System.out.println("NO");

//        else{
//            System.out.println("Yes");
//
//            while(arr.size() < pos) {
//
//                for (int i = 0; i < arr.size(); i++) {
//
//                    if(arr.get(i)!=1){
//                        arr.add(arr.get(i)/2);
//                        arr.set(i, arr.get(i)/2);
//                        break;
//                    }
//                }
//
//            }
//
//            Collections.sort(arr);
//
//            for(int i : arr){
//                System.out.print(i +" ");
//            }
//            System.out.println(" ");
//        }
//    }


        else {
            System.out.println("YES");

            for(int i=30; i>=1; i--){

                while (count < k && dp[i] > 0){
                    dp[i]--;
                    dp[i-1]+=2;
                    count++;
                }

                if(count==k)break;
            }

            for (int i=0; i<30;i++){

                while(dp[i]-- >0){
                    System.out.print((1<<i) +" ");
                }
            }

        }


    }
}
