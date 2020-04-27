package org.lv.ipractices.dsa.sorting;

import java.util.Arrays;
import java.util.Random;

public class Shuffle {


    public void shuffle(int[] arr){

        Random rand = new Random();
        for(int i=arr.length-1; i>0; i--){
            int randomIndex = rand.nextInt(i);
            swap(arr, i, randomIndex);

        }
    }

    public void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    public static void main(String[] args){

        int[] arr  =  {10, 20, 30, 40, 50, 60, 70};
        //int[] arr = {12, 11, -13, -5, 6, -7, 5, -3, -6};

        Shuffle shuffle = new Shuffle();
        shuffle.shuffle(arr);

        System.out.println(Arrays.toString(arr));
    }
}
