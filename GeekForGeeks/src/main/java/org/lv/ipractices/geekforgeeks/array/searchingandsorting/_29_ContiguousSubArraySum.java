package org.lv.ipractices.geekforgeeks.array.searchingandsorting;

import java.util.Arrays;

public class _29_ContiguousSubArraySum {


    public int[] contiguousSubArraySum(int[] arr, int keySum){

        int i = 0;
        int j= 0;
        int sum =0;

        while(j<arr.length){


            while(i<j && sum>keySum){
                sum-=arr[i];
                i++;
            }

            if(sum==keySum){
                int[] res = new int[j-i];
                System.arraycopy(arr,i, res, 0, j-i);
                return res;
            }

            if(sum<keySum){
                sum+=arr[j];
                j++;//expanding

            }
        }
        return new int[]{};
    }


    public static void main(String[] args){

        int[] arr = {1, 4, 0, 0, 3, 10, 5};
                //{1,4,20,3,10,5};
        //{1, 4, 0, 0, 3, 10, 5}, sum = 7

        _29_ContiguousSubArraySum sol = new _29_ContiguousSubArraySum();
        int[] res = sol.contiguousSubArraySum(arr, 7);
        System.out.println(Arrays.toString(res));


    }
}
