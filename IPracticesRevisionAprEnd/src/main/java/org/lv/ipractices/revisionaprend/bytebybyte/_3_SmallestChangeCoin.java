package org.lv.ipractices.revisionaprend.bytebybyte;

public class _3_SmallestChangeCoin {


    public static int smallestChangeTopDown(int[] denoms, int sum, int[] cache){
        if(sum == 0){
            return 0;
        }

        int min = sum;
        for(int denom : denoms){
            if(sum-denom>=0){
                int count = 0;
                if(cache[sum-denom]>=0){
                    count = cache[sum-denom];
                }else {
                    count = smallestChangeTopDown(denoms, sum-denom, cache);
                }
                if(count+1<min){
                    min = count+1;
                }
            }
        }
        return min;

    }


    public static void main(String[] args){
        int[] denoms = {25, 10, 5, 1};
        int sum = 32;
        int[] cache = new int[sum];
        for(int i=0; i<sum; i++){
            cache[i]=-1;

        }
        System.out.println(smallestChangeTopDown(denoms, sum, cache));


    }
}
