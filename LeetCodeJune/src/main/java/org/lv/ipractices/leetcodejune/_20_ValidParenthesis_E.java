package org.lv.ipractices.leetcodejune;

import java.util.ArrayDeque;
import java.util.Deque;

public class _20_ValidParenthesis_E {


    public static boolean isValidParenthesis(String parenthesis){

        Deque<Character> deque = new ArrayDeque<>();

        for(int i=0; i<parenthesis.length(); i++){

            char c = parenthesis.charAt(i);

            if(c=='(' || c=='{'  || c=='[' ){
                deque.addFirst(c);

            }else{

                if(deque.isEmpty()
                        || (c==')' && deque.removeFirst()!='(')
                        || (c=='}' && deque.removeFirst()!='{')
                        || (c==']' && deque.removeFirst()!='[') ){
                    return false;
                }
            }
        }

        if(!deque.isEmpty()){
            return  false;
        }

        return true;
    }

    public static void main(String[] args){

        ListNode head = new ListNode(1);
        head.next= new ListNode(2);
        int n = 1;

        String parenthesis = "]";

        System.out.println(parenthesis+"check is : "+isValidParenthesis(parenthesis));

    }
}
