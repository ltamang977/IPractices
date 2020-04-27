package org.lv.ipractices.revisionaprend.strings;

public class LongestCommonSubstring {


    //recursive solution
    public void longestCommonSubstringTopDown(){

    }


    // dynamic programming
    public static void longestCommonSubstringBottomUp(String s1, String s2){

        int[][] matrix = new int[s1.length()+1][s2.length()+1];

        int max =0;
        int maxIndexI = 0;
        int maxIndexJ=0;
        for(int i=1; i<=s1.length(); i++){
            for(int j=1; j<=s2.length(); j++){

                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    matrix[i][j]=matrix[i-1][j-1]+1;
                    if(matrix[i][j]>matrix[maxIndexI][maxIndexJ]){
                        maxIndexI=i;
                        maxIndexJ=j;
                    }
                }else {
                    matrix[i][j]=0;
                }
            }
        }

        printSubstring(matrix, maxIndexI, maxIndexJ, s1);

    }


    public static void printSubstring(int[][] matrix, int maxIndexI, int maxIndexJ, String s1){

        while(matrix[maxIndexI][maxIndexJ]>0){
            System.out.println(s1.charAt(maxIndexI-1));
            maxIndexI=maxIndexI-1;
            maxIndexJ=maxIndexJ-1;
        }

    }


    public static void main(String[] args){

        String s1 = "abcdaf";
        String s2 = "zbcdf";

        longestCommonSubstringBottomUp(s1, s2);
    }


}
