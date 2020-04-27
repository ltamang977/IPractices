package org.lv.ipractices.leetcodejune;

import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Queue;

public class _225_ImplementStackUsingQueues {


    static class MyStack {

        Queue pushQueue;
        Queue popQueue;

        /** Initialize your data structure here. */
        public MyStack() {
            pushQueue = new LinkedList();
            popQueue = new LinkedList();

        }

        /** Push element x onto stack. */
        public void push(int x) {
            pushQueue.offer(x);
            while(!popQueue.isEmpty()){
                pushQueue.offer(popQueue.poll());
            }
            Queue tempQueue=popQueue;
            popQueue=pushQueue;
            pushQueue=tempQueue;

        }

        /** Removes the element on top of the stack and returns that element. */
        public int pop() {
            if(popQueue.isEmpty())
                throw new NoSuchElementException();

            return (int)popQueue.poll();

        }

        /** Get the top element. */
        public int top() {
            if(popQueue.isEmpty())
                throw new NoSuchElementException();

            return (int)popQueue.peek();

        }

        /** Returns whether the stack is empty. */
        public boolean empty() {
            return popQueue.isEmpty();
        }
    }
}
