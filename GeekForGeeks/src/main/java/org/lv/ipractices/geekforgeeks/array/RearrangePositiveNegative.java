package org.lv.ipractices.geekforgeeks.array;

import java.util.Arrays;

public class RearrangePositiveNegative {


    public static void rearrange(int[] arr){

        int i = 0;
        int j = arr.length-1;

        while(i<j){

            while(arr[i]>0){
                i++;
            }

            while(arr[j]<0){
                j--;
            }

            if(i>j){
                break;
            }

            swap(arr, i, j);
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

        rearrange(arr);
        System.out.println(Arrays.toString(arr));
    }
}
