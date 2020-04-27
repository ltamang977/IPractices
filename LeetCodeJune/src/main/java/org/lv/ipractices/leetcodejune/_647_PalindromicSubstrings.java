package org.lv.ipractices.leetcodejune;

public class _647_PalindromicSubstrings {


    public static int countSubstrings(String s) {

        int count = 0;
        for(int len=1; len<=s.length(); len++){
            for(int i =0; i<=s.length()-len; i++){
                String sub = s.substring(i, i+len);

                if(isPalindrome((sub))){
                    count++;
                }

            }
        }

        return count;

    }


    public static boolean isPalindrome(String s){

        int start = 0;
        int end = s.length()-1;

        while(start<end){
            if(s.charAt(start)!=s.charAt(end)){
                return  false;
            }
            start++;
            end--;
        }
        return true;

    }

    public static void main(String[] strings){

       // String s = "abc";
        String s = "aaa";
        int count = countSubstrings( s);
        System.out.println("Count is :"+count);

    }

}
