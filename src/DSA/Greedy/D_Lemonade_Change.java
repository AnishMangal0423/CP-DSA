package DSA.Greedy;

import java.util.Scanner;

public class D_Lemonade_Change {

    public static boolean Transaction(int[]arr){

        int Money = 0, Count5 = 0 , Count10 = 0;

        for(int i=0; i<arr.length; i++){


            int val = arr[i];
            int returnVal = val - 5;
            if(Money >= returnVal){
                Money-=returnVal;
                Money+=val;

                if(val == 5){
                    Count5++;
                    continue;
                }
                else if(val == 10){
                    if(Count5 >= 1){
                        Count5--;
                        Count10++;
                    }
                    else return false;
                }

                else {
                    if(Count5 >= 1 && Count10 >= 1){
                        Count5--; Count10--;

                    }

                    else if(Count5 >= 3)Count5-=3;

                    else return false;
                }


            }

            else return false;
        }

        return true;
    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[]arr = new int[n];

        for(int i=0; i<n; i++)arr[i]=sc.nextInt();

        System.out.println("Is Possible ?: " + Transaction(arr));
    }
}