package org.lv.ipractices.leetcodejune;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class _1_TwoSum_E {


    public int[] twoSum(int[] input, int sum){

        Map<Integer,Integer> map = new HashMap<>();

        for(int i=0; i<input.length; i++){
            int val = input[i];
            Integer other = sum-val;
            if(map.containsKey(other)){
                return new int[]{map.get(other), i };
            }

            map.put(val, i);
        }

        return new int[]{};

    }


    public static void main(String[] args){

        int[] input = {2, 7, 11, 15};

        _1_TwoSum_E sol = new _1_TwoSum_E();
        System.out.println(Arrays.toString(sol.twoSum(input, 9)));

    }
}
