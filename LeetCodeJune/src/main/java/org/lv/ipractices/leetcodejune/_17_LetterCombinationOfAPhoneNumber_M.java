package org.lv.ipractices.leetcodejune;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _17_LetterCombinationOfAPhoneNumber_M {


    public static List<String> letterCombinations(String digits) {

        List<String> resultList = new ArrayList<>();

        if(digits==null || digits.isEmpty()){
            return resultList;
        }

        HashMap<Character, char[]> dict = new HashMap<Character, char[]>();
        dict.put('2',new char[]{'a','b','c'});
        dict.put('3',new char[]{'d','e','f'});
        dict.put('4',new char[]{'g','h','i'});
        dict.put('5',new char[]{'j','k','l'});
        dict.put('6',new char[]{'m','n','o'});
        dict.put('7',new char[]{'p','q','r','s'});
        dict.put('8',new char[]{'t','u','v'});
        dict.put('9',new char[]{'w','x','y','z'});



        char[] arr = new char[digits.length()];

        helper(resultList,  digits, 0,  arr, dict);

        return  resultList;

    }


    public static void helper(List<String> resultList, String digits, int index, char[] arr, Map<Character,char[]> map){

        if(index == digits.length()){
            resultList.add(new String(arr));
            return;
        }

        char[] chars = map.get(digits.charAt(index));
        for(char c : chars){
            arr[index]=c;
            helper(resultList, digits, index+1, arr, map);
            //tempList.remove(tempList.size()-1);
        }



    }


    public static void main(String[] args){

        List<String> resultList = letterCombinations( "234");
        resultList.stream().forEach(System.out :: println);

    }
}
