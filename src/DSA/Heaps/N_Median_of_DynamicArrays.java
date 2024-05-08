package DSA.Heaps;
import java.util.PriorityQueue;

/**
 *
 * Concept :- Finding the Median of Dyanmicially Changing Array.
 *
 * Approches :-
 *     1. Brute Force :- In every query sort the array and then return the Middle element.
 *                TC - O(Q * NlogN) ~ O(N*N*logN)
 *                SC - O(1)
 *
 *
 *     2. Priority Queue Approch :-
 *        Hmm jante h ki median middle hota h bakaki ko 2 parts mai break karta h , too hmm 2-halves ko min and max priority
 *        queue mai add kr skakte h and maxHeap ka first and minHeap ka first element /2 ans hoga , matlab even /odd dekh lena
 *
 *        AddNum -
 *        To hoga kya agar meri maxHeap khali h ya fir , aane wala element maxHeap ke top element se bda h to minHeap me push kr denge
 *        nhi to maxHeap mai
 *        and size >= 2 hui to idhar - odhar krke elements se size ko balance kr denge , kyuki hme halves mai krna h na break bas
 *        odd elements ke case mai kisi ek mai jada hoga element.
 *
 *        FindMedian-
 *        ye to simple hi h total elements ke odd/even ke hisab se bas return krna h.
 *
 *        Best Example to dry run is :-  [5,2,3,1,6,4]
 *
 *
 *        TC - O(NlogN)  --> haar ek number par logN ka kaam hota h (add hone mai , aur agar kabhi size jada ho jaye to top element extract krne mai)
 *        SC - O(N)
 *
 * **/


class MedianFinder {

    PriorityQueue<Integer>maxHeap;
    PriorityQueue<Integer>minHeap;
    public MedianFinder() {

        maxHeap = new PriorityQueue<>((a, b)->b-a);
        minHeap = new PriorityQueue<>((a, b)->a-b);
    }
    public void addNum(int num) {

        if(maxHeap.isEmpty()==true || maxHeap.peek() >= num) maxHeap.add(num);
        else minHeap.add(num);

        if(maxHeap.size() > minHeap.size()+1){
            minHeap.add(maxHeap.poll());
        }

        else if(minHeap.size() > maxHeap.size()+1){
            maxHeap.add(minHeap.poll());
        }

    }

    public double findMedian() {

        if(minHeap.size()==maxHeap.size())return ((double) maxHeap.peek() +(double) minHeap.peek())/2.0;
        else{
            if(minHeap.size() < maxHeap.size())return(double) maxHeap.peek();
            else return (double) minHeap.peek();
        }

    }
}
public class N_Median_of_DynamicArrays{

    public static void main(String[] args) {

        MedianFinder obj1 = new MedianFinder();
        obj1.addNum(5);
        System.out.println(obj1.findMedian());
        System.out.println(obj1.maxHeap +" "+ obj1.minHeap);
        obj1.addNum(1);
        System.out.println(obj1.findMedian());
        System.out.println(obj1.maxHeap +" "+ obj1.minHeap);
        obj1.addNum(2);
        System.out.println(obj1.findMedian());
        System.out.println(obj1.maxHeap +" "+ obj1.minHeap);
        obj1.addNum(6);
        System.out.println(obj1.findMedian());
        System.out.println(obj1.maxHeap +" "+ obj1.minHeap);
        obj1.addNum(3);
        System.out.println(obj1.findMedian());
        System.out.println(obj1.maxHeap +" "+ obj1.minHeap);
        obj1.addNum(4);
        System.out.println(obj1.findMedian());
        System.out.println(obj1.maxHeap +" "+ obj1.minHeap);
    }
}
