package DSA.Graph;
/***
 * Constraints:
 *
 * 1 <= accounts.length <= 1000
 * 2 <= accounts[i].length <= 10
 * 1 <= accounts[i][j].length <= 30
 * accounts[i][0] consists of English letters.
 * accounts[i][j] (for j > 0) is a valid email.
 * */

import java.awt.*;
import java.awt.font.MultipleMaster;
import java.util.*;
import java.util.List;

/**
 *
 * Concept :- Applications Of DSU Data Structure And UnionFind.
 * Learning :- This Illustration Shows us How we can use the Union-Find , whenever we are merging to make the Components Merged.
 *             Implimentation is only Lengthy.
 *
 *
 * Number of Total Emails - 1000 * 9
 * Time Complexity :- 9000 Log(9000) ~ NlogN.
 * Space Complexity :- O(9000) ~ Number of Total Emails. ~ N
 *
 *
 * **/


class DisjointSetAccount{

    int n;
    int[]size;
    int[]parent;

    DisjointSetAccount(int n){
        this.n = n;
        size=new int[n+1];
        Arrays.fill(size , 1);

        parent = new int[n+1];
        for(int i=0; i<=n; i++){
            parent[i]=i;
        }
    }

    int Ultimate_Parent(int Node){

        if(parent[Node]==Node) return Node;

        return parent[Node] = Ultimate_Parent(parent[Node]);
    }

    void UnionBySize(int v1 , int v2){

        int Ulp_V1 = Ultimate_Parent(v1);
        int Ulp_V2 = Ultimate_Parent(v2);

        if(Ulp_V1 == Ulp_V2) return;

        if(size[Ulp_V1] < size[Ulp_V2]){

            size[Ulp_V2]+=size[Ulp_V1];
            parent[Ulp_V1] = Ulp_V2;
        }

        else{
            size[Ulp_V1]+=size[Ulp_V2];
            parent[Ulp_V2]=Ulp_V1;
        }


    }

}
public class Accounts_Merge{

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int Number_Account_Holders = sc.nextInt();
        List<List<String>>accounts = new ArrayList<>();

        for(int i=0; i<Number_Account_Holders; i++){

            accounts.add(new ArrayList<>());

            int Number_of_Emails = sc.nextInt();

            for(int j=0; j<=Number_of_Emails; j++){
                accounts.get(i).add(sc.next());
            }
        }

        DisjointSetAccount dsA = new DisjointSetAccount(Number_Account_Holders);    // Dijsoint Set Made.


        HashMap<String , Integer> Emials_IndexMapping = new HashMap<>();  // HashMap of size ~ Number of Accounts * 9 (max emails) = 1000*9

        for(int j=0; j<accounts.size(); j++){   // TC - Account * Emails size

            List<String>emails = accounts.get(j);

            for(int i=1; i<emails.size(); i++){

                String email = emails.get(i);

                if(Emials_IndexMapping.containsKey(email)==false){
                    Emials_IndexMapping.put(email , j);
                }

                else{

                    int previous_Index = Emials_IndexMapping.get(email);
                    dsA.UnionBySize(previous_Index , j);     // tc - 4Alpha.

                }
            }

        }



        HashMap<Integer , ArrayList<String>> Index_EmailMapping = new HashMap<>();

        for(String email : Emials_IndexMapping.keySet()){        // SC - O( nUMBER OF TOTALS Emails)

            int index = Emials_IndexMapping.get(email);
            int Component_Index = dsA.Ultimate_Parent(index);

            if(Index_EmailMapping.containsKey(Component_Index)==true){

                ArrayList<String>temp = Index_EmailMapping.get(Component_Index);
                temp.add(email);
                Index_EmailMapping.put(Component_Index , temp);

            }

            else{

                ArrayList<String>temp = new ArrayList<>();
                temp.add(email);
                Index_EmailMapping.put(Component_Index , temp);

            }

        }


        List<List<String>>ans = new ArrayList<>();

        for(int index : Index_EmailMapping.keySet()){              // Number of Emails ~ Number of Accounts * 9
                                                                   // TC - O(Number ofEmails log(Number of Emails))

            ArrayList<String>temp = Index_EmailMapping.get(index);
            Collections.sort(temp);

            ArrayList<String>addition = new ArrayList<>();
            addition.add(accounts.get(index).get(0));
            addition.addAll(temp);
            ans.add(addition);

        }

        System.out.println(ans);


    }

}