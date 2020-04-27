package org.lv.ipractices.revisionaprend.bytebybyte;

public class _14_Palindrome {

    public static boolean isPalindrome(LinkedList.LinkedNode<Integer> head){

        LinkedList.LinkedNode<Integer> slow = head;
        LinkedList.LinkedNode<Integer> fast = head;

        java.util.Stack<Integer> stack = new java.util.Stack<>();

        while(fast!=null && fast.next!=null){
            stack.push(slow.data);
            fast = fast.next.next;
            slow = slow.next;
        }

        if(fast!=null){
            slow= slow.next;
        }

        while(slow!=null){
            if(stack.pop().compareTo(slow.data)!=0){
                return false;
            }
            slow=slow.next;
        }


        return true;

    }

    public static LinkedList.LinkedNode<Integer> reverse(LinkedList.LinkedNode<Integer> head){

        LinkedList.LinkedNode<Integer> curr = head;
        LinkedList.LinkedNode<Integer> prev = null;


        while(curr!=null){
            LinkedList.LinkedNode<Integer> next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;


        return prev;

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

        LinkedList.LinkedNode<Integer> reverseHead = reverse(linkedList.head);
        linkedList.head = reverseHead;


     /*   LinkedList<Integer> notPalindrome = new LinkedList<>(1);
        notPalindrome.insert(2);
        notPalindrome.insert(3);
        notPalindrome.insert(4);
        notPalindrome.insert(5);
        notPalindrome.insert(7);

        System.out.println("Printing palindrome linked list :");
        notPalindrome.print();

        System.out.println("Should be not palindrome"+isPalindrome(notPalindrome.head));*/


        LinkedList<Integer> palindrome = new LinkedList<>(1);
        palindrome.insert(2);
        palindrome.insert(3);
        palindrome.insert(3);
        palindrome.insert(2);
        palindrome.insert(1);
        //palindrome.insert(7);

        System.out.println("Printing palindrome linked list :");
        palindrome.print();

        System.out.println("Should be palindrome"+isPalindrome(palindrome.head));






    }
}
