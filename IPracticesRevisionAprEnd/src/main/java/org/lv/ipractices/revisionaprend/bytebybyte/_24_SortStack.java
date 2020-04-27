package org.lv.ipractices.revisionaprend.bytebybyte;

import java.util.Stack;

public class _24_SortStack {



    public static Stack<Integer> sortStack(Stack<Integer> orgMyStack){

        Stack<Integer> resultMyStack = new Stack<>();

        while(!orgMyStack.isEmpty()){

            Integer val = orgMyStack.pop();

            while(!resultMyStack.isEmpty() && resultMyStack.peek()<val){
                orgMyStack.push(resultMyStack.pop());
            }
            resultMyStack.push(val);


        }


        return resultMyStack;

    }


    public static void main(String[] args){

        Stack<Integer> myStack = new Stack<Integer>();
        myStack.push(4);
        myStack.push(2);
        myStack.push(3);
        myStack.push(1);

        Stack<Integer> resultMyStack = sortStack(myStack);
        while(!resultMyStack.isEmpty()){
            System.out.println(resultMyStack.pop());
        }


    }
}
