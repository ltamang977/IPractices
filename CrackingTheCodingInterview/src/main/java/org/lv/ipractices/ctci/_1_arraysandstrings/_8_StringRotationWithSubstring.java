package org.lv.ipractices.ctci._1_arraysandstrings;

/**
 * Created by root on 12/30/17.
 */
public class _8_StringRotationWithSubstring {

    public static boolean checkRotation(String s1, String s2){
        return  isS1SubStringOfS2(s1,s2+s2);
    }

    public static boolean isS1SubStringOfS2(String s1, String s2){
        int s1Length  = s1.length();
        char s1StartChar = s1.charAt(0);

        int startIndex = s2.indexOf(s1StartChar);

        String subStr = s2.substring(startIndex,startIndex+s1Length);

        System.out.println("S1 is"+s1);
        System.out.println("S2 is"+s2);
        System.out.println("S2 substr is"+subStr);

        if(s1.equals(subStr)){
            return  true;
        } else {
            return false;
        }
    }


    public static void main(String[] args){
       System.out.println("Rotation is "+ checkRotation("BINLA","LABIN"));
    }
}
