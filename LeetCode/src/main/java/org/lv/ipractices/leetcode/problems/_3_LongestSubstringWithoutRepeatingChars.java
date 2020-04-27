package org.lv.ipractices.leetcode.problems;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class _3_LongestSubstringWithoutRepeatingChars {

    /*
    method 1 : brute force using two for loops for substring and 1 for loop for check unique chars with hashset
    O(n3) time
     */


    /*
    method 2 : using dynamic programming
    O(n2) time
    0(n2) space
     */

    /*
    method 3 : using two pointers(sliding window)
    o(n) time
     */
    public static int longestSubstringWithoutRepeatingCharsUsingSet(String s){

        int maxLength = 0;
        int i=0;
        int j=0;

        Set<Character> set = new HashSet<>();

        while(j<s.length()){
            if(!set.contains(s.charAt(j))){
                set.add(s.charAt(j++));
                maxLength=Math.max(maxLength, j-i);
            }else {
                set.remove(s.charAt(i));
                i++;
            }
        }

        System.out.println(set.toString());


        return maxLength;

    }

    public static int longestSubstringWithoutRepeatingCharsUsingMap(String s) {
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>(); // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }
        return ans;
    }


    public static void main(String[] args){

        //longestSubstringWithoutRepeatingChars
        String s = "LLABINA";
        System.out.println("Longes substring without repeating chars is :"+longestSubstringWithoutRepeatingCharsUsingMap(s));

    }
}
