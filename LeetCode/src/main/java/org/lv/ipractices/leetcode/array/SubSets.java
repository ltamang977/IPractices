package org.lv.ipractices.leetcode.array;

/**
 * Created by root on 1/27/18.
 */

import java.util.ArrayList;
import java.util.List;

public class SubSets {



    public static List<List<Integer>>  findSubSets(int[] nums){
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList());
        List<Integer> tempList = new ArrayList<>();

        backtrack(result, tempList, nums, 0);

        return result;
    }

    public static void backtrack(List<List<Integer>> result,
                                 List<Integer> tempList, int[] nums, int start){

        for(int i=start; i<nums.length; i++){
            tempList.add(nums[i]);
            backtrack(result, tempList, nums, i+1);
            if (!result.contains(tempList)) {
                result.add(new ArrayList(tempList));
            }
            tempList.remove(tempList.size()-1);
        }
    }




    public static void main(String[] args){
        int[] nums = {1,2,3};
        List<List<Integer>> subsetList = findSubSets(nums);

        subsetList.stream().forEach(System.out::println);

    }
}
