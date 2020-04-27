package org.lv.ipractices.leetcode.array;

/**
 * Created by root on 1/24/18.
 */
import java.util.Arrays;
public class RangeInSortedArray {


    public static int[] rangeInSortedArray(int[] arr, int target){
        int i=0;
        for(int j=0; j<arr.length; j++){
            if(arr[j]==target && arr[i]!=target){
                i=j;

            }else if(arr[j]!=target && arr[i]==target){
                return new int[]{i,j-1};
            }
        }

        return new int[]{-1,-1};
    }

    public static void main(String[] args){

        int[] arr = {5,7,7,8,8,10};

        int[] rangeIndexes = rangeInSortedArray(arr, 8);

        System.out.println("Indexes range is :"+Arrays.toString(rangeIndexes));

    }
}
