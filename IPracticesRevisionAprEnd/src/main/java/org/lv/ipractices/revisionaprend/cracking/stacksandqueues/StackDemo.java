package org.lv.ipractices.revisionaprend.cracking.stacksandqueues;

import org.lv.ipractices.revisionaprend.cracking.MyStack;

public class StackDemo {


    public static void stackDemo(){

        MyStack<Integer> myStack = new MyStack(10);
        myStack.push(3);
        myStack.push(7);
        myStack.push(9);
        myStack.push(11);

        myStack.pop();
        myStack.pop();
        myStack.pop();
        myStack.pop();
        myStack.pop();

    }


    public static void main(String[] args){
        stackDemo();
    }
}
