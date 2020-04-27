package org.lv.ipractices.ctci._1_arraysandstrings;

import java.util.Arrays;

import java.util.Map;
import java.util.HashMap;
/**
 * Created by root on 12/30/17.
 */
public class _3_CheckStringPermutation {

    //usign sorting
    public static boolean checkPermutation1(String s1, String s2){
        char[] ch1 = s1.toCharArray();
        Arrays.sort(ch1);
        String str1 = new String(ch1);


        char[] ch2 = s2.toCharArray();
        Arrays.sort(ch2);
        String str2 = new String(ch2);

        if (str1.equals(str2)) {
            return true;
        }else {
            return false;
        }
    }

    //permutation using character count
    public static boolean checkPermutation2(String s1, String s2){

        if(s1.length()!=s2.length())
            return false;

        Map<Character,Integer> charCountMap1 = new HashMap<>();
        for(char c : s1.toCharArray()){
            Integer count = charCountMap1.get(c);
            if(count==null)
                count = 0;
            charCountMap1.put(c,count+1);
        }

        Map<Character,Integer> charCountMap2 = new HashMap<>();
        for(char c : s2.toCharArray()){
            Integer count = charCountMap2.get(c);
            if(count == null)
                count = 0;
            charCountMap2.put(c, count+1);
        }

        for(char c: s2.toCharArray()){
            if(charCountMap1.get(c) != charCountMap2.get(c)){
                return false;
            }
        }

        return true;

    }

    public static void main(String[] args){

        String s1 = "Labin";
        String s2 = "binLa";
        System.out.println("Permutation check using method 1"+checkPermutation1(s1,s2));

    }
}
