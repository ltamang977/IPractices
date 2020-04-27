package org.lv.ipractices.leetcodejune;

import java.util.Arrays;
import java.util.List;

public class _26_RemoveDuplicatesFromSortedArray_E {

    //[1,1,2],

    public static int[]  removeDuplicatesSorted(int[] nums){

        int i = -1;
        int j=0;
        for(; j<nums.length; j++){
            if(j==0 || nums[j]!=nums[j-1]){
                nums[++i]=nums[j];
            }
        }

        if(i==-1){
            return new int[]{};
        }else {
            int[] arr = new int[i+1];
            System.arraycopy(nums, 0, arr,0, i+1 );
            return arr;
        }

    }


    public static void main(String[] args){

        int[] nums = {0,0,1,1,1,2,2,3,3,4};
        int[]  arr= removeDuplicatesSorted( nums);
        System.out.println(Arrays.toString(arr));

    }
}
