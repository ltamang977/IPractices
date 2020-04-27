package org.lv.ipractices.geekforgeeks.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _26_CountWordsAppearingExactlyTwice {



    public static List<String> groupWordsWithSameChars(String[] input){
        Map<String, Integer> map = new HashMap<>();

        for(String word : input){
            map.put(word,map.getOrDefault(word,0)+1);
        }

        List<String> wordList = new ArrayList<>();
        for(Map.Entry<String,Integer> entry : map.entrySet()){
            if(entry.getValue()==2){
                wordList.add(entry.getKey());
            }
        }


        //map.values();

        return wordList;

    }


    public static void main(String[] args){

        String words[] = {"hate", "love", "peace", "love",
                "peace", "hate", "love", "peace",
                "love", "peace"};

        List<String> groupedWords = groupWordsWithSameChars(words);

        System.out.println(groupedWords.toString());


    }
}
