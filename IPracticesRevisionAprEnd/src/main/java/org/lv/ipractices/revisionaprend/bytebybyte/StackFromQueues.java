package org.lv.ipractices.revisionaprend.bytebybyte;

import java.util.ArrayDeque;
import java.util.Deque;

public class StackFromQueues {

    Deque<Integer> primary = new ArrayDeque<>();
    Deque<Integer> secondary = new ArrayDeque<>();



    public void push(int data){
        //push in secodnary
        secondary.addLast(data);
        while(!primary.isEmpty()){
            secondary.addLast(primary.removeFirst());
        }

        Deque<Integer> temp = primary;
        primary = secondary;
        secondary = primary;

    }


    public int pop(){

        if(primary.isEmpty()){
            throw  new ArrayIndexOutOfBoundsException();
        }

        return primary.removeFirst();

    }



}
