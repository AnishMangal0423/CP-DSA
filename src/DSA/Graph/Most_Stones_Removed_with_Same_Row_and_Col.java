package DSA.Graph;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;


/***
 *
 * Approch :- We have to only  find the total Number of Connected Compnonets .
 *            and every compnonent - 1 will add in our answer.
 *
 *  Time Complexity ::  (Number of Stones) * (4 alpha)  ~~ n^2
 *  Space Complexity :: (row + col) Because of DSU.
 *
 * */
class DSUBySizeStones{

    int n;
    int[]Parent;
    int[]sizeComponent;

    DSUBySizeStones(int n){

        this.n = n;
        Parent = new int[n+1];
        sizeComponent = new int[n+1];
        for(int i=1; i<=n; i++){
            Parent[i]=i;
            sizeComponent[i]=1;

        }
    }


    int ultimate(int node){

        if(Parent[node]==node)return node;

        return Parent[node] = ultimate(Parent[node]);
    }

    void unionSize(int u, int v){

        int ultimateParent_u = ultimate(u);
        int ultimateParent_v = ultimate(v);

        if(ultimateParent_u == ultimateParent_v)return;

        else{

            if(sizeComponent[ultimateParent_u] > sizeComponent[ultimateParent_v]){

                sizeComponent[ultimateParent_u] +=sizeComponent[ultimateParent_v];
                Parent[ultimateParent_v] = ultimateParent_u;
            }

            else{

                sizeComponent[ultimateParent_v] +=sizeComponent[ultimateParent_u];
                Parent[ultimateParent_u]=ultimateParent_v;
            }

        }


    }
}
public class Most_Stones_Removed_with_Same_Row_and_Col{

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
         int[][]stones = new int[n][2];

         for(int i=0; i<n; i++){
             for(int j=0; j<2; j++)stones[i][j] = sc.nextInt();
         }

         int maxrow = 0;
         int maxcol = 0;

         for(int i=0; i<n; i++){

             maxrow = Math.max(maxrow , stones[i][0]);
             maxcol = Math.max(maxcol , stones[i][1]);
         }

         // Now we will Create the Disjoint set of size - (maxrow + 1) + (maxcol + 1)

        HashMap<Integer , Integer>map=new HashMap<>();
        int N = maxrow + maxcol + 1;
        DSUBySizeStones ds = new DSUBySizeStones(N);

        // Now connecting the vertexes --

        for(int i=0; i<n; i++){

            int rowNode = stones[i][0];
            int colNode = stones[i][1] + (maxrow + 1);
            ds.unionSize(rowNode, colNode);
            map.put(rowNode, 0);
            map.put(colNode , 0);
        }

        System.out.println(Arrays.toString(ds.Parent));
        // Now finding the Number of Connected Components -

        int count = 0;

        for(int kii : map.keySet()){
            if(ds.ultimate(kii)==kii){
//                count+=(ds.sizeComponent[i])-1;
                System.out.println("ll");
                count++;
            }
        }

        System.out.println(n - count);

    }
}
