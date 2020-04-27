package org.lv.ipractices.leetcodejune;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombination {

    public static void phoneanumber(String input){

        Map<Character, char[]> map = new HashMap<>();
        map.put('2', new char[]{'a','b','c'});
        map.put('3', new char[]{'d','e','f'});
        map.put('4', new char[]{'g','h','i'});
        map.put('5', new char[]{'j','k','l'});
        map.put('6', new char[]{'m','n','o'});
        map.put('7', new char[]{'p','q','r','s'});
        map.put('8', new char[]{'t','u','v'});
        map.put('9', new char[]{'w','x','y', 'z'});

        char[] chArr = new char[input.length()];
        List<String> resultList = new ArrayList<>();

        helper(0, input, chArr, resultList, map);

        System.out.println(resultList.toString());


    }


    public static void helper(int depth, String input, char[] chArr, List<String> resultList, Map<Character, char[]> map){

        if(depth==input.length()){
            resultList.add(new String(chArr));
            return;
        }

        char digit = input.charAt(depth);
        char[] chars = map.get(digit);
        for(char c : chars){
            chArr[depth]=c;
            helper(depth+1, input, chArr, resultList, map);
        }
    }


    public static void main(String[] args){
        String input = "23";
        phoneanumber( input);
    }
}
