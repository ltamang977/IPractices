package org.lv.ipractices.leetcodejune;

import java.util.Arrays;

public class _28_strStr {

    public static int strStrOrIndexOf(String haystack, String needle){

       /* for(int i=0; i<haystick.length()-needle.length()+1; i++){

            if(haystick.substring(i,i+needle.length()).equals(needle)){
                return i;
            }

        }
        return -1;*/

        if(needle.length()==0)
            return 0;

        for(int i =0; i<haystack.length()-needle.length()+1; i++){
            int j=0;
            for(; j<needle.length(); j++){
                if(haystack.charAt(i+j)!=needle.charAt(j)){
                    i=i+j;
                    break;
                }
            }
            if(j==needle.length()){
                return i;
            }
        }
        return -1;

    }

    public static void main(String[] args){

        String hayStick = "a";
        String needle = "a";

        int  startIndex= strStrOrIndexOf( hayStick, needle);
        System.out.println("Index of at : "+startIndex);

    }
}
