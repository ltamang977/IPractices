package org.lv.ipractices.geekforgeeks.array.searchingandsorting;

import java.util.Arrays;

public class UnOrderedArray {

    //insert
    //search
    //delete
    /*
    O(n) - linear search
     */
    public int linearSearch(int[] arr, int size, int key){

        for(int i=0; i<size; i++){
            if(arr[i]==key){
                return i;
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

        arr[size]=key;

        return size;

    }


    /*
     O(1)
      */
    public int delete(int[] arr, int size, int key){

        int index = linearSearch(arr, size, key);

        if(index==-1)
            return  -1;

        for(int i=index; i<size-1; i++){
            arr[i]=arr[i+1];
        }

        return index;

    }

    public static void main(String[] args){

        UnOrderedArray unOrArr = new UnOrderedArray();

        int[] arr = {5,3,4,2,1};
        //int size = 5;
        //int searchIndex = unOrArr.linearSearch(arr, size, 3);
        //System.out.println("Key found at :"+searchIndex);

        System.out.println("Key inserted at :"+unOrArr.insert(arr,4, 7));
        System.out.println(Arrays.toString(arr));

        System.out.println("Key deleted at :"+unOrArr.delete(arr,5, 3));
        System.out.println(Arrays.toString(arr));
    }



}
