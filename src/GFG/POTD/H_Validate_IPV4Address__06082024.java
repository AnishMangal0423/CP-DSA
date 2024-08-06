package GFG.POTD;
import java.util.Scanner;


/**
 *
 * Learnings :- Question is Preety Decent But There are a Lot of Edge Cases in this Question that we should thinkof.
 *
 * Edge Case - 1 :- Dots Hi 2 Ho.
 *
 * Edge Case - 2 :- Leading Zeros aa Jaye Like - 01 or 081 is trah.
 *
 * Edge Case - 3 :- Leading Zeros mai ye na Ho 0 ko hi hta dia.
 *
 * Edge Case - 4 :- Last mai Dot Nhi h to dekhna padgea ki i==n par bhi checking ho.
 *
 * **/

public class H_Validate_IPV4Address__06082024 {

    public static boolean isValid(String str) {
        // Write your code here


        StringBuilder sb = new StringBuilder();


        int n = str.length();
        int DotCount = 0;

        for(int i=0; i<=n; i++){



            if(i==n || str.charAt(i)=='.'){

                DotCount++;
                if(sb.length()==0)return false;
                if(sb.charAt(0)=='0' && sb.length()>1)return false;

                int midVal = Integer.parseInt(sb.toString());
                sb.setLength(0);

                if(midVal < 0 || midVal > 255){
                    return false;
                }

            }

            else{
                char c = str.charAt(i);
                sb.append(c);
            }
        }

        if(DotCount==4) return true;
        return false;

    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String IPV4Add = sc.nextLine();

        System.out.println("Is this IPV4 Address Valid ?: "+ isValid(IPV4Add));

    }
}
