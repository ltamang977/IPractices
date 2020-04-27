package org.lv.ipractices.geekforgeeks.array.searchingandsorting;

import java.util.Arrays;

public class SortedArray {

    /*
    O(log(n)) - binary search
     */
    public int binarySearch(int[] arr, int size, int key){

        int left=0;
        int right = size-1;
        while(left<=right){
            int mid = left+(right-left)/2;
            if(key == arr[mid]){
                return  mid;
            }else if (key<arr[mid]){
                right=mid-1;
            }else{
                left = mid+1;
            }
        }

        return -1;

    }

    /*
    O(1)
     */
    public int insert(int[] arr, int size, int key){

        if(size==arr.length){
            return -1;
        }

        int i = size-1;

        for(; i>=0 && arr[i]>key; i--){
            arr[i+1]=arr[i];
        }

        arr[i+1]=key;

        return i+1;

    }


    /*
     O(1)
      */
    public int delete(int[] arr, int size, int key){

        int index = binarySearch(arr, size, key);

        if(index==-1)
            return  -1;

        for(int i=index; i<size-1; i++){
            arr[i]=arr[i+1];
        }

        return index;

    }

    public static void main(String[] args){

        SortedArray ordArr = new SortedArray();

        int[] arr = {1,2,3,5,6,7,8};
        //int size = 5;
        //int searchIndex = ordArr.binarySearch(arr, size, 3);

        //System.out.println("Key found at :"+searchIndex);

        System.out.println("Key inserted at :"+ordArr.insert(arr,4, 4));
        System.out.println(Arrays.toString(arr));


        System.out.println("Key deleted at :"+ordArr.delete(arr,5, 3));
        System.out.println(Arrays.toString(arr));

    }

}
