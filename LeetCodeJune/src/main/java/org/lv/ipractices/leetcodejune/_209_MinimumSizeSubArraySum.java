package org.lv.ipractices.leetcodejune;

public class _209_MinimumSizeSubArraySum {

    public static int minSubArrayLen(int s, int[] nums) {

        int minLen = Integer.MAX_VALUE;
        int sum = 0;

        int start=0;
        for(int i=0; i<nums.length; i++){
            sum +=nums[i];

            if(sum>=s){

                if(sum==s){
                    int len = i-start+1;
                    minLen=Math.min(len, minLen);
                    continue;
                }

                //else
                while(sum>s){
                    sum-=nums[start++];
                    if(sum>=s) {
                        int len = i - start + 1;
                        minLen = Math.min(len, minLen);
                    }
                }
            }
        }

        return (minLen==Integer.MAX_VALUE)?0:minLen;

    }



    public int maxSubArray(int[] nums) {
        //using dynamic programming

        if(nums==null || nums.length==0)
            return 0;

        int maxSoFar = nums[0];

        int sum = nums[0];

        for(int i=1; i<nums.length; i++){

            sum = Math.max(sum+nums[i], nums[i]);
            maxSoFar = Math.max(maxSoFar, sum);

        }

        return maxSoFar;

    }

    public static int maxProduct(int[] nums) {

        int maxBefore = nums[0];
        int minBefore = nums[0];

        int maxSoFar = nums[0];

        int maxHere = maxBefore;
        int minHere = minBefore;


        int sum = nums[0];

        for(int i=1; i<nums.length; i++){
            int current = nums[i];
            maxHere = Math.max(Math.max(maxBefore * current, minBefore * current), current);
            minHere = Math.min(Math.min(maxBefore * current, minBefore * current), current);
            maxSoFar = Math.max(maxSoFar, maxHere);
            maxBefore = maxHere;
            minBefore = minHere;

        }

        return maxSoFar;

    }

    public static void main(String[] args){

       // int[] nums = {2,3,1,2,4,3};
       // int s = 7;

        //int minLen = minSubArrayLen( s,  nums) ;


        int[] nums = {2,3,-2,4};
        int maxProd = maxProduct(nums);
        System.out.println(maxProd);
    }

}
