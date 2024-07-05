package LeetCode.POTD;

import DSA.LinkedList.LinkedList;
import DSA.LinkedList.ListNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class O__Minimum_Maximum_DistanceinCriticals {

    public static int[] Distance(ListNode head){

        int[]ans = {Integer.MAX_VALUE, -1};

        ListNode temp1=head;
        ListNode temp2 = head.next;
        int cnt = 2;
        int start = -1;
        int newtar = -1;
        while (temp1!=null && temp2!=null && temp2.next!=null){

            ListNode temp3 = temp2.next;
            if(temp2.data > temp3.data && temp2.data > temp1.data) {
                if (start == -1) {
                    start = cnt;
                    newtar = cnt;

                } else {
                    ans[0] = Math.min(ans[0], cnt - newtar);
                    ans[1] = cnt - start;
                    newtar = cnt;

                }
            }
               else if(temp2.data < temp3.data && temp2.data < temp1.data){
                   if(start==-1){
                       start=cnt;
                       newtar=cnt;

                   }
                   else {
                       ans[0]=Math.min(ans[0] , cnt-newtar);
                       ans[1] = cnt - start;
                       newtar=cnt;

                   }
               }
//            System.out.println(temp2.data+" " + start+" "+ newtar+" "+ cnt);
               temp1=temp1.next;
               cnt++;
               temp2=temp2.next;

            }

        if(ans[0]==Integer.MAX_VALUE)ans[0]=-1;
return ans;

        }

    public static void main(String[] args) {

        ListNode list = LinkedList.CreateLinkedList();
        System.out.println(Arrays.toString(Distance(list)));
    }
}
