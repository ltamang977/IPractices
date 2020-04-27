package org.lv.ipractices.leetcode.strings;


import java.util.List;

/**
 * Created by root on 1/23/18.
 */
public class LetterCombinationOfPhoneNumber {


    public static void letterCombination(String digits, String[] map){

    }


    public void combination(String s, String[] temp, List<String> resultList){

        for(char c: s.toCharArray()){
            for(String ss: temp){
                resultList.add(c+ss);
            }
        }

    }


    public static void main(String[] args){

        String[] map = {"","","abc", "def", "ghi"};
        String digits = "23";

        letterCombination(digits,map);

    }
}
