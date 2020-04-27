package org.lv.ipractices.ctci._2_linkedlists;

/**
 * Created by root on 12/31/17.
 * correct solution
 */
public class _3_DeleteGivenNode {

    public static boolean delete(Node n){
        if(n==null|| n.next==null)
            return false;

        Node next = n;
        n.data = next.data;
        n.next=next.next;
        return true;
    }


}
