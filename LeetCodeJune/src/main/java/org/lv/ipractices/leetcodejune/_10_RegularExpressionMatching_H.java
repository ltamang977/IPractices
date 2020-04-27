package org.lv.ipractices.leetcodejune;

public class _10_RegularExpressionMatching_H {

    /**
     * pattern witll be in format a*b.c
     * * --> 0 to many matches
     * . --> any one match
     * @param text
     * @param pattern
     * @return
     */
    public static boolean matchRegularExpression(String text, String pattern){

        char[] textArr = text.toCharArray();
        char[] patternArr = pattern.toCharArray();

        boolean[][] T = new boolean[text.length()+1][pattern.length()+1];

        T[0][0]=true;

        for(int i=1; i<T[0].length; i++){
            if(patternArr[i-1]=='*'){
                T[0][i]= T[0][i-2];
            }

        }

        for(int i=1; i<T.length; i++){
            for(int j=1; j<T[0].length; j++){

                if(textArr[i-1]==patternArr[j-1] || patternArr[j-1]=='.'){
                    T[i][j] = T[i-1][j-1];

                }else if(patternArr[j-1]=='*'){
                    T[i][j] = T[i][j-2];//for 0 occurrences
                    if(patternArr[j-2]=='.' || textArr[i-1]==patternArr[j-2]){
                        T[i][j] =  T[i][j] || T[i-1][j];
                    }

                }else {
                    T[i][j] = false;

                }

            }
        }

        return T[textArr.length][patternArr.length];

    }



    public static void main(String[] args){

        String text = "aa";
        String pattern  = "a";

        boolean isMatch = matchRegularExpression(text, pattern);
        System.out.println("Regular expression matching"+isMatch);

    }
}
