package org.lv.ipractices.leetcodejune;

import java.util.*;

public class _692_TopKFrequentElements {


    public static List<String> topKFrequent(String[] words, int k) {

        Map<String, Integer>  countMap = new HashMap<>();

        for(String word : words){
            countMap.put(word, countMap.getOrDefault(word,0)+1);
        }

        List<String> keys = new ArrayList<>(countMap.keySet());

        Collections.sort(keys, (w1,w2)->countMap.get(w1).equals(countMap.get(w2))
                                    ? w1.compareTo(w2):countMap.get(w2)-countMap.get(w1));

        return keys.subList(0,k);

    }

    /**
     * #347
     * @param k
     * @return
     */
    public static  List<Integer> topKFrequent(int[] nums, int k) {

        Map<Integer, Integer>  countMap = new HashMap<>();

        for(int word : nums){
            countMap.put(word, countMap.getOrDefault(word,0)+1);
        }

        List<Integer> keys = new ArrayList<>(countMap.keySet());

        Collections.sort(keys, (w1,w2)->countMap.get(w2)-countMap.get(w1));//descending count

        return keys.subList(0,k);

    }


    public int findKthLargest(int[] nums, int k) {

        Arrays.sort(nums);//sorts ascending order

        return nums[nums.length-k];

    }

    public static void main(String[] args){

        /*String[] words = {"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"};
        int k = 4;
        List<String> topK = topKFrequent(words,  k);*/

        int[] nums = {1,1,1,2,2,3};
        int k = 2;
        List<Integer> topKElements = topKFrequent(nums,  k);

        System.out.println(topKElements.toString());

    }
}
