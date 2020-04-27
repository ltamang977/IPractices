package org.lv.ipractices.leetcodejune;

import java.util.Arrays;

public class _2_AddTwoNumbersInLInkedList_E {

    static  class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        int carry = 0;
        ListNode resultDummyHead = new ListNode(0);
        ListNode curr = resultDummyHead;

        ListNode l1Curr = l1;
        ListNode l2Curr = l2;


        while(l1Curr!=null || l2Curr!=null){
            int l1Val = (l1Curr!=null)?l1Curr.val:0;
            int l2Val = (l2Curr!=null)?l2Curr.val:0;
            int sum = l1Val+l2Val+carry;

            curr.next = new ListNode(sum%10);
            curr = curr.next;

            carry = sum/10;

            if(l1Curr!=null){
                l1Curr=l1Curr.next;
            }

            if(l2Curr!=null){
                l2Curr=l2Curr.next;
            }

        }

        if(carry!=0){
            curr.next = new ListNode(carry);
            curr = curr.next;
        }

        return resultDummyHead.next;



    }


    public static void main(String[] args){

        ListNode list1 = new ListNode(2);
        list1.next = new ListNode(4);
        list1.next.next = new ListNode(3);

        ListNode list2 = new ListNode(5);
        list2.next = new ListNode(6);
        list2.next.next = new ListNode(4);

        _2_AddTwoNumbersInLInkedList_E sol = new _2_AddTwoNumbersInLInkedList_E();

        ListNode result = sol.addTwoNumbers(list1, list2);

        ListNode resultCurr = result;
        while(resultCurr!=null){
            System.out.println(resultCurr.val);
            resultCurr = resultCurr.next;
        }

    }

}
