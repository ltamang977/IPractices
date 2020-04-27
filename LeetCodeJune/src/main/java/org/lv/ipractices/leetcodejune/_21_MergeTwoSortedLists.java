package org.lv.ipractices.leetcodejune;

public class _21_MergeTwoSortedLists {


    public static ListNode mergeTwoSortedLists(ListNode l1, ListNode l2){


        ListNode dummyHead = new ListNode(0);
        ListNode curr = dummyHead;

        while(l1!=null || l2!=null){

            if(l2==null){
                ListNode next = l1.next;
                l1.next = null;
                curr.next = l1;
                l1=next;

            } else if(l1==null){
                ListNode next = l2.next;
                l2.next = null;
                curr.next = l2;
                l2=next;

            }else {
                if(l1.val<=l2.val){
                    ListNode next = l1.next;
                    l1.next = null;
                    curr.next = l1;
                    l1=next;
                }else{

                    ListNode next = l2.next;
                    l2.next = null;
                    curr.next = l2;
                    l2=next;

                }
            }
            curr = curr.next;

        }

        return dummyHead.next;

    }

    public static void printNodes(ListNode head){
        ListNode curr = head;

        System.out.println("Printting list");
        while(curr!=null){
            System.out.println("->"+curr.val);
            curr = curr.next;
        }
    }

    public static void main(String[] args){

          /*
            Input: 1->2->4, 1->3->4
            Output: 1->1->2->3->4->4
        */

        ListNode l1 = new ListNode(1);
        ListNode l1Two = new ListNode(2);
        ListNode l1Four = new ListNode(4);
        l1.next = l1Two;
        l1Two.next = l1Four;


        ListNode l2 = new ListNode(1);
        ListNode l2Three = new ListNode(3);
        ListNode l2Four = new ListNode(4);
        l2.next=l2Three;
        l2Three.next=l2Four;

        ListNode mergedListHead = mergeTwoSortedLists( l1,  l2);
        printNodes(mergedListHead);

    }

}
