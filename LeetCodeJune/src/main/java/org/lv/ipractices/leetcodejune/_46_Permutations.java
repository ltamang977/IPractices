package org.lv.ipractices.leetcodejune;

import java.util.ArrayList;
import java.util.List;

public class _46_Permutations {

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
            swap(nums, i, start);
            dfs(nums,  start+1, resultList);
            swap(nums, i, start);
        }

    }


    public static void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }

    public static void main(String[] args){

        int[] nums = {1,2,3};
        List<List<Integer>> resultList = permute(nums);
        System.out.println(resultList.toString());

    }
}
