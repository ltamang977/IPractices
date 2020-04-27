package org.lv.ipractices.leetcodejune;

import java.util.NoSuchElementException;
import java.util.Stack;

public class _232_ImplementQueueUsingStacks {

    static class MyQueue {

        /** Initialize your data structure here. */

        Stack firstStack;
        Stack secondStack;

        public MyQueue() {
            firstStack = new Stack();
            secondStack = new Stack();


        }

        /** Push element x to the back of queue. */
        public void push(int x) {

            secondStack.push(x);

        }

        /** Removes the element from in front of queue and returns that element. */
        public int pop() {
            if(empty()){
                throw new NoSuchElementException();
            }

            if(firstStack.isEmpty()){
                firstStack.push(secondStack.pop());
            }

            return (int)firstStack.pop();

        }

        /** Get the front element. */
        public int peek() {
            if(empty()){
                throw new NoSuchElementException();
            }

            if(firstStack.isEmpty()){
                firstStack.push(secondStack.pop());
            }

            return (int)firstStack.peek();

        }

        /** Returns whether the queue is empty. */
        public boolean empty() {
            return firstStack.isEmpty() && secondStack.isEmpty();

        }
    }


    public static void main(String[] args){
          MyQueue obj = new MyQueue();
          obj.push(1);
            obj.push(2);
            obj.push(3);
            obj.push(4);
            obj.push(5);
            obj.push(6);

          int param_2 = obj.pop();
          int param_3 = obj.peek();
          boolean param_4 = obj.empty();

        System.out.println(param_2);
        System.out.println(param_3);
        System.out.println(param_4);

    }
}
