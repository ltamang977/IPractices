package org.lv.ipractices.algorithms1.sorting;

/**
 * Created by root on 12/17/17.
 */
public class InsertionSort {

    public static void sort(int[] arr){

        for(int i=0; i<arr.length-1; i++){
            int curr = arr[i+1];
            for(int j=i+1;j>0; j--){//j=1
                if(arr[j]<arr[j-1]){
                    arr[j]= arr[j-1];
                    //
                }else {
                    arr[j]=curr;
                    break;
                }
            }

        }

    }

    public static void oldsort(int[] arr){

        for(int i=1; i<arr.length; i++){
            int curr= arr[i];
            int j=i-1;
            while(j>=0 && curr<arr[j]){
                arr[j+1]= arr[j];
                j--;
            }
            arr[j+1]= curr;

        }
    }

    public static void oldsort1(int[] arr){

        for(int i=1; i<arr.length; i++){
            int curr= arr[i];
            int j=i-1;
            for(;j>=0 && curr<arr[j];j--){
                arr[j+1]= arr[j];
            }
            arr[j+1]= curr;

        }
    }

    public static void sortC(int[] arr){

        for(int i=0; i<arr.length; i++){

            for(int j=i;j>0 && arr[j]<arr[j-1];j--){
                int temp = arr[j];
                arr[j]= arr[j-1];
                arr[j-1]= temp;
            }

        }
    }


    public static void print(int[] arr)
    {
        for(int i=0; i<arr.length; i++){
            System.out.printf("%5d", arr[i]);
        }

    }

    public static void main(String[] args){
        //int[] arr = {1,2,5,8,3};
        int[] arr = {5,4,3,2,1};
        //int[] arr = {1,2,3,4,5};
        //int[] arr = {2,2,2,2,2};
        //int[] arr = {1,2,1,2,1};
        sortC(arr);
        print(arr);

    }

}
