package org.lv.ipractices;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

class KthSmallestPairDifference {


    /*
    use binary search instead
     */
    public int smallestDistancePair(int[] nums, int k) {


        Map<Integer,Integer> diffCount = new HashMap<>();

        for(int i = 0; i<nums.length-1; i++){
            int a = nums[i];

            for(int j=i+1; j<nums.length; j++){
                int b = nums[j];

                int diff= Math.abs(a-b);

                diffCount.put(diff, diffCount.getOrDefault(diff,0)+1);

            }
        }

        ArrayList<Integer> list = new ArrayList<>(diffCount.keySet());

        list.sort((e1,e2)->e1-e2);

        /*
         for (int i = 0; i < N; ++i) {
            if (cnt[i] >= k) return i;
            k -= cnt[i];
        }
        return -1;
        */

        int cnt = 0;
        for(Integer i : list){

            cnt+=diffCount.get(i);
            if(cnt>=k){
                return i;
            }

        }

        return -1;

    }

    public static void main(String[] args){

        int[] nums = {1,3,1};
        int k = 4;

        KthSmallestPairDifference sol = new KthSmallestPairDifference();
        int val = sol.smallestDistancePair(nums, k);
        System.out.println(val);

    }
}
