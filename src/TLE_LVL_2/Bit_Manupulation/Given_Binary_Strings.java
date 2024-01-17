package TLE_LVL_2.Bit_Manupulation;

import java.util.Scanner;

public class Given_Binary_Strings {


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int tc = sc.nextInt();
        sc.nextLine();

        while(tc-- > 0) {
            String x = sc.nextLine();
            String y = sc.nextLine();


            int n1= x.length();
            int n2= y.length();

            int c1=0; int c2=0;
            for(int i=n2-1; i>=0; i--){

                if(y.charAt(i)=='0'){
                    c2++;
                }
                else{
                    break;
                }

            }


            for(int j=n1-1-c2; j>=0; j--){

                if(x.charAt(j)=='0'){
                    c1++;
                }
                else{
                    break;
                }
            }




            System.out.println(c1);

        }
    }
}
