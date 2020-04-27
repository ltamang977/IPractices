package org.lv.ipractices.leetcodejune;

public class _55_JumpGame {

    static enum Index{
        GOOD, BAD, UNKNOWN;
    }

    public static boolean jumpGameDP(int[] nums){

        int[] memo = new int[nums.length];
        for(int i=0; i<memo.length; i++){
            memo[i]=-1;
        }
        memo[memo.length-1]=0;//good

        for(int i = nums.length-2; i>=0; i--){
            int farthest = Math.min(i+nums[i], nums.length-1);
            for(int j=i+1; j<=farthest; j++){
                if(memo[j]==0){
                    memo[i]=0;
                    break;
                }

            }
        }

        return memo[0]==0;

    }

/*
    public static boolean jumpGame(int[] nums, int index){

        if (memo[position] != Index.UNKNOWN) {
            return memo[position] == Index.GOOD ? true : false;
        }

        if(index==nums.length-1){
            return true;
        }


        int val = nums[index];
        int farthest = Math.min(index+val, nums.length-1);
        for(int pos = index+1; pos<=farthest; pos++){

            boolean res = jumpGame(nums, pos);
            if(res) {
                memo[position] = Index.GOOD;
                return true;
            }

        }
        memo[position] = Index.GOOD;
        return false;


    }*/


    public boolean canJumpGreedy(int[] nums) {
        int lastPos = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (i + nums[i] >= lastPos) {
                lastPos = i;
            }
        }
        return lastPos == 0;
    }

    public static void main(String[] args){

        int[] nums = {2,3,1,1,4};
        //int[] nums = {3,2,1,0,4};
        //3,2,1,0,4
       boolean result = jumpGameDP(nums);
        System.out.println("Result is :"+result);
    }
}
