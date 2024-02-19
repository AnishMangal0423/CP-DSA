package CodeForces.Contests.Div3.Div3__Round927__18022024;
import java.util.Scanner;
public class Q3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        while (tc-->0){
         int n = sc.nextInt();
         int k = sc.nextInt();
         int[]arr = new int[n];
         long pro=1;
         for(int i=0; i<n; i++){
             arr[i]=sc.nextInt();
             pro*=arr[i];
         }
         String s = sc.next();
         int l=0, r=n-1;
         for(int i=0; i<n; i++){
             System.out.print(pro%k+" ");
             if(s.charAt(i)=='L'){
                 pro/=(long)arr[l];
                 l++;
             }
             if(s.charAt(i)=='R'){
                 pro/=(long)arr[r];
                 r--;

             }
         }
            System.out.println();
        }
    }
}
