package org.lv.ipractices.dsa.sorting;

import java.util.Arrays;

public class QuickSort {


    public void quicksort(int[] arr){
        quicksort( arr, 0,  arr.length-1);

    }

    public void quicksort(int[] arr, int lo, int hi){

        if(hi<=lo){
            return;
        }

        int p = partitionAlg(arr, lo, hi);

        quicksort(arr, lo, p-1);
        quicksort(arr, p+1, hi);

    }

    public int partitionGfg(int[] arr, int lo, int hi){

        int pivot = arr[hi];

        int i = lo-1;
        //int j = lo;

        for(int j=lo; j<hi; j++){
            if(arr[j]<pivot){
                i++;
                swap(arr, i,j);
            }
        }


        swap(arr, i+1, hi);

        return i+1;

    }

    public int partitionAlg(int[] arr, int lo, int hi){

       int pivot = arr[lo];
       int i = lo+1;
       int j = hi;

       while(true){

           while(i<=hi && arr[i]<pivot){
               i++;
           }

           while(j>=0 && arr[j]>pivot){
               j--;
           }

           if(j<=i){
               break;
           }

           swap(arr, i, j);
       }

         swap(arr, lo, j);

       return j;

    }


    public void swap(int[] arr, int i, int j){
        int temp = arr[i];
         arr[i] = arr[j];
         arr[j] = temp;
    }


    public static void main(String[] args){

        int[] arr  =  {60, 80, 30, 90,40,50, 70};
        //int[] arr = {12, 11, -13, -5, 6, -7, 5, -3, -6};

        QuickSort quickSort = new QuickSort();
        quickSort.quicksort(arr);

        System.out.println(Arrays.toString(arr));
    }


}
