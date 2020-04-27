/*
package org.lv.ipractices.leetcodejune;

public class _5_LongestPalindromicSubstring {


    public String longestPalindromicSubstring(String input){

        String longestPalindromicSubstring = "";

        int[][] matrix = new int[input.length()][input.length()];

        for(int i=0; i<input.length(); i++){
            matrix[i][i]=1;
        }

        //StringBuffer sb = new StringBuffer();
        for(int len=1; len<=input.length(); len++){
            //matrix[i][i]=1;
            for(int i=0; i<input.length(); i++){
                int j = i+len-1;

                if(input.charAt(i)==input.charAt(j)){
                    //same found
                    matrix[i][j]=matrix[i+1][j-1]+2;
                    //sb.append(input.charAt(i));
                }else {
                    matrix[i][j] = Math.max(matrix[i][j-1],matrix[i+1][j]);
                }
            }
        }


        //now trace the string back
       // int row = 0;
        //int col = input.length()-1;



    }
}
*/
