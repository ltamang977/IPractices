package org.lv.ipractices.leetcode.array;

/**
 * Created by root on 1/27/18.
 */

import java.util.Arrays;
public class RemoveDuplicates {



    public static void removeDuplicatesInSortedArray(int[] arr){

        int i=0;
        for(int j=1; j<arr.length; j++){
            if(arr[j]!=arr[j-1] && j==i+1){//just next

                arr[++i]=arr[j];

            }else if (arr[j]!=arr[j-1] && j>i+1){
                i=i+2;
                arr[i]=arr[j];
            }

        }
    }


    public static void main(String[] args){
        int[] arr = {1,1,1,2,2,2,3};

        removeDuplicatesInSortedArray(arr);

        System.out.println("Removed arrays contents :"+Arrays.toString(arr));
    }
}
