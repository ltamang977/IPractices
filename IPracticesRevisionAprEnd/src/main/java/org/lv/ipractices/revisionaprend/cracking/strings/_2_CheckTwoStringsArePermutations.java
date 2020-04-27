package org.lv.ipractices.revisionaprend.cracking.strings;

import java.util.Arrays;

public class _2_CheckTwoStringsArePermutations {


    public static boolean checkPermutationCharCount(String str1, String str2){

        if(str1.length()!=str2.length())
            return false;

        int[] count = new int[256];

        for(int i=0; i<str1.length(); i++){
            char c = str1.charAt(i);
            count[c]++;
        }

        for(int i=0; i<str2.length(); i++){
            char c = str2.charAt(i);
            if(--count[c]<0){
                return false;
            }
        }

        return true;
    }


    public static boolean checkPermutationSorting(String str1, String str2){

        if(str1.length()!=str2.length())
            return false;

        char[] ch1 = str1.toCharArray();
        char[] ch2 = str2.toCharArray();

        Arrays.sort(ch1);
        Arrays.sort(ch2);

        for(int i=0; i<ch1.length; i++){
            if(ch1[i]!=ch2[i]){
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args){

        String s1 = "labin";
        String s2 = "laabi";

        //System.out.println("Checking permutatiion :"+checkPermutationCharCount(s1, s1));

        System.out.println("Checking permutatiion sorting :"+checkPermutationSorting(s1, s2));
    }


}
