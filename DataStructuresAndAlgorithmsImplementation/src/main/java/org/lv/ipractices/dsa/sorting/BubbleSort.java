package org.lv.ipractices.dsa.sorting;

import java.util.Arrays;

public class BubbleSort {



    public static void bubbleSort(int[] arr){
        for(int i=arr.length-1; i>=0; i--){
            for(int j= 0; j<i; j++){
                if(arr[j]>arr[j+1]){
                    swap(arr, j, j+1);
                }
            }
        }
    }

    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }

    public static void main(String[] args){

        int[] arr  =  {-1, 2, -3, 4, 5, 6, -7, 8, 9};
        //int[] arr = {12, 11, -13, -5, 6, -7, 5, -3, -6};

        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
