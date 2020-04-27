package org.lv.ipractices.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by root on 1/20/18.
 */
public class ThreeSumSmaller {

    /**
     * three sum using soring from gff
     * returns duplicate triplets
     * //fixning duplicates after solution
     * @param arr
     * @return
     */
    public static  List<List<Integer>> threeSumSmaller(int[] arr, int target){


        Arrays.sort(arr);
        System.out.println("Sorted array :"+Arrays.toString(arr));

        List<Integer> triplet = new ArrayList<>();
        List<List<Integer>> tripletList = new ArrayList<>();

        if(arr==null || arr.length<3)
            return null;

        for(int i=0; i<arr.length-2; i++){

            int left = i+1;
            int right = arr.length-1;
            while(left<right){

                int sum = arr[i]+arr[left]+arr[right];
                System.out.println("sum is"+sum);

                if(sum>=target){
                   right--;

                }else {
                    //this means element  from left to right are all smaller
                    //becasuse of sorted array
                    for(int m = left; m<right;m++) {
                        addTriplets(tripletList, arr[i], arr[m], arr[right]);
                    }
                    left++;
                }
            }
        }

        return tripletList;


    }

    public static void addTriplets(List<List<Integer>> result, int i, int j, int k){
        List<Integer> triplet = new ArrayList<>();
        triplet.add(i);
        triplet.add(j);
        triplet.add(k);
        result.add(triplet);

    }

    /*
    other solution is to always maintain closest value insted of dii

    closest = if(Math.abs(sum-target)<Math.abs(closest-target))?sum:closest;
     */


    public static void main(String[] args){

        int[] arr = {-2,0,1,3};//{-1,2,1,-4};

        List<List<Integer>> tripletsList = threeSumSmaller(arr, 2);

        for(List<Integer> triplet : tripletsList){
            System.out.println("triplet :"+triplet.toString());
        }
    }

}
