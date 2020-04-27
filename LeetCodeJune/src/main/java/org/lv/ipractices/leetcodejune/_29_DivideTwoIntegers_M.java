package org.lv.ipractices.leetcodejune;

import java.util.Arrays;

public class _29_DivideTwoIntegers_M {

    public static int divide(int dividend, int divisor){

        if(divisor==-1 && dividend == Integer.MIN_VALUE)
            return Integer.MAX_VALUE;

        int sign = ((dividend < 0) ^ (divisor < 0)) ? -1 : 1;

        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);

        int div = 0;
        while(dividend>=divisor){
            int temp = dividend-divisor;
            if(temp+divisor!=dividend){
                return sign * Integer.MAX_VALUE;
            }
            dividend=temp;
            div++;
        }

        return sign * div;

    }


    public static void main(String[] args){

        int dividend = 10;
        int divisor = -3;

        int result = divide( dividend, divisor );
        System.out.println("Divide result is :"+result);

    }
}
