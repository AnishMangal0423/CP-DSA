package DSA.Heaps;

import java.util.*;

class CombinationPair{
    int val;
    int ind1;
    int ind2;

    CombinationPair(int v, int f, int s){
        val=v;
        ind1=f;
        ind2=s;
    }

}
public class L_Maximum_Sum_Combinations{

    public static ArrayList<Integer> Combinations(ArrayList<Integer>A, ArrayList<Integer>B, int C){

        ArrayList<Integer>ans = new ArrayList<>();
        int N = A.size();
        PriorityQueue<CombinationPair>pq=new PriorityQueue<>((a, b)->{
            if (a.val != b.val) return b.val - a.val;
            else if (a.ind1 != b.ind1) return b.ind1 - a.ind1;
            return b.ind2 - a.ind2;
        });
       Collections.sort(A); Collections.reverse(A);
       Collections.sort(B); Collections.reverse(B);
        HashSet<String>set = new HashSet<>();

       pq.add(new CombinationPair(A.get(0)+B.get(0) , 0, 0));
       set.add("00");

        while(ans.size() < C && !pq.isEmpty()){

              CombinationPair front = pq.poll();
              int value = front.val;
              int ind1 = front.ind1;
              int ind2 = front.ind2;

              ans.add(value);
            System.out.println(value+" " + ind1+" " + ind2 +" ");
              if(ind1+1 < N && set.contains((ind1+1)+""+ind2)==false){
                  pq.add(new CombinationPair(A.get(ind1+1) + B.get(ind2), ind1+1, ind2));
                  set.add((ind1+1)+""+ind2);
              }
              if(ind2+1 < N && set.contains(ind1+""+(ind2+1))==false){
                  pq.add(new CombinationPair(A.get(ind1) + B.get(ind2+1) , ind1 , ind2+1));
                  set.add(ind1+""+(ind2+1));
              }
        }

        return ans;
    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        ArrayList<Integer>A=new ArrayList<>();
        ArrayList<Integer>B = new ArrayList<>();

        for(int i=0; i<N; i++)A.add(sc.nextInt());

        int NN = sc.nextInt();
        for(int i=0; i<N; i++)B.add(sc.nextInt());

        int C = sc.nextInt();

        System.out.println("Maximum sum Combinations of Size C is ?: " + Combinations(A, B, C));
    }
}
