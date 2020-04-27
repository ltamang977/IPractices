package org.lv.ipractices.sorting;


import java.util.Arrays;

public class MergeSort {
    /**
     * @param A: an integer array
     * @return: nothing
     */
    public void sortIntegers2(int[] A) {
        // write your code here

        mergeSort(A);
    }

    /**
     * alg 1 : merge sort
     * */

    void mergeSort(int[] nums){

        int start = 0;
        int end = nums.length-1;

        int[] temp = new int[nums.length];

        mergeSortRecur(nums, temp,  start,  end);


    }

    void mergeSortRecur(int[] nums, int[] temp, int start, int end){

        if(end<=start)
            return;

        int mid = start+(end-start)/2;
        mergeSortRecur(nums,  temp, start,  mid);
        mergeSortRecur(nums,  temp, mid+1,  end);

        merge(nums, temp,  start,  mid,  end);


    }

    void merge(int[] nums, int[] temp, int start, int mid, int end){

        int i = start;
        int j = mid+1;

        for(int k=start; k<=end; k++){
            temp[k]=nums[k];
        }

        for(int k=start; k<=end; k++){

            if(i>mid){
                nums[k]=temp[j++];

            }else if(j>end){
                nums[k]=temp[i++];

            }else{
                if(temp[i]<=temp[j]){
                    nums[k]=temp[i++];

                }else{
                    nums[k]=temp[j++];
                }
            }

        }

    }


    /**
     *
     * alg 2 : Heap sort
     * heapify -- push elements down -- max heap
     *
     * **/

    void heapSort(int[] nums){

        int size = nums.length;

        for(int i=nums.length/2-1; i>=0; i--){
            heapify(nums, i, size);
        }

        for(int i=1; i<nums.length; i++){//total times
            swap(nums, 0, size-1);//0 has max value
            size--;
            heapify(nums, 0, size);


        }

    }

    void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i]= nums[j];
        nums[j]=temp;
    }



    void heapify(int[] nums, int index, int size){

        int left = 2*index+1;
        int right = 2*index+2;
        int max = index;

        if(left<size && nums[left]>nums[index]){
            max = left;
        }

        if(right<size && nums[right]>nums[max]){
            max = right;
        }

        if(max!=index){
            swap(nums, max, index);
            heapify(nums, max, size);
        }

    }


    public static void main(String[] args){

        //int[] nums = {3,2,1,4,5};

        int[] nums = {5,4,3,2};

        MergeSort sol = new MergeSort();
       // sol.sortIntegers2(nums);
        sol.heapSort(nums);

        System.out.println(Arrays.toString(nums));

    }
}