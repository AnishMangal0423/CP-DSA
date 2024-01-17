package DSA.Graph;
import java.util.*;

class WordLadderPair{

    String word;
    int level;

    WordLadderPair(String word, int level){
        this.word=word;
        this.level=level;
    }
}

public class Word_Ladder{

    public static int Ladderlen(String beginWord, String endWord, Set<String>set){

        Queue<WordLadderPair>q=new LinkedList<>();
        q.add(new WordLadderPair(beginWord, 1));

        while (!q.isEmpty()){
            System.out.println(set);
            WordLadderPair front = q.poll();
            String word=front.word;
            if(word.equals(endWord)) return front.level;
            int level=front.level;
            set.remove(word);

            for(int i=0; i<word.length(); i++){

                for(char ch='a'; ch<='z'; ch++){

                    char[]temparray= word.toCharArray();
                    temparray[i]=ch;
                    String tempstring=new String(temparray);
                    if(set.contains(tempstring)) q.add(new WordLadderPair(tempstring, level+1));

                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        String beginWord=sc.nextLine();

        String endWord=sc.nextLine();

        int n = sc.nextInt();
        int m = sc.nextInt();
        String es = sc.nextLine();

        ArrayList<String>wordList=new ArrayList<>();

        for(int i=0; i<n; i++)wordList.add(sc.nextLine());

        Set<String>set=new HashSet<>();
        for (int i=0; i<n; i++)set.add(wordList.get(i));
        System.out.println(Ladderlen(beginWord, endWord, set));

    }
}