package CodeForces.Contests.Div4.Div_4_964__06082024;
import java.util.Scanner;


/***
 *
 * This the Question on Games :-
 * Basically main thing was Like i was missing 1 Case -
 * what will happen is :- summit player1 will win when
 * both match player-1 will win , or player-1 wins 1 match and another match is tie.
 *
 * Second case nhi lia tha isi liye glat de rha tha answers.
 *
 * & Good Question.
 *
 * **/
public class Q2 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-->0){

            int[]arr = new int[4];

            for(int i=0; i<4; i++)arr[i]=sc.nextInt();

            int ans = 0;

             if(arr[0] >=arr[2] && arr[1] > arr[3] || (arr[0]>arr[2] && arr[1]>=arr[3]))ans+=2;
             if(arr[1]>=arr[2] && arr[0]>arr[3] || (arr[1]>arr[2] && arr[0]>=arr[3]))ans+=2;

            System.out.println(ans);
        }
    }
}
