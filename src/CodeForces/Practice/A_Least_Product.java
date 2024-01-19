package CodeForces.Practice;

import java.util.Scanner;

public class A_Least_Product{

    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);

        int tc= sc.nextInt();

        while (tc-->0){

            int n=sc.nextInt();
//            System.out.println("n" + n);
            int sum=0;

            boolean flag=false;
            int neg=0;
            for(int i=0; i<n; i++){

                long a=sc.nextLong();

                if( a ==0 && flag==false ){
                    flag=true;
                    System.out.println(0);
                }
                else if(a < 0)neg++;
            }

//            System.out.println("Neg : "+neg+ " " +n);
            if((neg & 1)==0 && flag==false){
                System.out.println("1");
                System.out.println("1 0");
            }

           else if((neg & 1)==1 && flag==false){
                System.out.println("0");
            }
        }
    }
}
