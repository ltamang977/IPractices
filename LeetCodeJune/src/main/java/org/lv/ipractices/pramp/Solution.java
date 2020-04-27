package org.lv.ipractices.pramp;

public class Solution {



    //[-8, 0, 2, 5]
    //[ 0, 1, 2, 3]


    static int indexEqualsValueSearch(int[] arr) {
        // your code goes here

        if(arr==null || arr.length==0)
            return -1;

        int start = 0;
        int end = arr.length;

        while(start<end){

            int mid = start + (end-start)/2;

            if(arr[mid]==mid){
                end = mid;

            }else if(arr[mid] > mid){
                end = mid;

            }else{
                start=mid+1;
            }

        }

        if(arr[start]==start){
            return start;

        }else {
            return -1;
        }

    /*
    while(start<=end){
       int mid = (start + end)/2;

      if(arr[mid]==mid){
        return mid;

      }else if(arr[mid] > mid){
        end = mid-1;

      }else{
        start=mid+1;

      }
    }
    */

    }



    public static void main(String[] args) {

       // int[]arr = {-8,0,2,5};

        //int[] arr = {0,3};
        //int[] arr = {-8,0,1,3,5};
        int[] arr = {-5,0,2,3,10,29};
        int val = indexEqualsValueSearch(arr);
        System.out.println("Value is :"+val);
    }

}
