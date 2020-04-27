package org.lv.ipractices.codingmadesimple.dynamicprogramming;

import java.util.HashMap;
import java.util.Map;

public class MaximumSumSubsequenceNonAdjacent {



    public static int maximumSumSubsequenceNonAdjacent(int[] input){

        int[] maxArr = new int[input.length];
        int[] indexArr = new int[input.length];

        int inclusive = input[0];
        int exclusive = 0;

        for(int i=1; i<input.length; i++){
            int oldInclusive = inclusive;
            inclusive=Math.max(exclusive+input[i], inclusive);
            exclusive= oldInclusive;
        }

        return  Math.max(inclusive, exclusive);
    }



    public static void main(String[] args){

        int[] arr = {4,1,1,4,2,1};


        Map<Integer,Integer> memo = new HashMap<>();
        //int longesCommonSubsequenceTopDown = longesCommonSubsequenceTopDown( s1, s2,  0, 0);
        // System.out.println("Longes common subsequence top down  is :"+longesCommonSubsequenceTopDown);

        int maximumSumIncreasingSubsequenceBottomUp = maximumSumSubsequenceNonAdjacent(arr);
        System.out.println("maximum sum increasing subsequence bottom up is :"+maximumSumIncreasingSubsequenceBottomUp);

    }
}
