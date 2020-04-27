package org.lv.ipractices.leetcodejune;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _18_4Sum_Zero_M {

    public static  List<List<Integer>> fourSum(int[] nums, int target) {

        List<List<Integer>> resultList = new ArrayList<>();
        Arrays.sort(nums);

        for(int i=0; i<nums.length-3; i++){

            if(i!=0 && nums[i]==nums[i-1])
                continue;

            for(int j=i+1; j<nums.length-2; j++){

                if(j!=i+1 && nums[j]==nums[j-1])
                    continue;

                int lo = j+1;
                int hi = nums.length-1;

                while(lo<hi) {

                    if (nums[i] + nums[j] + nums[lo] + nums[hi] == target) {
                        resultList.add(Arrays.asList(new Integer[]{nums[i], nums[j], nums[lo], nums[hi]}));
                        lo++;
                        hi--;

                        while(lo<hi && nums[hi]==nums[hi+1] ){
                            hi--;
                        }

                        while(lo<hi && nums[lo]==nums[lo-1]){
                            lo++;
                        }

                    } else if (nums[i] + nums[j] + nums[lo] + nums[hi] < target) {
                        lo++;
                    } else {
                        hi--;
                    }
                }

            }

        }

        return resultList;


    }

    public static void main(String[] args){

        int[] arr = {1, 0, -1, 0, -2, 2};

        List<List<Integer>> resultList = fourSum( arr, 0);

        resultList.stream().forEach(System.out :: println);



    }



}
