package org.lv.ipractices.leetcode.strings;

/**
 * Created by root on 1/21/18.
 */
import java.util.Arrays;

import java.util.Set;
import java.util.HashSet;

public class LongestSubstringWithUniqueChars {


    public static  int longestSubstringWithUniqueCharsGFG(String str){

        //char set assue small aa
        int[] visited = new int[256];
        Arrays.fill(visited, -1);

        int currentLength = 1;
        int maxLength = 1;

        visited[str.charAt(0)]=0;
        for(int i=1; i<str.length(); i++){
            int pre_index = visited[str.charAt(i)];

            if(pre_index==-1 || i-currentLength>pre_index){
                currentLength++;
                System.out.println();
                System.out.printf("Current lengh %d for char %c",currentLength, str.charAt(i));

            }else {
                if(currentLength>maxLength)
                    maxLength = currentLength;
                currentLength = visited[str.charAt(i)]-pre_index;

                System.out.println();
                System.out.printf("Max length %d",maxLength);

            }

            visited[str.charAt(i)]=i;
        }

        if(currentLength>maxLength){
            maxLength = currentLength;
        }

        return  maxLength;

    }


    public static int longestSubstringWithUniqueCharsT(String str){

        Set<Character> charSet = new HashSet<>();

        int start = 0;
        int maxSize =0;
        for(int i=0; i<str.length(); i++){

            char c = str.charAt(i);
            if (charSet.contains(c)) {
                while(str.charAt(start)!=c){
                    charSet.remove(str.charAt(start));
                    start++;
                }
                start++;
            }else {
                charSet.add(c);
                if (charSet.size() > maxSize) {
                    maxSize=charSet.size();
                }

            }

        }

        return maxSize;

    }

    public static int longestSubstringWithUniqueCharsLC(String str){

        //thnking about it
      return 0;

    }

    public static void main(String[] args){

        //String str = "ABCDECAMNCZB";
        String str = "GEEKSFORGEEKS";
        //System.out.println("Maximum length of substring win unique chars is :"+longestSubstringWithUniqueCharsGFG(str));

        System.out.println("Maximum length of substring win unique chars is :"+longestSubstringWithUniqueCharsT(str));

    }
}
