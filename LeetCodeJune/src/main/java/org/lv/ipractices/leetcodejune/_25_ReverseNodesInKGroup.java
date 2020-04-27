package org.lv.ipractices.leetcodejune;

public class _25_ReverseNodesInKGroup {



    public static ListNode reverseNodes(ListNode node){

        ListNode prev = null;
        ListNode curr = node;

        while(curr!=null){

            ListNode next = curr.next;
            curr.next = prev;
            prev=curr;
            curr = next;

        }


        return prev;

    }


    public static ListNode reverseNodesInKGroup(ListNode head, int k){


        ListNode dummy = new ListNode(0);
        ListNode prev = dummy;

        ListNode curr = head;

        while(curr!=null){

            ListNode slow = curr;
            ListNode fast = slow;

            int i=1;
            for(;i<k; i++){
                if(curr==null)
                    break;
                curr = curr.next;
            }

            if(i==k && curr!=null){//k nodes present
                ListNode next = curr.next;
                fast = curr;
                fast.next = null;
                ListNode reverseHead = reverseNodes(slow);
                prev.next = reverseHead;
                prev = slow;
                curr = next;

            }else{//less than k nodes
                prev.next = slow;
                break;
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

        ListNode head = new ListNode(1);

        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);
        ListNode four = new ListNode(4);
        ListNode five = new ListNode(5);
        ListNode six = new ListNode(6);
        ListNode seven = new ListNode(7);
        ListNode eight = new ListNode(8);

        head.next = two;
        two.next = three;
        three.next = four;
        four.next = five;
        five.next = six;
        six.next = seven;
        seven.next = eight;


        printNodes(head);

        //ListNode reverseHead = reverseNodes( head);
        ListNode reverseHead = reverseNodesInKGroup( head,  3);
        printNodes(reverseHead);


    }
}
