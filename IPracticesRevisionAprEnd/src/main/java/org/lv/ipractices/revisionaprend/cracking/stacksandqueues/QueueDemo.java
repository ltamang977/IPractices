package org.lv.ipractices.revisionaprend.cracking.stacksandqueues;

import org.lv.ipractices.revisionaprend.cracking.MyQueue;

public class QueueDemo {

    public static void main(String[] args){

        MyQueue<Integer> queue = new MyQueue<>(5);
        queue.add(6);
        queue.add(7);
        queue.add(8);
        queue.add(9);
        queue.add(10);

        queue.remove();
        queue.remove();
        queue.remove();
        queue.remove();
        queue.remove();
        queue.remove();


    }
}
