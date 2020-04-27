package org.lv.ipractices.leetcodejune;

import java.util.NoSuchElementException;
import java.util.Stack;

public class _155_MinStack {

    static class MinStack {

        /** initialize your data structure here. */

        Stack valStack;
        Stack minStack;

        public MinStack() {
            valStack = new Stack();
            minStack = new Stack();

        }

        public void push(int x) {
            valStack.push(x);

            if(minStack.isEmpty()){
                minStack.push(x);

            }else{
                if(x<=(int)minStack.peek()){
                    minStack.push(x);
                }

            }

        }

        public void pop() {
            if(valStack.isEmpty())
                throw new NoSuchElementException();

            int val = (int)valStack.pop();
            int min = (int)minStack.peek();

            if(val==min){
                minStack.pop();
            }

        }

        public int top() {
            if(valStack.isEmpty())
                throw new NoSuchElementException();

            return (int)valStack.peek();

        }

        public int getMin() {
            if(minStack.isEmpty())
                throw new NoSuchElementException();

            return (int)minStack.peek();

        }
    }



    public static void main(String[] args){
        MinStack obj = new MinStack();
        obj.push(3);
        obj.push(4);
        obj.push(2);
        obj.push(1);


        obj.pop();
        int top = obj.top();
        int min = obj.getMin();

        System.out.println("top is :"+top);
        System.out.println("min is :"+min);

    }
}
