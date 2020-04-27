package org.lv.ipractices.codingmadesimple.dynamicprogramming;

import java.util.HashMap;
import java.util.Map;

public class LongestIncreasingSubsequence {


    public static int longestIncreasingSubsequence(int[] arr){

        int[] temp = new int[arr.length];

        for(int i=0; i<arr.length; i++){
            temp[i]=1;
        }

        for(int i=1; i<temp.length; i++){
            int j=0;
            while(i!=j) {
                if(arr[j]<arr[i]){
                    temp[i] = temp[j]+1;

                }
                j++;

            }
        }

        return temp[temp.length-1];

    }




    public static void main(String[] args){

        int[] arr = {3,4,-1,0,6,2,3};

        Map<Integer,Integer> memo = new HashMap<>();
        //int longesCommonSubsequenceTopDown = longesCommonSubsequenceTopDown( s1, s2,  0, 0);
        // System.out.println("Longes common subsequence top down  is :"+longesCommonSubsequenceTopDown);

        int longestIncreasingSubsequence = longestIncreasingSubsequence(arr);
        System.out.println("Longest increasing subsequence is :"+longestIncreasingSubsequence);


     /*


        int minBottomUp = minimumCoinChangeBottomUp( total, coins);
        System.out.println("Minimimum using bottom up  approach is :"+minBottomUp);
*/
    }
}
