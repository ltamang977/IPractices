package org.lv.ipractices.geekforgeeks.array.searchingandsorting;

import java.util.Arrays;

public class _10_MaximumSubArraySum {


    /**
     * O(n2 implementation)
     * @param arrA
     * @param arrB
     * @return
     */
    public int findMaxSubArraySum(int[] arrA, int[] arrB){

        int maxSum = Integer.MIN_VALUE;

        for(int i=0; i<arrA.length; i++){

            int tempSum = 0;
            for(int j=i; j<arrA.length; j++){

                if(contains(arrB, arrA[j])){
                    break;
                }

                tempSum +=arrA[j];
                maxSum = Math.max(maxSum, tempSum);
            }
        }

        return  maxSum;

    }


    /**
     * O(n implementation using two pointer)
     * @param arrA
     * @param arrB
     * @return
     */
    public int findMaxSubArraySumLinear(int[] arrA, int[] arrB){

        int maxSum = Integer.MIN_VALUE;

        int i=0;
        int j = 0;

        int tempSum = 0;
        while(i<arrA.length && j<arrA.length){

            if(contains(arrB, arrA[j])){
                //reset
                tempSum = 0;
                j=j+1;
                i=j+1;

            }else{
                tempSum+=arrA[j];
                maxSum = Math.max(maxSum, tempSum);
                j++;

            }

        }
        return  maxSum;

    }


    public boolean contains(int[] arr, int key){

        for(int i=0; i<arr.length; i++){
            if(arr[i]==key){
                return true;
            }
        }

        return false;


    }

    public static void main(String[] args){
        //int[] arrA  = {1, 7, -10, 6, 2};
        //int[] arrB  = {5, 6, 7, 1};

        int[] arrA = {3, 4, 5, -4, 6};
        int[] arrB = {1, 8, 5};
        _10_MaximumSubArraySum maxSubArrSum = new _10_MaximumSubArraySum();
        System.out.println(maxSubArrSum.findMaxSubArraySumLinear(arrA, arrB));
    }
}
