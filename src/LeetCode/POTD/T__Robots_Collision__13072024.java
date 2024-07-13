package LeetCode.POTD;
import java.util.*;
/***

 Time Complexity :- O(nlogn + n + nlogn) == O(NlogN)
 first nlogn to fill first pq, and n is for fill stack and second nlogn for fill remaining robots who won.


 Space Complexity :- O(N + N + N) --> 2pq, 1 stack.


 Intuition --> It is Just same as the Bracket Problems of Stack and Now this the weights brackets
 Problem you can Imagine ((() --> overall there is a fighting happeing in ( , )
 with their weights/health and stack problem normal.
 I took the help of Robot class (to Have clear with position and all.. More Scalable Code I think So.)
 and used the Priority Queue on whatever thing we want to Manupulate the data.
 */
class robot{

           int robotNo;
           int robotPos;
           int robotHealth;
           char robotdir;

           robot(int rno, int rpos, int rhealth, char rdir){
               this.robotNo=rno;
               this.robotPos=rpos;
               this.robotHealth=rhealth;
               this.robotdir=rdir;
           }
        }
public class T__Robots_Collision__13072024 {

    public static List<Integer> finalHealth(int[]positions, int[]healths, String directions){

        int n = positions.length;
        PriorityQueue<robot>pq = new PriorityQueue<>((a, b)->{
            if(a.robotPos!=b.robotPos)return a.robotPos - b.robotPos;
            return a.robotNo-b.robotNo;
        });
        for(int i=0; i<n; i++){
            robot r = new robot(i+1, positions[i], healths[i], directions.charAt(i));
            pq.add(r);
        }

        Stack<robot>stk = new Stack<>();

        while (!pq.isEmpty()){

            robot r = pq.poll();

            if(stk.isEmpty()){
                // First entry or All Robot Lost Condition -
                stk.add(r);
            }

            else{
                while (stk.isEmpty()==false  && stk.peek().robotdir=='R' && r.robotdir=='L'){
                    // collison -
                    if(stk.peek().robotHealth < r.robotHealth){
                        // CurrentRobot Won -
                        stk.pop();
                        r.robotHealth = r.robotHealth -1;
                    }
                    else if(stk.peek().robotHealth > r.robotHealth){
                        // Prev-Robot Won -
                        robot r1 = stk.pop();
                        r1.robotHealth--;
                        r = r1;
                        break;
                    }
                    else{
                        // But Loss -
                        stk.pop();  r=null; break;
                    }
                }

                if(r!=null)stk.add(r);

            }
        }

        List<Integer>ans = new ArrayList<>();
        PriorityQueue<robot>pq2 = new PriorityQueue<>((a, b)->{
            if(a.robotNo != b.robotNo)return a.robotNo - b.robotNo;
            return a.robotPos-b.robotPos;
        });
        while (!stk.isEmpty()){
            robot r = stk.pop();
            pq2.add(r);
        }

        while(!pq2.isEmpty()){

            ans.add(pq2.poll().robotHealth);
        }

        return ans;
    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Number of Robots ?: ");
        int n = sc.nextInt();

        System.out.println("Enter the Position of Robots ?: ");
        int[]positions = new int[n];
        for(int i=0; i<n; i++)positions[i]=sc.nextInt();

        int[]healths = new int[n];
        for(int i=0; i<n; i++)healths[i] = sc.nextInt();

        System.out.println("Enter the Direction String ?: ");
        sc.nextLine();
        String directions = sc.nextLine();

        System.out.println("The Final Array of Health is ?: " +  finalHealth(positions, healths, directions));

    }
}
