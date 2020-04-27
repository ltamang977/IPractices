package org.lv.ipractices.leetcodejune;

public class _58_LastWord {


    /**
     * #58 Length ot last word
     * @param s
     * @return
     */
    public static int lengthOfLastWord(String s) {

        if(s==null || s.length()==0){
            return 0;
        }


        for(int i = s.length()-1; i>=0; i--){
            if(s.charAt(i)==' '){
                return s.length()-(i+1);
            }
        }

        return s.length();
    }


    public static void main(String[] args){

        String s = "Hello World";
        int len = lengthOfLastWord(s);
        System.out.println(len);

    }
}
