package org.lv.ipractices.geekforgeeks.array.searchingandsorting;

import java.util.*;

public class _13_SortElementsByFrequency {

    public void sortByFrequency(int[] arr){

        Map<Integer, Integer> keyToFreqMap = new LinkedHashMap<Integer, Integer>();
        for(Integer key: arr){
            keyToFreqMap.put(key, keyToFreqMap.getOrDefault(key,0)+1);

        }

        Map<Integer, List<Integer>> valueToKeyListMap = new HashMap<>();
        for(Map.Entry<Integer,Integer> entry : keyToFreqMap.entrySet()){
            if(valueToKeyListMap.get(entry.getValue())==null){
                valueToKeyListMap.put(entry.getValue(), new ArrayList<>());
            }
            valueToKeyListMap.get(entry.getValue()).add(entry.getKey());

        }

        List<Integer> list = new ArrayList<Integer>(valueToKeyListMap.keySet());
        Collections.sort(list, (x1,x2)->{
           return x2.compareTo(x1);
        });//sorts in descending order
        //list.sort();

        for(Integer freq :list){
            List<Integer>  keys =  valueToKeyListMap.get(freq);
            for(Integer key : keys){
                for(int i=0; i<freq; i++){
                    System.out.println(key);
                }
            }
        }



    }


   /* public void sortByFrequency(int[] arr){

        Map<Integer, Integer> keyToFreqMap = new LinkedHashMap<Integer, Integer>();
        for(Integer key: arr){
            keyToFreqMap.put(key, keyToFreqMap.getOrDefault(key,0)+1);

        }

        Map<Integer, List<Integer>> valueToKeyListMap = new HashMap<>();
        for(Map.Entry<Integer,Integer> entry : keyToFreqMap.entrySet()){
            if(valueToKeyListMap.get(entry.getValue())==null){
                valueToKeyListMap.put(entry.getValue(), new ArrayList<>());
            }
            valueToKeyListMap.get(entry.getValue()).add(entry.getKey());

        }

        List<Integer> list = new ArrayList<Integer>(valueToKeyListMap.entrySet());


    }*/


   public static void main(String[] args){

       int[] arr = {2, 5, 2, 8, 5, 6, 8, 8};
       _13_SortElementsByFrequency sol = new _13_SortElementsByFrequency();
       sol.sortByFrequency(arr);
   }
}
