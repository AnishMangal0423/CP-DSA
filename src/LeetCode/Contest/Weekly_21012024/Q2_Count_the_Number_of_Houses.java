package LeetCode.Contest.Weekly_21012024;
import java.util.*;

class Pair{

    int data;
    int level;

    Pair(int d, int l){
        data=d;
        level=l;
    }
}


public class Q2_Count_the_Number_of_Houses{
    public static int[] countOfPairs(int n, int x, int y) {


        int[]ans=new int[n];

        ArrayList<ArrayList<Integer>>arr=new ArrayList<>();


        for(int i=0; i<n; i++){

            arr.add(new ArrayList<>());
        }


        for(int i=0; i<n-1; i++){

            arr.get(i).add(i+1);
            arr.get(i+1).add(i);
        }

        arr.get(y-1).add(x-1);
        arr.get(x-1).add(y-1);

        // System.out.println(arr);


        for(int i=0; i<n; i++){

            boolean[]visited=new boolean[n];
            Queue<Pair>q=new LinkedList<>();
            q.add(new Pair(i, 0));

            while(!q.isEmpty()){

                Pair front = q.poll();
                int data = front.data;
                int level = front.level;
                visited[data]=true;

                for(int childs : arr.get(data)){

                    if(visited[childs]==false){

                        q.add(new Pair(childs, level+1));
                        visited[childs]=true;
                        ans[level]++;
                    }
                }


            }


        }



        return ans;
    }
    public static void main(String[] args) {


        Scanner sc=new Scanner(System.in);

        int n=sc.nextInt();
        int x=sc.nextInt();
        int y=sc.nextInt();

        int[]ans=countOfPairs(n, x, y);

        System.out.println(Arrays.toString(ans));
    }

}
