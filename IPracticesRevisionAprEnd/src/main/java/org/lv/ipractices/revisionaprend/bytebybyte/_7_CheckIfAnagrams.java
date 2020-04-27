package org.lv.ipractices.revisionaprend.bytebybyte;

public class _7_CheckIfAnagrams {


    public static boolean isAnagram(char[] chArr1, char[] chArr2){

        if(chArr1.length!=chArr2.length){
            return false;
        }

        int[] count = new int[26];

        for(int i=0; i<chArr1.length; i++){
            count[chArr1[i]-'a']++;
        }

        for(int i=0; i<chArr2.length; i++){
            count[chArr1[i]-'a']--;
        }

        for(int i=0; i<26; i++){
            if(count[i]!=0){
               return false;
            }
        }

        return true;

    }


    public static void main(String[] args){

        String s1 = "labin";
        String s2 = "nibal";

        System.out.println(isAnagram(s1.toCharArray(), s2.toCharArray()));


    }
}
