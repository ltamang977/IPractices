package org.lv.ipractices.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by root on 1/20/18.
 */
public class FourSum {

    /**
     4 sum solution from leetcode
     * @param arr
     * @return
     */
    public static  List<List<Integer>> fourSumLC(int[] arr, int target){


        Arrays.sort(arr);
        System.out.println("Sorted array :"+Arrays.toString(arr));

        List<Integer> triplet = new ArrayList<>();
        List<List<Integer>> tripletList = new ArrayList<>();

        if(arr==null || arr.length<4)
            return null;

        for(int m=0; m<arr.length-3;m++) {

            if(m>0 && arr[m]==arr[m-1])
                continue;

            for (int i = 0; i < arr.length - 2; i++) {

                if(i>0 && arr[i]==arr[i-1])
                    continue;

                int left = i + 1;
                int right = arr.length - 1;

                while (left < right) {

                    int sum = arr[m]+arr[i]+arr[left]+arr[right];
                    System.out.println("sum is" + sum);

                    if(sum == target) {
                        addTriplets(tripletList, arr[m], arr[i], arr[left], arr[right]);

                        left++;
                        while(left<right && arr[left]==arr[left-1]){
                            left++;
                        }

                        right--;
                        while(left<right && arr[right]==arr[right+1]){
                            right--;
                        }

                    }else if(sum<target){
                        left++;

                    } else {
                        right--;
                    }
                }
            }
        }

        return tripletList;


    }

    public static void addTriplets(List<List<Integer>> result, int m, int i, int j, int k){
        List<Integer> triplet = new ArrayList<>();
        triplet.add(m);
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

        int[] arr = {10, 2, 3, 4,5,9,7,8};//{-1,2,1,-4};

        List<List<Integer>> tripletsList = fourSumLC(arr, 23);

        for(List<Integer> triplet : tripletsList){
            System.out.println("triplet :"+triplet.toString());
        }
    }

}
