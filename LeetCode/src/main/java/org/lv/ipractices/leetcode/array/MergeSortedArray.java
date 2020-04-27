package org.lv.ipractices.leetcode.array;

/**
 * Created by root on 1/23/18.
 */

import java.util.Arrays;
public class MergeSortedArray {

    public static int[] mergeSortedArrays(int[] arr1, int[] arr2){

        int mergeSize = arr1.length+arr2.length;
        int[] mergeArr = new int[mergeSize];

        int i=0;
        int j= 0;

        for(int k=0; k<mergeSize; k++){
            if(i>=arr1.length){
                mergeArr[k]=arr2[j];
                j++;
            }else if (j>=arr2.length){
                mergeArr[k]=arr1[i];
                i++;
            }else{
                if(arr1[i]<=arr2[j]){
                    mergeArr[k]=arr1[i];
                    i++;
                }else {
                    mergeArr[k]=arr2[j];
                    j++;
                }
            }

        }
        return mergeArr;
    }

    public static void main(String[] args){

        int[] arr1 = {1,3,5,7};
        int[] arr2 = {2,2,4,6};

        int[] mergedArr = mergeSortedArrays(arr1, arr2);
        System.out.println("Arrrays contents :"+Arrays.toString(mergedArr));

    }
}
