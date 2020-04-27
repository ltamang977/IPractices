package org.lv.ipractices.leetcodejune;

import java.util.Arrays;

public class _34_SearchRangeInSortedArray {


    public static int[] searchRange(int[] nums, int target){

        int lo = 0;
        int hi = nums.length-1;

        while(lo<=hi){

            int mid = lo + (hi-lo)/2;

            if(nums[mid]==target){
                //search for range

                int left = mid;
                while(left>0 && nums[left]==nums[left-1]){
                    left--;
                }

                int right = mid;
                while(right<nums.length-1 && nums[right]==nums[right+1]){
                    right++;
                }

                return new int[]{left, right};

            } else if(nums[mid]<target){
                lo = mid+1;

            } else {
                hi = mid-1;

            }

        }

        return new int[]{-1, -1};
    }


    public static void main(String[] args){

        int nums[] = {5,7,7,8,8,10};
        int target = 8;

        int[] range = searchRange(nums, target);

        System.out.println("Range is : "+ Arrays.toString(range));


    }
}
