package org.lv.ipractices.leetcodejune;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class _23_MergeKSortedLists {




    public static ListNode mergeKSortedLists(ListNode[] lists){

        if(lists==null || lists.length==0){
            return  null;
        }


        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        int size = lists.length;
        Queue<ListNode> queue = new PriorityQueue<ListNode>(size,
                                        new Comparator<ListNode>(){
                                                public int compare(ListNode o1, ListNode o2){
                                                    assert o1!=null && o2!=null;

                                                    return o1.val-o2.val; //in ascending order
                                                }
                                        }
                                    );


        for(int i=0; i<size; i++){
            if(lists[i]!=null)
                queue.offer(lists[i]);
        }


        while(!queue.isEmpty()){
            ListNode node = queue.poll();
            curr.next = node;
            curr = curr.next;
            if(node.next!=null){
                queue.offer(node.next);
            }
        }



        return dummy.next;

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
        Input:
[
  1->4->5,
  1->3->4,
  2->6
]
Output: 1->1->2->3->4->4->5->6
         */

        ListNode firstOne = new ListNode(1);
        ListNode firstTwo = new ListNode(4);
        ListNode firstThree = new ListNode(5);
        firstOne.next = firstTwo;
        firstTwo.next = firstThree;


        ListNode secondOne = new ListNode(1);
        ListNode secondTwo = new ListNode(3);
        ListNode secondThree = new ListNode(4);
        secondOne.next = secondTwo;
        secondTwo.next = secondThree;


        ListNode thirdOne = new ListNode(2);
        ListNode thirdTwo = new ListNode(6);
        thirdOne.next = thirdTwo;


        printNodes(firstOne);
        printNodes(secondOne);
        printNodes(thirdOne);

        ListNode sortedList = mergeKSortedLists(new ListNode[]{firstOne, secondOne, thirdOne});

        printNodes(sortedList);


    }
}
