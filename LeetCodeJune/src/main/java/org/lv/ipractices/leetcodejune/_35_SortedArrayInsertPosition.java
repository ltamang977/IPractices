package org.lv.ipractices.leetcodejune;

public class _35_SortedArrayInsertPosition {


    public static int insertPosition(int[] nums, int target){

        int lo = 0;
        int hi = nums.length-1;

        int index=nums.length;
        while(lo<=hi) {

            int mid = lo+(hi-lo)/2;

            if(nums[mid]==target){
                return mid;

            }else if(nums[mid]<target){
                lo = mid+1;
                index = mid+1;

            }else{
                hi = mid-1;
                index = mid;

            }

        }

        return index;


    }

    public static void main(String[] args){

        int[] nums = {1, 3, 5, 6};
        int target = 2;

        int pos = insertPosition(nums, target);
        System.out.println(pos);


    }
}
