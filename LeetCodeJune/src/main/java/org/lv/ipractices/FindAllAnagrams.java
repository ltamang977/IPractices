package org.lv.ipractices;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindAllAnagrams {

    public List<Integer> findAnagrams(String s, String p) {

        List<Integer> result = new ArrayList<>();

        if(s==null || p==null){
            return result;
        }

        Map<Character,Integer> map = new HashMap<>();
        for(char c : p.toCharArray()){
            map.put(c, map.getOrDefault(c, 0)+1);
            //dual purpose when
            //1. all the chars in p
            //2. count of characters
        }

        int start = 0;
        int counter = map.size();
        for(int i = 0; i<s.length(); i++){

            char c = s.charAt(i);
            if(map.containsKey(c)){//chars in p ,, matching deducting
                map.put(c, map.get(c)-1);
                if(map.get(c)==0)
                    counter--;//chars matched in window

            }

            // a-1
            // b-1

            while(counter==0){
                //all chars matched with all number of chars in p

                if(i-start+1==p.length()){
                    result.add(start);
                }

                char t = s.charAt(start);
                if(map.containsKey(t)){
                    map.put(t, map.get(t)+1);
                    if(map.get(t)==1)
                        counter++;//chars matched in window
                }


                start++;


            }

        }


        return result;


    }


    public static void main(String[] args){

        String s = "cbaebabacd";
        String p = "abc";

        FindAllAnagrams sol = new FindAllAnagrams();
        List<Integer> list = sol.findAnagrams(s, p);
        System.out.println(list.toString());


    }
}
