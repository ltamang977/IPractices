package org.lv.ipractices.ctci._1_arraysandstrings;

/**
 * Created by root on 12/30/17.
 * good
 */
public class _1_CheckIfStringHasUniqueCharacters {


    public static boolean containsUniqueChars(String input){

        //default false
        boolean[] asciiChars = new boolean[128];
        char[] chArr = input.toCharArray();
        for(char c : chArr){
            if(asciiChars[c]){
                return false;
            }else {
                asciiChars[c]=true;
            }
        }

        return true;

    }


    public static void main(String[] args){

        String str = "Tamang";
        System.out.println("conatains unique chars ??"+containsUniqueChars(str));

    }
}
