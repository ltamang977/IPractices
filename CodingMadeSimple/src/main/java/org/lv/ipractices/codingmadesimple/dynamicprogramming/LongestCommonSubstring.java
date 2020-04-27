package org.lv.ipractices.codingmadesimple.dynamicprogramming;

import java.util.HashMap;
import java.util.Map;

public class LongestCommonSubstring {



    public static int longesCommonSubstring(String s1, String s2){

        int temp[][] = new int[s1.length()+1][s2.length()+1];

        for(int i=1; i<=s1.length(); i++){
            for(int j=1; j<=s2.length(); j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    temp[i][j] = temp[i-1][j-1]+1;
                }else {
                    //as it is zero
                }
            }
        }

        int max = 0;
        for(int i=1; i<=s1.length(); i++){
            for(int j=1; j<=s2.length(); j++){
               if(temp[i][j]>max){
                   max = temp[i][j];
               }
            }
        }

        return max;

    }



    public static void main(String[] args){

        String s1 = "abcdaf";
        String s2 = "zbcdf";

        int[] coins = {1,5,10,25};

        Map<Integer,Integer> memo = new HashMap<>();
        //int longesCommonSubsequenceTopDown = longesCommonSubsequenceTopDown( s1, s2,  0, 0);
        // System.out.println("Longes common subsequence top down  is :"+longesCommonSubsequenceTopDown);

        int longesCommonSubstring = longesCommonSubstring( s1, s2);
        System.out.println("Longes common substring bottom up is :"+longesCommonSubstring);


     /*


        int minBottomUp = minimumCoinChangeBottomUp( total, coins);
        System.out.println("Minimimum using bottom up  approach is :"+minBottomUp);
*/
    }
}
