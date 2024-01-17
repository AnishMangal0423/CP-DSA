import java.util.*;

 class Node{

    int data;
    Node next;

    Node(int d){
        data=d;
        next=null;
    }
}


public class LinkedList {

     Node head=null;
     Node tail=null;

     void insert(int data){

         Node newNode=new Node(data);
         if(head==null){
             head=newNode;
             tail=newNode;
         }

         else{
             tail.next=newNode;
             tail=tail.next;
         }
     }

     void display(){

         Node temp=head;

         while(temp!=tail.next){

             System.out.print(temp.data+" --> ");
             temp=temp.next;
         }

         System.out.println(" ");
     }

    public static void main(String[] args) {

         LinkedList ls=new LinkedList();

         ls.insert(10);
        ls.insert(20);
        ls.insert(30);
        ls.insert(40);
        ls.insert(50);
        ls.display();
    }

}


