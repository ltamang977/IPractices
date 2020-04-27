package org.lv.ipractices.leetcode.array;

/**
 * Created by root on 1/24/18.
 */
import java.util.Arrays;

public class BinarySearchInsertPosition {


    public static int findInsertPosition(int[] arr, int value){

        int i =0;
        int j= arr.length-1;

        while(i<=j){
            int mid = i+(j-1)/2;
            if(arr[mid]>value){
                j=mid-1;
            }else if(arr[mid]<value){
                i=mid+1;
            }else {
                return mid;
            }
        }

        return i;
    }

    public static void main(String[] args){

        int[] arr = {1,3,5,6};

        int index = findInsertPosition(arr, 2);

        System.out.println("Indexes range is :"+index);

    }
}
