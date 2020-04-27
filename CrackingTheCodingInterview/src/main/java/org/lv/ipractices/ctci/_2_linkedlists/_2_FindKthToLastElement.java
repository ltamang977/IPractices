package org.lv.ipractices.ctci._2_linkedlists;

/**
 * Created by root on 12/31/17.
 * correct
 */
public class _2_FindKthToLastElement {


    public static Node findKthElement(LinkedList list, int k){
        Node first = list.getFirst();

        Node n1 = first;
        Node n2 = n1;
        int i=0;
        while(n2.next!=null){
            if(i==k+1)
                break;
            n2=n2.next;
            i=i+1;
        }

        System.out.println("n1 dataa is :"+n1.data);
        System.out.println("n2 data is :"+n2.data);
        //find kth element

        //
        while(n2.next!=null){
            n1 = n1.next;
            n2 = n2.next;
        }
        //n1 is the kth to last element
        //n1.next=n1.next.next;
        //??
        return n1;
    }

    public static void main(String[] args){


        LinkedList list = new LinkedList();
        list.insert(1);
        list.insert(3);
        list.insert(5);
        list.insert(7);
        list.insert(9);
        list.insert(11);
        list.insert(13);

        list.print();

        Node kthToLast = findKthElement(list, 6);
        System.out.println("Kth to last is:"+kthToLast.data);
        list.print();



    }
}
