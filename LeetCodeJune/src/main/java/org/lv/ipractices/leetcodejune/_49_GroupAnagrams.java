package org.lv.ipractices.leetcodejune;

import java.util.*;

public class _49_GroupAnagrams {


    public static List<List<String>> groupAnagrams(String[] strs) {

        List<List<String>> resultList = new ArrayList<>();

        Map<String, List>  map = new HashMap<>();


        for(String s : strs){
            char[] ch = s.toCharArray();
            Arrays.sort(ch);

            String st = new String(ch);


            if(!map.containsKey(st)){
                map.put(st, new ArrayList());
            }
            map.get(st).add(s);

        }

        for(List list : map.values()){
            resultList.add(list);

        }

        return resultList;


    }


    public static void main(String[] args){

        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};

        List<List<String>> resultList = groupAnagrams(strs);
        System.out.println(resultList.toString());

    }
}
