package DSA.Strings;
import java.util.Scanner;

/**
 *
 * It is Note Time Now -
 * So the Overall Time and Spaces are -
 *
 * Pattern Length - m
 * Mainstr Length - n
 *
 * Time Complexity :-
 *
 *     O(m) --> For calculating Initial HashCode Value for pattern , mainstr.  +
 *     O(n-m+1) --> Maximum shifts or Iteration (window switch) on mainstr.    +
 *     Now it depends ese bhi ho sakta saree pe hit kre ya ek pe hit kre...
 *     if(sarre pe) to whai O(m*n) nhi too                                     +
 *     O(M)   --> basically string matching krenge pattern se confirm krne ke liye.
 *
 *
 *    Overall AverageCaseComplexity -- O(m) + O(n-m+1) + O(m)
 *    Overall WorstCaseComplexity  -- O(m*n)
 *
 *
 *
 * Space Complexity :-
 *
 * O(1) I think ..
 * **/


public class RabinKarp_Algorithm {

    public static boolean MatchStrings(String pattern , String mainString , int i){
        for(int j=0; j<pattern.length(); j++){
            if(mainString.charAt(i)!=pattern.charAt(j))return false;
            i++;
        }
        return true;
    }
    public static boolean isPresent(String mainString, String pattern){

        if(pattern.length() > mainString.length())return false;
        int MultiplyValue = 27;
        long MOD = (long) 10e9+7;
        long patternHashCode = 0;

        int mainStringLen = mainString.length();
        long mainStringHashCode = 0;

        for(int i=0; i<pattern.length(); i++){
            char patternLetter = pattern.charAt(i);
            char mainStringLetter = mainString.charAt(i);
            patternHashCode += ((patternLetter-'a'+1)*(long)(Math.pow(MultiplyValue, (pattern.length()-i-1))))%MOD;
            mainStringHashCode += ((mainStringLetter-'a'+1)*(long)(Math.pow(MultiplyValue, (pattern.length()-i-1))))%MOD;
        }
//        System.out.println(mainStringHashCode+ " "+patternHashCode);

       int i=0 , j = pattern.length()-1;

        while (i<= (mainStringLen - pattern.length())){

            if(patternHashCode == mainStringHashCode){
                boolean isSimilar = MatchStrings(pattern, mainString , i);
                if(isSimilar==true)return true;
            }
            if(i==(mainStringLen-pattern.length()))return false;
            // Rollback HashCode -
            mainStringHashCode = ((((mainStringHashCode) - ((mainString.charAt(i)-'a'+1)*(long)(Math.pow(MultiplyValue, (pattern.length()-1)))))*MultiplyValue)%MOD + (mainString.charAt(j+1)-'a'+1))%MOD;
//            System.out.println(" Now new - "+ mainStringHashCode);
            i++; j++;
        }
return false;

    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String mainString = sc.next();
        String pattern = sc.next();

        System.out.println("Is Pattern Present in MainString :- " + isPresent(mainString , pattern));
    }
}
