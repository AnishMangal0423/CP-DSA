package TLE_LVL_2.Bit_Manupulation;

import java.util.Scanner;

public class Xor_and_Multiply{

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int tc=sc.nextInt();

        while(tc-->0){

            int n=sc.nextInt();
            int a=sc.nextInt();
            int b=sc.nextInt();

            if(b > a){
                int s=a;
                a=b;
                b=s;
            }

            int ans=0;
            boolean flag = true;
            for(int i=n-1; i>=0; i--){

                int a1=(a&(1 << i));
                int a2=(b&(1 << i));
                if(a1==a2){
                    if(a1==0) ans |= (1 << i);
                }

                else {
                    if (flag == true) flag = false;

                    else {
                        if (a2 == 0) ans |= (1 << i);
                    }
                }
            }

            System.out.println(ans);
        }

    }
}
