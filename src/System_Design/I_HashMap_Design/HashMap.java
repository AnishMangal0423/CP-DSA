
/**
 *
 * So there are 2 Types of Collisions , Collision By only Hashcode or Collsion By hashcode and Key Same
 * **/

package System_Design.I_HashMap_Design;


class Entry<K, V>{

    public K key;
    public V value;
    public Entry next;

    public Entry(K key, V value){
        this.key=key;
        this.value=value;
        next=null;
    }
}
public class HashMap<K, V>{

    private static final int INITIAL_SIZE = 1<<2;
    private static final int MAXIMUM_SIZE =  1<<30;
    public Entry[] hashTable;

    public static int size = 0;

    public static int NumberofNodes = 0;

    int ThreshouldRehash = 2;
    int TableSize=INITIAL_SIZE;
    public HashMap(){
        hashTable = new Entry[INITIAL_SIZE];
        for(int i=0; i<INITIAL_SIZE; i++)hashTable[i]=null;
    }

    public HashMap(int Capacity){
        int hashMapCapacity = findhashMapCapacity(Capacity);
        hashTable = new Entry[INITIAL_SIZE];
        for(int i=0; i<INITIAL_SIZE; i++)hashTable[i]=null;
        TableSize=hashMapCapacity;
    }

    public int size(){return size;}
    public int findhashMapCapacity(int Capacity){

        for(int i=0; i<30; i++){
            if((1<<i)>=Capacity)return (1<<i);
        }

        return 0;
    }


    public void put(K key, V value){

        int HashCode = (key.hashCode() % (TableSize));
        Entry node = hashTable[HashCode];

        if(node==null){
            node = new Entry(key, value);
            size++;
            NumberofNodes++;
            hashTable[HashCode]=node;
        }

        // It means It is the Case of Collision via HashCode
        else{
            Entry head = hashTable[HashCode];

            while(head.next!=null){
                if(key==head.key){
                    head.value = value;
                    return;
                }
                head=head.next;
            }
            head.next = new Entry(key, value);
            NumberofNodes++;

        }

        int NumberOfTotalNodesinHashMap = NumberofNodes;
        int BucketSize = hashTable.length;
        double LoadingFactor = (double)NumberOfTotalNodesinHashMap / (double) BucketSize;
//        System.out.println("Nodes in Hashmap : "+ NumberOfTotalNodesinHashMap + " BucketSize : " + BucketSize+"Lambda : "+LoadingFactor);
        if(LoadingFactor > ThreshouldRehash){
            Rehash();
        }

    }

    public void Rehash(){
        System.out.println("HIii");
        Entry[]oldhashTable = hashTable;
        hashTable = new Entry[2 * hashTable.length];
        size=0;
        NumberofNodes=0;

        for(Entry Bucket : oldhashTable){

            Entry head = Bucket;

            while (head!=null){

                put((K) head.key, (V) head.value);

                head=head.next;
            }
        }

    }
    public V get(K key){

        int hashCode = (key.hashCode() % TableSize);

        Entry<K, V> head = hashTable[hashCode];

        // Traverse the linked list
        while (head != null) {
            // Use .equals to compare keys
            if (head.key.equals(key)) {
                return head.value;
            }
            head = head.next;
        }
        System.out.println("Value is Not Found in HashMap - Returning Null ");
        return null;
    }

}
