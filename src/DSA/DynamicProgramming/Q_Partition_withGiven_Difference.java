package DSA.DynamicProgramming;
import java.util.Scanner;

/**

 Both Methods Done -

 Method-1 :- Recursion and Memoization -
 Recursion Part Is Easy to Write Only thing that Keep in Mind is we have to
 return in Last after doing all Calcuations...


 Method-2 :- Tabulation Method -
 JO Ye wali Problems Hoti h jisme Hme Partition Krna Hota h .. on sab
 mai 0 Kaffi Bda role play krta h
 Eg --> arr=[1,2,1] and now arr = [0, 1, 2, 1]
 first wali ka ans 2 , second one will have 4 as ans.

 To Hamesha Esi situation Ko deal krne ke liye kya Kro ki , Hamesha dp ka
 size dp[n+1][sum+1] krdo aab kya tumhare ans dp[0][..] ke hisab se
 decide hoga and tumhe arr[0]=0 / kuch oor ko sochna nhi padega
 simply dp[0][i] ko fill krdo and other dp ko fill krke ans return krdo.


 Time Complexity :- O( (N+1) * (Sum+1))
 Space Complexity :- O(N * Sum)

 **/

public class Q_Partition_withGiven_Difference {

    public static int PossiblePartition_Memoization(int[]arr, int index, int sum1, int[][]dp, int sum,  int diff){

        int sum2 = sum-sum1;
//        if(sum1-sum2==diff)return 2;
        if(index < 0){
            if(sum1-sum2==diff)return 1;
            return 0;
        }
        if(dp[index][sum1]!=-1)return dp[index][sum1];

        return dp[index][sum1]=PossiblePartition_Memoization(arr, index-1, sum1+arr[index],dp, sum, diff) + PossiblePartition_Memoization(arr, index-1, sum1,dp, sum, diff);

    }

    public static int PossiblePartition_Tabulation(int[]arr, int[][]dp, int sum,  int diff){

        for(int i=0; i<=sum; i++){
            int s1 = i;
            int s2 = sum-i;
            if(s1-s2==diff)dp[0][i]=1;
        }

        for(int i=1; i<=arr.length; i++){
            for(int j=0; j<= sum; j++){

                System.out.println("i "+i +" j "+j+" "+ (j+arr[i-1]));
                int non_take = dp[i-1][j];

                int take = 0;
                if(j+arr[i-1]<=sum){
                    take =dp[i-1][j+arr[i-1]];
                }

                dp[i][j] = take+non_take;
                System.out.println(dp[i][j]);
            }
        }
//
//        for(int i=0; i<=arr.length; i++){
//            for(int j=0; j<=sum; j++) System.out.print(dp[i][j]+" ");
//            System.out.println();
//        }
//

        return dp[arr.length][0];
    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Size of Array : ");
        int n = sc.nextInt();
        int[]arr = new int[n];
        int sum=0;
        for(int i=0; i<n; i++){
            arr[i]=sc.nextInt();
            sum+=arr[i];
        }
        int diff = sc.nextInt();
        int[][]dp = new int[n+1][sum+1];

        System.out.println("The Number of Partitions Possible is :- " + PossiblePartition_Tabulation(arr, dp, sum, diff));
    }
}
