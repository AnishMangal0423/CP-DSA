package DSA.Greedy;
import java.util.Scanner;
import java.util.Stack;

/**
 *
 * Concept :- Family of String Parenthesis.
 *
 * Approches :-
 *
 *     Approch-1 :-  Recursive Approch (Brute Force)
 *                   Hame pata h ki '*' teen trah se ho skata h , to teeno append krlo seperately ese krte jayo
 *                   decesion tree bna lo , aur ek bhi branch se true aa rha ho, too whai se true return krte chle jao , ans = true.
 *
 *                   TC - O(3^N) , SC - O(N)
 *
 *
 *     Approch -2 :- StacK Approch -
 *                   Hmm kya karenge na 2 stack bna lenge ek(parenthesis ka index apne pass rkhegi) , dusri ( '*' ka index rkhegi)
 *                   aab jab bhi ')' aayega ,, to agar prenthesis stack mai ya fir * stack mai element h to kaam bn gya , warna false.
 *                   Lets suppose hmm string ke end mai poch gye and parenthesis stack is empty to return true.otherwise hmm opening parenthesis ko * se compensiate krenge.
 *
 *                   My I am string Indexes --> Kyuki jo baad mai loop h , osme lets suppose (* ho tab thek h , but agar *( ho to glat
 *                                              aayega agar index store nhi kre too.
 *
 *                   TC - O(N) , SC - O(N)
 *
 *
 *
 *     Approch-3 :- Range Method -
 *                  Ye thoda sa tough h feel karna , but koi na aacha method h ,,
 *                  Hmm is trakike se samajte h ki letssuppse saree '*' agar (((( bn gye lekin fir bhi ))) jada hoo to ans false hi hona h.
 *                  Hmm poraa qn * ko '(' mai badalne ki ho baat kr rhe h , hmm range nikal rhe h , finally kitne '(' bachenge
 *                  // Case-6.
 *                return leftMin == 0;  // agar leftmin == 0 h matlab, last mai agar '(' hota to leftmin>0 hota , & agar )))) jada hote too phle hi case-4 mai aa jate
 *                               // iska matlab h ki balance ho gya h ( , ) .
 *
 *                TC - O(N) ,   SC - O(1)

 * **/
public class E_Valid_Parenthesis_Checker{

    public static boolean isValidMtd1(String s){

        Stack<Integer>paranthesis = new Stack<>();
        Stack<Integer>stars = new Stack<>();

        for(int i=0; i<s.length(); i++) {

            char curr = s.charAt(i);

            if (curr == '(') paranthesis.push(i);
            else if (curr == '*') stars.push(i);
            else {
                if (!paranthesis.isEmpty()) paranthesis.pop();
                else if (!stars.isEmpty()) stars.pop();
                else return false;
            }
        }

            while (!paranthesis.isEmpty() && !stars.isEmpty()){

                if(stars.peek() > paranthesis.peek()){
                    stars.pop();
                    paranthesis.pop();
                }
                else return false;
            }

            return paranthesis.isEmpty();
        }

    public static boolean isValidMtd2(String s){

        int leftMin = 0 , leftMax = 0;

        for(int i=0; i<s.length(); i++){

            char curr = s.charAt(i);

            // Case-1
            if(curr == '('){
                leftMin++; leftMax++;  // yha obv badega.
            }

            // Case-2
            else if(curr == ')'){      // Concrete ) ho to wo to khud hi ghateya .
                leftMin--; leftMax--;
            }

            // Case-3
            else{
                leftMin--;  leftMax++;  // hmne ghatane , badane ke case to yha le liye and empty string ka niche baar baar 0 kr denge agar -ve gya too wo wha manupulate ho rha

            }

            // Case-4
            if(leftMax < 0)return false;   // ((())))))))  '*' is treated as '(' , lekin ')' hi jada h kya kare.

            // Case-5
            if(leftMin < 0) leftMin = 0;   // Aab jab hmm '*' ko ')' ese treat kr rhe to matlab jada ))) lagana bhi sahi nhi h , is se aacha * ko _ treat krlo
                                           // continued to upper case example --> (***)
        }

        // Case-6.
        return leftMin == 0;  // agar leftmin == 0 h matlab, last mai agar '(' hota to leftmin>0 hota , & agar )))) jada hote too phle hi case-4 mai aa jate
                              // iska matlab h ki balance ho gya h ( , ) .
    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();

        System.out.println("Is string has Valid Parenthesis ?: " + isValidMtd1(s));
        System.out.println("Is string has Valid Parenthesis ?: " + isValidMtd2(s));
    }
}
