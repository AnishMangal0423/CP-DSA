package DSA.Graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


/**
 *
 * Beauty of Question --> Barrier is Given for 100000 so a Minimum dis is updated only once here .... If multiply becomes > 10^5
 *                        then again it will go for 0....99999 numbers ..
 *
 *
 *                       TC - O(10^5)
 *                       SC- O(10^5)
 *
 * **/

class Multiply_Pair{

    int val;
    int step;

    Multiply_Pair(int v, int s){
        this.val=v;
        this.step=s;
    }
}
public class Minimum_Multiplication_to_Reach_end{

    static int mod = 100000;

    public static int Fill_dis(int[]arr, int[]steps, int start, int end){

        steps[start]=0;
        Queue<Multiply_Pair>q=new LinkedList<>();
        q.add(new Multiply_Pair(start, 0));

        while (!q.isEmpty()){

            int size=q.size();

            for(int i=0; i<size; i++){

                Multiply_Pair front = q.poll();
                int val = front.val;
                int step=front.step;

                if(val == end) return step;

                for(int h=0; h<arr.length; h++){


                    int target=(val * arr[h])%mod;

                    if(steps[target] > step + 1){

                        steps[target]=step+1;
                        q.add(new Multiply_Pair((val*arr[h])%mod, step+1));
                    }


                }

            }


        }

return -1;

    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n=sc.nextInt();
        int[]arr=new int[n];

        for(int i=0; i<n; i++)arr[i]=sc.nextInt();
        int start=sc.nextInt();
        int end = sc.nextInt();


        int[]steps = new int[mod];
        Arrays.fill(steps, Integer.MAX_VALUE);

        System.out.println(Fill_dis(arr, steps , start,end));
    }
}
