package org.lv.ipractices.dsa.sorting;

import java.util.Arrays;
import java.util.Random;

public class HeapSort {


    public void heapSort(Comparable[] arr){

        int n = arr.length;
        for(int i=n/2; i>=1; i--){
            pushDown(arr, i, n);
        }

        while(n>1){
            exchange(arr, 1, n--);
            pushDown(arr, 1, n);

        }
    }

    public void pushUp(Comparable[] comparables, int i){

        while(i>1 && lessThan(comparables, i,i/2)){
            exchange(comparables, i, i/2);
            i = i/2;
        }

    }



    public void pushDown(Comparable[] comparables, int i, int n){

        while(2*i<=n){
            int k = 2*i;

            if(k<n && lessThan(comparables, k+1, k)){
                k = k+1;
            }

            if(!lessThan(comparables, k, i)){
                return;
            }
            exchange(comparables, k, i);
            i=k;

        }

    }



    private boolean lessThan(Comparable[] comparables, int i, int j){

        return comparables[i-1].compareTo(comparables[j-1])<0;

    }

    private void exchange(Comparable[] comparables, int i, int j){

        Comparable temp = comparables[i-1];
        comparables[i-1] = comparables[j-1];
        comparables[j-1] = temp;


    }

    public Integer[] populateArr(){

        Integer[] arr = new Integer[10];

        Random rand = new Random();
        for(int i=0; i<arr.length; i++){
            arr[i] = rand.nextInt(100);
        }

        System.out.println(Arrays.toString(arr));

        return arr;

    }


    public static void main(String[] args){

        HeapSort heapSort = new HeapSort();
        Integer[] arr =heapSort.populateArr();

        heapSort.heapSort(arr);


        System.out.println("Array contents after sorting :"+Arrays.toString(arr));


    }

}
