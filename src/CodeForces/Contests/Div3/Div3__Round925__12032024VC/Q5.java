package CodeForces.Contests.Div3.Div3__Round925__12032024VC;

import java.util.Scanner;

public class Q5 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int tc=sc.nextInt();

        while (tc-->0){


             int n = sc.nextInt();
            boolean flag = false;
             for(int i=1; i<=26; i++){
                 for(int j=1; j<=26; j++){
                     for(int k=1; k<=26; k++){
                         if(i+j+k == n){
                             System.out.print((char) ('a'+ i -1)+""+ (char) ('a'+ j -1) +""+ (char)('a'+ k -1));
                             System.out.println();
                             flag=true;
                             break;
                         }
                     }
                   if(flag==true)break;
                 }
                 if(flag==true)break;
             }
        }
    }
}
