package org.lv.ipractices.leetcodejune;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _39_CombinationSum2 {



    public static List<List<Integer>> combinationSum(int[] candidates, int target) {


        List<List<Integer>> resultLIst = new ArrayList<>();
        List<Integer> tempList = new ArrayList<>();
        Arrays.sort(candidates);

        dfs(candidates, resultLIst, tempList, target, 0);

        return  resultLIst;

    }



    public static void dfs(int[] candidates, List<List<Integer>> resultLIst,
                    List<Integer> tempList, int target, int start){

        if(target==0){
            resultLIst.add(new ArrayList<>(tempList));
            return;
        }


        int prev = -1;
        for(int i=start; i<candidates.length; i++){

            if(prev == candidates[i])
                continue;

            int val = candidates[i];
            if(val<=target){
                tempList.add(candidates[i]);
                dfs(candidates, resultLIst, tempList, target-val, i+1);
                tempList.remove(tempList.size()-1);
            }
            prev = candidates[i];
        }

    }


    public static void main(String[] args){

        int[] candidates = {2,3,6,7};
        int target = 7;

        List<List<Integer>> resultList = combinationSum(candidates, target);

        System.out.println(resultList.toString());
    }
}
