package org.lv.ipractices.algorithms1.sorting;

import java.util.Random;

/**
 * Created by root on 12/21/17.
 */
public class HeapSort {

    //N is number of elements 1..N

    public static void sort(int[] arr, int N){
        heapify(arr, N);
        //max
        //suppose N=10 ... 1..10,, cut 0,, array length 11
        System.out.println("Sorting array : ");

        for(int i=N; i>1; i--){
            exchange(arr, 1, i);
            sink(arr, i-1, 1);
        }
    }


    public static void heapify(int[] arr, int N){

        for(int k=N/2;k>=1; k--){
            sink(arr, N, k);
            //construcitng heap tree
        }

        System.out.println("Heap tree");
        print(arr, N);

    }




    public static void sink(int[] arr, int N, int k){
        while(2*k<=N){
            int l = 2*k;
            if(l<N && arr[l+1]>arr[l])
                l = l+1;

            if(arr[l]<arr[k])
                break;

            exchange(arr, l, k);
            k = l;
        }

    }

    public static void shuffle(int[] arr, int N){
        Random rand = new Random();
        for (int i= 1; i<=N; i++){
            arr[i] = rand.nextInt(10)+1;
        }

    }

    public static void swim(){

    }

    public static void exchange(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j]= temp;
    }

    public static void print(int[] arr, int N){
        for(int i=1; i<=N; i++){
            System.out.printf("\t %7d", arr[i]);
        }
    }

    public static void main(String[] args){
        int[] arr = new int[11];
        arr[1]= 5;
        arr[2] = 7;
        arr[3] = 4;
       // arr[4]= 7;
        //arr[5]= 9;

        shuffle(arr, 10);
        print(arr, 10);
        sort(arr, 10);
        print(arr, 10);
    }
}
