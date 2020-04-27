package org.lv.ipractices.geekforgeeks.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _14_GroupWordsWithSameSetOfChars {


    public static String findCharSetKey(String word){
        int[] charSet = new int[26];
        for(int i=0; i<word.length(); i++){
            charSet[word.charAt(i)-'a']++;
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<charSet.length; i++){
            if(charSet[i]>0){
                sb.append((char)(i+'a'));
            }
        }

        return sb.toString();
    }


    public static Map<String, List> groupWordsWithSameChars(String[] input){
        Map<String, List> map = new HashMap<>();

        for(String word : input){

            String key = findCharSetKey(word);

            if(map.containsKey(key)){
                map.get(key).add(word);

            }else{
                List<String> list = new ArrayList<>();
                list.add(word);

                map.put(key, list);
            }
        }

        return map;

    }


    public static void main(String[] args){

        String words[] = { "may", "student", "students", "dog",
                "studentssess", "god", "cat", "act",
                "tab", "bat", "flow", "wolf", "lambs",
                "amy", "yam", "balms", "looped",
                "poodle"};

        Map<String,List> groupedWords = groupWordsWithSameChars(words);

        for(Map.Entry<String,List> entry : groupedWords.entrySet()){
            System.out.println("Key is "+entry.getKey()+"and value is "+entry.getValue().toString());
        }


    }
}
