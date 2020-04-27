package org.lv.ipractices.leetcodejune;

import java.util.HashMap;
import java.util.Map;

public class _395_LongestSubstringWithAtLeasKRepeatingChars {


    public static int longestSubstring(String s, int k) {


        Map<Character,Integer> countMap = new HashMap<>();
        int start = 0;

        int maxLen = 0;

        for(int i =0; i<s.length(); i++){
            char c = s.charAt(i);
            countMap.put(c, countMap.getOrDefault(c,0)+1);

            if(hasKRepeatingChars(countMap,  k)){
                //calculate length
                maxLen = Math.max(maxLen, i-start+1);

            }


            //
        }

        return 0;


    }


    public static boolean hasKRepeatingChars(Map<Character,Integer> countMap, int k){

        for(Integer count : countMap.values()){
            if(count<k){
                return false;
            }

        }

        return true;
    }
}
