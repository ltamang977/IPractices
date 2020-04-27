package org.lv.ipractices.geekforgeeks.string;

import java.util.*;

public class _26_CheckIfFrequencyCanBeSameByOneRemoval {


    public static boolean checkIfCountIsSimilar(Integer[] arr){

        for(int i=0; i<arr.length-1; i++){
            if(arr[i]!=0 && arr[i+1]!=0 && arr[i]!=arr[i+1]){
                return false;
            }
        }

        return true;


    }


    public static boolean checkFrequencySameByOneRemoval(String input){

        Map<Character, Integer> freq = new HashMap<>();

        for(int i=0; i<input.length(); i++){
            freq.put(input.charAt(i), freq.getOrDefault(input.charAt(i),0)+1);
        }

        for(Map.Entry<Character,Integer> entry : freq.entrySet()){

            Character ch = entry.getKey();
            int count = entry.getValue();

            freq.put(ch, count-1);

            Integer[] arr = new Integer[freq.values().size()];
            Integer[] values = freq.values().toArray(arr);

            boolean checkResult = checkIfCountIsSimilar(values);

            if(checkResult){
                return true;

            }else {
                freq.put(ch, count);
            }
        }


        return false;

    }


    public static void main(String[] args){

        //String word = "xyyz";
        String word = "xyyzz";

        boolean checkStatus = checkFrequencySameByOneRemoval(word);

        System.out.println(checkStatus);


    }
}
