package org.lv.ipractices.leetcode.problems;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class _5_LongestPalindromicSubstring {

    /*
    method 1 : brute force using two for loops for substring and 1 for loop to check palindrome
    O(n3) time
     */


    /*
    method 2 : using dynamic programming
    O(n2) time
    0(n2) space
     */

    public static int longestPalindromicSubstringDynamic(String s){

        int[][] arr = new int[s.length()][s.length()];

        for(int i=0; i < s.length(); i++){
            arr[i][i] = 1;
        }


        for(int len=2; len<=s.length(); len++){
            for(int i=0; i<s.length()-len+1; i++){
                int j=i+len-1;
                if(s.charAt(i)==s.charAt(j)){
                    arr[i][j]= arr[i+1][j-1]+2;
                }else {
                    arr[i][j]= Math.max(arr[i+1][j],arr[i][j-1]);
                    //arr[i][j]= arr[i+1][j-1]+2;
                }
            }
        }

        return arr[0][s.length()-1];

    }


    public static String longestPalindromicSubstringDynamicBoolean(String s){

        boolean[][] arr = new boolean[s.length()][s.length()];

        for(int i=0; i < s.length(); i++){
            arr[i][i] = true;
        }


        int left = 0;
        int right = 0;

        for(int len=2; len<=s.length(); len++){
            for(int i=0; i<s.length()-len+1; i++){
                int j=i+len-1;

                if(s.charAt(i)==s.charAt(j) && (len==2 || arr[i+1][j-1])){
                    arr[i][j]= true;
                    if(j-i>right-left){
                        left = i;
                        right = j;
                    }
                }else {
                    arr[i][j]=false;
                }
            }
        }

        return s.substring(left, right+1);

    }

    /*
    method 3 : expand around the center and form palindrome
    o(n2) time
     */
    public static int longestSubstringWithoutRepeatingChars(String s){

        int maxLength = 0;
        int i=0;
        int j=0;

        Set<Character> set = new HashSet<>();

        while(j<s.length()){
            if(!set.contains(s.charAt(j))){
                set.add(s.charAt(j));
                j++;
                maxLength=Math.max(maxLength, j-i);
            }else {
                set.remove(s.charAt(i));
                i++;
            }
        }

        System.out.println(set.toString());


        return maxLength;

    }


    /*
    manacher algorithms
     */

    public static void main(String[] args){

        //longestSubstringWithoutRepeatingChars
        String s = "APPLE";
        System.out.println("Longes substring without repeating chars is :"+longestPalindromicSubstringDynamicBoolean(s));

    }
}
