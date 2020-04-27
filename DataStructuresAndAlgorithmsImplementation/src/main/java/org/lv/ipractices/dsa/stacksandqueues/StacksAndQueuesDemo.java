package org.lv.ipractices.dsa.stacksandqueues;

public class StacksAndQueuesDemo {

    public static void queuesFromNodesDemo(){
        QueueFromNodes<Integer> queue = new QueueFromNodes<>();
        queue.enqueue(1);
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.dequeue();
        queue.enqueue(4);
        queue.enqueue(5);

        System.out.println("Queue content is :"+queue.toString());
    }

    public static void stackFromNodesDemo(){
        StackFromNodes<Integer> stack = new StackFromNodes<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(3);
        System.out.println(stack.pop());
        stack.push(4);
        stack.push(5);

        System.out.println("Queue content is :"+stack.toString());
    }


    public static void stackFromArrayDemo(){
        StackFromArray<Integer> stack = new StackFromArray<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(3);
        System.out.println(stack.pop());
        stack.push(4);
        stack.push(5);

        System.out.println("Size is :"+stack.size());
        System.out.println("Queue content is :"+stack.toString());
    }



    public static void queuesFromArrayDemo(){
        QueueFromArray<Integer> queue = new QueueFromArray<>();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(3);
        System.out.println(queue.dequeue());
        queue.enqueue(4);
        queue.enqueue(5);
        queue.enqueue(6);

        System.out.println("Size is :"+queue.size());
        System.out.println("Queue content is :"+queue.toString());
    }

    //StackFromNodes

    public static void main(String[] args){

        //queuesFromNodesDemo();
        //stackFromNodesDemo();
        //stackFromArrayDemo();
        queuesFromArrayDemo();


    }
}
