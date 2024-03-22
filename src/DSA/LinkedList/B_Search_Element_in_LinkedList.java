package DSA.LinkedList;

import java.util.Scanner;

public class B_Search_Element_in_LinkedList {

    public  static boolean isPresent(ListNode list, int k){

        ListNode temp = list;
        while (temp!=null){
            if(temp.data==k)return true;
            temp=temp.next;
        }

        return false;
    }
    public static void main(String[] args) {

        ListNode list = LinkedList.CreateLinkedList();

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Key to search in LinkedList : ");

        int k = sc.nextInt();

        System.out.println("Is Key Present in LinkedList : "+ isPresent(list, k));

    }
}
