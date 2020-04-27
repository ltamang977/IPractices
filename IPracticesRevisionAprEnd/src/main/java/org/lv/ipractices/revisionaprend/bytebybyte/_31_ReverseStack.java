package org.lv.ipractices.revisionaprend.bytebybyte;

import java.util.Stack;

public class _31_ReverseStack {


    public static Stack<Integer> reverse(Stack<Integer> stack){
        if(stack.isEmpty()){
            return stack;
        }

        int temp = stack.pop();
        reverse(stack);
        insert(stack, temp);

        return stack;
    }


    public static Stack<Integer> insert(Stack<Integer> stack, int x){
        if(stack.isEmpty()){
            stack.push(x);
            return stack;
        }

        int temp = stack.pop();
        insert(stack, x);
        stack.push(temp);

        return stack;
    }


    public static void main(String[] args){

        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println("original stack"+ stack);

        Stack<Integer> reverseStack = reverse(stack);
        System.out.println("Reversed stack"+reverseStack);

    }
}
