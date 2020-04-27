package org.lv.ipractices.revisionaprend.bytebybyte;

public class _5_MaxStack {


    public static void maxStack(){
        MyStack<Integer> myStack = new MyStack(10);
        myStack.push(3);
        myStack.push(7);
        myStack.push(9);
        System.out.println("Max is :"+ myStack.max());
        myStack.push(11);

        myStack.push(5);
        System.out.println("Max is :"+ myStack.max());
        myStack.print();
        myStack.pop();
        myStack.push(13);

        System.out.println("Max is :"+ myStack.max());
    }


    public static void main(String[] args){
        maxStack();
    }
}
