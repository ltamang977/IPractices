package org.lv.ipractices.revisionaprend.bytebybyte;

public class _2_NthToLastLinkedList {

    public static <T> T  nthToLastLinkedList(LinkedList<T> linkedList, int n){

        LinkedList.LinkedNode<T> head =  linkedList.head; //

        if(head==null){
            return null;
        }

        LinkedList.LinkedNode<T> slow = head;
        LinkedList.LinkedNode<T> fast = head;

        for(int i=0; i<n; i++){
            if(fast==null)
                return null;
            fast = fast.next;
        }

        if(fast==null)
            return null;

        while(fast.next!=null){
            fast = fast.next;
            slow=slow.next;
        }

        return slow.data;

    }


    public static void main(String[] args){

        LinkedList<Integer> linkedList = new LinkedList<>(1);
        linkedList.insert(2);
        linkedList.insert(3);
        linkedList.insert(4);
        linkedList.insert(5);
        linkedList.insert(7);
        System.out.println("Printing linked list :");
        linkedList.print();

        System.out.println("Printing linked list :");
        System.out.println(linkedList.contains(3));
        System.out.println(linkedList.contains(9));

        //linkedList.delete(1);
        //linkedList.delete(2);
        //linkedList.delete(3);
        //linkedList.delete(4);
        //linkedList.delete(5);
        //linkedList.delete(7);


        System.out.println("Printing linked list :");
        linkedList.print();

        System.out.println("nth element from last :"+nthToLastLinkedList(linkedList, 2));



    }
}
