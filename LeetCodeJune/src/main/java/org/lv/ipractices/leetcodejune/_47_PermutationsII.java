package org.lv.ipractices.leetcodejune;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _47_PermutationsII {

    public static List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> resultList = new ArrayList<>();
        dfs(nums, 0, resultList);
        return resultList;

    }


    public static void dfs(int[] nums, int start, List<List<Integer>> resultList){

        if(start==nums.length){
            List<Integer> list = new ArrayList<>();
            for(int i=0; i<nums.length; i++){
                list.add(nums[i]);
            }
            resultList.add(list);
            return;

        }


        for(int i=start; i<nums.length; i++){
            //containsDuplicate(nums, i, end)
            if(!containsDuplicate(nums,  start,  i)) {
                swap(nums, i, start);
                dfs(nums, start + 1, resultList);
                swap(nums, i, start);
            }
        }

    }

    public static boolean containsDuplicate(int[] nums, int start, int end){

        for(int i=start; i<end; i++) {
            if (nums[i] == nums[end]) {
                return true;
            }
        }
        return false;

    }


    public static void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }

    public static void main(String[] args){

       // int[] nums = {1,2,3};//[1,1,2]
        int[] nums = {1,1,2};
        List<List<Integer>> resultList = permute(nums);
        System.out.println(resultList.toString());

    }
}
