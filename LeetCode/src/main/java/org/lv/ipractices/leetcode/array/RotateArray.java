package org.lv.ipractices.leetcode.array;

import java.util.Arrays;

/**
 * Created by root on 1/27/18.
 */
public class RotateArray {

    /**
     * time : O(n*k)
     * space : O(1)
     * @param arr
     * @param times
     */
    public static void rotateArray(int[] arr, int times){
        for(int i=0; i<times; i++){
            int previous = arr[arr.length-1];
            for(int j=0; j<arr.length; j++){
                int temp = arr[j];
                arr[j]=previous;
                previous = temp;
            }
        }
    }

    /**
     *time : O(n)
     * space : O(n)
     * @param arr
     * @param times
     */
    public static void rotateArrayExtraArray(int[] arr, int times){

        int[] temp = new int[arr.length];

        for(int i=0; i<arr.length; i++){
            temp[(i+times)%arr.length]= arr[i];
        }

        for(int i=0; i<arr.length; i++){
            arr[i] = temp[i];
        }

    }

    public static void main(String[] args){
        int[] arr = {1,2,3,4,5,6,7};
        //rotateArray(arr, 3);
        rotateArrayExtraArray(arr, 3);

        System.out.println("Rotated array"+Arrays.toString(arr));
    }
}
