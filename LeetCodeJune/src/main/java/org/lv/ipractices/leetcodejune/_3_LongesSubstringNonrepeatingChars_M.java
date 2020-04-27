package org.lv.ipractices.leetcodejune;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class _3_LongesSubstringNonrepeatingChars_M {


    public String longestSubstringNonrepeatingChars(String input){

        Set<Character> set = new HashSet<>();
        String longestSubstring = "";

        int i = -1;
        for(int j=0; j<input.length(); j++){
            if(set.contains(input.charAt(j))){
                //logic to shring substring
                i++;
                while(i<j){
                    if(input.charAt(i)==input.charAt(j)){
                        break;
                    }
                    set.remove(input.charAt(i));
                    i++;
                }

            }else {
                set.add(input.charAt(j));
                if(input.substring(i+1,j+1).length()>longestSubstring.length()){
                    longestSubstring = input.substring(i+1,j+1);
                }
            }
        }

        return longestSubstring;


    }

    public String longestSubstringNonrepeatingCharsBetter(String input){

        Map<Character,Integer> map = new HashMap<>();
        String longestSubstring = "";

        int i = 0;
        int j=0;
        for(; j<input.length(); j++){
            if(map.containsKey(input.charAt(j))){
                //logic to shring substring
                i=Math.max(map.get(input.charAt(j)),i);
                map.put(input.charAt(j), j);

            }else {
                map.put(input.charAt(j), j);
                if(input.substring(i,j+1).length()>longestSubstring.length()){
                    longestSubstring = input.substring(i,j+1);
                }
            }
        }
        if(input.substring(i,j).length()>longestSubstring.length()){
            longestSubstring = input.substring(i,j);
        }

        return longestSubstring;


    }

    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.isEmpty())
            return 0;

        Map<Character, Integer> map = new HashMap<>();

        int start = 0;
        int len = 0;
        int i = 0;
        for (; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                //duplicate foind need to shrink
              //  int oldIndex = map.get(s.charAt(i));
                start = Math.max(map.get(s.charAt(i))+1, start);

            } else {
                len = Math.max(i - start + 1, len);
            }
            map.put(s.charAt(i), i);

        }
        len = Math.max(i - start, len);
        return len;
    }

    public static void main(String[] args){
        _3_LongesSubstringNonrepeatingChars_M sol = new _3_LongesSubstringNonrepeatingChars_M();
        String input = "tmmzuxt";
        //String input = "abcabcbb";
        //String longestSubstring = sol.longestSubstringNonrepeatingCharsBetter(input);
        //System.out.println("Longest substring of "+input+" is :"+longestSubstring);

        int len = sol.lengthOfLongestSubstring(input);
        System.out.println(len);
    }
}
