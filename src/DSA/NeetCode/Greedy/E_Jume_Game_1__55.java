package DSA.NeetCode.Greedy;
import java.util.Scanner;

/***
 Brute Force - Dp O(N^2) soln , O(N) space.

 Optmized - Greedy O(N), O(1) Space.

 Approach - Let's Keep the Goal at n-1 and now check for element n-2 that if
 according to it he will reach or not i + nums[i] >= goal , means we get
 new goal .. keep going
 if goal becomes zero means true else not.

 */
public class E_Jume_Game_1__55 {

    public static boolean JumpGame(int[]nums){

        int n = nums.length;
        int goal = n - 1;

        for (int i = n - 2; i >= 0; i--) {
            if ((i + nums[i]) >= goal)
                goal = i;
        }

        return goal == 0;
    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[]arr=new int[n];
        for(int i=0; i<n; i++)arr[i]=sc.nextInt();
        System.out.println("Will reach at End : "+ JumpGame(arr));
    }
}
