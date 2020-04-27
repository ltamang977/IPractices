package org.lv.ipractices.geekforgeeks.array.searchingandsorting;

import java.util.Arrays;

public class _32_DiffernceOfAPair {

    //O(nlogn) -- for sorting and then binary search
    public int[] differenceOfAPairOnlogn(int[] arr, int n){

        Arrays.sort(arr);//O(nlogn)

        for(int i=0; i<arr.length-1; i++){
            int key = n+arr[i];

            int keyVal = binarySearch(arr, i+1, arr .length-1, key);
            if(keyVal>-1){
                return new int[]{arr[i], keyVal};
            }
        }

        return new int[]{};

    }

    //O(nlogn) sorting and then O(n linear search)
    public int[] differenceOfAPairOn(int[] arr, int n){

        Arrays.sort(arr);//O(nlogn)

       int i=0;
       int j = 1;
       while(i<arr.length && j<arr.length){

           int diff = arr[j]-arr[i];

           if(diff==n){
               return new int[]{arr[i], arr[j]};
           }else if(diff<n){
               j++;
           }else{
               j++;
           }

       }

        return new int[]{};

    }

    public int binarySearch(int[] arr, int left, int right, int key){

        while(left<=right){

            int mid = left+(right-left)/2;

            if(arr[mid]==key){
                return arr[mid];//found

            }else if (key<arr[mid]){
                right = mid-1;

            }else {
                left = mid+1;
            }

        }

        return -1;//not found
    }


    public static void main(String[] args){

         int arr[] = {5, 20, 3, 2, 50, 80};
         int n = 78;

        //int arr[] = {90, 70, 20, 80, 50};
        //int n = 45;

        _32_DiffernceOfAPair sol = new _32_DiffernceOfAPair();
        //int[] res = sol.differenceOfAPairOnlogn(arr, n);
        int[] res = sol.differenceOfAPairOn(arr, n);
        System.out.println(Arrays.toString(res));


    }
}
