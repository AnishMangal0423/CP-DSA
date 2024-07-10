package LeetCode.POTD;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Q__AverageWaitingTime_Resaturant__09072024{

    public static double AverageTime(int[][]customers) {

        int NowTime = 0;
        int averageTimeSum = 0;
        for (int i = 0; i < customers.length; i++) {

            if (customers[i][0] > NowTime) {
                averageTimeSum += customers[i][1];
                NowTime = customers[i][0] + customers[i][1];
            } else {
                averageTimeSum += (NowTime + customers[i][1] - customers[i][0]);
                NowTime = NowTime + customers[i][1];
            }
            System.out.println(NowTime + " " + averageTimeSum);
        }


        double val = (double) (averageTimeSum) / (double) (customers.length);

        return Double.parseDouble(String.format("%.5f", val));
    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Number of Customer Came to Restaurant ?: ");
        int noofCustomers = sc.nextInt();

        int[][] customers= new int[noofCustomers][2];
        System.out.println("Enter the Customer Arrival And Food Time ?: ");
        for(int i=0; i<noofCustomers; i++){
            for(int j=0; j<2; j++)customers[i][j]=sc.nextInt();
        }


        System.out.println("The Total Average Time for Customers is ?: " + AverageTime(customers));
    }
}
