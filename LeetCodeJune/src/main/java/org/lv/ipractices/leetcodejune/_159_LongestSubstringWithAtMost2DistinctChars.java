package org.lv.ipractices.leetcodejune;

import java.util.HashMap;
import java.util.Map;

public class _159_LongestSubstringWithAtMost2DistinctChars {


    public static int lengthOfLongestSubstringTwoDistinct(String s) {


        if(s==null || s.isEmpty()){
            return 0;
        }

        int start=0;

        Map<Character,Integer>  countMap = new HashMap<>();
        int longest=0;

        for(int i =0; i<s.length(); i++){
            char c = s.charAt(i);
            if(countMap.containsKey(c)){
                countMap.put(c, countMap.get(c)+1);
            }else {
                countMap.put(c, 1);
            }

            if(countMap.size()>2){

                longest = Math.max(longest, i-start);

                while(countMap.size()>2){
                    char ch = s.charAt(start);
                    if(countMap.get(ch)>1){
                        countMap.put(ch, countMap.get(ch)-1);
                    }else{
                        countMap.remove(ch);
                    }
                    start++;

                }

            }

        }

        return Math.max(longest, s.length()-start);

    }



    public static int lengthOfLongestSubstringAtMostKDistinct(String s, int k) {


        if(s==null || s.isEmpty()){
            return 0;
        }

        int start=0;

        Map<Character,Integer>  countMap = new HashMap<>();
        int longest=0;

        for(int i =0; i<s.length(); i++){
            char c = s.charAt(i);
            if(countMap.containsKey(c)){
                countMap.put(c, countMap.get(c)+1);
            }else {
                countMap.put(c, 1);
            }

            if(countMap.size()>k){

                longest = Math.max(longest, i-start);

                while(countMap.size()>k){
                    char ch = s.charAt(start);
                    if(countMap.get(ch)>1){
                        countMap.put(ch, countMap.get(ch)-1);
                    }else{
                        countMap.remove(ch);
                    }
                    start++;

                }

            }

        }

        return Math.max(longest, s.length()-start);

    }



    public static void main(String[] args){

        String s = "eceba";
        int k = 2;
        //int length = lengthOfLongestSubstringTwoDistinct(s);
        int length = lengthOfLongestSubstringAtMostKDistinct(s, k);
        System.out.println("Length of longest substring of k distinct char is :"+length);

    }
}
