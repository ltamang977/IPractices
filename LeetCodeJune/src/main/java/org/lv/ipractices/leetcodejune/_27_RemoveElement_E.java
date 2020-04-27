package org.lv.ipractices.leetcodejune;

import java.util.Arrays;

public class _27_RemoveElement_E {



    public static int[]  removeElement(int[] nums, int target){

        int i = -1;
        int j=0;
        for(; j<nums.length; j++){
            if(nums[j]!=target){
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

        int[] nums = {3,2,2,3};
        int target = 3;
        int[]  arr= removeElement( nums, target);
        System.out.println(Arrays.toString(arr));

    }

}
