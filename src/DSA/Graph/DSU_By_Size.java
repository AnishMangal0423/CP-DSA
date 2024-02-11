package DSA.Graph;

/**
 *
 * Add : DSU By Size only the change is that we do not want our number o…
 * …f elements to loose like in rank one so we use less no of elements will add ..
 * Btw rank is more good because it tells smaller rank means smaller height so will take log(smaller)
 * will reduce more time complexity so yeah at the end of the day tc for both is almost 4@ and both are
 * good only this method is more intutive
 *
 * **/
class DSUBySize{

    int n;
    int[]Parent;
    int[]sizeComponent;

    DSUBySize(int n){

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
public class DSU_By_Size {
    public static void main(String[] args) {

        DSUBySize d1 = new DSUBySize(7);

        d1.unionSize(1, 2);
        d1.unionSize(2, 3);
        d1.unionSize(4, 5);
        d1.unionSize(6, 7);
        d1.unionSize(5, 6);

        System.out.println(d1.ultimate(3) == d1.ultimate(7));

        d1.unionSize(3, 7);

        System.out.println(d1.ultimate(3) == d1.ultimate(7));

    }
}
