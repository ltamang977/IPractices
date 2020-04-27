package org.lv.ipractices.leetcodejune;

import java.util.Arrays;
import java.util.List;

public class _151_ReverseWordsInAString {


    /**
     * problem #151
     * @param s
     * @return
     */
    public static String reverseWords(String s) {


        if(s==null || s.isEmpty()){
            return s;
        }

        String[] strs = s.split("\\s+");

        StringBuilder sb = new StringBuilder();
        for(int i = strs.length-1; i>=0; i--){
            sb.append(strs[i]).append(" ");

        }

        return sb.toString().trim();

    }

    /**
     * problem #557
     * @param s
     * @return
     */
    public static String reverseWordsIII(String s) {


        if(s==null || s.isEmpty()){
            return s;
        }

        char[] chArr = s.toCharArray();

        int i = 0;
        for(int j =0; j<s.length(); j++){
            if(chArr[j]==' '){
                reverseChars(chArr, i, j-1);
                i=j+1;
            }
        }
        reverseChars(chArr, i, s.length()-1);

        return new String(chArr);

    }

    /**
     * #344 reverse string
     * @param chArr
     * @param i
     * @param j
     */
    public static void reverseChars(char[] chArr, int i, int j){
        int start = i;
        int end = j;
        while(start<end){
            char temp = chArr[start];
            chArr[start]=chArr[end];
            chArr[end]=temp;
            start++;
            end--;
        }

    }

    /**
     * problem #541
     * @param s
     * @return
     */
    public static String reverseWordsII(String s) {


        if(s==null || s.isEmpty()){
            return s;
        }

        char[] chArr = s.toCharArray();

        int i = 0;
        for(int j =0; j<s.length(); j++){
            if(chArr[j]==' '){
                reverseChars(chArr, i, j-1);
                i=j+1;
            }
        }
        reverseChars(chArr, i, s.length()-1);

        reverseChars(chArr, 0, s.length()-1);

        return new String(chArr);

    }


    public static String reverseStr(String s, int k) {

        if(s==null || s.isEmpty())
            return s;

        //s = "abcdefg", k = 2
        char[] chArr = s.toCharArray();
        int start = 0;
        while(start+2*k-1<s.length()){
            reverseChars(chArr, start, start+k-1);
            start+=2*k;
        }

        if(start+k-1<s.length()){
            reverseChars(chArr, start, start+k-1);
        }else{
            reverseChars(chArr, start, s.length()-1);
        }

        return new String(chArr);

    }


    /**
     * #345. Reverse Vowels of a String
     * @param s
     * @return
     */
    public static String reverseVowels(String s) {

        if(s==null || s.isEmpty())
            return s;


        char[] chArr = s.toCharArray();

        List<Character> vowels = Arrays.asList('a','e','i','o','u', 'A','E','I','O','U');

        int start = 0;
        int end = s.length()-1;

        while(start<end){

            while(start<end && !vowels.contains(chArr[start])){
                start++;
            }

            while(start<end && !vowels.contains(chArr[end])){
                end--;
            }

            if(start>=end){
                break;
            }
            swap(chArr,  start,  end);
            start++;
            end--;
        }

        return new String(chArr);

    }



    public static void swap(char[] chArr, int i, int j){
        char temp = chArr[i];
        chArr[i]= chArr[j];
        chArr[j]=temp;
    }


    public static void main(String[] args){

        String input = "the sky is blue";
        //String reverse = reverseWords(input);
        //String reverseIII = reverseWordsIII(input);
       // String reverseWordsII = reverseWordsII(input);
        //reverseWordsII
        //"Let's take LeetCode contest"
        //reverseWordsIII

       // String reverse = reverseStr("abcdefg", 2);
        String s = "leetcode";
        String reversedVowels = reverseVowels(s);

        System.out.println("Reversed string is :"+reversedVowels);

    }
}
