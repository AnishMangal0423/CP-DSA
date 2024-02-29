package DSA.Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * Time Complexity :- O(q + n*n)
 * Space Complexity :- O(N*N)
 * **/

class DisjointSet_Islands_2{

    int n;
    int[]size;
    int[]parent;

    DisjointSet_Islands_2(int n){

        this.n = n;
        size = new int[n+1];
        Arrays.fill(size, 1);

        parent = new int[n+1];
        for(int i=0; i<=n; i++) parent[i]=i;
    }

    int Ultimate_Parent(int node){

        if(parent[node]==node)return node;

        return parent[node]=Ultimate_Parent(parent[node]);
    }

    void UnionFind(int v1, int v2){

        int Ulp_v1 = Ultimate_Parent(v1);
        int Ulp_v2 = Ultimate_Parent(v2);

        if(Ulp_v1 == Ulp_v2) return;

        if(size[Ulp_v1] >= size[Ulp_v2]){
            size[Ulp_v1]+=size[Ulp_v2];
            parent[Ulp_v2]=Ulp_v1;
        }

        else{
            size[Ulp_v2]+=size[Ulp_v1];
            parent[Ulp_v1]=Ulp_v2;
        }

    }


}
public class Number_of_Islands_2__Online_Quiries{

   static  int count = 0;
   static int[][]coord = {{0, -1}, {-1, 0}, {0, 1}, {1, 0}};

   public static boolean isValid(int x, int y, int n){
       return (x>=0 && x<n && y>=0 && y<n);
   }
    public static int GetQueryAns(DisjointSet_Islands_2 ds, int x, int y, int[][]visited){

        int n = visited.length;
        int gridNo1 = (x*n)+y;
        if(visited[x][y]==1)return count;
        else{

            visited[x][y]= 1;
            count++;

            for(int[]cord : coord){

                int xx = x + cord[0];
                int yy = y + cord[1];

                if(isValid(xx, yy, n) && visited[xx][yy]==1){
                    int gridNo2 = (xx* n)+yy;
                    if(ds.Ultimate_Parent(gridNo1)!=ds.Ultimate_Parent(gridNo2)) {
                        count--;
                        ds.UnionFind(gridNo1, gridNo2);
                    }
                }
            }

        }
return count;
    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Size of HoneyMoon Matrix : ");

        int n = sc.nextInt();

        int[][]honeyMoon = new int[n][n];

        System.out.println("Enter the Number of Quiries You want to Ask : ");
        int q = sc.nextInt();
        int[][]quieries = new int[q][2];

        for(int i=0; i<q; i++){
            quieries[i][0]=sc.nextInt();
            quieries[i][1]=sc.nextInt();
        }


        // We will use DS in Dynamanic Graphs.

       DisjointSet_Islands_2 ds = new DisjointSet_Islands_2(n*n);

        ArrayList<Integer>ans = new ArrayList<>();

        int[][]visited = new int[n][n];

        for(int i=0; i<q; i++){

            int x = quieries[i][0];
            int y = quieries[i][1];
            ans.add(GetQueryAns(ds, x, y , visited));
        }


        System.out.println(ans);
    }
}

//
//0 0
//        0 0
//        1 1
//        1 0
//        0 1
//        0 3
//        1 3
//        0 4
//        3 2
//        2 2
//        1 2
//        0 2