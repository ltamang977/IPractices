package org.lv.ipractices.leetcode.strings;

/**
 * Created by root on 1/24/18.
 */
public class IndexOf {


    public static int indexOf(String hayStack, String needle){

        int length = hayStack.length()-needle.length()+1;

        int i = 0;
        while(i<length){
            int j=0;
            while(j<needle.length()){
                if(hayStack.charAt(i+j)!=needle.charAt(j)){
                    break;
                }
                j++;
            }
            if(j==needle.length()){
                return i;
            }
            i++;
        }
        return -1;
    }

    public static void main(String[] args){
        String hayStack = "hello";
        String needle = "llo";

        int indexOf = indexOf(hayStack,needle);
        System.out.println("Index is :"+indexOf);
    }
}
