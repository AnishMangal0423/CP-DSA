package LeetCode.POTD;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/**
 *
 * TC - O(Length_of_sentence * No_of_roots)
 * SC - O(Length_of_sentence)
 *
 * Error-1 :: Index Out of Bound ?: Not taking the Min length in 2 matching string.
 *
 * Error-2 :: with checking length we have to keen in mind ki root.length agar kaam ho sentence ke word se too hi hmm replace krenge.
 *
 *
 * Cringe in this Question --> root.length can be greater then sentenceword.length.
 *
 *
 * **/

public class K__Replace_Words__07062024 {

        public static String replaceWords(List<String> dictionary, String sentence) {


            String[]arr=sentence.split(" ");

            for(int i=0; i<arr.length; i++){

                String derivative = arr[i];

                int len = Integer.MAX_VALUE;
                for(String root : dictionary){

                    // Error-1 :: was occured here for me.
                    int mini = Math.min(root.length(), derivative.length());
                    boolean flag = true;
                    for(int j=0; j<mini; j++){

                        if(derivative.charAt(j)!=root.charAt(j)){
                            flag = false;
                            break;
                        }
                    }

                    if(flag == true){

                        // Error-2 :: was occured for me here.
                        if(root.length() < len && root.length() <= derivative.length()){
                            len = root.length();
                            arr[i]=root;
                        }
                    }
                }
            }

            StringBuilder newstr = new StringBuilder();

            for(String ss : arr){
                newstr.append(ss + " ");
            }
            newstr.deleteCharAt(newstr.length()-1);
            return newstr.toString();
        }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<String>dictioanry = new ArrayList<>();
        for(int i=0; i<n; i++)dictioanry.add(sc.next());

        String sentence = sc.next();
        System.out.println("Replaced Sentence is ?: " + replaceWords(dictioanry, sentence));
    }
}
