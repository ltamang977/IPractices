package org.lv.ipractices.algorithms1.sorting;

/**
 * Created by root on 12/19/17.
 */
public class QuickSort {


    public static void shuffle(int[] arr){

        java.util.Random rand = new java.util.Random();
        int N = arr.length;
        for(int i=N-1; i>=0; i--){

            int randIndex = rand.nextInt(i+1);
            exchange(arr, i, randIndex);

        }
    }

    public static int partition(int arr[], int lo, int hi){

        int i= lo;
        int j= hi;


        while(true){

            while(arr[i]<=arr[lo]){
                //if(i==hi)
                i++;
                if(i==hi)
                    break;
            }

            while(arr[j]>=arr[lo] && j!=lo){
                j--;
                if(j==lo)
                    break;
            }

            if(j<i)
                break;

            exchange(arr, i, j);
        }
        exchange(arr, lo, j);



        return j;
    }


    public static void quickSort(int[] arr){
        shuffle(arr);
        System.out.println("Array after shuffling :\n");
        print(arr);

        quickSort(arr, 0, arr.length-1);
        System.out.println("Array after sorting :\n");
        print(arr);

    }

    public static void quickSort(int[] arr, int lo, int hi){

        if(hi<=lo)
            return;

        int partitionIndex = partition(arr, lo, hi);
        System.out.println("Partion index is :"+partitionIndex);

        quickSort(arr, lo, partitionIndex-1);
        quickSort(arr, partitionIndex+1, hi);
    }

    public static void exchange(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j]= temp;

    }

    public static void print(int[] arr){
        for(int i=0; i<arr.length ; i++){
            System.out.printf("%10d",arr[i]);
           // System.out.println();
        }
    }

    public static void main(String[] args){
        //int[] arr = {3, 5, 8, 2, 1};
        int[] arr = {2, 5, 8, 3, 1, 7, 9, 4};
        quickSort(arr);

        /*
        shuffle(arr);
        System.out.println("Array after shuffling is:");
        print(arr);

        int partitionKeyIndex = partition(arr);
        System.out.println("\n Partion key index for provided arr is :"+partitionKeyIndex);
        print(arr);
        */
    }
}

