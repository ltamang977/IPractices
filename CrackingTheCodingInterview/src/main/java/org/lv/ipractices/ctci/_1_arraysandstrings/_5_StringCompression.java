package org.lv.ipractices.ctci._1_arraysandstrings;

/**
 * Created by root on 12/30/17.
 */
public class _5_StringCompression {

    public static String compress(String input){
        char[] chArr = input.toCharArray();

        if(chArr.length==1)
            return input;

        StringBuilder sb = new StringBuilder();
        char ch = chArr[0];
        int count = 1;
        for(int i=1; i<chArr.length; i++ ){
            if(ch!=chArr[i]){
                sb.append(ch);
                sb.append(count);
                ch = chArr[i];
                count = 1;
            } else {
                count++;
            }

        }
        sb.append(ch);
        sb.append(count);

        String compressedStr = sb.toString();

        if(compressedStr.length()<input.length())
            return compressedStr;
        else
            return input;


    }

    public static void main(String[] args){

        String str = "abcaabbccaaabbbcccaaaabbbbcccc";

        System.out.println("Compressed string is :"+compress(str));

    }
}
