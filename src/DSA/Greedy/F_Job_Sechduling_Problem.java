package DSA.Greedy;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * Good Question :-
 *
 * Explanation ?:- Question Kaffi Aacha h. Bas baat ye thi ki Hmm maximum profit ke hisab se sort kr lenge.
 *                 fir agar us asked deadline par koi bhi sechdule nhi hua hoga to ose sechdule kr denge.
 *                 aur agar os jagah par phle se koi sechdule h to deadline -1 to 1 tk sechdular mai check krnge agar koi khali mila
 *                 to add kr denge.
 *
 *                 Intution - Maximum profit ke hisab se bas sechdule krate gye khali positions pe.
 *
 *
 *                 Time Complexity ?;  - O(NlogN + N *(maxdeadline))
 *                 Space Complexity ?: - O(maxDeadline).
 *
 * **/
class Job {
    int id, profit, deadline;
    Job(int x, int y, int z){
        this.id = x;
        this.deadline = y;
        this.profit = z;

    }
}
public class F_Job_Sechduling_Problem {

    public static int[] TotalProfit(Job[] Jobs, int n){

        Arrays.sort(Jobs , (a, b)->{
            return b.profit - a.profit;
        });

        // Calculate the Maximum Deadline.
        int maxiDeadline = 0;

        for(int i=0; i<Jobs.length; i++){
            maxiDeadline = Math.max(maxiDeadline , Jobs[i].deadline);
        }
        int[]JobsSechduler = new int[maxiDeadline+1];
        Arrays.fill(JobsSechduler , -1);

        int Profit = 0; int TotalJobs = 0;
        for(int i=0; i<Jobs.length; i++){

            int deadline = Jobs[i].deadline;
            int profit = Jobs[i].profit;
            int id = Jobs[i].id;

            if(JobsSechduler[deadline]==-1){
                JobsSechduler[deadline] = id;
                Profit+= profit;
                TotalJobs++;
            }

            else{

                for(int j = deadline-1; j>0; j--){
                    if(JobsSechduler[j]==-1){
                        JobsSechduler[j] = id;
                        Profit+= profit;
                        TotalJobs++;
                        break;
                    }
                }
            }
        }
        int[] ans = new int[2];
        ans[0] = TotalJobs; ans[1] = Profit;
        return ans;
    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Job[]Jobs = new Job[n];

        for(int i=0; i<n; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            Jobs[i] = new Job(a, b, c);
        }


        System.out.println("Number of Jobs and Total Profit is ?: " + Arrays.toString(TotalProfit(Jobs, n)));
    }
}
