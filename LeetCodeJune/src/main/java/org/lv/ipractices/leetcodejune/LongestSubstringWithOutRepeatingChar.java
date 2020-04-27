package org.lv.ipractices.leetcodejune;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithOutRepeatingChar {


    public static int longestNotRepeatingChar(String s){

        if(s==null || s.isEmpty())
            return 0;


        int start = -1;

        int len = 0;
        Set<Character> set = new HashSet<Character>();

        for(int i=0; i<s.length(); i++){

            char c = s.charAt(i);

            if(!set.contains(c)){
                set.add(c);
                len = Math.max(len,i-start+1);
                //update length

            }else {

                while(start<i && s.charAt(start)!=c){
                    set.remove(s.charAt(start));
                    start++;
                }
                i++;

            }

        }

        return len;

    }

    public static void main(String[] args){

        String s = "pwwkew";
        int len = longestNotRepeatingChar(s);
        System.out.println("Longest not repeating char is :"+len);

    }
}
