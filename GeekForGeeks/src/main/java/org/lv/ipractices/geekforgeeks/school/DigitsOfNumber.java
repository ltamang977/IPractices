package org.lv.ipractices.geekforgeeks.school;

/**
 * Created by root on 12/25/17.
 */
public class DigitsOfNumber {

    public static void main(String[] args){
        Integer n = 12345;

        String nStr = String.valueOf(n);
        char[] arr = nStr.toCharArray();



        char first = arr[0];
        char second = arr[arr.length-1];


        System.out.println("First char is :"+first + "Second char is :"+second);
    }
}
