package org.lv.ipractices.leetcode.integer;

/**
 * Created by root on 1/21/18.
 */
public class ReverseInteger {

    public static void reverseInteger(int x){
        System.out.println(String.valueOf(x));

        int result = 0;
        while(x!=0){
            int tail = x%10;
            int newResult  = result *10 +tail;
            result = newResult;
            x = x/10;
        }

        System.out.println("Reverse string is :"+result);


    }


    public static void main(String[] args){
        reverseInteger(-120);
    }
}
