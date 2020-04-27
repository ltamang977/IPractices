package org.lv.ipractices.ctci._2_linkedlists;

import java.util.Set;
import java.util.HashSet;

/**
 * Created by root on 12/30/17.
 * all correct solutions
 */
public class _1_RemoveDuplicates {//linked list

    //uses additional buffer hashset
    public static void removeDuplicateCtci(Node first){
        Set<Integer> set = new HashSet<Integer>();

        Node current = first;
        Node previous = null;

        while(current!=null){
            if(set.contains(current.data)){
                previous.next = current.next;
            }else {
                set.add(current.data);
                previous= current;
            }
            current = current.next;

        }

    }

    public static void removeDuplicatesCtciInPlace(Node first){

        Node current = first;
        while(current!=null){
            Node runner=current;
            while(runner.next!=null){
                if(runner.next.data == current.data){
                    runner.next = runner.next.next;
                }else {
                    runner = runner.next;
                }
            }

            current=current.next;
        }

    }

    //my method
    public static void removeDuplicates(LinkedList list){

        Node current = list.first;
        while(current!=null){
            removeDuplicate(current);
            current = current.next;
        }

    }

    public static void removeDuplicate(Node i){

        Node previous = i;
        Node j = i.next;

        while(j!=null){
            if(j.data==i.data){//duplicate found
                previous.next = j.next;
            }
            previous = j;
            j = j.next;
        }
    }


    //uses additional buffer hashset
    //added in feb 17
    public static Node removeDuplicateRecent(Node first){
        Set<Integer> set = new HashSet<Integer>();

        Node current = first;
        set.add(current.data);
        while(current.next!=null){
            if(set.contains(current.next.data)){
                current.next = current.next.next;
            }else {
                set.add(current.next.data);
                current = current.next;
            }

        }
        return first;

    }



    public static void main(String[] args){

        LinkedList list = new LinkedList();
        list.insert(1);
        list.insert(3);
        list.insert(5);
        list.print();

        list.insert(3);
        list.insert(5);
        list.print();

       // removeDuplicateCtci(list.getFirst());
        //removeDuplicates(list);
        //removeDuplicatesCtciInPlace(list.getFirst());
        //removeDuplicateRecent
       // Node result =
                removeDuplicateRecent(list.getFirst());
        list.print();

    }
}
