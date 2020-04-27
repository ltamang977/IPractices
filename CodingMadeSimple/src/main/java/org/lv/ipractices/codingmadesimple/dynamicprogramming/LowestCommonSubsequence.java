package org.lv.ipractices.codingmadesimple.dynamicprogramming;

import java.util.HashMap;
import java.util.Map;

public class LowestCommonSubsequence {


    public static int longesCommonSubsequenceTopDown(String s1, String s2, int index1, int index2){

        if(index1>=s1.length() || index2>=s2.length()){
            return 0;
        }

        int max = 0;
        if(s1.charAt(index1)==s2.charAt(index2)){
            max = longesCommonSubsequenceTopDown(s1, s2, index1+1, index2+1)+1;

        }else {
            max = Math.max(longesCommonSubsequenceTopDown(s1, s2, index1+1, index2),
                    longesCommonSubsequenceTopDown(s1, s2, index1, index2+1));
        }

        return max;
    }


    public static int longesCommonSubsequenceBottomUp(String s1, String s2){

        int[][] temp = new int[s1.length()+1][s2.length()+1];

        for(int i=1; i<=s1.length(); i++){
            for(int j=1; j<=s2.length(); j++){

                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    temp[i][j]=temp[i-1][j-1]+1;
                }else {
                    temp[i][j]=Math.max(temp[i-1][j], temp[i][j-1]);
                }

            }
        }

        return temp[s1.length()][s2.length()];
    }



    public static void main(String[] args){

        String s1 = "acbcf";
        String s2 = "abcdaf";

        int[] coins = {1,5,10,25};

        Map<Integer,Integer> memo = new HashMap<>();
        //int longesCommonSubsequenceTopDown = longesCommonSubsequenceTopDown( s1, s2,  0, 0);
       // System.out.println("Longes common subsequence top down  is :"+longesCommonSubsequenceTopDown);

        int longesCommonSubsequenceBottomUp = longesCommonSubsequenceBottomUp( s1, s2);
        System.out.println("Longes common subsequence bottom up is :"+longesCommonSubsequenceBottomUp);


     /*


        int minBottomUp = minimumCoinChangeBottomUp( total, coins);
        System.out.println("Minimimum using bottom up  approach is :"+minBottomUp);
*/
    }
}
