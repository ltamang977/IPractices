package org.lv.ipractices.hackerrank.stacks;

import java.io.*;
        import java.util.*;
        import java.text.*;
        import java.math.*;
        import java.util.regex.*;

public class EqualStacks {

    public static void main(String[] args) {

        int[] h1 = {3, 2, 1, 1, 1};
        int[] h2 = {4,3,2};
        int[] h3 = { 1, 1, 4, 1};

        Deque<Integer> deque1 = new ArrayDeque<>();
        for(int h1_i=0; h1_i < h1.length; h1_i++){
            deque1.addFirst(h1[h1_i]);
        }
        Deque<Integer> deque2 = new ArrayDeque<>();
        for(int h1_i=0; h1_i < h2.length; h1_i++){
            deque2.addFirst(h2[h1_i]);
        }
        Deque<Integer> deque3 = new ArrayDeque<>();
        for(int h1_i=0; h1_i < h3.length; h1_i++){
            deque3.addFirst(h3[h1_i]);
        }

        int sum1=deque1.stream().mapToInt(i->i).sum();
        int sum2=deque2.stream().mapToInt(i->i).sum();
        int sum3=deque3.stream().mapToInt(i->i).sum();

        while(sum1!=sum2 && sum2!=sum3 && sum1!=sum3){

            if( deque1.isEmpty() || deque2.isEmpty() || deque3.isEmpty()){//equal heights
                break;
            }

            if(sum1>sum2 && sum1>sum3){
                Integer removeEle = deque1.removeFirst();
                sum1 = sum1 - removeEle;

            }else if(sum2>sum1 && sum2>sum3){
                System.out.println();
                Integer removeEle = deque2.removeFirst();
                sum2 = sum2 - removeEle;

            }else if(sum3>sum1 && sum3>sum2){
                Integer removeEle = deque3.removeFirst();
                sum3 = sum3 - removeEle;
            }

        }

        if(sum1==sum2 && sum2==sum3 && sum1==sum3){
            System.out.println(sum1);
        }else{
            System.out.println(-1);
        }
    }
}

