package org.lv.ipractices.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by root on 1/20/18.
 */
public class ThreeSumClosest {

    /**
     * three sum using soring from gff
     * returns duplicate triplets
     * //fixning duplicates after solution
     * @param arr
     * @return
     */
    public static int threeSumClosest(int[] arr, int target){


        Arrays.sort(arr);
        System.out.println("Sorted array :"+Arrays.toString(arr));

        List<Integer> triplet = new ArrayList<>();
        List<List<Integer>> tripletList = new ArrayList<>();

        int sign = 1;

        if(arr==null || arr.length<3)
            return -1;

        int minDiff = Integer.MAX_VALUE;

        for(int i=0; i<arr.length-2; i++){

            if(i>0 && arr[i]==arr[i-1])
                continue;

            int left = i+1;
            int right = arr.length-1;
            while(left<right){
                int sum = arr[i]+arr[left]+arr[right];
                System.out.println("sum is"+sum);
                int diff = Math.abs(sum-target);
                if(diff<minDiff){
                    minDiff=diff;
                }

                if(sum==target){
                    System.out.printf(" i: %d j: %d k:%d and closest value is %f", arr[i], arr[left], arr[right], minDiff);
                    break;

                }else if(sum<target){
                    sign=-1;
                    left++;

                }else if (sum>target){
                    sign=1;
                    right--;
                }
            }
        }

        System.out.printf("Target and diff : %d",minDiff);

        return target+sign * minDiff;


    }

    /*
    other solution is to always maintain closest value insted of dii

    closest = if(Math.abs(sum-target)<Math.abs(closest-target))?sum:closest;
     */


    public static void main(String[] args){

        int[] arr = {-1,2,1,-4};

        int closestValue = threeSumClosest(arr,1);
        System.out.println("Sum closes to target is :"+closestValue);

        //List<List<Integer>> tripletsList = threeSumSortingLC(arr);
    }

}
