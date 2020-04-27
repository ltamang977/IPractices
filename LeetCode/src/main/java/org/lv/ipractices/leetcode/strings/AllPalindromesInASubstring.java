package org.lv.ipractices.leetcode.strings;

/**
 * Created by root on 1/21/18.
 */
import java.util.List;
import java.util.ArrayList;

public class AllPalindromesInASubstring {


    public static List<String> allPalindromes(String str){

        //check all possible odd and even palindromes
        List<String> palindromeList = new ArrayList<String>();

        //int longest = 1;
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
            if(palindrome>0){
                palindromeList.add(str.substring(start, start+palindrome));
            }
           // longest = Math.max(longest, palindrome);
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
            if(palindrome>1){
                palindromeList.add(str.substring(start, start+palindrome));
            }
        }

        return palindromeList;

    }


    public static void main(String[] args){
        String str = "forgeekskeegfor";

        List<String> list = allPalindromes(str);

        for(String palindrome : list){
            System.out.println("palindrome is :"+palindrome);

        }
    }
}
