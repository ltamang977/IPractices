package org.lv.ipractices.ctci._2_linkedlists;

/**
 * Created by root on 12/31/17.
 * correct
 */
public class _4_PartitionLinkedList {

    public static LinkedList partition(Node first, int x){

        LinkedList beforeList = null;
        LinkedList afterList = null;


        Node current = first;
        while(current!=null){

            Node n = current;
            //n.next = null;

            if(n.data<x){
                //append to lessList
                if(beforeList==null){
                    beforeList = new LinkedList(n);
                }else {
                    beforeList.insert(n.data);
                }
            }else{
                //append to x list
                if(afterList==null){
                    afterList = new LinkedList(n);
                }else {
                    afterList.insert(n.data);
                }
            }

            current = current.next;

        }

        if(beforeList!=null) {
            beforeList.append(afterList.getFirst());
            return beforeList;
        }else {
            return afterList;

        }

    }

    public static void main(String[] args){

        LinkedList list = new LinkedList();

        list.insert(9);
        list.insert(11);
        list.insert(13);
        list.insert(1);
        list.insert(3);
        list.insert(5);
        list.insert(7);

        list.print();

        LinkedList partitionedList = partition(list.first, 5);
        partitionedList.print();

    }
}
