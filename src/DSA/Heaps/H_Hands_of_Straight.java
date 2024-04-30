package DSA.Heaps;
import java.util.Scanner;
import java.util.TreeMap;

/**
 *
 * Concept :- Question on Frequency/Counts and Story of HashMap vs TreeMap
 *
 * Approch :- Direct Approch Came in Mind of TreeMap:-
 *           Make the TreeMap and then hamesha first eleemnt ko nikalkar oske corressponding
 *           Kii + Groupsize ka loop lagakar corresponding kii's ko nikal lo..
 *           agar khai par consecutiev na mile to false,, nhi to baad mai true.
 *
 *           TC - O(NlogN)
 *           SC - O(N)
 *
 *          Chayee Priority queue se Bas values ko daal do and consecutive ka dekh lo.
 *
 *
 *   Story Of HashMap vs TreeMap ---->
 *
 *   TreeMap --> Jisa ki hmm Log dekh rhe h naam mai hi tree h to iska internal Implementation Red Black tree se Hota h
 *               jisme Intesertion , del, update ye sab O(logN) time hi lete h in all cases , logN to leta h but Hashmap
 *               Key ke hisab se sorted Hota h.
 *               Isi liye isme aaram se baad mai remove bhi chal jata h.
 *
 *
 *    HashMap --> Ye bilkul hi alag concept h , ye shuruat mai array of LinkedListNodes se implement hota h , But
 *                agar data values badi dedi , ya data jada h to ye bhi O(logN) matlab R.B tree mai shift ho jata h
 *                But phle array se to O(1) hi rhta h , but hme pta h hmm array se kuch remove nhi kr sakte h.
 *
 *
 *
 *
 * **/

public class H_Hands_of_Straight{

    public static boolean isPossible(int[]hand, int groupSize){

        int n = hand.length;
        TreeMap<Integer, Integer>map = new TreeMap<>();
        for(int i=0; i<n; i++)map.put(hand[i] , map.getOrDefault(hand[i], 0 ) + 1);

        while (map.size()!=0){
            for(int kii : map.keySet()){
                for(int k=kii; k<kii+groupSize; k++){
                    if(map.containsKey(k)==false)return false;
                    else map.put(k , map.get(k)-1);

                    if(map.get(k)==0)map.remove(k);
                }
                break;
            }
        }
        return true;
    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[]hand = new int[n];
        for(int i=0; i<n; i++)hand[i]=sc.nextInt();
        int groupSize = sc.nextInt();

        if(Math.floor((double) n/(double)groupSize)!=Math.ceil((double) n/(double) groupSize)) System.out.println("false");
        else System.out.println("Is Possible to split in Groups ?: " + isPossible(hand , groupSize));

    }
}
