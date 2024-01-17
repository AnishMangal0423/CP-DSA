package TLE_LVL_2.Backtracking;

import java.util.*;

public class Combination_Sum_1{

    public static void fn (ArrayList<ArrayList<Integer>>output , ArrayList<Integer>helper, int target, int[] arr, int index){

        if(target == 0){
            output.add(new ArrayList<>(helper));
            return;
        }


        if(index == arr.length) return;



        // taking-
//        System.out.println("tar "+target);
        if(target >= arr[index]){
            helper.add(arr[index]);
            fn(output, helper, target-arr[index], arr, index+1);
            helper.remove(helper.size()-1);
        }

        //non-taking case-
//        System.out.println(helper);

        int j= index+1;

        while(j< arr.length && arr[j]==arr[j-1]) j++;
        fn(output, helper, target , arr, j);

    }


    public static void main(String[]args){

        Scanner sc = new Scanner(System.in);

        int n=sc.nextInt();
        int []arr = new int[n];
        for(int i=0; i<n; i++){

            arr[i]=sc.nextInt();
        }

        int target = sc.nextInt();

        Arrays.sort(arr);

        ArrayList<Integer> helper = new ArrayList<>();
        ArrayList<ArrayList<Integer>> output = new ArrayList<>();
        fn(output, helper, target, arr, 0);

        for(ArrayList<Integer> ans : output) System.out.println(ans);


        String arr1[] = {"wwww","wwwx","wwwy","wwwz","wwxw","wwxx","wwxy","wwxz","wwyw","wwyx","wwyy","wwyz","wwzw","wwzx","wwzy","wwzz","wxww","wxwx","wxwy","wxwz","wxxw","wxxx","wxxy","wxxz","wxyw","wxyx","wxyy","wxyz","wxzw","wxzx","wxzy","wxzz","wyww","wywx","wywy","wywz","wyxw","wyxx","wyxy","wyxz","wyyw","wyyx","wyyy","wyyz","wyzw","wyzx","wyzy","wyzz","wzww","wzwx","wzwy","wzwz","wzxw","wzxx","wzxy","wzxz","wzyw","wzyx","wzyy","wzyz","wzzw","wzzx","wzzy","wzzz","xwww","xwwx","xwwy","xwwz","xwxw","xwxx","xwxy","xwxz","xwyw","xwyx","xwyy","xwyz","xwzw","xwzx","xwzy","xwzz","xxww","xxwx","xxwy","xxwz","xxxw","xxxx","xxxy","xxxz","xxyw","xxyx","xxyy","xxyz","xxzw","xxzx","xxzy","xxzz","xyww","xywx","xywy","xywz","xyxw","xyxx","xyxy","xyxz","xyyw","xyyx","xyyy","xyyz","xyzw","xyzx","xyzy","xyzz","xzww","xzwx","xzwy","xzwz","xzxw","xzxx","xzxy","xzxz","xzyw","xzyx","xzyy","xzyz","xzzw","xzzx","xzzy","xzzz"};

        System.out.println(arr1.length);
    }



}