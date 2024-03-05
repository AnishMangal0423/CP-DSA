package Java_in_Java.Constructors_in_Java;

import java.util.Scanner;

class CheckBalance{

    int Balance;

    private CheckBalance(int Balance){
        this.Balance = Balance;
    }

    public static CheckBalance CanCheckBalance(int balance){          // It is Necassary to make it public and Static.
        CheckBalance obj = new CheckBalance(balance);
        return obj;
    }


}
public class Private_Constructors {

    public static void main(String[] args) {

     int []RollNo = {1, 2, 3, 4};

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Roll Number of Candidate : ");
        int no = sc.nextInt();

        boolean flag = false;
        for(int i=0; i<RollNo.length; i++){
            if(no == RollNo[i]){
                flag = true;
                System.out.println("Enter the balance of candidate : ");
                int balance = sc.nextInt();
                CheckBalance obj = CheckBalance.CanCheckBalance(balance);
                System.out.println("Roll No : " + no +" Has Balance of : "+ obj.Balance);
                break;
            }
        }

        if(flag == false) System.out.println("User Not Found in Database , Cannot fetch Balance details.");

    }
}
