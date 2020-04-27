package org.lv.ipractices.leetcodejune;

import java.util.*;

public class _451_SortCharactersByFrequency {

    public static String frequencySort(String s) {

        if(s==null || s.isEmpty())
            return s;


        Map<Character,Integer> freqMap = new HashMap<>();

        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);

            freqMap.put(c, freqMap.getOrDefault(c, 0)+1);
        }

        List<Character> list = new ArrayList<>(freqMap.keySet());

        Collections.sort(list, (w1, w2)->freqMap.get(w2).compareTo(freqMap.get(w1)));

        StringBuilder sb = new StringBuilder();
        for(Character c : list){
            int count = freqMap.get(c);
            for(int i=0; i<count; i++) {
                sb.append(c);
            }
        }

        return sb.toString();

    }

    public static void main(String[] args){

        String s = "Aabb";
        String sortedChars = frequencySort(s);

        System.out.println("Sorted string is :"+sortedChars);

    }
}
