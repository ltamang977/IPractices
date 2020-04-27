package org.lv.ipractices.ctci._1_arraysandstrings;

/**
 * Created by root on 12/30/17.
 */
public class _2_ReverseString {

    public static String reverse(String input){
        char[] chArr = input.toCharArray();
        int i = 0;
        int j = chArr.length-1;
        while(i<j){
            char temp= chArr[i];
            chArr[i]= chArr[j];
            chArr[j]= temp;
            i++;
            j--;
        }
        return new String(chArr);
    }

    public static void main(String[] args){
        String input = "TAMANG";
        System.out.println(input +" and reverse is :"+reverse(input));
    }
}
