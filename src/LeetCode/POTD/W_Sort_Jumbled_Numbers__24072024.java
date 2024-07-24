package LeetCode.POTD;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

class MapPair{

    int MappedNumber;
    int index;

    MapPair(int n, int i){
        MappedNumber = n;
        index=i;
    }
}
public class W_Sort_Jumbled_Numbers__24072024 {

    public static int[] Sort(int[]mappings, int[]nums){

        int n1 = mappings.length;
        int n2 = nums.length;

        PriorityQueue<MapPair>pq = new PriorityQueue<>();
        int index=0;
        for(int number : nums){

            int numbeer = number;
            StringBuilder sb = new StringBuilder();
            while (numbeer > 0){
                sb.append(mappings[numbeer%10]);
                numbeer/=10;
            }

            sb.reverse();
            int newNumber = Integer.parseInt(sb.toString());
            pq.add(new MapPair(newNumber , index));
            index++;
        }


        int[]ans = new int[n2];

        for(int k=0; k<n2; k++){
            ans[k]=nums[pq.poll().index];
        }

        return ans;
    }
    public static void main(String[] args) {

        System.out.println("Enter the Mapping Length ?: ");
        Scanner sc = new Scanner(System.in);
        int n1 = sc.nextInt();
        System.out.println("Enter the Nums Length ?: ");
        int n2 = sc.nextInt();

        int[]mapping = new int[n1];
        int[]nums = new int[n2];

        for(int i=0; i<n1; i++)mapping[i]=sc.nextInt();
        for(int j=0; j<n2; j++)nums[j] = sc.nextInt();

        System.out.println("The Sorted order is ?: " + Arrays.toString(Sort(mapping, nums)));

    }
}
