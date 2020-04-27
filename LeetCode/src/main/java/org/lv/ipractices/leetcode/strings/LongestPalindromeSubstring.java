package org.lv.ipractices.leetcode.strings;

/**
 * Created by root on 1/21/18.
 */
public class LongestPalindromeSubstring {


    public static int longestPanlindromicSubstringExpandOut(String str){

        //check all possible odd and even palindromes

        int longest = 1;
        int start = 0;
        for(int i=0; i<str.length();i++){
            int left = i;
            int right = i+1;
            int palindrome = 0;
            while(left>=0 && right<=str.length()-1 && str.charAt(left)==str.charAt(right)){
                palindrome+=2;
                start=left;
                left--;
                right++;
            }
            longest = Math.max(longest, palindrome);
        }

        for(int i=1; i<str.length();i++){
            int left = i-1;
            int right = i+1;
            int palindrome = 1;
            while(left>=0 && right<=str.length()-1 && str.charAt(left)==str.charAt(right)){
                palindrome+=2;
                start=left;
                left--;
                right++;
            }
            longest = Math.max(longest, palindrome);
        }

        System.out.println("Longest palindrome is"+str.substring(start, start+longest));

        return longest;

    }


    public static void main(String[] args){
        String str = "forgeekskeegfor";

        System.out.println("longest palindrome is :"+longestPanlindromicSubstringExpandOut(str));

    }
}
