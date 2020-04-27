package org.lv.ipractices.codingmadesimple.dynamicprogramming;

import java.util.HashMap;
import java.util.Map;

public class MaximumSumIncreasingSubsequence {


    public static int maximumSumIncreasingSubsequenceBottomUp(int[] input){

        int[] maxArr = new int[input.length];
        int[] indexArr = new int[input.length];

        for(int i=0; i<input.length; i++){
            maxArr[i] = input[i];
        }

        for(int i=0; i<input.length; i++){
            indexArr[i] = i;
        }

        for(int i=1; i<input.length; i++){
            int j = 0;
            while(j<i){

                if(input[j]<input[i] && maxArr[j]+input[i]>maxArr[i]){
                    maxArr[i] = maxArr[j]+input[i];
                    indexArr[i]=j;
                }

                j++;
            }
        }

        int max = 0;
        int maxIndex = 0;
        for(int i=0; i<maxArr.length; i++){
            if(maxArr[i]>max){
                max = maxArr[i];
                maxIndex=i;
            }
        }

        printMaximumSumSubsequence(maxIndex, input, indexArr);

        return  max;
    }


    public static void printMaximumSumSubsequence(int maxIndex, int[] input, int[] indexArr){

        while(maxIndex>=0){
            System.out.println(input[maxIndex]);
            if(maxIndex==0)
                break;
            maxIndex=indexArr[maxIndex];
        }

    }

    public static void main(String[] args){

        int[] arr = {4,6,1,3,8,4,6};


        Map<Integer,Integer> memo = new HashMap<>();
        //int longesCommonSubsequenceTopDown = longesCommonSubsequenceTopDown( s1, s2,  0, 0);
        // System.out.println("Longes common subsequence top down  is :"+longesCommonSubsequenceTopDown);

        int maximumSumIncreasingSubsequenceBottomUp = maximumSumIncreasingSubsequenceBottomUp(arr);
        System.out.println("maximum sum increasing subsequence bottom up is :"+maximumSumIncreasingSubsequenceBottomUp);

    }
}
