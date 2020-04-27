package org.lv.ipractices.leetcodejune;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class _387_FirstUniqueCharacter {

    public static int firstUniqChar(String s) {

        if(s==null || s.isEmpty())
            return -1;

        Map<Character,Integer> freqMap = new HashMap<>();

        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            freqMap.put(c, freqMap.getOrDefault(c, 0)+1);
        }

        for(int i=0; i<s.length(); i++){
            if(freqMap.get(s.charAt(i))==1){
                return i;
            }
        }

        return -1;

    }


    public static int thirdMax(int[] nums) {

        if(nums==null || nums.length==0)
            return -1;

        Arrays.sort(nums);

        int start = nums.length-1;
        int count = 1;
        for(int i=nums.length-2; i>=0; i--){
            if(nums[i]!=nums[start]){
                start=i;
                count++;
                if(count==3){
                    return nums[start];
                }

            }
        }

        return nums[nums.length-1];

    }

    public static void main(String[] args){

        /*String s = "leetcode";

        int indexFound = firstUniqChar( s);
        System.out.println("First unique found at :"+indexFound);*/

        int[] nums = {2, 2, 3};


        int thirdMax = thirdMax(nums);
        System.out.println("Third max is "+thirdMax);
    }
}
